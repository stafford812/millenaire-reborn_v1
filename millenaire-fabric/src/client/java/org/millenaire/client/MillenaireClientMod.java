package org.millenaire.client;

import net.fabricmc.api.ClientModInitializer;
import org.millenaire.MillenaireMod;

public class MillenaireClientMod implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        MillenaireMod.LOGGER.info("Initializing Millenaire Client");
        
        // Register client-side rendering and models here
        
        MillenaireMod.LOGGER.info("Millenaire Client initialized!");
    }
}
