package com.parzi.starwarsmod.rendering.vehicles;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.models.vehicles.ModelXWing;
import com.parzi.starwarsmod.utils.MathUtils;
import com.parzi.starwarsmod.vehicles.VehicXWing;
import com.parzi.starwarsmod.vehicles.VehicleAirBase;

public class RenderXWing extends RenderVehicAirBase
{
	public static ResourceLocation texture = new ResourceLocation(StarWarsMod.MODID, "textures/models/xwing.png");

	public RenderXWing(ModelXWing model, float par2)
	{
		super(model, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}

	@Override
	public ModelBase setRotations(ModelBase modelBase, EntityLivingBase entity, float partialTicks)
	{
		if (modelBase instanceof ModelXWing && entity instanceof VehicXWing)
		{
			VehicXWing xwing = (VehicXWing)entity;
			ModelXWing model = (ModelXWing)modelBase;

			model.Booster_L_Top.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Engine_L_Top.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Wing_L_Top.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Wing_Extra_L_Top.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Laser_Base_L_Top.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Laser_Base_2_L_Top.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Laser_L_Top.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Laser_Prong_1_L_Top.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Laser_Prong_2_L_Top.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Laser_Prong_3_L_Top.rotateAngleZ = -0.314159f * xwing.getSFoil();

			model.Booster_L_Bottom.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Engine_L_Bottom.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Wing_L_Bottom.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Wing_Extra_L_Bottom.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Laser_Base_L_Bottom.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Laser_Base_2_L_Bottom.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Laser_L_Bottom.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Laser_Prong_1_L_Bottom.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Laser_Prong_2_L_Bottom.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Laser_Prong_3_L_Bottom.rotateAngleZ = 0.314159f * xwing.getSFoil();

			model.Booster_R_Top.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Engine_R_Top.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Wing_R_Top.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Wing_Extra_R_Top.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Laser_Base_R_Top.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Laser_Base_2_R_Top.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Laser_R_Top.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Laser_Prong_1_R_Top.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Laser_Prong_2_R_Top.rotateAngleZ = 0.314159f * xwing.getSFoil();
			model.Laser_Prong_3_R_Top.rotateAngleZ = 0.314159f * xwing.getSFoil();

			model.Booster_R_Bottom.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Engine_R_Bottom.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Wing_R_Bottom.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Wing_Extra_R_Bottom.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Laser_Base_R_Bottom.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Laser_Base_2_R_Bottom.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Laser_R_Bottom.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Laser_Prong_1_R_Bottom.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Laser_Prong_2_R_Bottom.rotateAngleZ = -0.314159f * xwing.getSFoil();
			model.Laser_Prong_3_R_Bottom.rotateAngleZ = -0.314159f * xwing.getSFoil();

			return model;
		}
		return modelBase;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\vehicles\RenderSpeederBike.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */