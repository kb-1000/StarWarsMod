package com.parzi.starwarsmod.rendering.vehicles;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.models.vehicles.ModelLandspeeder;
import com.parzi.starwarsmod.vehicles.VehicleLandBase;

public class RenderLandspeeder extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(StarWarsMod.MODID, "textures/models/landspeeder.png");

	public RenderLandspeeder(ModelLandspeeder modelLandspeeder, float par2)
	{
		super(modelLandspeeder, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		GL11.glScalef(2.4F, 2.4F, 2.4F);
		if (entity instanceof VehicleLandBase)
		{
			VehicleLandBase vehic = (VehicleLandBase)entity;
			float tx = (float)Math.sin(vehic.frame) * 0.005F;
			float ty = (float)Math.cos(vehic.frame * 1.25F) * 0.005F;
			GL11.glTranslatef(tx, ty, tx * ty);
			GL11.glRotatef(-vehic.mouseDX / 5f, 0.0F, 0.0F, 1.0F);
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\vehicles\RenderLandspeeder.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */