package com.parzi.starwarsmod;

import java.io.InputStream;
import java.net.URL;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import org.apache.commons.io.IOUtils;

import com.parzi.starwarsmod.achievement.StarWarsAchievements;
import com.parzi.starwarsmod.commands.CommandFlySpeed;
import com.parzi.starwarsmod.commands.CommandJediRobes;
import com.parzi.starwarsmod.commands.CommandSWDim;
import com.parzi.starwarsmod.handlers.ClientEventHandler;
import com.parzi.starwarsmod.handlers.CommonEventHandler;
import com.parzi.starwarsmod.handlers.GuiHandler;
import com.parzi.starwarsmod.items.crafting.ItemLightsaberCrystal;
import com.parzi.starwarsmod.items.weapons.ItemBlasterHeavy;
import com.parzi.starwarsmod.items.weapons.ItemBlasterPistol;
import com.parzi.starwarsmod.items.weapons.ItemBlasterRifle;
import com.parzi.starwarsmod.items.weapons.ItemEwokSpear;
import com.parzi.starwarsmod.items.weapons.ItemGaffiStick;
import com.parzi.starwarsmod.items.weapons.ItemGamorreanAx;
import com.parzi.starwarsmod.items.weapons.ItemLightsaber;
import com.parzi.starwarsmod.items.weapons.ItemLightsaberOff;
import com.parzi.starwarsmod.items.weapons.ItemSequelBlasterPistol;
import com.parzi.starwarsmod.items.weapons.ItemSequelBlasterRifle;
import com.parzi.starwarsmod.items.weapons.ItemSequelLightsaber;
import com.parzi.starwarsmod.items.weapons.ItemSequelLightsaberOff;
import com.parzi.starwarsmod.items.weapons.ItemWookieeBowcaster;
import com.parzi.starwarsmod.network.PacketCreateBlasterBolt;
import com.parzi.starwarsmod.network.PacketDestructionBolt;
import com.parzi.starwarsmod.network.PacketEntityAlterMotion;
import com.parzi.starwarsmod.network.PacketEntityHurt;
import com.parzi.starwarsmod.network.PacketEntitySetMotion;
import com.parzi.starwarsmod.network.PacketHealBlock;
import com.parzi.starwarsmod.network.PacketPlayerLightning;
import com.parzi.starwarsmod.network.PacketReverseEntity;
import com.parzi.starwarsmod.network.PacketRobesBooleanNBT;
import com.parzi.starwarsmod.network.PacketRobesIntNBT;
import com.parzi.starwarsmod.network.PacketRobesPowerNBT;
import com.parzi.starwarsmod.network.PacketRobesStringNBT;
import com.parzi.starwarsmod.network.PacketShipTargetLock;
import com.parzi.starwarsmod.network.PacketTeleportPlayerNetwork;
import com.parzi.starwarsmod.network.PacketTogglePlayerLightsaber;
import com.parzi.starwarsmod.network.PacketTogglePlayerSequelLightsaber;
import com.parzi.starwarsmod.network.PacketUpdateRobes;
import com.parzi.starwarsmod.network.PacketXwingSfoil;
import com.parzi.starwarsmod.registry.BlockRegister;
import com.parzi.starwarsmod.registry.EntityRegister;
import com.parzi.starwarsmod.registry.ItemRegister;
import com.parzi.starwarsmod.registry.MaterialRegister;
import com.parzi.starwarsmod.registry.RecipeRegister;
import com.parzi.starwarsmod.registry.WorldRegister;
import com.parzi.starwarsmod.tabs.SequelStarWarsTab;
import com.parzi.starwarsmod.tabs.StarWarsTab;
import com.parzi.util.ui.Lumberjack;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Resources.MODID, version = Resources.VERSION, name = "Parzi's Star Wars Mod", acceptedMinecraftVersions = "[1.7.10]")
public class StarWarsMod
{
	public static boolean hasShownNeedUpdate = false;

	public static Configuration config;

	public static Random rngGeneral = new Random();
	public static Random rngChromium = new Random();
	public static Random rngTitanium = new Random();

	@Mod.Instance(Resources.MODID)
	public static StarWarsMod instance;

	@SideOnly(Side.CLIENT)
	public static Minecraft mc;

