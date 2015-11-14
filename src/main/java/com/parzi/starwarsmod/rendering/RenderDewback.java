package com.parzi.starwarsmod.rendering;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.models.mobs.ModelDewback;

public class RenderDewback extends RenderLiving
{
	public RenderDewback(ModelDewback par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return new ResourceLocation(StarWarsMod.MODID, "textures/models/dewback.png");
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		if (!entity.isChild()) GL11.glScalef(2.5F, 2.5F, 2.5F);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderDewback.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */