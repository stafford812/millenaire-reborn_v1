package org.millenaire.common.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.millenaire.MillenaireMod;

import java.util.HashMap;
import java.util.Map;

public class ModBlocks {
    
    // Storage map for all registered blocks
    private static final Map<String, Block> BLOCKS = new HashMap<>();
    
    // Decorative Blocks - Phase 1: Basic Building Materials
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
    
    // Painted Bricks - 16 colors (simplified for Phase 1, will add all colors later)
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
    
    public static final Block PAINTED_BRICK_YELLOW = registerBlock("painted_brick_yellow",
        new Block(AbstractBlock.Settings.create()
            .strength(2.0f, 6.0f)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()));
    
    // Byzantine decorative blocks
    public static final Block BYZANTINE_STONE_TILES = registerBlock("byzantine_stone_tiles",
        new Block(AbstractBlock.Settings.create()
            .strength(2.0f, 6.0f)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()));
    
    public static final Block BYZANTINE_TILES = registerBlock("byzantine_tiles",
        new Block(AbstractBlock.Settings.create()
            .strength(2.0f, 6.0f)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()));
    
    // Ice and Snow blocks
    public static final Block ICE_BRICKS = registerBlock("icebricks",
        new Block(AbstractBlock.Settings.create()
            .strength(0.5f)
            .sounds(BlockSoundGroup.GLASS)
            .slipperiness(0.98f)));
    
    public static final Block SNOW_BRICKS = registerBlock("snowbricks",
        new Block(AbstractBlock.Settings.create()
            .strength(0.2f)
            .sounds(BlockSoundGroup.SNOW)));
    
    // Path blocks
    public static final Block PATH_DIRT = registerBlock("pathdirt",
        new Block(AbstractBlock.Settings.create()
            .strength(0.5f)
            .sounds(BlockSoundGroup.GRAVEL)));
    
    public static final Block PATH_SANDSTONE = registerBlock("pathsandstone",
        new Block(AbstractBlock.Settings.create()
            .strength(0.8f)
            .sounds(BlockSoundGroup.STONE)));
    
    public static final Block PATH_GRAVEL = registerBlock("pathgravel",
        new Block(AbstractBlock.Settings.create()
            .strength(0.6f)
            .sounds(BlockSoundGroup.GRAVEL)));
    
    /**
     * Register a block with its item
     */
    private static Block registerBlock(String name, Block block) {
        Identifier id = Identifier.of(MillenaireMod.MOD_ID, name);
        
        // Register block
        Block registeredBlock = Registry.register(Registries.BLOCK, id, block);
        
        // Register block item
        Item.Settings itemSettings = new Item.Settings();
        BlockItem blockItem = new BlockItem(registeredBlock, itemSettings);
        Registry.register(Registries.ITEM, id, blockItem);
        
        // Store in map
        BLOCKS.put(name, registeredBlock);
        
        return registeredBlock;
    }
    
    /**
     * Initialize and register all blocks
     */
    public static void register() {
        MillenaireMod.LOGGER.info("Registering Millenaire Blocks - Phase 1: Basic Building Materials");
        
        // Add blocks to creative tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(THATCH);
            entries.add(MUD_BRICK);
            entries.add(TIMBERFRAME);
            entries.add(PAINTED_BRICK_WHITE);
            entries.add(PAINTED_BRICK_RED);
            entries.add(PAINTED_BRICK_BLUE);
            entries.add(PAINTED_BRICK_YELLOW);
            entries.add(BYZANTINE_STONE_TILES);
            entries.add(BYZANTINE_TILES);
            entries.add(ICE_BRICKS);
            entries.add(SNOW_BRICKS);
            entries.add(PATH_DIRT);
            entries.add(PATH_SANDSTONE);
            entries.add(PATH_GRAVEL);
        });
    }
    
    /**
     * Get block by name
     */
    public static Block getBlock(String name) {
        return BLOCKS.get(name);
    }
}
