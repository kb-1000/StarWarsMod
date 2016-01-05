package com.parzi.starwarsmod.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandEnchant;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.jedirobes.ArmorJediRobes;
import com.parzi.starwarsmod.network.PacketRobesNBT;

public class CommandJediRobes extends CommandBase
{
	private List aliases;

	public CommandJediRobes()
	{
		this.aliases = new ArrayList();
		this.aliases.add("robes");
	}

	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring)
	{
		return null;
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
	{
		return true;
	}

	@Override
	public int compareTo(Object o)
	{
		return 0;
	}

	@Override
	public List getCommandAliases()
	{
		return this.aliases;
	}

	@Override
	public String getCommandName()
	{
		return "robes";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "robes <level|xp|maxxp> <int:value>";
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i)
	{
		return false;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{
		if (astring.length != 2)
		{
			icommandsender.addChatMessage(new ChatComponentText("Invalid args! Usage: " + this.getCommandUsage(icommandsender)));
			return;
		}

		String key = astring[0];
		int value = 0;

		value = parseInt(icommandsender, astring[1]);
		if (key.equalsIgnoreCase("level"))
			value *= 10;

		EntityPlayerMP player = getCommandSenderAsPlayer(icommandsender);

		if (player != null && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes && (key.equalsIgnoreCase("level") || key.equalsIgnoreCase("xp") || key.equalsIgnoreCase("maxxp")))
		{
			ItemStack robes = player.inventory.armorItemInSlot(2);
			ArmorJediRobes.getXP(robes);
			ArmorJediRobes.getMaxXP(robes);

			StarWarsMod.network.sendToServer(new PacketRobesNBT(key, value, player.dimension, player.getCommandSenderName()));

			if (key.equalsIgnoreCase("level"))
				StarWarsMod.network.sendToServer(new PacketRobesNBT("maxxp", value * 10, player.dimension, player.getCommandSenderName()));

			icommandsender.addChatMessage(new ChatComponentText("[Robes] Done!"));
		}
		else
		{
			icommandsender.addChatMessage(new ChatComponentText("Usage: " + this.getCommandUsage(icommandsender)));
			if (player == null)
				icommandsender.addChatMessage(new ChatComponentText("Error: player is null!"));
			else if (player.inventory.armorItemInSlot(2) == null)
				icommandsender.addChatMessage(new ChatComponentText("Note: You must be wearing robes!"));
			else if (player.inventory.armorItemInSlot(2).getItem() != StarWarsMod.jediRobes)
				icommandsender.addChatMessage(new ChatComponentText("Note: You must be wearing robes!"));
			else
				icommandsender.addChatMessage(new ChatComponentText("Unknown key!"));
			return;
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\commands\CommandFlySpeed.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */