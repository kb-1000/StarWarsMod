package com.parzi.starwarsmod.rendering.gui;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.jedirobes.ArmorJediRobes;
import com.parzi.starwarsmod.jedirobes.powers.Power;
import com.parzi.starwarsmod.network.PacketRobesIntNBT;
import com.parzi.starwarsmod.network.PacketRobesPowerNBT;
import com.parzi.starwarsmod.network.PacketRobesStringNBT;
import com.parzi.starwarsmod.utils.ForceUtils;
import com.parzi.util.ui.LangUtils;
import com.parzi.util.ui.Text;
import com.parzi.util.ui.TextUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiScreenJediRobes extends GuiScreen
{
	private GuiScreen mainMenu;
	private GuiSlotPowerList powerList;
	private int selected = -1;
	private GuiPowerListItem selectedPower;
	private int listWidth = 0;
	private ArrayList<String> powers;

	private GuiButton learnButton;
	private GuiButton enableButton;

	private ItemStack stack;
	private EntityPlayer player;

	private int points = 0;

	public GuiScreenJediRobes(EntityPlayer player)
	{
		this.mc = Minecraft.getMinecraft();
		this.stack = player.getEquipmentInSlot(3);
		this.player = player;

		this.powers = ForceUtils.getPowersAvailableAtLevel(ArmorJediRobes.getSide(stack), (int)Math.floor(ArmorJediRobes.getLevel(stack) / 10f));

		this.points = ArmorJediRobes.getPoints(stack);
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled)
		{
			if (button.id == this.enableButton.id)
			{
				ForceUtils.activePower = this.selectedPower.power;
				StarWarsMod.network.sendToServer(new PacketRobesStringNBT(Resources.nbtActive, this.selectedPower.power.name, StarWarsMod.mc.thePlayer.dimension, StarWarsMod.mc.thePlayer.getCommandSenderName()));
				StarWarsMod.network.sendToServer(new PacketRobesIntNBT(Resources.nbtActiveLevel, Power.getPowerFromName(this.selectedPower.power.name).currentLevel, StarWarsMod.mc.thePlayer.dimension, StarWarsMod.mc.thePlayer.getCommandSenderName()));
				if (this.selectedPower.power.name.equals("defend"))
					StarWarsMod.network.sendToServer(new PacketRobesIntNBT(Resources.nbtActiveHealth, Power.getPowerFromName(this.selectedPower.power.name).currentLevel, StarWarsMod.mc.thePlayer.dimension, StarWarsMod.mc.thePlayer.getCommandSenderName()));
			}
			if (button.id == this.learnButton.id && this.selectedPower.power != null)
			{
				Power.getPowerFromName(this.selectedPower.power.name).currentLevel++;
				StarWarsMod.network.sendToServer(new PacketRobesPowerNBT(this.selectedPower.power.name, Power.getPowerFromName(this.selectedPower.power.name).currentLevel, this.player.dimension, this.player.getCommandSenderName()));
				StarWarsMod.network.sendToServer(new PacketRobesIntNBT(Resources.nbtRemainingPts, --points, player.dimension, player.getCommandSenderName()));
			}
		}
	}

	public boolean canLearn(Power power)
	{
		if (power == null)
			return false;
		return (power.currentLevel < power.maxLevel || power.maxLevel == -1) && points > 0;
	}

	public void drawBg2()
	{
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_FOG);
		Tessellator tessellator = Tessellator.instance;
		this.mc.getTextureManager().bindTexture(optionsBackground);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		float f = 32.0F;
		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(4210752);
		tessellator.addVertexWithUV(0.0D, this.height, 0.0D, 0.0D, this.height / f + 1);
		tessellator.addVertexWithUV(this.width, this.height, 0.0D, this.width / f, this.height / f + 1);
		tessellator.addVertexWithUV(this.width, 0.0D, 0.0D, this.width / f, 1);
		tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 1);
		tessellator.draw();
	}

	public int drawLine(String line, int offset, int shifty)
	{
		this.fontRendererObj.drawString(line, offset, shifty, 0xd7edea);
		return shifty + 10;
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	@Override
	public void drawScreen(int p_571_1_, int p_571_2_, float p_571_3_)
	{
		this.powerList.drawScreen(p_571_1_, p_571_2_, p_571_3_);
		int offset = (this.listWidth + this.width) / 2;
		int y = 5;
		this.drawCenteredString(this.fontRendererObj, String.format("Level %s %s ", (int)Math.floor(ArmorJediRobes.getLevel(stack) / 10f), ForceUtils.getTitle(ArmorJediRobes.getSide(stack), (int)Math.floor(ArmorJediRobes.getLevel(stack) / 10f))) + TextUtils.addEffect(this.player.getCommandSenderName(), ArmorJediRobes.getSide(stack).equals(ArmorJediRobes.SIDE_JEDI) ? Text.COLOR_BLUE : Text.COLOR_DARK_RED), offset, y += 10, 0xFFFFFF);
		this.drawCenteredString(this.fontRendererObj, String.format("%s available upgrade points", points), offset, y += 10, 0xFFFFFF);
		y += 10;
		if (this.selectedPower != null)
		{
			GL11.glEnable(GL11.GL_BLEND);
			this.drawCenteredString(this.fontRendererObj, this.selectedPower.localizedName, offset, y += 10, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, String.format("Current Level: %s", this.selectedPower.power == null ? 0 : this.selectedPower.power.currentLevel), offset, y += 10, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, String.format("XP/use: %s", this.selectedPower.power == null ? 0 : this.selectedPower.power.getCost()), offset, y += 10, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, String.format("Recharge Time: %s seconds", this.selectedPower.power == null ? 0 : this.selectedPower.power.rechargeTime), offset, y += 10, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, "Description and Use:", offset, y += 10, 0xDDDDDD);
			this.fontRendererObj.drawSplitString(this.selectedPower.localizedDesc, offset - 125, y += 10, 250, 0xDDDDDD);
			GL11.glDisable(GL11.GL_BLEND);

			if (this.selectedPower.power != null)
			{
				this.enableButton.enabled = this.selectedPower.power.currentLevel > 0 && ForceUtils.activePower != this.selectedPower.power;
				this.learnButton.enabled = this.canLearn(this.selectedPower.power);
			}
		}
		else
		{
			this.learnButton.enabled = false;
			this.enableButton.enabled = false;
		}
		super.drawScreen(p_571_1_, p_571_2_, p_571_3_);
	}

	FontRenderer getFontRenderer()
	{
		/** The FontRenderer used by GuiScreen */
		return this.fontRendererObj;
	}

	Minecraft getMinecraftInstance()
	{
		/** Reference to the Minecraft object. */
		return this.mc;
	}

	public boolean indexSelected(int var1)
	{
		return var1 == this.selected;
	}

	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void initGui()
	{
		ArrayList<GuiPowerListItem> items = new ArrayList<GuiPowerListItem>();

		this.listWidth = 100;

		for (String power : this.powers)
		{
			GuiPowerListItem item = new GuiPowerListItem();
			item.localizedName = LangUtils.translate("force.power." + power);
			item.localizedDesc = LangUtils.translate("force.power." + power + ".desc");

			if (this.stack != null)
			{
				item.power = Power.getPowerFromName(power);
				if (item.power != null)
					item.power.currentLevel = ArmorJediRobes.getLevelOf(this.stack, item.power.name);
			}

			items.add(item);
		}

		this.listWidth = Math.min(this.listWidth, 150);
		this.powerList = new GuiSlotPowerList(this, items, this.listWidth);
		this.powerList.registerScrollButtons(this.buttonList, 7, 8);

		this.learnButton = new GuiButton(20, 10, this.height - 60, this.listWidth, 20, "Learn");
		this.enableButton = new GuiButton(21, 10, this.height - 38, this.listWidth, 20, "Enable");
		this.buttonList.add(this.learnButton);
		this.buttonList.add(this.enableButton);
	}

	/**
	 * @param var1
	 */
	public void selectIndex(int var1)
	{
		this.selected = var1;
		if (var1 >= 0 && var1 <= this.powerList.getSize())
			this.selectedPower = this.powerList.powers.get(this.selected);
		else
			this.selectedPower = null;
	}
}