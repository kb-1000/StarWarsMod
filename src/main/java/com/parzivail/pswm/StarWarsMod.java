package com.parzivail.pswm;

import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.achievement.StarWarsAchievements;
import com.parzivail.pswm.blocks.npc.BlockNpcBase;
import com.parzivail.pswm.commands.CommandJediRobes;
import com.parzivail.pswm.exception.UserError;
import com.parzivail.pswm.handlers.ClientEventHandler;
import com.parzivail.pswm.handlers.CommonEventHandler;
import com.parzivail.pswm.handlers.GuiHandler;
import com.parzivail.pswm.network.*;
import com.parzivail.pswm.registry.*;
import com.parzivail.pswm.tabs.SequelStarWarsTab;
import com.parzivail.pswm.tabs.StarWarsTab;
import com.parzivail.pswm.tabs.StarWarsTabBlocks;
import com.parzivail.util.block.*;
import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
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
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.DamageSource;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

//import com.rollbar.Rollbar;

@Mod(modid = Resources.MODID,
     version = Resources.VERSION,
     name = "Parzi's Star Wars Mod",
     acceptedMinecraftVersions = "[1.7.10]",
     guiFactory = "com.parzivail.pswm.gui.GuiFactory")
public class StarWarsMod
{
	public static boolean hasShownNeedUpdate = false;
	public static boolean hasShownLeaderboardPart = false;

	private static int packetId = 0;

	public static Random rngGeneral = new Random();

	@Mod.Instance(Resources.MODID)
	public static StarWarsMod instance;

	@SideOnly(Side.CLIENT)
	public static Minecraft mc;

	public static int shipSpecialWeaponCooldown = 0;

	static ClientEventHandler clientHandler;
	private static CommonEventHandler commonHandler;

	@SidedProxy(clientSide = "com.parzivail.pswm.StarWarsClientProxy",
	            serverSide = "com.parzivail.pswm.StarWarsCommonProxy")
	public static StarWarsCommonProxy proxy;
	public static SimpleNetworkWrapper network;

	public static CreativeTabs StarWarsTab;
	public static CreativeTabs StarWarsTabBlocks;
	public static CreativeTabs SequelStarWarsTab;

	public static BiomeGenBase biomeTatooine;
	public static BiomeGenBase biomeHoth;
	public static BiomeGenBase biomeKashyyyk;
	public static BiomeGenBase biomeYavin4;
	public static BiomeGenBase biomeEndor;
	public static BiomeGenBase biomeDagobah;
	public static BiomeGenBase biomeIlum;
	public static BiomeGenBase biomeMustafar;
	public static BiomeGenBase biomeSpace;

	public static boolean isOverlayOnscreen = false;

	public static PBlockContainer blockMV;
	public static PBlockContainer blockLightsaberForge;
	public static PBlockContainer blockCrystalCompressor;
	public static PBlockContainer blockAntenna;
	public static PBlockContainer blockFieldEmitter;
	public static PBlockContainer blockDeathStarDoor;
	public static PBlockContainer blockHoloTable;
	public static PBlockContainer blockTable;
	public static PBlockContainer blockTable2;
	public static PBlock blockFocusingCrystalOre;
	public static PBlock blockCrystalOre;
	public static PBlock blockChromiumOre;
	public static PBlock blockTitaniumOre;
	public static PBlock blockTitaniumChromiumBlock;
	public static PBlock blockDeathStarGlass;
	public static PBlock blockEndorBaseWall;
	public static PBlockStairs blockEndorBaseWallStairs;
	public static PBlockStairs blockMudStairs;
	public static PBlock blockDeathStarLight;
	public static PBlock blockDeathStarBlock;
	public static PBlockStairs blockDeathStarLightStairs;
	public static PBlockFence blockDeathStarLightFence;
	public static PBlock blockTatooineSand;
	public static PBlock blockTatooineSandstone;
	public static PBlock blockIlumStone;
	public static PBlock blockSpaceLamp;
	public static PBlock blockDagobahMud;
	public static PBlockContainer blockHangingCauldron;
	public static PBlockContainer blockHangingBucket;
	public static PBlockContainer blockBasket;
	public static PBlockContainer blockBactaTank;

	public static PBlockContainer blockMovingLightSource;

	public static PBlockContainer blockSensorXWing;
	public static PBlockContainer blockSensorYWing;
	public static PBlockContainer blockSensorAWing;
	public static PBlockContainer blockSensorTIE;
	public static PBlockContainer blockSensorTIEAdvanced;
	public static PBlockContainer blockSensorTIEBomber;
	public static PBlockContainer blockSensorTIEInterceptor;
	public static PBlockContainer blockSensorScootemaround;
	public static PBlockContainer blockSensorScootemaroundHoth;
	public static PBlockContainer blockSensorSnowspeeder;
	public static PBlockContainer blockSensorSkyhopper;
	public static PBlockContainer blockSensorATST;
	public static PBlockContainer blockSensorSpeederBike;
	public static PBlockContainer blockSensorHothSpeederBike;
	public static PBlockContainer blockSensorLandspeeder;
	public static PBlockContainer blockSensorJakkuSpeeder;

