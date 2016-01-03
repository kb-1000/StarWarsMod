package com.parzi.starwarsmod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import com.parzi.starwarsmod.entities.EntityDestruction;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketDestructionBolt implements IMessage
{
	public static class Handler implements IMessageHandler<PacketDestructionBolt, IMessage>
	{
		@Override
		public IMessage onMessage(PacketDestructionBolt message, MessageContext ctx)
		{
			EntityPlayer player = MinecraftServer.getServer().worldServerForDimension(message.dim).getPlayerEntityByName(message.player);
			player.worldObj.spawnEntityInWorld(new EntityDestruction(player.worldObj, player, message.radius));
			return null;
		}
	}

	private String player;
	private int dim;
	private int radius;

	public PacketDestructionBolt()
	{
	}

	public PacketDestructionBolt(String player, int dim, int type)
	{
		this.player = player;
		this.dim = dim;
		this.radius = type;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.player = ByteBufUtils.readUTF8String(buf);
		this.dim = ByteBufUtils.readVarInt(buf, 5);
		this.radius = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, this.player);
		ByteBufUtils.writeVarInt(buf, this.dim, 5);
		ByteBufUtils.writeVarInt(buf, this.radius, 5);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\network\CreateBlasterBoltSpeeder.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */