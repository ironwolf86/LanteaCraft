//------------------------------------------------------------------------------------------------
//
//   SG Craft - Stargate Controller Block
//
//------------------------------------------------------------------------------------------------

package gcewing.sg;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class SGControllerBlock extends Base4WayCtrBlock<SGControllerTE> {

	Icon topTexture, bottomTexture, sideTexture;

	public SGControllerBlock(int id) {
		super(id, Material.rock /*SGRingBlock.ringMaterial*/, SGControllerTE.class);
		setHardness(1.5F);
		//blockIndexInTexture = 0x0a;
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	@Override
	public void registerIcons(IconRegister reg) {
		if (SGCraft.RenderHD == true) {
			topTexture = getIcon(reg, "controller_top");
			bottomTexture = getIcon(reg, "controller_bottom");
			sideTexture = getIcon(reg, "controller_side");
		} else {
			topTexture = getIcon(reg, "controller_top_SD");
			bottomTexture = getIcon(reg, "controller_bottom_SD");
			sideTexture = getIcon(reg, "controller_side_SD");
		}

	}
	
	@Override
	public Icon getIcon(int side, int data) {
		switch (side) {
			case 0: return bottomTexture;
			case 1: return topTexture;
			default: return sideTexture;
		}
	}

	@Override
	public int getRenderType()
    {
		if (SGCraft.RenderHD == true) {
			return -1;
		} else {
			return 0;
		}
	}
	
	@Override
	public boolean renderAsNormalBlock() 
	{
		if (SGCraft.RenderHD == true) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isOpaqueCube() 
	{
		if (SGCraft.RenderHD == true) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) {
		super.onBlockPlacedBy(world, x, y, z, player, stack);
		checkForLink(world, x, y, z);
		int dir = MathHelper.floor_double((double)((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, dir, 0);
	}

	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta) {
		return true;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int id, int data) {
		SGControllerTE cte = getTileEntity(world, x, y, z);
		super.breakBlock(world, x, y, z, id, data);
		if (cte == null) {
			//System.out.printf("SGControllerBlock.breakBlock: No tile entity at (%d,%d,%d)\n",
				//x, y, z);
		}
		else if (cte.isLinkedToStargate) {
			SGBaseTE gte = cte.getLinkedStargateTE();
			if (gte != null)
				gte.clearLinkToController();
		}
	}
	
	@Override
	public boolean hasTileEntity(int metadata)
	{
		return true;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
		int side, float cx, float cy, float cz)
	{
		SGCraft.mod.openGui(player, SGGui.SGController, world, x, y, z);
		return true;
	}
	
	public void checkForLink(World world, int x, int y, int z) {
		//System.out.printf("SGControllerBlock.checkForLink at (%s, %s, %s)\n", x, y, z);
		getTileEntity(world, x, y, z).checkForLink();
	}
	
}
