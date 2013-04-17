package co.uk.silvania.roads;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CementBlock extends Block {

        public CementBlock (int id, int texture, Material material) {
                super(id, texture, material);
        }
        
        @Override
        public String getTextureFile () {
                return CommonProxy.BLOCK_PNG;
        }

}