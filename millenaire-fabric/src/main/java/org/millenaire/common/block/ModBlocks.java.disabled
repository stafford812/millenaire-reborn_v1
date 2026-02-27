package org.millenaire.common.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.millenaire.MillenaireMod;

import java.util.HashMap;
import java.util.Map;

public class ModBlocks {
    
    private static final Map<String, Block> BLOCKS = new HashMap<>();
    
    // Decorative blocks
    public static final Block THATCH = registerBlock("thatch",
        new Block(AbstractBlock.Settings.create()
            .strength(0.5f)
            .sounds(BlockSoundGroup.GRASS)));
    
    public static final Block MUD_BRICK = registerBlock("mudbrick",
        new Block(AbstractBlock.Settings.create()
            .strength(2.0f, 6.0f)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()));
    
    public static final Block TIMBERFRAME = registerBlock("timberframe",
        new Block(AbstractBlock.Settings.create()
            .strength(2.0f)
            .sounds(BlockSoundGroup.WOOD)));
    
    // Painted bricks
    public static final Block PAINTED_BRICK_WHITE = registerBlock("painted_brick_white",
        new Block(AbstractBlock.Settings.create()
            .strength(2.0f, 6.0f)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()));
    
    public static final Block PAINTED_BRICK_RED = registerBlock("painted_brick_red",
        new Block(AbstractBlock.Settings.create()
            .strength(2.0f, 6.0f)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()));
    
    public static final Block PAINTED_BRICK_BLUE = registerBlock("painted_brick_blue",
        new Block(AbstractBlock.Settings.create()
            .strength(2.0f, 6.0f)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()));
    
    // Byzantine blocks
    public static final Block BYZANTINE_STONE_TILES = registerBlock("byzantine_stone_tiles",
        new Block(AbstractBlock.Settings.create()
            .strength(2.0f, 6.0f)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()));
    
    // Path blocks
    public static final Block PATH_DIRT = registerBlock("pathdirt",
        new Block(AbstractBlock.Settings.create()
            .strength(0.5f)
            .sounds(BlockSoundGroup.GRAVEL)));
    
    private static Block registerBlock(String name, Block block) {
        Identifier id = Identifier.of(MillenaireMod.MOD_ID, name);
        
        Block registeredBlock = Registry.register(Registries.BLOCK, id, block);
        
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
        BlockItem blockItem = new BlockItem(registeredBlock, new Item.Settings().registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, blockItem);
        
        BLOCKS.put(name, registeredBlock);
        return registeredBlock;
    }
    
    public static void register() {
        MillenaireMod.LOGGER.info("Registering Millenaire Blocks - Phase 1");
        
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(THATCH);
            entries.add(MUD_BRICK);
            entries.add(TIMBERFRAME);
            entries.add(PAINTED_BRICK_WHITE);
            entries.add(PAINTED_BRICK_RED);
            entries.add(PAINTED_BRICK_BLUE);
            entries.add(BYZANTINE_STONE_TILES);
            entries.add(PATH_DIRT);
        });
    }
    
    public static Block getBlock(String name) {
        return BLOCKS.get(name);
    }
}
