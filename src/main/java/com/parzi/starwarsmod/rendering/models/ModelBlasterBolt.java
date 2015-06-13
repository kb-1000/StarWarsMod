package com.parzi.starwarsmod.rendering.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBlasterBolt extends ModelBase {
	// fields
	ModelRenderer Shape1;

	public ModelBlasterBolt() {
		textureWidth = 64;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(-0.5F, 0F, -3.5F, 1, 1, 7);
		Shape1.setRotationPoint(0F, 23F, 0F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		Shape1.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