	public static ClientEventHandler clientHandler;
	public static CommonEventHandler commonHandler;

	@SidedProxy(clientSide = "com.parzi.starwarsmod.StarWarsClientProxy", serverSide = "com.parzi.starwarsmod.StarWarsCommonProxy")
	public static StarWarsCommonProxy proxy;
	public static SimpleNetworkWrapper network;

	public static CreativeTabs StarWarsTab;
	public static CreativeTabs SequelStarWarsTab;

	public static ItemGaffiStick gaffiStick;
	public static ItemLightsaber lightsaber;
	public static ItemLightsaberOff lightsaberOff;
	public static ItemSequelLightsaber sequelLightsaber;
	public static ItemSequelLightsaberOff sequelLightsaberOff;
	public static ItemBlasterPistol blasterPistol;
	public static ItemBlasterRifle blasterRifle;
	public static ItemSequelBlasterRifle sequelBlasterRifle;
	public static ItemSequelBlasterPistol sequelBlasterPistol;
	public static ItemBlasterHeavy blasterHeavy;
	public static ItemEwokSpear ewokSpear;
	public static ItemWookieeBowcaster bowcaster;
	public static ItemGamorreanAx gamorreanAx;
	public static ItemLightsaberCrystal lightsaberCrystal;

	public static Item customTest;

	public static Item hiltMetelCompound;
	public static Item hiltMetelAlloy;
	public static Item plasmaEmitter;
	public static Item containmentField;
	public static Item blasterXWingBolt;
	public static Item blasterTIEBolt;
	public static Item blasterBolt;
	public static Item blasterRifleBolt;
	public static Item banthaHorn;
	public static Item droidCaller;
	public static Item droidHacker;
	public static Item imperialCredit;
	public static Item silverImperialCredit;
	public static Item goldImperialCredit;
	public static Item waterDroplet;

	public static Item binoculars;
	public static Item binocularsHoth;

	public static Item debugLootGen;
	public static Item debugLandspeederNPC;

	public static Item chromiumDust;
	public static Item titaniumDust;
	public static Item titaniumChromiumDust;
	public static Item titaniumChromiumIngot;

	public static Item hyperdriveMotivator;
	public static Item hyperdriveEngine;
	public static Item hyperdriveEarth;
	public static Item hyperdriveTatooine;
	public static Item hyperdriveHoth;
	public static Item hyperdriveKashyyyk;
	public static Item hyperdriveYavin4;
	public static Item hyperdriveEndor;
	public static Item hyperdriveIlum;
	public static Item hyperdriveDagobah;

	public static Item spawnSpeederBike;
	public static Item spawnJakkuSpeeder;
	public static Item spawnHothSpeederBike;
	public static Item spawnLandspeeder;
	public static Item spawnTie;
	public static Item spawnTieInterceptor;
	public static Item spawnAwing;
	public static Item spawnXwing;
	public static Item spawnDsTurret;
	public static Item spawnAstromech;
	public static Item spawnAstromechImperial;
	public static Item spawnAstromechImperial2;
	public static Item spawnAstromech2;
	public static Item spawnAstromechBb8;
	public static Item spawnProtocol;
	public static Item spawnProtocol2;
	public static Item spawnProbe;
	public static Item spawnMouse;
	public static Item spawnGonk;
	public static Item spawnSurgical;
	public static Item spawnTreadwell;

	public static Item jediRobes;

	public static Item recordTheme;
	public static Item recordThrone;
	public static Item recordBinary;
	public static Item recordImperial;
	public static Item recordCantina;

	public static Item endorHelmet;
	public static Item endorChest;
	public static Item endorLegs;
	public static Item endorBoots;

	public static Item rebelPilotHelmet;
	public static Item rebelPilotChest;
	public static Item rebelPilotLegs;
	public static Item rebelPilotBoots;

	public static Item stormtrooperHelmet;
	public static Item stormtrooperChest;
	public static Item stormtrooperLegs;
	public static Item stormtrooperBoots;

	public static Item stormtrooperNewHelmet;
	public static Item stormtrooperNewChest;
	public static Item stormtrooperNewLegs;
	public static Item stormtrooperNewBoots;

