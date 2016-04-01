package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.items.ItemQuestContainer;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.IQuest;

import net.minecraft.entity.player.EntityPlayer;

public class Quest0Welcome implements IQuest
{
	DialogTree tree;

	public Quest0Welcome()
	{
		this.tree = new DialogTree();

		this.tree.npcHeader = "Welcome to the Rebel Alliance. We're a small group dedicated to taking back the galaxy from the Galactic Empire. If you want to join us, just find the Quartermaster and he�ll give you some armor. You can find him in the main hangar. Good luck, kid.";
	}

	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		return true;
	}

	@Override
	public void begin(EntityPlayer player)
	{
		ItemQuestContainer.setQuestDone(player, this);
	}

	@Override
	public boolean isQuestComplete(EntityPlayer player)
	{
		return true;
	}

	@Override
	public void end(EntityPlayer player)
	{
	}

	@Override
	public DialogTree getDialog(EntityPlayer player)
	{
		return tree;
	}

	@Override
	public String getID()
	{
		return "r0-welcome";
	}
}
