package org.millenaire;

import net.fabricmc.api.ModInitializer;
import org.millenaire.common.block.ModBlocks;
import org.millenaire.common.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MillenaireMod implements ModInitializer {
    public static final String MOD_ID = "millenaire";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Millenaire Reborn for Minecraft 1.21.11");
        
        // Register blocks and items
        ModBlocks.register();
        ModItems.register();
        
        LOGGER.info("Millenaire Reborn initialized successfully!");
    }
}
