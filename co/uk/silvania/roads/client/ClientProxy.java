package co.uk.silvania.roads.client;

import net.minecraftforge.client.MinecraftForgeClient;
import co.uk.silvania.roads.CommonProxy;

public class ClientProxy extends CommonProxy {
        
        @Override
        public void registerRenderThings() {
    		MinecraftForgeClient.preloadTexture("/telinc/tutorialmod/textures/blocks.png");
    		MinecraftForgeClient.preloadTexture("/telinc/tutorialmod/textures/items.png");
        }
        
}