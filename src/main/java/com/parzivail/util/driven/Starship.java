package com.parzivail.util.driven;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.dimension.PlanetInformation;
import com.parzivail.pswm.network.MessageDrivableControl;
import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Starship extends Pilotable
{
	public Starship(World world)
	{
		super(world);
	}

	public Starship(World world, double x, double y, double z)
	{
		super(world);
		setPosition(x, y, z);
		prevPosX = x;
		prevPosY = y;
		prevPosZ = z;
		Lumberjack.debug("starship init");
		initType(world.isRemote);
	}

	public Starship(World world, double x, double y, double z, EntityPlayer placer)
	{
		this(world, x, y, z);
		rotateYaw(placer.rotationYaw + 90F);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag)
	{
		super.writeEntityToNBT(tag);
		tag.setTag("Pos", this.newDoubleNBTList(this.posX, this.posY + 1D, this.posZ));
	}

	@Override
	public boolean interactFirst(EntityPlayer entityplayer)
	{
		if (isDead)
			return false;

		if (seats == null)
		{
			Lumberjack.debug("starship interactfirst");
			initType(entityplayer.worldObj.isRemote);
		}

		//Check each seat in order to see if the entity can sit in it
		for (int i = 0; i < numPassengers; i++)
			if (seats[i] != null && seats[i].interactFirst(entityplayer))
				return true;

		return false;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (seats == null)
		{
			// Wait for server to sync seats
			return;
		}

		//Work out if this is the client side and the entity is driving
		boolean thePlayerIsDrivingThis = worldObj.isRemote && seats[0] != null && seats[0].riddenByEntity instanceof EntityPlayer && StarWarsMod.proxy.isThePlayer((EntityPlayer)seats[0].riddenByEntity);

		//Player is not driving this. Update its position from server update packets 
		if (worldObj.isRemote && !thePlayerIsDrivingThis)
		{
			//The drivable is currently moving towards its server position. Continue doing so.
			if (serverPositionTransitionTicker > 0)
			{
				double x = posX + (serverPosX - posX) / serverPositionTransitionTicker;
				double y = posY + (serverPosY - posY) / serverPositionTransitionTicker;
				double z = posZ + (serverPosZ - posZ) / serverPositionTransitionTicker;
				double dYaw = MathHelper.wrapAngleTo180_double(serverYaw - axes.getYaw());
				double dPitch = MathHelper.wrapAngleTo180_double(serverPitch - axes.getPitch());
				double dRoll = MathHelper.wrapAngleTo180_double(serverRoll - axes.getRoll());
				rotationYaw = (float)(axes.getYaw() + dYaw / serverPositionTransitionTicker);
				rotationPitch = (float)(axes.getPitch() + dPitch / serverPositionTransitionTicker);
				float rotationRoll = (float)(axes.getRoll() + dRoll / serverPositionTransitionTicker);
				--serverPositionTransitionTicker;
				setPosition(x, y, z);
				setRotation(rotationYaw, rotationPitch, rotationRoll);
			}
		}

		for (EntitySeat seat : seats)
			if (seat != null)
				seat.updatePosition();

		//Calculate movement on the client and then send position, rotation etc to the server
		if (thePlayerIsDrivingThis)
		{
			calculateMotion();

			serverPosX = posX;
			serverPosY = posY;
			serverPosZ = posZ;
			serverYaw = axes.getYaw();
			StarWarsMod.network.sendToServer(new MessageDrivableControl(this));
		}

		if (!worldObj.isRemote)
		{
			StarWarsMod.network.sendToAllAround(new MessageDrivableControl(this), new NetworkRegistry.TargetPoint(dimension, posX, posY, posZ, 100));
		}
	}

	private void calculateMotion()
	{
		Vector3f forwards = (Vector3f)axes.getXAxis().normalise();

		//Apply gravity
		PlanetInformation info = PlanetInformation.getPlanet(this.worldObj.provider.dimensionId);
		float g = info == null ? 0.98f / 20f : info.getGravity();

		motionY -= g;

		float amountOfLift = 2F * g * throttle;
		if (amountOfLift > g)
			amountOfLift = g;

		motionY += amountOfLift;

		//Add the corrected pos
		motionX += throttle * forwards.x;
		motionY += throttle * forwards.y;
		motionZ += throttle * forwards.z;

		float drag = info == null ? 0.75f : info.getAtmosphericDrag();

		//Apply drag
		motionX *= drag;
		motionY *= drag;
		motionZ *= drag;
	}
}