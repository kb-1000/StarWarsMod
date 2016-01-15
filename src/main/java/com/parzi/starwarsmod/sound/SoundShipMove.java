package com.parzi.starwarsmod.sound;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.util.vehicle.VehicleAirBase;

public class SoundShipMove extends MovingSound
{
	public SoundShipMove(String type)
	{
		super(new ResourceLocation(Resources.MODID, "vehicle." + type + ".move"));
		this.field_147666_i = ISound.AttenuationType.NONE;
		this.repeat = true;
		this.field_147665_h = 0; // repeat delay
	}

	/**
	 * Updates the JList with a new model.
	 */
	@Override
	public void update()
	{
		this.donePlaying = !(StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicleAirBase);
		if (!this.donePlaying)
		{
			float s = (float)Math.abs(StarWarsMod.mc.thePlayer.ridingEntity.motionX);
			s += (float)Math.abs(StarWarsMod.mc.thePlayer.ridingEntity.motionZ);
			s /= 2;
			s = MathHelper.clamp_float(s, 0, 1);
			this.volume = s;
		}
	}
}