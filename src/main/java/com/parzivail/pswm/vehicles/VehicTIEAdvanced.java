package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.ui.LangUtils;
import com.parzivail.util.vehicle.VehicleAirBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class VehicTIEAdvanced extends VehicleAirBase
{
	public VehicTIEAdvanced(World par1World)
	{
		super(par1World);
		this.setSize(3.0F, 7.0F);
		this.vehicYOffset = -3F;
		this.moveModifier = 1.75F;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(StarWarsItems.spawnTieAdvanced, 1);
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
			return this.getCustomNameTag();
		return LangUtils.translate("tie.advanced.x1.starfighter");
	}

	@Override
	public String getDeathSound()
	{
		return Resources.MODID + ":" + "vehicle.tie.die";
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.tie.move";
	}

	@Override
	public boolean interact(EntityPlayer player)
	{
		if (player.isSneaking())
		{
			if (!worldObj.isRemote)
				player.openGui(StarWarsMod.instance, Resources.GUI_HYPERDRIVE, this.worldObj, 0, 0, 0);
			return true;
		}

		return super.interact(player);
	}
}