	public static PBlock blockThorolideOre;
	public static PBlock blockCortosisOre;
	public static PBlock blockDiatiumOre;
	public static PBlock blockExoniumOre;
	public static PBlock blockHeliciteOre;
	public static PBlock blockIoniteOre;
	public static PBlock blockKeleriumOre;
	public static PBlock blockRubindumOre;

	public static PBlock blockTempleStone;
	public static PBlockSlab blockTempleStoneSlab;
	public static PBlock blockTempleStoneLit;
	public static PBlockSlab blockTempleStoneSlabLit;

	public static PBlock blockTempleStoneMH;

	public static PBlockStairs blockTempleStoneStairs;
	public static PBlockStairs blockTempleStoneStairsBrick;
	public static PBlockStairs blockTempleStoneStairsFancy;
	public static PBlockStairs blockTempleStoneStairsSlabTop;
	public static PBlockStairs blockTempleStoneStairsSlabTopDark;

	public static PBlock blockHothSandbag;
	public static PBlock blockHothSnowCut;
	public static PBlock blockHothBaseDoor;

	public static Block blockCrate1;
	public static PBlockContainer blockFloorLight;
	public static PBlockContainer blockHolotableMass;
	public static PBlockContainer blockLadder;
	public static PBlockContainer blockPipeClampedMass;
	public static PBlockContainer blockPipeMass;
	public static PBlockContainer blockPipeSleevedMass;
	public static PBlockContainer blockConsoleHoth1;
	public static PBlockContainer blockConsoleHoth2;
	public static PBlockContainer blockConsoleHoth3;
	public static PBlockContainer blockPanelHoth;
	public static PBlockContainer blockHothCeilingLight;
	public static PBlockContainer blockPipeDoubleOffsetTopSpecial;
	public static PBlockContainer blockPipeDoubleOffsetBot;
	public static PBlockContainer blockPipeDoubleOffsetBotSpecial;
	public static PBlockContainer blockPipeDoubleOffsetTop;
	public static PBlockContainer blockMedicalConsole;
	public static PBlockContainer blockMedicalConsole2;
	public static PBlockContainer blockFloorLight2;
	public static Block blockHothCrate1;
	public static Block blockHothCrate2;

	public static Block blockAncientJediStatue;
	public static BlockNpcBase[] blockStaticNpc;
	public static Block blockHyperdrive;

	public static Item.ToolMaterial materialGaffi;
	public static Item.ToolMaterial materialEwok;
	public static Item.ToolMaterial materialGamorrean;
	public static Item.ToolMaterial materialPlasma;
	public static Item.ToolMaterial materialPlasmaOff;
	public static Item.ToolMaterial materialNoDamage;

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

	public static DamageSource blasterDamageSource;
	public static DamageSource saberDamageSource;
	public static DamageSource roadkillDamageSource;

	//public static final Rollbar rollbar = new Rollbar("2f2f385fc5d24ecbbf91e62fb9818577", "production");

	public StarWarsMod()
	{
		//rollbar.handleUncaughtErrors();
		Lumberjack.info("========== Begin Parzi's Star Wars Mod constructor ==========");
		this.checkJavaVersion();
		this.checkModVersion();
		Lumberjack.info("========== Begin Parzi's Star Wars Mod constructor ==========");
	}

	private void checkCompat()
	{
		boolean flag = false;
		ArrayList<String> m = new ArrayList<>();
		for (String mod : Resources.checkCompatList)
			if (Loader.isModLoaded(mod))
			{
				flag = true;
				m.add(mod);
			}
		if (flag)
		{
			Lumberjack.warn("WARNING! It is known that Parzi's Star Wars Mod may have game-breaking issues when played with the following mods:");
			Lumberjack.warn("-> " + String.join(", ", m));
			Lumberjack.warn("Please report any issues to our GitHub: https://github.com/Parzivail-Modding-Team/ParziStarWarsMod/issues");
		}
	}

	private void checkJavaVersion()
	{
		String versionString = System.getProperty("java.version");
		int pos = versionString.indexOf('.');
		pos = versionString.indexOf('.', pos + 1);
		double version = Double.parseDouble(versionString.substring(0, pos));
		if (version < 1.8)
		{
			Lumberjack.log("######################################PSWM ERROR####################################");
			Lumberjack.log("Parzi's Star Wars Mod requires Java 1.8 or above. You are currently using Java " + version);
			Lumberjack.log("Minecraft will now halt. Download and install Java 1.8.");
			Lumberjack.log("NOTE to MultiMC Users: make sure MultiMC is using the correct Java as default!");
			Lumberjack.log("####################################END PSWM ERROR##################################");
			FMLCommonHandler.instance().exitJava(0, false);
		}
		else
		{
			Lumberjack.log("Confirmed client using Java 1.8+");
		}
	}

