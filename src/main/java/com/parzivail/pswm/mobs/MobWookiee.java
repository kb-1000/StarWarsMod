package com.parzivail.pswm.mobs;

import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.ai.AiFreqMove;
import com.parzivail.pswm.ai.AiMelee;
import com.parzivail.pswm.ai.AiShoot;
import com.parzivail.pswm.entities.EntityBlasterProbeBolt;
import com.parzivail.util.entity.trade.WeightedLoot;
import com.parzivail.util.world.WorldUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.parzivail.pswm.Resources.MODID;
import static com.parzivail.pswm.StarWarsItems.bowcaster;
import static com.parzivail.pswm.utils.LootGenUtils.baseRarity;
import static com.parzivail.pswm.utils.LootGenUtils.getWeightedItemFromList;
import static java.util.UUID.fromString;

public class MobWookiee extends EntityCreature implements IMob, IShootThings
{
	private static final UUID field_110189_bq = fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
	private static final AttributeModifier field_110190_br = new AttributeModifier(field_110189_bq, "Attacking speed boost", 1, 0).setSaved(false);
	private int angerLevel;
	private Entity angryAt;
	private AiShoot aiShoot;
	private EntityAIArrowAttack aiArrow;

	// TODO: Fix wookiee model?

	public MobWookiee(World par1World)
	{
		super(par1World);
		getNavigator().setCanSwim(true);
		setSize(0.5F, 2.0F);
		getNavigator().setEnterDoors(true);
		getNavigator().setAvoidsWater(true);
		switch (rand.nextInt(3))
		{
			case 0:
				setCurrentItemOrArmor(0, new ItemStack(StarWarsItems.gaffiStick, 1));
				break;
			case 1:
				setCurrentItemOrArmor(0, new ItemStack(bowcaster, 1));
				this.tasks.addTask(0, aiShoot = new AiShoot(this, 1.0D, 20, 60, 15.0F));
				break;
		}
		this.tasks.addTask(1, new EntityAISwimming(this));
		targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
		tasks.addTask(0, new AiMelee(this, EntityPlayer.class, 1, false, 3));
		tasks.addTask(1, new AiFreqMove(this, 1, 0));
		targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
	}

	public void rangeAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
	{
		playSound(MODID + ":" + "item.blasterBow.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(rand, -0.2D, 0.2D));
		worldObj.spawnEntityInWorld(new EntityBlasterProbeBolt(worldObj, this, p_82196_1_));
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		Entity entity = source.getEntity();
		if (entity instanceof EntityPlayer)
		{
			List<Entity> list = WorldUtils.getEntitiesWithinAABBExcludingEntity(worldObj, this, boundingBox.expand(32.0D, 32.0D, 32.0D));
			for (Entity entity1 : list)
			{
				if (entity1 instanceof MobWookiee)
				{
					MobWookiee wook = (MobWookiee)entity1;
					wook.becomeAngryAt(entity);
				}
			}
			becomeAngryAt(entity);
		}
		return super.attackEntityFrom(source, amount);
	}

	private void becomeAngryAt(Entity p_70835_1_)
	{
		entityToAttack = p_70835_1_;
		angerLevel = 400 + rand.nextInt(400);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		List<WeightedLoot> drop = new ArrayList<>();
		drop.add(new WeightedLoot(new ItemStack(bowcaster, 1), baseRarity / 2.0F));
		if (rand.nextInt(5) == 0)
		{
			entityDropItem(getWeightedItemFromList(drop, rand), 0.0F);
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
	}

	@Override
	protected Entity findPlayerToAttack()
	{
		return angerLevel == 0 ? null : super.findPlayerToAttack();
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return true;
	}

	@Override
	protected String getDeathSound()
	{
		return MODID + ":" + "mob.wookiee.die";
	}

	@Override
	protected String getHurtSound()
	{
		return MODID + ":" + "mob.wookiee.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return MODID + ":" + "mob.wookiee.say";
	}
}