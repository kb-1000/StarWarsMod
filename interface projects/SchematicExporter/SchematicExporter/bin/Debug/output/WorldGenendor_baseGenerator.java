/*
 * Generated by SchematicExporter
 */
if (this.locY == null)
	this.locY = (int)MathUtils.map(this.rootHeight, -2, 2, 0, 128);

if (chunkX == 0 && chunkZ == 0)
	new WorldGenendor_base_x0_z0().generate(par1World, par2Random, chunkX, this.locY, chunkZ);
else if (chunkX == 0 && chunkZ == 16)
	new WorldGenendor_base_x0_z16().generate(par1World, par2Random, chunkX, this.locY, chunkZ);
else if (chunkX == 16 && chunkZ == 0)
	new WorldGenendor_base_x16_z0().generate(par1World, par2Random, chunkX, this.locY, chunkZ);
else if (chunkX == 16 && chunkZ == 16)
	new WorldGenendor_base_x16_z16().generate(par1World, par2Random, chunkX, this.locY, chunkZ);

