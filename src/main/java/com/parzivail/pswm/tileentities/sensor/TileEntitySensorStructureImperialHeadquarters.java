package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.EntityDroidBase;
import com.parzivail.pswm.mobs.MobDroidAstromechImperial;
import com.parzivail.pswm.mobs.MobDroidAstromechImperial2;
import com.parzivail.pswm.mobs.MobDroidMouse;
import com.parzivail.pswm.mobs.trooper.*;
import net.minecraft.entity.EntityLiving;

public class TileEntitySensorStructureImperialHeadquarters extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureImperialHeadquarters()
	{
		this.rX = 30;
		this.rY = 3;
		this.rZ = 30;
		this.entityMax = 8;
		this.otherMax = 3;
	}

	public MobTrooper getNewEntity()
	{
		switch (this.worldObj.rand.nextInt(6))
		{
			case 0:
				return new MobScouttrooper(this.worldObj);
			case 1:
				return new MobStormtrooper(this.worldObj);
			case 2:
				return new MobTiePilot(this.worldObj);
			case 3:
				return new MobRebelTechnician(this.worldObj);
			case 4:
				return new MobAtstPilot(this.worldObj);
			case 5:
				return new MobImperialOfficer(this.worldObj);
			default:
				return null;
		}
	}

	@Override
	public Class<? extends EntityLiving> getEntityNeedleClass()
	{
		return MobTrooper.class;
	}

	@Override
	public EntityLiving getNewEntityOther()
	{
		switch (this.worldObj.rand.nextInt(4))
		{
			case 1:
				return new MobDroidAstromechImperial(this.worldObj);
			case 2:
				return new MobDroidAstromechImperial2(this.worldObj);
			case 3:
				return new MobDroidMouse(this.worldObj);
			default:
				return null;
		}
	}

	@Override
	public Class<? extends EntityLiving> getEntityNeedleClassOther()
	{
		return EntityDroidBase.class;
	}
}
