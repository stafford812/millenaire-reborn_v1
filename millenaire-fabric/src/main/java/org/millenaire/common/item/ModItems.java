package org.millenaire.common.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.millenaire.MillenaireMod;

import java.util.HashMap;
import java.util.Map;

public class ModItems {
    
    // Storage map for all registered items
    private static final Map<String, Item> ITEMS = new HashMap<>();
    
    // === CURRENCY ITEMS ===
    public static final Item DENIER = registerItem("denier",
        new Item(new Item.Settings()));
    
    public static final Item DENIER_ARGENT = registerItem("denierargent",
        new Item(new Item.Settings()));
    
    public static final Item DENIER_OR = registerItem("denieror",
        new Item(new Item.Settings()));
    
    // === FOOD ITEMS ===
    public static final Item CIDER_APPLE = registerItem("ciderapple",
        new Item(new Item.Settings()
            .food(new FoodComponent.Builder()
                .nutrition(4)
                .saturationModifier(0.3f)
                .build())));
    
    public static final Item CIDER = registerItem("cider",
        new Item(new Item.Settings()
            .food(new FoodComponent.Builder()
                .nutrition(2)
                .saturationModifier(0.2f)
                .build())));
    
    public static final Item CHICKEN_CURRY = registerItem("chickencurry",
        new Item(new Item.Settings()
            .food(new FoodComponent.Builder()
                .nutrition(8)
                .saturationModifier(0.8f)
                .build())));
    
    public static final Item VEG_CURRY = registerItem("vegcurry",
        new Item(new Item.Settings()
            .food(new FoodComponent.Builder()
                .nutrition(6)
                .saturationModifier(0.6f)
                .build())));
    
    public static final Item MASA = registerItem("masa",
        new Item(new Item.Settings()
            .food(new FoodComponent.Builder()
                .nutrition(5)
                .saturationModifier(0.6f)
                .build())));
    
    public static final Item WINE_BASIC = registerItem("winebasic",
        new Item(new Item.Settings()
            .food(new FoodComponent.Builder()
                .nutrition(2)
                .saturationModifier(0.2f)
                .build())));
    
    // === CRAFTING MATERIALS ===
    public static final Item OLIVE_OIL = registerItem("oliveoil",
        new Item(new Item.Settings()));
    
    public static final Item COTTON = registerItem("cotton",
        new Item(new Item.Settings()));
    
    public static final Item BRICK_MOULD = registerItem("brickmould",
        new Item(new Item.Settings()));
    
    // === PAINT BUCKETS ===
    public static final Item PAINT_BUCKET_WHITE = registerItem("paint_bucket_white",
        new Item(new Item.Settings()));
    
    public static final Item PAINT_BUCKET_RED = registerItem("paint_bucket_red",
        new Item(new Item.Settings()));
    
    public static final Item PAINT_BUCKET_BLUE = registerItem("paint_bucket_blue",
        new Item(new Item.Settings()));
    
    public static final Item PAINT_BUCKET_YELLOW = registerItem("paint_bucket_yellow",
        new Item(new Item.Settings()));
    
    public static final Item PAINT_BUCKET_GREEN = registerItem("paint_bucket_green",
        new Item(new Item.Settings()));
    
    public static final Item PAINT_BUCKET_BLACK = registerItem("paint_bucket_black",
        new Item(new Item.Settings()));
    
    // === SPECIAL ITEMS ===
    public static final Item PURSE = registerItem("purse",
        new Item(new Item.Settings().maxCount(1)));
    
    public static final Item PARCHMENT = registerItem("parchment",
        new Item(new Item.Settings()));
    
    // === CUSTOM ITEM GROUP ===
    public static final RegistryKey<ItemGroup> MILLENAIRE_GROUP_KEY = RegistryKey.of(
        RegistryKeys.ITEM_GROUP,
        Identifier.of(MillenaireMod.MOD_ID, "millenaire_items")
    );
    
    public static final ItemGroup MILLENAIRE_GROUP = FabricItemGroup.builder()
        .icon(() -> new ItemStack(DENIER_OR))
        .displayName(Text.translatable("itemGroup.millenaire.items"))
        .build();
    
    /**
     * Register an item
     */
    private static Item registerItem(String name, Item item) {
        Identifier id = Identifier.of(MillenaireMod.MOD_ID, name);
        Item registeredItem = Registry.register(Registries.ITEM, id, item);
        ITEMS.put(name, registeredItem);
        return registeredItem;
    }
    
    /**
     * Initialize and register all items
     */
    public static void register() {
        MillenaireMod.LOGGER.info("Registering Millenaire Items - Phase 1: Basic Items");
        
        // Register custom item group
        Registry.register(Registries.ITEM_GROUP, MILLENAIRE_GROUP_KEY, MILLENAIRE_GROUP);
        
        // Add items to custom creative tab
        ItemGroupEvents.modifyEntriesEvent(MILLENAIRE_GROUP_KEY).register(entries -> {
            // Currency
            entries.add(DENIER);
            entries.add(DENIER_ARGENT);
            entries.add(DENIER_OR);
            
            // Food
            entries.add(CIDER_APPLE);
            entries.add(CIDER);
            entries.add(CHICKEN_CURRY);
            entries.add(VEG_CURRY);
            entries.add(MASA);
            entries.add(WINE_BASIC);
            
            // Materials
            entries.add(OLIVE_OIL);
            entries.add(COTTON);
            entries.add(BRICK_MOULD);
            
            // Paint buckets
            entries.add(PAINT_BUCKET_WHITE);
            entries.add(PAINT_BUCKET_RED);
            entries.add(PAINT_BUCKET_BLUE);
            entries.add(PAINT_BUCKET_YELLOW);
            entries.add(PAINT_BUCKET_GREEN);
            entries.add(PAINT_BUCKET_BLACK);
            
            // Special
            entries.add(PURSE);
            entries.add(PARCHMENT);
        });
        
        // Also add food items to food creative tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(CIDER_APPLE);
            entries.add(CIDER);
            entries.add(CHICKEN_CURRY);
            entries.add(VEG_CURRY);
            entries.add(MASA);
            entries.add(WINE_BASIC);
        });
    }
    
    /**
     * Get item by name
     */
    public static Item getItem(String name) {
        return ITEMS.get(name);
    }
}
