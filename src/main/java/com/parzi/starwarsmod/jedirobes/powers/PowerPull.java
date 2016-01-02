package com.parzi.starwarsmod.jedirobes.powers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.network.PacketEntityAlterMotion;
import com.parzi.starwarsmod.utils.EntityUtils;

public class PowerPull extends Power
{
	public PowerPull(int currentLevel)
	{
		super("pull");
		this.costBase = 240;
		this.costMult = 40;
		this.currentLevel = currentLevel;
		this.maxLevel = 5;
		this.rechargeTime = 5;
		this.recharge = 0;
	}

	@Override
	public boolean run(EntityPlayer player)
	{
		if (this.recharge == 0)
		{
			Entity e = EntityUtils.rayTrace(this.currentLevel * 3, player, new Entity[0]);

			if (e != null)
			{
				Vec3 lookVec = player.getLookVec();

				float mult = (1 + 0.5f * this.currentLevel);

				lookVec.xCoord *= -mult;
				lookVec.yCoord *= -mult;
				lookVec.zCoord *= -mult;

				String vecString = String.format("%s,%s,%s", lookVec.xCoord, lookVec.yCoord, lookVec.zCoord);

				StarWarsMod.network.sendToServer(new PacketEntityAlterMotion(e.getEntityId(), e.dimension, vecString));
			}

			return true;
		}
		return false;
	}
}