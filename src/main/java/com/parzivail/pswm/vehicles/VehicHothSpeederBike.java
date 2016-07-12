package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.StarWarsItems;
import com.parzivail.util.ui.LangUtils;
import com.parzivail.util.vehicle.VehicleLandBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class VehicHothSpeederBike extends VehicleLandBase
{
	public VehicHothSpeederBike(World par1World)
	{
		super(par1World);
		this.setSize(1.0F, 2.0F);
		this.vehicYOffset = -0.4F;
		this.moveModifier = 3.0F;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(StarWarsItems.spawnHothSpeederBike, 1);
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
			return this.getCustomNameTag();
		return LangUtils.translate("74.z.speeder.bike");
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.speeder.move";
	}
}
