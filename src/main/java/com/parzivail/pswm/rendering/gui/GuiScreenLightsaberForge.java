package com.parzivail.pswm.rendering.gui;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.weapons.ItemLightsaber;
import com.parzivail.pswm.rendering.RenderLightsaber;
import com.parzivail.util.ui.GLPalette;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import scala.actors.threadpool.Arrays;

@SideOnly(Side.CLIENT)
public class GuiScreenLightsaberForge extends GuiScreen
{
	private EntityPlayer player;
	private static final ResourceLocation background = new ResourceLocation(Resources.MODID, "textures/gui/space.png");

	OutlineButton bTabHilts;
	OutlineButton bTabBlade;
	OutlineButton bTabOptions;

	OutlineButton bSave;

	Map<String, OutlineButton> listBHilts;
	Map<String, OutlineButton> listBBlade;
	Map<String, OutlineButton> listBOptions;

	ItemStack stackShowing;
	RenderLightsaber renderLightsaber;

	public GuiScreenLightsaberForge(EntityPlayer player)
	{
		this.mc = Minecraft.getMinecraft();
		this.player = player;

		stackShowing = new ItemStack(StarWarsMod.lightsaberNew[0], 1);
		ItemLightsaber.setupNBT(0, stackShowing);
		if (player.inventory.getCurrentItem() != null)
			stackShowing = player.inventory.getCurrentItem().copy();

		renderLightsaber = new RenderLightsaber();
	}

	@Override
	public void initGui()
	{
		int id = 0;
		bTabHilts = new OutlineButton(id++, 10, 10, 40, 20, "Hilts", true);
		bTabBlade = new OutlineButton(id++, 60, 10, 40, 20, "Blades", false);
		bTabOptions = new OutlineButton(id++, 110, 10, 40, 20, "Options", false);

		buttonList.add(bTabHilts);
		buttonList.add(bTabBlade);
		buttonList.add(bTabOptions);

		bSave = new OutlineButton(id++, 375, 10, 40, 20, "Save", false);

		buttonList.add(bSave);

		listBHilts = new HashMap<>();
		listBBlade = new HashMap<>();
		listBOptions = new HashMap<>();

		int x = 0;
		int y = 0;
		for (String s : ItemLightsaber.hilts)
		{
			OutlineButton b = new OutlineModelButton(id++, s, x * 32 + 10, y * 32 + 40, RenderLightsaber.models.get(s));
			b.visible = true;
			listBHilts.put(s, b);
			buttonList.add(b);
			x++;
			if (x >= 3)
			{
				x = 0;
				y++;
			}
		}

		x = 0;
		y = 0;
		for (int i = 0; i < ItemLightsaber.colorHex.length; i++)
		{
			OutlineButton b = new FilledColorButton(id++, x * 32 + 10, y * 32 + 40, 30, 30, ItemLightsaber.colorHex[i]);
			b.visible = false;
			listBBlade.put(ItemLightsaber.colorName[i], b);
			buttonList.add(b);
			x++;
			if (x >= 3)
			{
				x = 0;
				y++;
			}
		}

		x = 0;
		y = 0;
		OutlineButton bBladeToggle = new OutlineButton(id++, x * 32 + 10, y * 32 + 40, 140, 30, "Toggle Blade", false);
		bBladeToggle.visible = false;
		listBOptions.put("toggleBlade", bBladeToggle);
		buttonList.add(bBladeToggle);
		y++;
		OutlineButton bBladeLength = new OutlineButton(id++, x * 32 + 10, y * 32 + 40, 140, 30, "Blade Length", false);
		bBladeLength.visible = false;
		listBOptions.put("bladeLength", bBladeLength);
		buttonList.add(bBladeLength);
		y++;
		int l = stackShowing.stackTagCompound.getInteger(ItemLightsaber.nbtBladeLength);
		switch (l)
		{
			case 0:
				listBOptions.get("bladeLength").displayString = "Blade Length: Short";
				break;
			case 1:
				listBOptions.get("bladeLength").displayString = "Blade Length: Medium";
				break;
			case 2:
				listBOptions.get("bladeLength").displayString = "Blade Length: Long";
				break;
			default:
				break;
		}
		OutlineButton bBladeWaterproof = new OutlineButton(id++, x * 32 + 10, y * 32 + 40, 140, 30, "Toggle Waterproof", false);
		bBladeWaterproof.visible = false;
		listBOptions.put("bladeWaterproof", bBladeWaterproof);
		buttonList.add(bBladeWaterproof);
		y++;
		OutlineButton bBladeDistort = new OutlineButton(id++, x * 32 + 10, y * 32 + 40, 140, 30, "Toggle Distortion", false);
		bBladeDistort.visible = false;
		listBOptions.put("bladeDistort", bBladeDistort);
		buttonList.add(bBladeDistort);
		y++;
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled && button.visible)
		{
			if (RenderLightsaber.models.containsKey(button.displayString))
			{
				for (OutlineButton b : listBHilts.values())
					b.selected = (b.displayString.equals(button.displayString));
				int color = stackShowing.stackTagCompound.getInteger(ItemLightsaber.nbtBladeColor);
				ItemLightsaber.setupNBT(Arrays.asList(ItemLightsaber.hilts).indexOf(button.displayString), stackShowing);
				stackShowing.stackTagCompound.setInteger(ItemLightsaber.nbtBladeColor, color);
				stackShowing.stackTagCompound.setString(ItemLightsaber.nbtHilt, button.displayString);
				stackShowing.stackTagCompound.setBoolean(ItemLightsaber.nbtBladeOn, listBOptions.get("toggleBlade").selected);
				int l = stackShowing.stackTagCompound.getInteger(ItemLightsaber.nbtBladeLength);
				switch (l)
				{
					case 0:
						listBOptions.get("bladeLength").displayString = "Blade Length: Short";
						break;
					case 1:
						listBOptions.get("bladeLength").displayString = "Blade Length: Medium";
						break;
					case 2:
						listBOptions.get("bladeLength").displayString = "Blade Length: Long";
						break;
					default:
						break;
				}
			}
			else if (button instanceof FilledColorButton)
			{
				stackShowing.stackTagCompound.setInteger(ItemLightsaber.nbtBladeColor, ((FilledColorButton)button).color);
			}
			else if (button.id == listBOptions.get("toggleBlade").id)
			{
				stackShowing.stackTagCompound.setBoolean(ItemLightsaber.nbtBladeOn, !stackShowing.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeOn));
				listBOptions.get("toggleBlade").selected = stackShowing.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeOn);
			}
			else if (button.id == bSave.id)
			{
				player.inventory.mainInventory[player.inventory.currentItem] = this.stackShowing;
				StarWarsMod.mc.currentScreen = null;
				StarWarsMod.mc.setIngameFocus();
			}
			else if (button.id == listBOptions.get("bladeWaterproof").id)
			{
				stackShowing.stackTagCompound.setBoolean(ItemLightsaber.nbtBladeWaterproof, !stackShowing.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeWaterproof));
				listBOptions.get("bladeWaterproof").selected = stackShowing.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeWaterproof);
			}
			else if (button.id == listBOptions.get("bladeDistort").id)
			{
				stackShowing.stackTagCompound.setBoolean(ItemLightsaber.nbtBladeDistortion, !stackShowing.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeDistortion));
				listBOptions.get("bladeDistort").selected = stackShowing.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeDistortion);
			}
			else if (button.id == listBOptions.get("bladeLength").id)
			{
				int l = stackShowing.stackTagCompound.getInteger(ItemLightsaber.nbtBladeLength);
				switch (l)
				{
					case 0:
						listBOptions.get("bladeLength").displayString = "Blade Length: Medium";
						l = 1;
						break;
					case 1:
						listBOptions.get("bladeLength").displayString = "Blade Length: Long";
						l = 2;
						break;
					case 2:
						listBOptions.get("bladeLength").displayString = "Blade Length: Short";
						l = 0;
						break;
					default:
						break;
				}
				stackShowing.stackTagCompound.setInteger(ItemLightsaber.nbtBladeLength, l);
			}
			else if (button.id == bTabHilts.id)
			{
				bTabHilts.selected = true;
				bTabBlade.selected = false;
				bTabOptions.selected = false;
				for (OutlineButton b : listBHilts.values())
					b.visible = true;
				for (OutlineButton b : listBBlade.values())
					b.visible = false;
				for (OutlineButton b : listBOptions.values())
					b.visible = false;
			}
			else if (button.id == bTabBlade.id)
			{
				bTabHilts.selected = false;
				bTabBlade.selected = true;
				bTabOptions.selected = false;
				for (OutlineButton b : listBBlade.values())
					b.visible = true;
				for (OutlineButton b : listBHilts.values())
					b.visible = false;
				for (OutlineButton b : listBOptions.values())
					b.visible = false;
			}
			else if (button.id == bTabOptions.id)
			{
				bTabHilts.selected = false;
				bTabBlade.selected = false;
				bTabOptions.selected = true;
				for (OutlineButton b : listBOptions.values())
					b.visible = true;
				for (OutlineButton b : listBHilts.values())
					b.visible = false;
				for (OutlineButton b : listBBlade.values())
					b.visible = false;
			}
		}
	}

	public void drawBg2()
	{
		Tessellator tessellator = Tessellator.instance;
		this.mc.getTextureManager().bindTexture(background);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		float f = 200.0F;
		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(0xFFFFFFFF);
		tessellator.addVertexWithUV(0.0D, this.height, 0.0D, 0.0D, this.height / f + 1);
		tessellator.addVertexWithUV(this.width, this.height, 0.0D, this.width / f, this.height / f + 1);
		tessellator.addVertexWithUV(this.width, 0.0D, 0.0D, this.width / f, 1);
		tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 1);
		tessellator.draw();
	}

	@Override
	public void drawScreen(int mX, int mY, float p)
	{
		this.drawBg2();

		GL11.glPushMatrix();

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LIGHTING);
		RenderHelper.enableStandardItemLighting();

		GLPalette.glColorI(GLPalette.WHITE);

		GL11.glTranslatef(290, 215, 130);
		GL11.glScalef(130, -130, 130);
		GL11.glRotatef((System.currentTimeMillis() / 10) % 360, 0, 1, 0);

		RenderLightsaber.applyTransformFix(this.stackShowing.stackTagCompound.getString(ItemLightsaber.nbtHilt));

		String s = stackShowing.stackTagCompound.getString(ItemLightsaber.nbtHilt);

		if (stackShowing.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeOn))
		{
			if (s.equals("dooku"))
			{
				GL11.glScalef(0.45f, 0.45f, 0.45f);
				GL11.glTranslatef(0, -0.5f, 0);
			}
			else if (s.equals("ezra"))
			{
				GL11.glScalef(0.4f, 0.4f, 0.4f);
				GL11.glTranslatef(0, -0.6f, 0);
			}
			else if (s.equals("kanan"))
			{
				GL11.glScalef(0.45f, 0.45f, 0.45f);
				GL11.glTranslatef(0, -0.7f, 0);
			}
			else if (s.equals("maul"))
			{
				GL11.glScalef(0.4f, 0.4f, 0.4f);
				GL11.glTranslatef(0, 1.4f, 0);
			}
			else if (s.equals("padawan"))
			{
				GL11.glScalef(0.45f, 0.45f, 0.45f);
				GL11.glTranslatef(0, -1.1f, 0);
			}
			else if (s.equals("shoto"))
			{
				GL11.glScalef(0.45f, 0.45f, 0.45f);
				GL11.glTranslatef(0, -0.8f, 0);
			}
			else if (s.equals("doubleSith"))
			{
				GL11.glScalef(0.3f, 0.3f, 0.3f);
				GL11.glTranslatef(0, 2.5f, 0);
			}
			else if (s.equals("vader2"))
			{
				GL11.glScalef(0.35f, 0.35f, 0.35f);
				GL11.glTranslatef(0, -0.65f, 0);
			}
			else if (s.equals("luke1"))
			{
				GL11.glScalef(0.3f, 0.3f, 0.3f);
				GL11.glTranslatef(0, -0.95f, 0);
			}
			else if (s.equals("luke2"))
			{
				GL11.glScalef(0.4f, 0.4f, 0.4f);
				GL11.glTranslatef(0, -0.7f, 0);
			}
			else if (s.equals("crossguard"))
			{
				GL11.glScalef(0.35f, 0.35f, 0.35f);
				GL11.glTranslatef(0, -0.9f, 0);
			}
			else if (s.equals("malgus"))
			{
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				GL11.glTranslatef(0, -0.75f, 0);
			}
			else if (s.equals("obiwan"))
			{
				GL11.glScalef(0.5f, 0.5f, 0.5f);
				GL11.glTranslatef(0, -0.9f, 0);
			}
			else if (s.equals("quigon"))
			{
				GL11.glScalef(0.5f, 0.5f, 0.5f);
				GL11.glTranslatef(0, -0.95f, 0);
			}
			else if (s.equals("revan"))
			{
				GL11.glScalef(0.5f, 0.5f, 0.5f);
				GL11.glTranslatef(0, -0.95f, 0);
			}
			else if (s.equals("starkiller"))
			{
				GL11.glScalef(0.5f, 0.5f, 0.5f);
				GL11.glTranslatef(0, -0.82f, 0);
			}
		}

		renderLightsaber.renderItem(ItemRenderType.ENTITY, stackShowing);

		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);

		GL11.glPopMatrix();

		super.drawScreen(mX, mY, p);
	}
}