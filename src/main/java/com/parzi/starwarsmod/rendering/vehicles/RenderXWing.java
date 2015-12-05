package com.parzi.starwarsmod.rendering.vehicles;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.models.vehicles.ModelXWing;
import com.parzi.starwarsmod.utils.Lumberjack;
import com.parzi.starwarsmod.utils.MathUtils;
import com.parzi.starwarsmod.vehicles.VehicleAirBase;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderXWing extends RenderLiving
{
	public RenderXWing(ModelXWing model, float par2)
	{
		super(model, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return new ResourceLocation(StarWarsMod.MODID, "textures/models/xwing.png");
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		GL11.glScalef(3.0F, 3.0F, 3.0F);
		if (entity instanceof VehicleAirBase)
		{
			VehicleAirBase vehicle = (VehicleAirBase)entity;
			GL11.glTranslatef(0, -1F, 0);
			float x = MathUtils.lerp(vehicle.renderPitchLast, vehicle.rotationPitch, f);
			if (f > 0.5F)
				vehicle.renderPitchLast = vehicle.rotationPitch;
			GL11.glRotatef(x, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0, 1F, 0);
			GL11.glRotatef(-vehicle.mouseDX, 0.0F, 0.0F, 1.0F);
			//Lumberjack.log(vehicle.rotationLast - vehicle.rotationYaw);
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\vehicles\RenderSpeederBike.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */