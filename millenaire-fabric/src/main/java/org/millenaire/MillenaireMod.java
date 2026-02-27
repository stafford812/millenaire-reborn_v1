package org.millenaire;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MillenaireMod implements ModInitializer {
    public static final String MOD_ID = "millenaire";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("========================================");
        LOGGER.info("  Millenaire Reborn загружается!");
        LOGGER.info("  Версия: Alpha 1.0.0");
        LOGGER.info("========================================");
        
        // TODO: Регистрация блоков и предметов будет здесь
        
        LOGGER.info("Millenaire успешно инициализирован!");
    }
}
