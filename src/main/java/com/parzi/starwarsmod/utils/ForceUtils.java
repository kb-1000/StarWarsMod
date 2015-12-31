package com.parzi.starwarsmod.utils;

import java.util.ArrayList;

import com.parzi.starwarsmod.jedirobes.powers.Power;
import com.parzi.starwarsmod.jedirobes.powers.PowerJump;
import com.parzi.starwarsmod.jedirobes.powers.PowerPush;

public class ForceUtils
{
	public static Power activePower = null;
	public static ArrayList<Power> coolingPowers = new ArrayList<Power>();
	public static ArrayList<Power> queueToRemove = new ArrayList<Power>();

	public static Power powerJump = new PowerJump(0);
	public static Power powerPush = new PowerPush(0);

	public static String[] getAllPowers()
	{
		return new String[] { "jump", "push", "pull", "defend", "disable", "deflect", "grab", "healing", "naturalAwareness", "slow", "drainKnowledge", "lightning", "destruction" };
	}

	public static String[] getJediPowers()
	{
		return new String[] { "naturalAwareness" };
	}

	public static String[] getSithPowers()
	{
		return new String[] { "slow", "drainKnowledge", "lightning", "destruction" };
	}

	public static String[] getBasicPowers()
	{
		return new String[] { "jump", "push", "pull", "defend", "disable", "deflect", "grab", "healing" };
	}
}