package com.parzivail.pswm.models.lightsabers;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.rendering.IHandlesRender;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Revan 2 - Wolfie
 * Created using P-Tabula 4.1.1
 */
public class ModelRevan2Hilt extends ModelBase implements IHandlesRender
{

	ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/revan2_A.png");
	ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/revan2_B.png");

	public ModelRenderer shape1;
	public ModelRenderer shape2;
	public ModelRenderer shape3;
	public ModelRenderer shape4;
	public ModelRenderer shape5;
	public ModelRenderer shape6;
	public ModelRenderer shape7;
	public ModelRenderer shape8;
	public ModelRenderer shape9;
	public ModelRenderer shape10;
	public ModelRenderer shape11;
	public ModelRenderer shape12;
	public ModelRenderer shape13;
	public ModelRenderer shape14;
	public ModelRenderer shape15;
	public ModelRenderer shape16;
	public ModelRenderer shape17;
	public ModelRenderer shape18;
	public ModelRenderer shape19;
	public ModelRenderer shape20;
	public ModelRenderer shape21;
	public ModelRenderer shape22;
	public ModelRenderer shape23;
	public ModelRenderer shape24;
	public ModelRenderer shape25;
	public ModelRenderer shape26;
	public ModelRenderer shape27;
	public ModelRenderer shape28;
	public ModelRenderer shape29;
	public ModelRenderer shape30;
	public ModelRenderer shape31;
	public ModelRenderer shape32;
	public ModelRenderer shape33;
	public ModelRenderer shape34;
	public ModelRenderer shape35;
	public ModelRenderer shape36;
	public ModelRenderer shape37;
	public ModelRenderer shape38;
	public ModelRenderer shape39;
	public ModelRenderer shape40;
	public ModelRenderer shape41;
	public ModelRenderer shape42;
	public ModelRenderer shape43;
	public ModelRenderer shape44;
	public ModelRenderer shape45;
	public ModelRenderer shape46;
	public ModelRenderer shape47;
	public ModelRenderer shape48;
	public ModelRenderer shape49;
	public ModelRenderer shape50;

