package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class Rebel10 extends Quest
{
	public Rebel10()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Good to see you back in one piece rookie, I assume you didn't have too much trouble in Wild Space.";
		this.tree.response1 = "Not too much sir, the T65 is one fine machine.";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "That's why we use em soldier. Now, if you're up to the task, I've got one heck of a mission for you.";
		this.tree.response1DT.response1 = "I'm always up to the task sir, what have you got for me?";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.npcHeader = "Well I'm sure you know about the TIE Fighters the Empire is using, and i'm sure you know how tricky they can be. It turns out they've been outgunning us in recent firefights, and we've got to put a stop to it. Our Research and Development team is confident that they can improve our ships if they can get their hands on plans for the TIE Fighter. The Rebel Alliance needs you to break into the Imperial Base on Endor and steal the plans for the TIE Fighter. When you have them, bring them back here. Good luck, and try not to get captured.";
		this.tree.response1DT.response2 = "Hopefully it won't bore me too much.";
		this.tree.response1DT.response2DT = new DialogTree();
		this.tree.response1DT.response2DT.npcHeader = "Has anyone ever told you that you talk too much rookie? Well whatever, I'm sure you know about the TIE Fighters the Empire is using, and i'm sure you know how tricky they can be. It turns out they've been outgunning us in recent firefights, and we've got to put a stop to it. Our Research and Development team is confident that they can improve our ships if they can get their hands on plans for the TIE Fighter. The Rebel Alliance needs you to break into the Imperial Base on Endor and steal the plans for the TIE Fighter. When you have them, bring them back here. Good luck, and try not to get captured.";
		this.tree.response1DT.response3 = "Aw man, I don't even get a break...";
		this.tree.response1DT.response3DT = new DialogTree();
		this.tree.response1DT.response3DT.npcHeader = "The Imperials don't take breaks do they? No listen up, I'm sure you know about the TIE Fighters the Empire is using, and i'm sure you know how tricky they can be. It turns out they've been outgunning us in recent firefights, and we've got to put a stop to it. Our Research and Development team is confident that they can improve our ships if they can get their hands on plans for the TIE Fighter. The Rebel Alliance needs you to break into the Imperial Base on Endor and steal the plans for the TIE Fighter. When you have them, bring them back here. Good luck, and try not to get captured.";
		this.tree.response2 = "Have you seen me sir? Do I look like a guy who'd have trouble in a cockpit?";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "You look like a guy who'd get in trouble if he keeps talking so tough. Now if you're done talking yourself up, I've got an actual mission for you.";
		this.tree.response2DT.response1 = "Sorry sir I'm just a little excited right now, what's the mission?";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response2DT.response1DT.npcHeader = "Well I'm sure you know about the TIE Fighters the Empire is using, and i'm sure you know how tricky they can be. It turns out they've been outgunning us in recent firefights, and we've got to put a stop to it. Our Research and Development team is confident that they can improve our ships if they can get their hands on plans for the TIE Fighter. The Rebel Alliance needs you to break into the Imperial Base on Endor and steal the plans for the TIE Fighter. When you have them, bring them back here. Good luck, and try not to get captured.";
		this.tree.response2DT.response2 = "Go ahead and try it old man, now give me my mission.";
		this.tree.response2DT.response2DT = new DialogTree();
		this.tree.response2DT.response2DT.npcHeader = "Has anyone ever told you that you talk too much rookie? Well whatever, I'm sure you know about the TIE Fighters the Empire is using, and i'm sure you know how tricky they can be. It turns out they've been outgunning us in recent firefights, and we've got to put a stop to it. Our Research and Development team is confident that they can improve our ships if they can get their hands on plans for the TIE Fighter. The Rebel Alliance needs you to break into the Imperial Base on Endor and steal the plans for the TIE Fighter. When you have them, bring them back here. Good luck, and try not to get captured.";
		this.tree.response2DT.response3 = "I'm just trying to get noticed sir... What's the mission?";
		this.tree.response2DT.response3DT = new DialogTree();
		this.tree.response2DT.response3DT.npcHeader = "Well I'm sure you know about the TIE Fighters the Empire is using, and i'm sure you know how tricky they can be. It turns out they've been outgunning us in recent firefights, and we've got to put a stop to it. Our Research and Development team is confident that they can improve our ships if they can get their hands on plans for the TIE Fighter. The Rebel Alliance needs you to break into the Imperial Base on Endor and steal the plans for the TIE Fighter. When you have them, bring them back here. Good luck, and try not to get captured.";
		this.tree.response3 = "It sure wasn't anything like flying a T47.";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "I would hope not, the T47 is a modified civilian craft, what you just flew was an honest to goodness starfighter. Also, now that you're back I've got a new mission for you.";
		this.tree.response3DT.response1 = "Anything for the Rebel Alliance sir!";
		this.tree.response3DT.response1DT = new DialogTree();
		this.tree.response3DT.response1DT.npcHeader = "Well I'm sure you know about the TIE Fighters the Empire is using, and i'm sure you know how tricky they can be. It turns out they've been outgunning us in recent firefights, and we've got to put a stop to it. Our Research and Development team is confident that they can improve our ships if they can get their hands on plans for the TIE Fighter. The Rebel Alliance needs you to break into the Imperial Base on Endor and steal the plans for the TIE Fighter. When you have them, bring them back here. Good luck, and try not to get captured.";
		this.tree.response3DT.response2 = "Well thanks for the history lesson, i'm sure I'll ace my next quiz. How about you give me my mission?";
		this.tree.response3DT.response2DT = new DialogTree();
		this.tree.response3DT.response2DT.npcHeader = "Has anyone ever told you that you talk too much rookie? Well whatever, I'm sure you know about the TIE Fighters the Empire is using, and i'm sure you know how tricky they can be. It turns out they've been outgunning us in recent firefights, and we've got to put a stop to it. Our Research and Development team is confident that they can improve our ships if they can get their hands on plans for the TIE Fighter. The Rebel Alliance needs you to break into the Imperial Base on Endor and steal the plans for the TIE Fighter. When you have them, bring them back here. Good luck, and try not to get captured.";
		this.tree.response3DT.response3 = "No wonder it was so different... Well what's the mission sir?";
		this.tree.response3DT.response3DT = new DialogTree();
		this.tree.response3DT.response3DT.npcHeader = "I'm sure you know about the TIE Fighters the Empire is using, and i'm sure you know how tricky they can be. It turns out they've been outgunning us in recent firefights, and we've got to put a stop to it. Our Research and Development team is confident that they can improve our ships if they can get their hands on plans for the TIE Fighter. The Rebel Alliance needs you to break into the Imperial Base on Endor and steal the plans for the TIE Fighter. When you have them, bring them back here. Good luck, and try not to get captured.";
	}

	@Override
	public String getQuestgiverName()
	{
		return "Dreis";
	}

	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		return !isQuestDone(player, this);
	}

	@Override
	public void begin(EntityPlayer player)
	{

	}

	@Override
	public boolean isQuestComplete(EntityPlayer player)
	{
		return true;
	}

	@Override
	public void end(EntityPlayer player)
	{
		setQuestDone(player, this);
	}

	@Override
	public DialogTree getDialog(EntityPlayer player)
	{
		return tree;
	}

	@Override
	public String getID()
	{
		return "Infiltration";
	}
}