	public static Item stormtrooperSilverNewHelmet;
	public static Item stormtrooperSilverNewChest;
	public static Item stormtrooperSilverNewLegs;
	public static Item stormtrooperSilverNewBoots;

	public static Item snowtrooperHelmet;
	public static Item snowtrooperChest;
	public static Item snowtrooperLegs;
	public static Item snowtrooperBoots;

	public static Item scoutTrooperHelmet;
	public static Item scoutTrooperChest;
	public static Item scoutTrooperLegs;
	public static Item scoutTrooperBoots;

	public static Item sandtrooperHelmet;
	public static Item sandtrooperChest;
	public static Item sandtrooperLegs;
	public static Item sandtrooperBoots;

	public static Item bobaHelmet;
	public static Item bobaChest;
	public static Item bobaJetpack;
	public static Item bobaJetpackChest;
	public static Item bobaLegs;
	public static Item bobaBoots;

	public static Item tiePilotHelmet;
	public static Item tiePilotChest;
	public static Item tiePilotLegs;
	public static Item tiePilotBoots;

	public static Item fleetHelmet;
	public static Item fleetChest;
	public static Item fleetLegs;
	public static Item fleetBoots;

	public static Item atatPilotHelmet;
	public static Item atatPilotChest;
	public static Item atatPilotLegs;
	public static Item atatPilotBoots;

	public static Item hothHelmet;
	public static Item hothChest;
	public static Item hothLegs;
	public static Item hothBoots;

	public static Item leiasBuns;

	public static ItemFood banthaChop;
	public static ItemFood banthaChopCooked;
	public static ItemFood banthaMilk;
	public static ItemFood acidBeets;
	public static ItemFood banthaPlatter;
	public static ItemFood canron;
	public static ItemFood chasuka;
	public static ItemFood dewbackRibs;
	public static ItemFood gorrnar;

	public static BiomeGenBase biomeTatooine;
	public static BiomeGenBase biomeHoth;
	public static BiomeGenBase biomeKashyyyk;
	public static BiomeGenBase biomeYavin4;
	public static BiomeGenBase biomeEndor;
	public static BiomeGenBase biomeEndorPlains;
	public static BiomeGenBase biomeDagobah;
	public static BiomeGenBase biomeIlum;

	public static boolean isWorldRegistered = false;

	public static boolean isOverlayOnscreen = false;

	public static Block blockMV;
	public static Block blockFieldEmitter;
	public static Block blockDeathStarDoor;
	public static Block blockTable;
	public static Block blockTable2;
	public static Block blockChromiumOre;
	public static Block blockTitaniumOre;
	public static Block blockTitaniumChromiumBlock;
	public static Block blockDeathStarGlass;
	public static Block blockEndorBaseWall;
	public static Block blockEndorBaseWallStairs;
	public static Block blockMudStairs;
	public static Block blockDeathStarLight;
	public static Block blockDeathStarBlock;
	public static Block blockTatooineSand;
	public static Block blockTatooineSandstone;
	public static Block blockSpaceLamp;
	public static Block blockDagobahMud;
	public static Block blockHangingCauldron;
	public static Block blockHangingBucket;
	public static Block blockBasket;

	public static Item.ToolMaterial materialGaffi;
	public static Item.ToolMaterial materialEwok;
	public static Item.ToolMaterial materialGamorrean;
	public static Item.ToolMaterial materialPlasma;
	public static Item.ToolMaterial materialPlasmaOff;

	public static ArmorMaterial jediRobesMat;
	public static ArmorMaterial endorArmorMat;
	public static ArmorMaterial fleetArmorMat;
	public static ArmorMaterial rebelPilotArmorMat;
	public static ArmorMaterial stormtrooperArmorMat;
	public static ArmorMaterial stormtrooperNewArmorMat;
	public static ArmorMaterial snowtrooperArmorMat;
	public static ArmorMaterial scoutTrooperArmorMat;
	public static ArmorMaterial tiePilotArmorMat;
	public static ArmorMaterial atatPilotArmorMat;
	public static ArmorMaterial hothArmorMat;
	public static ArmorMaterial sandtrooperArmorMat;
	public static ArmorMaterial bobaArmorMat;
	public static ArmorMaterial leiaBunsArmorMat;

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		Lumberjack.info("========== Begin Star Wars Mod init() ==========");

