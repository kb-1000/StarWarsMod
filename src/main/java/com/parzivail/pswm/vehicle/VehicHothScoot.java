package com.parzivail.pswm.vehicle;

import com.parzivail.util.driven.PilotableLand;
import net.minecraft.world.World;

/**
 * Created by colby on 1/17/2017.
 */
public class VehicHothScoot extends PilotableLand
{
	public VehicHothScoot(World world)
	{
		super(world);
	}

	public VehicHothScoot(World world, double i, double j, double k)
	{
		super(world, i, j, k);
	}

	@Override
	protected void setupShipData()
	{
		super.setupShipData();
		this.data.throttleStep = 0.05f;
		this.data.maxThrottle = 0.1f;
	}
}