	private void checkModVersion()
	{
		InputStream in = null;
		try
		{
			in = new URL(Resources.remoteVersionLink).openStream();
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
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		Lumberjack.info("========== Begin Parzi's Star Wars Mod init() ==========");

		Lumberjack.info("This is Parzi's Star Wars Mod v" + Resources.VERSION);

		instance = this;

		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

		StarWarsMod.commonHandler = new CommonEventHandler();
		StarWarsMod.clientHandler = new ClientEventHandler();

		FMLCommonHandler.instance().bus().register(StarWarsMod.commonHandler);
		MinecraftForge.EVENT_BUS.register(StarWarsMod.clientHandler);

		proxy.doSidedThings();

		EntityRegister.registerAll();

		MaterialRegister.registerAll();

		if (ConfigOptions.enableTabOriginal)
		{
			StarWarsTab = new StarWarsTab();
			StarWarsTabBlocks = new StarWarsTabBlocks();
		}
		else
		{
			StarWarsTab = CreativeTabs.tabAllSearch;
			StarWarsTabBlocks = CreativeTabs.tabAllSearch;
		}

		if (Resources.IS_SEQUEL_RELEASE)
		{
			Lumberjack.log("Sequel update! Suck it, JJ!");
			if (ConfigOptions.enableTabSequel)
				SequelStarWarsTab = new SequelStarWarsTab();
			else
				SequelStarWarsTab = CreativeTabs.tabAllSearch;
		}

		ItemRegister.registerAll();

		BlockRegister.registerAll();

		WorldRegister.registerAll();

		RecipeRegister.registerAll();

		StarWarsAchievements.registerAll();

		DamageSourceRegister.registerAll();

		proxy.registerRendering();

		Lumberjack.info("=========== End Parzi's Star Wars Mod init() ===========");
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) throws UserError
	{
		Lumberjack.info("========== Begin Parzi's Star Wars Mod preInit() ==========");

		this.checkCompat();

		setupNetworking();

		setupConfig(event);

		Lumberjack.info("=========== End Parzi's Star Wars Mod preInit() ===========");
	}

	private void setupConfig(FMLPreInitializationEvent event)
	{
		ConfigOptions.configFile = new File(event.getSuggestedConfigurationFile().getPath().replace(Resources.MODID, "pswm-" + Resources.VERSION));
		ConfigOptions.config = new Configuration(ConfigOptions.configFile, Resources.VERSION);

		ConfigOptions.config.load();

		ConfigOptions.loadConfigOptions();

		ConfigOptions.config.save();
	}

	private void setupNetworking()
	{
		network = NetworkRegistry.INSTANCE.newSimpleChannel(Resources.MODID + "." + "chan");

		this.registerMessage(MessageEntityGrab.class);
		this.registerMessage(MessageAddEffectTo.class);
		this.registerMessage(MessageHoloTableUpdate.class);
		this.registerMessage(MessageCreateDestructionBolt.class);
		this.registerMessage(MessageEntityAlterMotion.class);
		this.registerMessage(MessageHyperdrive.class);
		this.registerMessage(MessageEntityHurt.class);
		this.registerMessage(MessageTransmute.class);
		this.registerMessage(MessageEntityReverse.class);
		this.registerMessage(MessageRobesIntNBT.class);
		this.registerMessage(MessageRobesStringNBT.class);
		this.registerMessage(MessageSFoil.class);
		this.registerMessage(MessageHeal.class);
		this.registerMessage(MessageDrainKnowledge.class);
		this.registerMessage(MessageShipTargetLock.class);
		this.registerMessage(MessageCreateBlasterBolt.class);
		this.registerMessage(MessageSetPlayerHolding.class);
		this.registerMessage(MessageTransferHyperdrive.class);
		this.registerMessage(MessageSpawn.class);
		this.registerMessage(MessageThrowSaber.class);
		this.registerMessage(MessageHolocronRefreshPowers.class);
		this.registerMessage(MessageHolocronSetActive.class);
		this.registerMessage(MessagePlayerRemoveItems.class);
		this.registerMessage(MessageShipAstroDetails.class);
		this.registerMessage(MessageShipHoverMode.class);

		Lumberjack.log("Network registered " + String.valueOf(packetId) + " packets!");
	}

	@SuppressWarnings("unchecked")
	private void registerMessage(Class messageHandler)
	{
		network.registerMessage(messageHandler, messageHandler, packetId, Side.SERVER);
		Lumberjack.debug("Registered packet \"" + messageHandler + "\" as packet ID " + packetId);
		packetId += 1;
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandJediRobes());
	}
}
