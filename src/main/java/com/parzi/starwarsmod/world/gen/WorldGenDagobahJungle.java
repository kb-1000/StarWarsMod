package com.parzi.starwarsmod.world.gen;

import java.util.Random;

import com.parzi.starwarsmod.StarWarsMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraftforge.common.util.ForgeDirection;

public class WorldGenDagobahJungle extends WorldGenHugeTrees
{
	private static final String __OBFID = "CL_00000420";

	public WorldGenDagobahJungle(boolean p_i45456_1_, int p_i45456_2_, int p_i45456_3_, int p_i45456_4_, int p_i45456_5_)
	{
		super(p_i45456_1_, p_i45456_2_, p_i45456_3_, p_i45456_4_, p_i45456_5_);
	}

    private boolean func_150532_c(World p_150532_1_, Random p_150532_2_, int p_150532_3_, int p_150532_4_, int p_150532_5_)
    {
        return true;
    }

    //Just a helper macro
    private void onPlantGrow(World world, int x, int y, int z, int sourceX, int sourceY, int sourceZ)
    {
        world.getBlock(x, y, z).onPlantGrow(world, x, y, z, sourceX, sourceY, sourceZ);
    }

	public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
	{
		int l = this.func_150533_a(p_76484_2_);

		if (!this.func_150537_a(p_76484_1_, p_76484_2_, p_76484_3_, p_76484_4_, p_76484_5_, l))
		{
			return false;
		}
		else
		{
			this.func_150543_c(p_76484_1_, p_76484_3_, p_76484_5_, p_76484_4_ + l, 2, p_76484_2_);

			for (int i1 = p_76484_4_ + l - 2 - p_76484_2_.nextInt(4); i1 > p_76484_4_ + l / 2; i1 -= 2 + p_76484_2_.nextInt(4))
			{
				float f = p_76484_2_.nextFloat() * (float)Math.PI * 2.0F;
				int j1 = p_76484_3_ + (int)(0.5F + MathHelper.cos(f) * 4.0F);
				int k1 = p_76484_5_ + (int)(0.5F + MathHelper.sin(f) * 4.0F);
				int l1;

				for (l1 = 0; l1 < 5; ++l1)
				{
					j1 = p_76484_3_ + (int)(1.5F + MathHelper.cos(f) * (float)l1);
					k1 = p_76484_5_ + (int)(1.5F + MathHelper.sin(f) * (float)l1);
					this.setBlockAndNotifyAdequately(p_76484_1_, j1, i1 - 3 + l1 / 2, k1, Blocks.log, this.woodMetadata);
				}

				l1 = 1 + p_76484_2_.nextInt(2);
				int i2 = i1;

				for (int j2 = i1 - l1; j2 <= i2; ++j2)
				{
					int k2 = j2 - i2;
					this.func_150534_b(p_76484_1_, j1, j2, k1, 1 - k2, p_76484_2_);
				}
			}

			for (int l2 = 0; l2 < l; ++l2)
			{
				Block block = p_76484_1_.getBlock(p_76484_3_, p_76484_4_ + l2, p_76484_5_);

				if (block.isAir(p_76484_1_, p_76484_3_, p_76484_4_ + l2, p_76484_5_) || block.isLeaves(p_76484_1_, p_76484_3_, p_76484_4_ + l2, p_76484_5_))
				{
					this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_, p_76484_4_ + l2, p_76484_5_, Blocks.log, this.woodMetadata);

					if (l2 > 0)
					{
						if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.isAirBlock(p_76484_3_ - 1, p_76484_4_ + l2, p_76484_5_))
						{
							this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_ - 1, p_76484_4_ + l2, p_76484_5_, Blocks.vine, 8);
						}

						if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.isAirBlock(p_76484_3_, p_76484_4_ + l2, p_76484_5_ - 1))
						{
							this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_, p_76484_4_ + l2, p_76484_5_ - 1, Blocks.vine, 1);
						}
					}
				}

				if (l2 < l - 1)
				{
					block = p_76484_1_.getBlock(p_76484_3_ + 1, p_76484_4_ + l2, p_76484_5_);

					if (block.isAir(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + l2, p_76484_5_) || block.isLeaves(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + l2, p_76484_5_))
					{
						this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + l2, p_76484_5_, Blocks.log, this.woodMetadata);

						if (l2 > 0)
						{
							if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.isAirBlock(p_76484_3_ + 2, p_76484_4_ + l2, p_76484_5_))
							{
								this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_ + 2, p_76484_4_ + l2, p_76484_5_, Blocks.vine, 2);
							}

							if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.isAirBlock(p_76484_3_ + 1, p_76484_4_ + l2, p_76484_5_ - 1))
							{
								this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + l2, p_76484_5_ - 1, Blocks.vine, 1);
							}
						}
					}

					block = p_76484_1_.getBlock(p_76484_3_ + 1, p_76484_4_ + l2, p_76484_5_ + 1);

					if (block.isAir(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + l2, p_76484_5_ + 1) || block.isLeaves(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + l2, p_76484_5_ + 1))
					{
						this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + l2, p_76484_5_ + 1, Blocks.log, this.woodMetadata);

						if (l2 > 0)
						{
							if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.isAirBlock(p_76484_3_ + 2, p_76484_4_ + l2, p_76484_5_ + 1))
							{
								this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_ + 2, p_76484_4_ + l2, p_76484_5_ + 1, Blocks.vine, 2);
							}

							if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.isAirBlock(p_76484_3_ + 1, p_76484_4_ + l2, p_76484_5_ + 2))
							{
								this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + l2, p_76484_5_ + 2, Blocks.vine, 4);
							}
						}
					}

					block = p_76484_1_.getBlock(p_76484_3_, p_76484_4_ + l2, p_76484_5_ + 1);

					if (block.isAir(p_76484_1_, p_76484_3_, p_76484_4_ + l2, p_76484_5_ + 1) || block.isLeaves(p_76484_1_, p_76484_3_, p_76484_4_ + l2, p_76484_5_ + 1))
					{
						this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_, p_76484_4_ + l2, p_76484_5_ + 1, Blocks.log, this.woodMetadata);

						if (l2 > 0)
						{
							if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.isAirBlock(p_76484_3_ - 1, p_76484_4_ + l2, p_76484_5_ + 1))
							{
								this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_ - 1, p_76484_4_ + l2, p_76484_5_ + 1, Blocks.vine, 8);
							}

							if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.isAirBlock(p_76484_3_, p_76484_4_ + l2, p_76484_5_ + 2))
							{
								this.setBlockAndNotifyAdequately(p_76484_1_, p_76484_3_, p_76484_4_ + l2, p_76484_5_ + 2, Blocks.vine, 4);
							}
						}
					}
				}
			}

			return true;
		}
	}

	private void func_150543_c(World p_150543_1_, int p_150543_2_, int p_150543_3_, int p_150543_4_, int p_150543_5_, Random p_150543_6_)
	{
		byte b0 = 2;

		for (int i1 = p_150543_4_ - b0; i1 <= p_150543_4_; ++i1)
		{
			int j1 = i1 - p_150543_4_;
			this.func_150535_a(p_150543_1_, p_150543_2_, i1, p_150543_3_, p_150543_5_ + 1 - j1, p_150543_6_);
		}
	}

	@Override
	protected boolean func_150523_a(Block p_150523_1_)
	{
		return p_150523_1_.getMaterial() == Material.air || p_150523_1_.getMaterial() == Material.leaves || p_150523_1_ == StarWarsMod.blockDagobahMud || p_150523_1_ == Blocks.grass || p_150523_1_ == Blocks.dirt || p_150523_1_ == Blocks.log || p_150523_1_ == Blocks.log2 || p_150523_1_ == Blocks.sapling || p_150523_1_ == Blocks.vine;
	}
}