		Lumberjack.info("This is Parzi's Star Wars Mod v" + Resources.VERSION);

		InputStream in = null;
		try
		{
			in = new URL("https://raw.githubusercontent.com/Parzivail-Modding-Team/ParziStarWarsMod/master/VERSION.md").openStream();
			Resources.ONLINE_VERSION = IOUtils.toString(in).replace("\n", "");
			if (!Resources.VERSION.equalsIgnoreCase(Resources.ONLINE_VERSION))
				Lumberjack.log("New version of Parzi's Star Wars Mod available: " + Resources.ONLINE_VERSION + "!");
		}
		catch (Exception e)
		{
			Lumberjack.warn("Couldn't check version!");
		}
		finally
		{
			if (in != null)
				IOUtils.closeQuietly(in);
		}

		instance = this;

		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

		StarWarsMod.commonHandler = new CommonEventHandler();
		StarWarsMod.clientHandler = new ClientEventHandler();

		FMLCommonHandler.instance().bus().register(StarWarsMod.commonHandler);
		MinecraftForge.EVENT_BUS.register(StarWarsMod.clientHandler);

		proxy.doSidedThings();

		EntityRegister.registerAll();

		MaterialRegister.registerAll();

		if (Resources.enableTabOriginal)
			StarWarsTab = new StarWarsTab();
		else
			StarWarsTab = CreativeTabs.tabAllSearch;

		if (Resources.IS_SEQUEL_RELEASE)
		{
			Lumberjack.log("Sequel update! Suck it, JJ!");
			if (Resources.enableTabSequel)
				SequelStarWarsTab = new SequelStarWarsTab();
			else
				SequelStarWarsTab = CreativeTabs.tabAllSearch;
		}

		ItemRegister.registerAll();

		BlockRegister.registerAll();

		WorldRegister.registerAll();

		RecipeRegister.registerAll();

		StarWarsAchievements.registerAll();

		proxy.registerRendering();

		Lumberjack.info("=========== End Star Wars Mod init() ===========");
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		network = NetworkRegistry.INSTANCE.newSimpleChannel(Resources.MODID + "." + "chan");
		int packetId = 0;
		network.registerMessage(PacketRobesIntNBT.Handler.class, PacketRobesIntNBT.class, packetId++, Side.SERVER);
		network.registerMessage(PacketRobesPowerNBT.Handler.class, PacketRobesPowerNBT.class, packetId++, Side.SERVER);
		network.registerMessage(PacketTeleportPlayerNetwork.Handler.class, PacketTeleportPlayerNetwork.class, packetId++, Side.SERVER);
		network.registerMessage(PacketCreateBlasterBolt.Handler.class, PacketCreateBlasterBolt.class, packetId++, Side.SERVER);
		network.registerMessage(PacketTogglePlayerLightsaber.Handler.class, PacketTogglePlayerLightsaber.class, packetId++, Side.SERVER);
		network.registerMessage(PacketTogglePlayerSequelLightsaber.Handler.class, PacketTogglePlayerSequelLightsaber.class, packetId++, Side.SERVER);
		network.registerMessage(PacketShipTargetLock.Handler.class, PacketShipTargetLock.class, packetId++, Side.SERVER);
		network.registerMessage(PacketXwingSfoil.Handler.class, PacketXwingSfoil.class, packetId++, Side.SERVER);
		network.registerMessage(PacketEntityAlterMotion.Handler.class, PacketEntityAlterMotion.class, packetId++, Side.SERVER);
		network.registerMessage(PacketEntityHurt.Handler.class, PacketEntityHurt.class, packetId++, Side.SERVER);
		network.registerMessage(PacketPlayerLightning.Handler.class, PacketPlayerLightning.class, packetId++, Side.SERVER);
		network.registerMessage(PacketDestructionBolt.Handler.class, PacketDestructionBolt.class, packetId++, Side.SERVER);
		network.registerMessage(PacketEntitySetMotion.Handler.class, PacketEntitySetMotion.class, packetId++, Side.SERVER);
		network.registerMessage(PacketReverseEntity.Handler.class, PacketReverseEntity.class, packetId++, Side.SERVER);
		network.registerMessage(PacketHealBlock.Handler.class, PacketHealBlock.class, packetId++, Side.SERVER);
		network.registerMessage(PacketUpdateRobes.Handler.class, PacketUpdateRobes.class, packetId++, Side.SERVER);
		network.registerMessage(PacketRobesBooleanNBT.Handler.class, PacketRobesBooleanNBT.class, packetId++, Side.SERVER);
		network.registerMessage(PacketRobesStringNBT.Handler.class, PacketRobesStringNBT.class, packetId++, Side.SERVER);