	public ModelRevan2Hilt()
	{
		this.textureWidth = 256;
		this.textureHeight = 256;
		this.shape22 = new ModelRenderer(this, 0, 226);
		this.shape22.setRotationPoint(50.0F, 7.5F, 2.0F);
		this.shape22.addBox(0.0F, -2.0F, 0.0F, 4, 2, 1, 0.0F);
		this.setRotateAngle(shape22, 0.0F, -0.0F, -0.8203047513961791F);
		this.shape37 = new ModelRenderer(this, 0, 177);
		this.shape37.setRotationPoint(-6.0F, -0.5F, 2.0F);
		this.shape37.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1, 0.0F);
		this.setRotateAngle(shape37, 0.0F, -0.0F, -0.13962633907794952F);
		this.shape12 = new ModelRenderer(this, 0, 215);
		this.shape12.setRotationPoint(-3.0F, 1.5F, 1.5F);
		this.shape12.addBox(0.0F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
		this.shape10 = new ModelRenderer(this, 0, 105);
		this.shape10.setRotationPoint(24.5F, -1.0F, -1.0F);
		this.shape10.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.shape5 = new ModelRenderer(this, 0, 89);
		this.shape5.setRotationPoint(12.0F, -1.0F, -1.0F);
		this.shape5.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.shape41 = new ModelRenderer(this, 224, 12);
		this.shape41.setRotationPoint(2.0F, 2.0F, -2.5F);
		this.shape41.addBox(-7.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.setRotateAngle(shape41, 0.0F, 0.296705961227417F, 0.0F);
		this.shape1 = new ModelRenderer(this, 120, 0);
		this.shape1.setRotationPoint(3.0F, 0.0F, 0.0F);
		this.shape1.addBox(0.0F, 0.0F, 0.0F, 11, 5, 5, 0.0F);
		this.shape42 = new ModelRenderer(this, 12, 211);
		this.shape42.setRotationPoint(-1.0F, 2.0F, -1.5F);
		this.shape42.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		this.shape25 = new ModelRenderer(this, 76, 0);
		this.shape25.setRotationPoint(29.0F, 2.0F, -1.0F);
		this.shape25.addBox(0.0F, 0.0F, 0.0F, 14, 1, 7, 0.0F);
		this.shape17 = new ModelRenderer(this, 0, 231);
		this.shape17.setRotationPoint(47.0F, -2.5F, 2.0F);
		this.shape17.addBox(0.0F, 0.0F, 0.0F, 3, 10, 1, 0.0F);
		this.shape6 = new ModelRenderer(this, 0, 163);
		this.shape6.setRotationPoint(1.0F, -0.5F, -0.5F);
		this.shape6.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
		this.shape48 = new ModelRenderer(this, 12, 221);
		this.shape48.setRotationPoint(-1.0F, 2.0F, 5.5F);
		this.shape48.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		this.shape13 = new ModelRenderer(this, 0, 0);
		this.shape13.setRotationPoint(26.0F, 0.0F, 0.0F);
		this.shape13.addBox(0.0F, 0.0F, 0.0F, 32, 5, 5, 0.0F);
		this.shape14 = new ModelRenderer(this, 68, 12);
		this.shape14.setRotationPoint(2.0F, -2.5F, 2.0F);
		this.shape14.addBox(0.0F, 0.0F, 0.0F, 23, 10, 1, 0.0F);
		this.shape20 = new ModelRenderer(this, 168, 16);
		this.shape20.setRotationPoint(25.0F, 7.5F, 2.0F);
		this.shape20.addBox(0.0F, -3.0F, 0.0F, 7, 3, 1, 0.0F);
		this.setRotateAngle(shape20, 0.0F, -0.0F, -0.22689279913902285F);
		this.shape38 = new ModelRenderer(this, 168, 12);
		this.shape38.setRotationPoint(-6.0F, 4.5F, 2.0F);
		this.shape38.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F);
		this.shape46 = new ModelRenderer(this, 0, 185);
		this.shape46.setRotationPoint(-6.0F, 5.5F, 2.0F);
		this.shape46.addBox(0.0F, -1.0F, 0.0F, 6, 1, 1, 0.0F);
		this.setRotateAngle(shape46, 0.0F, -0.0F, 0.13962633907794952F);
		this.shape21 = new ModelRenderer(this, 188, 12);
		this.shape21.setRotationPoint(47.0F, 7.5F, 2.0F);
		this.shape21.addBox(-7.0F, -3.0F, 0.0F, 7, 3, 1, 0.0F);
		this.setRotateAngle(shape21, 0.0F, -0.0F, 0.3141592741012573F);
		this.shape2 = new ModelRenderer(this, 0, 25);
		this.shape2.setRotationPoint(2.0F, -1.0F, -1.0F);
		this.shape2.addBox(0.0F, 0.0F, 0.0F, 3, 7, 7, 0.0F);
		this.shape39 = new ModelRenderer(this, 206, 16);
		this.shape39.setRotationPoint(-6.0F, 2.0F, -0.5F);
		this.shape39.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.shape30 = new ModelRenderer(this, 146, 18);
		this.shape30.setRotationPoint(47.0F, 2.0F, 7.5F);
		this.shape30.addBox(-7.0F, 0.0F, -3.0F, 7, 1, 3, 0.0F);
		this.setRotateAngle(shape30, 0.0F, -0.3141592741012573F, 0.0F);
		this.shape31 = new ModelRenderer(this, 242, 17);
		this.shape31.setRotationPoint(50.0F, 2.0F, 7.5F);
		this.shape31.addBox(0.0F, 0.0F, -2.0F, 4, 1, 2, 0.0F);
		this.setRotateAngle(shape31, 0.0F, 0.8203047513961792F, 0.0F);
		this.shape7 = new ModelRenderer(this, 0, 121);
		this.shape7.setRotationPoint(13.5F, -0.5F, -0.5F);
		this.shape7.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
		this.shape45 = new ModelRenderer(this, 12, 215);
		this.shape45.setRotationPoint(-1.0F, 5.5F, 2.0F);
		this.shape45.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		this.shape40 = new ModelRenderer(this, 206, 20);
		this.shape40.setRotationPoint(-6.0F, 2.0F, 4.5F);
		this.shape40.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.shape49 = new ModelRenderer(this, 0, 189);
		this.shape49.setRotationPoint(-6.0F, 2.0F, 5.5F);
		this.shape49.addBox(0.0F, 0.0F, -1.0F, 6, 1, 1, 0.0F);
		this.setRotateAngle(shape49, 0.0F, -0.13962633907794952F, 0.0F);
		this.shape3 = new ModelRenderer(this, 0, 57);
		this.shape3.setRotationPoint(6.0F, -1.0F, -1.0F);
		this.shape3.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.shape44 = new ModelRenderer(this, 224, 16);
		this.shape44.setRotationPoint(2.0F, 7.5F, 2.0F);
		this.shape44.addBox(-7.0F, -1.0F, 0.0F, 7, 1, 1, 0.0F);
		this.setRotateAngle(shape44, 0.0F, -0.0F, 0.296705961227417F);
		this.shape18 = new ModelRenderer(this, 238, 6);
		this.shape18.setRotationPoint(47.0F, -2.5F, 2.0F);
		this.shape18.addBox(-7.0F, 0.0F, 0.0F, 7, 3, 1, 0.0F);
		this.setRotateAngle(shape18, 0.0F, -0.0F, -0.3141592741012573F);
		this.shape16 = new ModelRenderer(this, 154, 0);
		this.shape16.setRotationPoint(29.0F, -1.0F, 2.0F);
		this.shape16.addBox(0.0F, 0.0F, 0.0F, 14, 7, 1, 0.0F);
		this.shape23 = new ModelRenderer(this, 0, 12);
		this.shape23.setRotationPoint(2.0F, 2.0F, -2.5F);
		this.shape23.addBox(0.0F, 0.0F, 0.0F, 23, 1, 10, 0.0F);
		this.shape27 = new ModelRenderer(this, 216, 6);
		this.shape27.setRotationPoint(47.0F, 2.0F, -2.5F);
		this.shape27.addBox(-7.0F, 0.0F, 0.0F, 7, 1, 3, 0.0F);
		this.setRotateAngle(shape27, 0.0F, 0.3141592741012573F, 0.0F);
		this.shape47 = new ModelRenderer(this, 224, 20);
		this.shape47.setRotationPoint(2.0F, 2.0F, 7.5F);
		this.shape47.addBox(-7.0F, 0.0F, -1.0F, 7, 1, 1, 0.0F);
		this.setRotateAngle(shape47, 0.0F, -0.296705961227417F, 0.0F);
		this.shape34 = new ModelRenderer(this, 188, 18);
		this.shape34.setRotationPoint(-6.0F, -0.5F, 2.0F);
		this.shape34.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.shape28 = new ModelRenderer(this, 242, 12);
		this.shape28.setRotationPoint(50.0F, 2.0F, -2.5F);
		this.shape28.addBox(0.0F, 0.0F, 0.0F, 4, 1, 2, 0.0F);
		this.setRotateAngle(shape28, 0.0F, -0.8203047513961792F, 0.0F);
		this.shape9 = new ModelRenderer(this, 0, 135);
		this.shape9.setRotationPoint(23.0F, -0.5F, -0.5F);
		this.shape9.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
		this.shape19 = new ModelRenderer(this, 0, 221);
		this.shape19.setRotationPoint(50.0F, -2.5F, 2.0F);
		this.shape19.addBox(0.0F, 0.0F, 0.0F, 4, 2, 1, 0.0F);
		this.setRotateAngle(shape19, 0.0F, -0.0F, 0.8203047513961791F);
		this.shape4 = new ModelRenderer(this, 0, 73);
		this.shape4.setRotationPoint(9.0F, -1.0F, -1.0F);
		this.shape4.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.shape29 = new ModelRenderer(this, 146, 12);
		this.shape29.setRotationPoint(25.0F, 2.0F, 7.5F);
		this.shape29.addBox(0.0F, 0.0F, -3.0F, 7, 1, 3, 0.0F);
		this.setRotateAngle(shape29, 0.0F, 0.22689279913902283F, 0.0F);
		this.shape11 = new ModelRenderer(this, 0, 207);
		this.shape11.setRotationPoint(-0.5F, 1.0F, 1.0F);
		this.shape11.addBox(0.0F, 0.0F, 0.0F, 2, 3, 3, 0.0F);
		this.shape33 = new ModelRenderer(this, 0, 149);
		this.shape33.setRotationPoint(56.5F, -0.5F, -0.5F);
		this.shape33.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
		this.shape24 = new ModelRenderer(this, 216, 0);
		this.shape24.setRotationPoint(25.0F, 2.0F, -2.5F);
		this.shape24.addBox(0.0F, 0.0F, 0.0F, 7, 1, 3, 0.0F);
		this.setRotateAngle(shape24, 0.0F, -0.22689279913902283F, 0.0F);
		this.shape26 = new ModelRenderer(this, 118, 12);
		this.shape26.setRotationPoint(47.0F, 2.0F, -2.5F);
		this.shape26.addBox(0.0F, 0.0F, 0.0F, 3, 1, 10, 0.0F);
		this.shape36 = new ModelRenderer(this, 12, 207);
		this.shape36.setRotationPoint(-1.0F, -1.5F, 2.0F);
		this.shape36.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		this.shape8 = new ModelRenderer(this, 186, 0);
		this.shape8.setRotationPoint(14.0F, 0.0F, 0.0F);
		this.shape8.addBox(0.0F, 0.0F, 0.0F, 9, 5, 5, 0.0F);
		this.shape15 = new ModelRenderer(this, 238, 0);
		this.shape15.setRotationPoint(25.0F, -2.5F, 2.0F);
		this.shape15.addBox(0.0F, 0.0F, 0.0F, 7, 3, 1, 0.0F);
		this.setRotateAngle(shape15, 0.0F, -0.0F, 0.22689279913902285F);
		this.shape43 = new ModelRenderer(this, 0, 181);
		this.shape43.setRotationPoint(-6.0F, 2.0F, -0.5F);
		this.shape43.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1, 0.0F);
		this.setRotateAngle(shape43, 0.0F, 0.13962633907794952F, 0.0F);
		this.shape50 = new ModelRenderer(this, 0, 193);
		this.shape50.setRotationPoint(60.5F, -0.5F, -0.5F);
		this.shape50.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
		this.shape32 = new ModelRenderer(this, 0, 41);
		this.shape32.setRotationPoint(58.0F, -1.0F, -1.0F);
		this.shape32.addBox(0.0F, 0.0F, 0.0F, 3, 7, 7, 0.0F);
		this.shape35 = new ModelRenderer(this, 206, 12);
		this.shape35.setRotationPoint(2.0F, -2.5F, 2.0F);
		this.shape35.addBox(-7.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.setRotateAngle(shape35, 0.0F, -0.0F, -0.296705961227417F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.shape22.render(f5);
		this.shape37.render(f5);
		this.shape12.render(f5);
		this.shape10.render(f5);
		this.shape5.render(f5);
		this.shape41.render(f5);
		this.shape1.render(f5);
		this.shape42.render(f5);
		this.shape25.render(f5);
		this.shape17.render(f5);
		this.shape6.render(f5);
		this.shape48.render(f5);
		this.shape13.render(f5);
		this.shape14.render(f5);
		this.shape20.render(f5);
		this.shape38.render(f5);
		this.shape46.render(f5);
		this.shape21.render(f5);
		this.shape2.render(f5);
		this.shape39.render(f5);
		this.shape30.render(f5);
		this.shape31.render(f5);
		this.shape7.render(f5);
		this.shape45.render(f5);
		this.shape40.render(f5);
		this.shape49.render(f5);
		this.shape3.render(f5);
		this.shape44.render(f5);
		this.shape18.render(f5);
		this.shape16.render(f5);
		this.shape23.render(f5);
		this.shape27.render(f5);
		this.shape47.render(f5);
		this.shape34.render(f5);
		this.shape28.render(f5);
		this.shape9.render(f5);
		this.shape19.render(f5);
		this.shape4.render(f5);
		this.shape29.render(f5);
		this.shape11.render(f5);
		this.shape33.render(f5);
		this.shape24.render(f5);
		this.shape26.render(f5);
		this.shape36.render(f5);
		this.shape8.render(f5);
		this.shape15.render(f5);
		this.shape43.render(f5);
		this.shape50.render(f5);
		this.shape32.render(f5);
		this.shape35.render(f5);
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

	@Override
	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
	{
		return true;
	}

	@Override
	public ResourceLocation getResourceLocation(boolean alt)
	{
		if (alt)
			return this.tB;
		return this.tA;
	}

	@Override
	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
	{
		switch (type)
		{
			case ENTITY:
				GL11.glPushMatrix();
				GL11.glScalef(0.03f, 0.03f, 0.03f);
				GL11.glRotatef(-90, 0, 0, 1);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glTranslatef(-40, -2, -2);
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case EQUIPPED:
				GL11.glPushMatrix();
				GL11.glScalef(0.035f, 0.035f, 0.035f);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glRotatef(45, 0, 1, 0);
				GL11.glRotatef(20, 0, 0, 1);
				GL11.glRotatef(90, 1, 0, 0);
				GL11.glTranslatef(8, -2, 25);
				if (data[1] instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer)data[1];
					if (player.isBlocking())
					{
						GL11.glRotatef(40, 0, 0, 1);
						GL11.glTranslatef(-3, -16, 0);
					}
				}
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();
				GL11.glScalef(0.05f, 0.05f, 0.05f);
				GL11.glTranslatef(0, 25, 0);
				GL11.glRotatef(-130, 0, 1, 0);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glRotatef(75, 0, 0, 1);
				GL11.glRotatef(85, 1, 0, 0);
				GL11.glTranslatef(0, 18, 0);
				if (data[1] instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer)data[1];
					if (player.isBlocking())
					{
						GL11.glRotatef(-20, 0, 0, 1);
						GL11.glRotatef(70, 0, 1, 0);
						GL11.glRotatef(30, 1, 0, 0);
						GL11.glTranslatef(-4, 12, 15);
					}
				}
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case INVENTORY:
				GL11.glScalef(0.042f, 0.042f, 0.042f);
				GL11.glTranslatef(-25, 3, 0);
				GL11.glRotatef(160, 0, 0, 1);
				GL11.glRotatef(180, 0, 1, 0);
				GL11.glRotatef(90, 1, 0, 0);
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				break;
			default:
				break;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
	{
		return true;
	}
}
