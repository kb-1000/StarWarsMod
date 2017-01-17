package com.parzivail.pswm.render;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelHothScoot;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/17/2017.
 */
public class RenderHothScoot extends RenderStarship
{
	public RenderHothScoot(RenderManager manager)
	{
		super(manager, new ModelHothScoot(), new ResourceLocation(Resources.MODID, "textures/models/hothscoot.png"));
	}
}