		Lumberjack.log("Network registered " + String.valueOf(packetId + 1) + " packets!");

		config = new Configuration(event.getSuggestedConfigurationFile(), Resources.VERSION);
		config.load();

		Resources.enableTabOriginal = config.get("core", "enableTabOriginal", true).getBoolean();
		Resources.enableTabSequel = config.get("core", "enableTabSequel", true).getBoolean();
		Resources.beshOverride = config.get("core", "aurebeshInsteadOfEnglish", false).getBoolean();
		Resources.lightningDatawatcherId = config.get("core", "lightningDatawatcherId", 31).getInt();
		Resources.activeDatawatcherId = config.get("core", "activeDatawatcherId", 30).getInt();
		Resources.runningDatawatcherId = config.get("core", "runningDatawatcherId", 29).getInt();
		Resources.durationDatawatcherId = config.get("core", "durationDatawatcherId", 28).getInt();
		Resources.activeLevelDatawatcherId = config.get("core", "activeLevelDatawatcherId", 27).getInt();
		Resources.activeHealthDatawatcherId = config.get("core", "activeHealthDatawatcherId", 26).getInt();

		Resources.dimTatooineId = config.get("dimensions", "tatooine", 2).getInt();
		Resources.dimHothId = config.get("dimensions", "hoth", 3).getInt();
		Resources.dimKashyyykId = config.get("dimensions", "kashyyyk", 4).getInt();
		Resources.dimYavin4Id = config.get("dimensions", "yavin", 5).getInt();
		Resources.dimEndorId = config.get("dimensions", "endor", 6).getInt();
		Resources.dimIlumId = config.get("dimensions", "ilum", 7).getInt();
		Resources.dimDagobahId = config.get("dimensions", "dagobah", 8).getInt();
		// StarWarsMod.dimEndorPlainsId = DimensionManager.getNextFreeDimId();
		// StarWarsMod.dimDagobahId = DimensionManager.getNextFreeDimId();

		Resources.biomeTatooineId = config.get("biomes", "tatooine", 196).getInt();
		Resources.biomeHothId = config.get("biomes", "hoth", 197).getInt();
		Resources.biomeKashyyykId = config.get("biomes", "kashyyyk", 198).getInt();
		Resources.biomeYavin4Id = config.get("biomes", "yavin", 199).getInt();
		Resources.biomeEndorId = config.get("biomes", "endor", 200).getInt();
		Resources.biomeIlumId = config.get("biomes", "ilum", 201).getInt();
		Resources.biomeDagobahId = config.get("biomes", "dagobah", 195).getInt();

		Resources.enableCreditsOverlay = config.get("gui", "enableGuiOverlay", true).getBoolean();

		Resources.lightsaberDamage = config.get("items", "lightsaberDamage", 26).getInt();
		Resources.enableLightsaber = config.get("items", "enableLightsaberRecipe", true).getBoolean();
		Resources.enableBlasterFire = config.get("items", "enableBlasterFire", true).getBoolean();
		Resources.enableLightsaberStrobe = config.get("items", "enableLightsaberAnimation", true).getBoolean();
		Resources.enableBuckets = config.get("items", "enableGettingThatDumbFreeBucketFromWaterDroplets", true).getBoolean();

		config.save();

		Lumberjack.info("Configuration loaded!");
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		if (Resources.IS_DEV_ENVIRONVENT)
		{
			event.registerServerCommand(new CommandFlySpeed());
			event.registerServerCommand(new CommandSWDim());
		}
		event.registerServerCommand(new CommandJediRobes());
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\StarWarsMod.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */