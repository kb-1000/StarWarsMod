package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorSequelStormtrooper extends ItemArmor
{
	private String[] names = { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorSequelStormtrooper(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName(StarWarsMod.MODID + "." + "stormtrooper" + this.names[par4] + "_new");
		this.setTextureName(StarWarsMod.MODID + ":" + "stormtrooper" + this.names[par4] + "_new");
		this.setCreativeTab(StarWarsMod.SequelStarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.stormtrooperHelmet || stack.getItem() == StarWarsMod.stormtrooperChest || stack.getItem() == StarWarsMod.stormtrooperBoots) return StarWarsMod.MODID + ":" + "textures/models/stormtrooperArmorLayer1_new.png";
		if (stack.getItem() == StarWarsMod.stormtrooperLegs) return StarWarsMod.MODID + ":" + "textures/models/stormtrooperArmorLayer2_new.png";
		return "";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\armor\ArmorStormtrooper.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */