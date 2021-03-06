package com.parzivail.pswm.models.vehicles;

import com.parzivail.pswm.vehicles.VehicATST;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

/**
 * AT-ST - Weaston
 * Created using Tabula 4.1.1
 */
public class ModelATST extends ModelBase
{
	public ModelRenderer BodyParentMain;
	public ModelRenderer Body1;
	public ModelRenderer MainLegLParent1;
	public ModelRenderer HeadParentMain;
	public ModelRenderer MainLegRParent;
	public ModelRenderer LegLChild1;
	public ModelRenderer LegLChild2;
	public ModelRenderer LegLChild3;
	public ModelRenderer LegLChild4;
	public ModelRenderer LegLChild5;
	public ModelRenderer LegLChild6;
	public ModelRenderer LegLChild7;
	public ModelRenderer LegLChild8;
	public ModelRenderer Head1;
	public ModelRenderer Head2;
	public ModelRenderer Head3;
	public ModelRenderer Head4;
	public ModelRenderer Head5;
	public ModelRenderer Head6;
	public ModelRenderer Head7;
	public ModelRenderer Head8;
	public ModelRenderer Head9;
	public ModelRenderer Head10;
	public ModelRenderer Head11;
	public ModelRenderer Head12;
	public ModelRenderer Head13;
	public ModelRenderer Head14;
	public ModelRenderer Head15;
	public ModelRenderer Head16;
	public ModelRenderer Head17;
	public ModelRenderer Head18;
	public ModelRenderer Head19;
	public ModelRenderer Head20;
	public ModelRenderer Head21;
	public ModelRenderer Head22;
	public ModelRenderer Head23;
	public ModelRenderer Head24;
	public ModelRenderer Head25;
	public ModelRenderer LegRChild1;
	public ModelRenderer MainLegLParent; // not parent
	public ModelRenderer shape6;
	public ModelRenderer shape6_1;
	public ModelRenderer shape6_2;
	public ModelRenderer shape6_3;
	public ModelRenderer shape10;
	public ModelRenderer shape10_1;

	public ModelATST()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.LegLChild7 = new ModelRenderer(this, 213, 0);
		this.LegLChild7.setRotationPoint(0.0F, 4.4F, -0.2F);
		this.LegLChild7.addBox(-1.5F, 1.0F, -2.0F, 3, 1, 4, 0.0F);
		this.setRotateAngle(LegLChild7, 0.5759586531581287F, 0.0F, 0.0F);
		this.Head10 = new ModelRenderer(this, 0, 43);
		this.Head10.setRotationPoint(6.0F, -9.2F, 0.79F);
		this.Head10.addBox(-3.0F, 0.0F, -5.5F, 1, 1, 11, 0.0F);
		this.setRotateAngle(Head10, -0.05235987755982988F, 0.0F, 0.0F);
		this.LegLChild1 = new ModelRenderer(this, 126, 0);
		this.LegLChild1.setRotationPoint(1.0F, 0.3F, -6.9F);
		this.LegLChild1.addBox(-1.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(LegLChild1, -0.4886921905584123F, 0.17453292519943295F, 0.0F);
		this.Head4 = new ModelRenderer(this, 365, 0);
		this.Head4.setRotationPoint(3.5F, -4.6F, -5.77F);
		this.Head4.addBox(-0.5F, -1.5F, -5.0F, 1, 2, 10, 0.0F);
		this.setRotateAngle(Head4, -1.8849555921538759F, 0.0F, 0.0F);
		this.LegLChild6 = new ModelRenderer(this, 200, 0);
		this.LegLChild6.setRotationPoint(0.0F, 3.7F, -0.3F);
		this.LegLChild6.addBox(-0.5F, -4.0F, -0.1F, 1, 10, 1, 0.0F);
		this.setRotateAngle(LegLChild6, -0.3141592653589793F, 0.0F, 0.0F);
		this.LegLChild8 = new ModelRenderer(this, 235, 0);
		this.LegLChild8.setRotationPoint(0.5F, -1.3F, 1.4F);
		this.LegLChild8.addBox(-1.5F, 0.1F, -1.6F, 2, 1, 1, 0.0F);
		this.Head16 = new ModelRenderer(this, 0, 153);
		this.Head16.setRotationPoint(-2.5F, -0.9F, -6.97F);
		this.Head16.addBox(-1.5F, -3.04F, -0.1F, 8, 4, 3, 0.0F);
		this.setRotateAngle(Head16, -0.6283185307179586F, 0.0F, 0.0F);
		this.shape6_2 = new ModelRenderer(this, 0, 0);
		this.shape6_2.setRotationPoint(0.0F, 5.0F, 0.0F);
		this.shape6_2.addBox(-0.5F, -4.0F, -0.5F, 1, 8, 1, 0.0F);
		this.Head12 = new ModelRenderer(this, 0, 84);
		this.Head12.setRotationPoint(0.0F, -1.4F, 0.9F);
		this.Head12.addBox(3.0F, -7.0F, -6.5F, 1, 8, 11, 0.0F);
		this.setRotateAngle(Head12, -0.10471975511965977F, 0.0F, 0.0F);
		this.Head15 = new ModelRenderer(this, 0, 139);
		this.Head15.setRotationPoint(-2.5F, -0.9F, -6.97F);
		this.Head15.addBox(-1.5F, -2.74F, 0.3F, 8, 3, 1, 0.0F);
		this.setRotateAngle(Head15, -2.076941809873252F, 0.0F, 0.0F);
		this.BodyParentMain = new ModelRenderer(this, 50, 0);
		this.BodyParentMain.setRotationPoint(0.0F, 3.0F, 4.0F);
		this.BodyParentMain.addBox(-3.0F, -2.0F, -4.5F, 6, 4, 9, 0.0F);
		this.setRotateAngle(BodyParentMain, 0.3141592653589793F, 0.0F, 0.0F);
		this.MainLegLParent1 = new ModelRenderer(this, 105, 0);
		this.MainLegLParent1.setRotationPoint(3.1F, -0.3F, 2.0F);
		this.MainLegLParent1.addBox(-0.5F, -0.4F, -7.5F, 1, 1, 8, 0.0F);
		this.setRotateAngle(MainLegLParent1, -0.08726646259971647F, -0.17453292519943295F, 0.0F);
		this.LegLChild5 = new ModelRenderer(this, 191, 0);
		this.LegLChild5.setRotationPoint(0.0F, 5.0F, 0.0F);
		this.LegLChild5.addBox(-0.5F, -4.0F, -0.5F, 1, 8, 1, 0.0F);
		this.Head9 = new ModelRenderer(this, 0, 42);
		this.Head9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Head9.addBox(-4.6F, -2.3F, -7.38F, 1, 3, 1, 0.0F);
		this.setRotateAngle(Head9, 0.07853981633974483F, 0.296705972839036F, 1.8325957145940461F);
		this.Head19 = new ModelRenderer(this, 0, 194);
		this.Head19.setRotationPoint(3.5F, -3.0F, -5.77F);
		this.Head19.addBox(1.9F, -1.0F, -3.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(Head19, -1.8849555921538759F, 0.0F, 0.0F);
		this.MainLegRParent = new ModelRenderer(this, 0, 281);
		this.MainLegRParent.setRotationPoint(-3.2F, -0.3F, 1.7F);
		this.MainLegRParent.addBox(-0.6F, -0.7F, -7.4F, 1, 1, 8, 0.0F);
		this.setRotateAngle(MainLegRParent, 0.08726646259971647F, 0.17453292519943295F, 0.0F);
		this.Head2 = new ModelRenderer(this, 285, 0);
		this.Head2.setRotationPoint(0.0F, -4.0F, 5.75F);
		this.Head2.addBox(-4.0F, 0.0F, -4.0F, 8, 1, 8, 0.0F);
		this.setRotateAngle(Head2, -1.6929693744344996F, 0.0F, 0.0F);
		this.Head22 = new ModelRenderer(this, 0, 238);
		this.Head22.setRotationPoint(3.5F, -3.0F, -5.77F);
		this.Head22.addBox(-9.9F, -1.0F, -3.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(Head22, -1.8849555921538759F, 0.0F, 0.0F);
		this.shape6 = new ModelRenderer(this, 0, 0);
		this.shape6.setRotationPoint(1.0F, -0.2F, 4.0F);
		this.shape6.addBox(-2.0F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
		this.LegLChild3 = new ModelRenderer(this, 160, 0);
		this.LegLChild3.setRotationPoint(1.0F, -0.2F, 4.0F);
		this.LegLChild3.addBox(-2.0F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
		this.Head13 = new ModelRenderer(this, 0, 112);
		this.Head13.setRotationPoint(0.0F, -1.4F, 0.9F);
		this.Head13.addBox(-4.0F, 0.0F, -6.5F, 8, 1, 11, 0.0F);
		this.setRotateAngle(Head13, -0.10471975511965977F, 0.0F, 0.0F);
		this.HeadParentMain = new ModelRenderer(this, 250, 0);
		this.HeadParentMain.setRotationPoint(0.0F, -3.0F, -2.0F);
		this.HeadParentMain.addBox(-1.0F, -1.5F, -1.0F, 2, 3, 2, 0.0F);
		this.shape10 = new ModelRenderer(this, 0, 0);
		this.shape10.setRotationPoint(0.0F, 4.4F, -0.2F);
		this.shape10.addBox(-1.5F, 1.0F, -2.0F, 3, 1, 4, 0.0F);
		this.setRotateAngle(shape10, 0.5759586531581287F, 0.0F, 0.0F);
		this.Head5 = new ModelRenderer(this, 394, 0);
		this.Head5.setRotationPoint(0.0F, -4.6F, -5.77F);
		this.Head5.addBox(-0.5F, -0.5F, -5.0F, 1, 1, 10, 0.0F);
		this.setRotateAngle(Head5, -1.8849555921538759F, 0.0F, 0.0F);
		this.Head11 = new ModelRenderer(this, 0, 63);
		this.Head11.setRotationPoint(-1.0F, -9.2F, 0.79F);
		this.Head11.addBox(-3.0F, 0.0F, -5.5F, 1, 1, 11, 0.0F);
		this.setRotateAngle(Head11, -0.05235987755982988F, 0.0F, 0.0F);
		this.Head24 = new ModelRenderer(this, 0, 260);
		this.Head24.setRotationPoint(3.5F, -3.0F, -5.77F);
		this.Head24.addBox(-5.8F, 0.5F, 1.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(Head24, -1.8849555921538759F, 0.0F, 0.0F);
		this.Head25 = new ModelRenderer(this, 0, 272);
		this.Head25.setRotationPoint(0.0F, -4.6F, -5.77F);
		this.Head25.addBox(-4.0F, -0.5F, -5.0F, 8, 1, 1, 0.0F);
		this.setRotateAngle(Head25, -1.8849555921538759F, 0.0F, 0.0F);
		this.Head8 = new ModelRenderer(this, 0, 34);
		this.Head8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Head8.addBox(-4.6F, -0.7F, -7.38F, 1, 3, 1, 0.0F);
		this.setRotateAngle(Head8, -0.07853981633974483F, 0.296705972839036F, 1.3089969389957472F);
		this.shape6_3 = new ModelRenderer(this, 0, 0);
		this.shape6_3.setRotationPoint(0.0F, 3.7F, -0.3F);
		this.shape6_3.addBox(-0.5F, -4.0F, -0.1F, 1, 10, 1, 0.0F);
		this.setRotateAngle(shape6_3, -0.3141592653589793F, 0.0F, 0.0F);
		this.Head14 = new ModelRenderer(this, 0, 131);
		this.Head14.setRotationPoint(-2.5F, -0.9F, -6.97F);
		this.Head14.addBox(-1.5F, -0.5F, 0.2F, 8, 1, 1, 0.0F);
		this.setRotateAngle(Head14, -1.8849555921538759F, 0.0F, 0.0F);
		this.shape10_1 = new ModelRenderer(this, 0, 0);
		this.shape10_1.setRotationPoint(0.5F, -1.3F, 1.4F);
		this.shape10_1.addBox(-1.5F, 0.1F, -1.6F, 2, 1, 1, 0.0F);
		this.Head1 = new ModelRenderer(this, 255, 0);
		this.Head1.setRotationPoint(0.0F, -1.4F, 0.9F);
		this.Head1.addBox(-4.0F, -7.0F, -6.5F, 1, 8, 11, 0.0F);
		this.setRotateAngle(Head1, -0.10471975511965977F, 0.0F, 0.0F);
		this.Head20 = new ModelRenderer(this, 0, 206);
		this.Head20.setRotationPoint(3.5F, -3.0F, -5.77F);
		this.Head20.addBox(-8.4F, -4.0F, -4.5F, 1, 4, 4, 0.0F);
		this.setRotateAngle(Head20, -1.8849555921538759F, 0.0F, 0.0F);
		this.Head17 = new ModelRenderer(this, 0, 167);
		this.Head17.setRotationPoint(3.5F, -3.0F, -5.77F);
		this.Head17.addBox(0.4F, -4.0F, -4.5F, 1, 4, 4, 0.0F);
		this.setRotateAngle(Head17, -1.8849555921538759F, 0.0F, 0.0F);
		this.Head18 = new ModelRenderer(this, 0, 184);
		this.Head18.setRotationPoint(3.5F, -3.0F, -5.77F);
		this.Head18.addBox(1.4F, -3.0F, -3.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(Head18, -1.8849555921538759F, 0.0F, 0.0F);
		this.Head7 = new ModelRenderer(this, 0, 24);
		this.Head7.setRotationPoint(-2.5F, -0.9F, -6.97F);
		this.Head7.addBox(-0.5F, -0.5F, -5.0F, 6, 1, 6, 0.0F);
		this.setRotateAngle(Head7, -1.8849555921538759F, 0.0F, 0.0F);
		this.shape6_1 = new ModelRenderer(this, 0, 0);
		this.shape6_1.setRotationPoint(-1.0F, 4.0F, 0.0F);
		this.shape6_1.addBox(-0.5F, -4.0F, -1.0F, 1, 8, 2, 0.0F);
		this.Head23 = new ModelRenderer(this, 0, 250);
		this.Head23.setRotationPoint(3.5F, -3.0F, -5.77F);
		this.Head23.addBox(-2.1F, 0.5F, 1.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(Head23, -1.8849555921538759F, 0.0F, 0.0F);
		this.Head21 = new ModelRenderer(this, 0, 225);
		this.Head21.setRotationPoint(3.5F, -3.0F, -5.77F);
		this.Head21.addBox(-10.4F, -3.0F, -3.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(Head21, -1.8849555921538759F, 0.0F, 0.0F);
		this.Body1 = new ModelRenderer(this, 88, 0);
		this.Body1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body1.addBox(-1.5F, 0.5F, -5.5F, 3, 2, 3, 0.0F);
		this.setRotateAngle(Body1, -0.3141592653589793F, 0.0F, 0.0F);
		this.LegLChild4 = new ModelRenderer(this, 178, 0);
		this.LegLChild4.setRotationPoint(-1.0F, 4.0F, 0.0F);
		this.LegLChild4.addBox(-0.5F, -4.0F, -1.0F, 1, 8, 2, 0.0F);
		this.Head6 = new ModelRenderer(this, 424, 0);
		this.Head6.setRotationPoint(-3.5F, -4.6F, -5.77F);
		this.Head6.addBox(-0.5F, -1.5F, -5.0F, 1, 2, 10, 0.0F);
		this.setRotateAngle(Head6, -1.8849555921538759F, 0.0F, 0.0F);
		this.MainLegLParent = new ModelRenderer(this, 0, 0);
		this.MainLegLParent.setRotationPoint(0.0F, 0.0F, 2.1F);
		this.MainLegLParent.addBox(-0.5F, -1.0F, -3.0F, 1, 2, 6, 0.0F);
		this.LegLChild2 = new ModelRenderer(this, 138, 0);
		this.LegLChild2.setRotationPoint(0.0F, 0.0F, 2.1F);
		this.LegLChild2.addBox(-0.5F, -1.0F, -3.0F, 1, 2, 6, 0.0F);
		this.LegRChild1 = new ModelRenderer(this, 0, 298);
		this.LegRChild1.setRotationPoint(-1.3F, 0.2F, -6.6F);
		this.LegRChild1.addBox(-1.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(LegRChild1, -0.6632251157578453F, -0.17453292519943295F, 0.0F);
		this.Head3 = new ModelRenderer(this, 324, 0);
		this.Head3.setRotationPoint(0.0F, -9.2F, 0.79F);
		this.Head3.addBox(-3.0F, 0.0F, -5.5F, 6, 1, 11, 0.0F);
		this.setRotateAngle(Head3, -0.05235987755982988F, 0.0F, 0.0F);
		this.LegLChild6.addChild(this.LegLChild7);
		this.HeadParentMain.addChild(this.Head10);
		this.MainLegLParent1.addChild(this.LegLChild1);
		this.HeadParentMain.addChild(this.Head4);
		this.LegLChild5.addChild(this.LegLChild6);
		this.LegLChild6.addChild(this.LegLChild8);
		this.HeadParentMain.addChild(this.Head16);
		this.shape6_1.addChild(this.shape6_2);
		this.HeadParentMain.addChild(this.Head12);
		this.HeadParentMain.addChild(this.Head15);
		this.BodyParentMain.addChild(this.MainLegLParent1);
		this.LegLChild4.addChild(this.LegLChild5);
		this.HeadParentMain.addChild(this.Head9);
		this.HeadParentMain.addChild(this.Head19);
		this.BodyParentMain.addChild(this.MainLegRParent);
		this.HeadParentMain.addChild(this.Head2);
		this.HeadParentMain.addChild(this.Head22);
		this.MainLegLParent.addChild(this.shape6);
		this.LegLChild2.addChild(this.LegLChild3);
		this.HeadParentMain.addChild(this.Head13);
		this.BodyParentMain.addChild(this.HeadParentMain);
		this.shape6_3.addChild(this.shape10);
		this.HeadParentMain.addChild(this.Head5);
		this.HeadParentMain.addChild(this.Head11);
		this.HeadParentMain.addChild(this.Head24);
		this.HeadParentMain.addChild(this.Head25);
		this.HeadParentMain.addChild(this.Head8);
		this.shape6_2.addChild(this.shape6_3);
		this.HeadParentMain.addChild(this.Head14);
		this.shape6_3.addChild(this.shape10_1);
		this.HeadParentMain.addChild(this.Head1);
		this.HeadParentMain.addChild(this.Head20);
		this.HeadParentMain.addChild(this.Head17);
		this.HeadParentMain.addChild(this.Head18);
		this.HeadParentMain.addChild(this.Head7);
		this.shape6.addChild(this.shape6_1);
		this.HeadParentMain.addChild(this.Head23);
		this.HeadParentMain.addChild(this.Head21);
		this.BodyParentMain.addChild(this.Body1);
		this.LegLChild3.addChild(this.LegLChild4);
		this.HeadParentMain.addChild(this.Head6);
		this.LegRChild1.addChild(this.MainLegLParent);
		this.LegLChild1.addChild(this.LegLChild2);
		this.MainLegRParent.addChild(this.LegRChild1);
		this.HeadParentMain.addChild(this.Head3);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		if (entity instanceof VehicATST)
		{
			VehicATST atst = (VehicATST)entity;

			if (atst.riddenByEntity instanceof EntityLivingBase)
			{
				EntityLivingBase elb = (EntityLivingBase)atst.riddenByEntity;
				if (atst.getDistanceSq(atst.prevPosX, atst.prevPosY, atst.prevPosZ) > 0f)
				{
					this.MainLegLParent1.rotateAngleX = -0.08726646259971647F + MathHelper.sin(atst.ticksExisted * (elb.moveForward >= 0 ? 1 : -1) / 3.75f) / 5f;
					this.LegLChild1.rotateAngleX = -0.4886921905584123F + -MathHelper.sin(atst.ticksExisted * (elb.moveForward >= 0 ? 1 : -1) / 3.75f + 1) / 5f;

					this.MainLegRParent.rotateAngleX = -0.08726646259971647F + MathHelper.sin(atst.ticksExisted * (elb.moveForward >= 0 ? 1 : -1) / 3.75f + 3) / 5f;
					this.LegRChild1.rotateAngleX = -0.4886921905584123F + -MathHelper.sin(atst.ticksExisted * (elb.moveForward >= 0 ? 1 : -1) / 3.75f + 4) / 5f;

					this.BodyParentMain.rotationPointY = 3.0f + MathHelper.sin(atst.ticksExisted / 1.875f + 4) / 5f;
				}

				this.HeadParentMain.rotateAngleX = (float)Math.toRadians(MathHelper.clamp_float(atst.riddenByEntity.rotationPitch, -20, 20));
			}
			else
			{
				this.MainLegLParent1.rotateAngleX = -0.08726646259971647F;
				this.LegLChild1.rotateAngleX = -0.4886921905584123F;

				this.MainLegRParent.rotateAngleX = -0.08726646259971647F;
				this.LegRChild1.rotateAngleX = -0.4886921905584123F;

				this.BodyParentMain.rotationPointY = 3.0f;

				this.HeadParentMain.rotateAngleY = 0;
				this.HeadParentMain.rotateAngleX = 0;
			}
		}

		this.BodyParentMain.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
