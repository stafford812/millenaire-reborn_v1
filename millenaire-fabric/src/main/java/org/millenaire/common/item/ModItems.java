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
    
    private static final Map<String, Item> ITEMS = new HashMap<>();
    
    // Currency items
    public static final Item DENIER = registerItem("denier");
    public static final Item DENIER_ARGENT = registerItem("denierargent");
    public static final Item DENIER_OR = registerItem("denieror");
    
    // Food items
    public static final Item CIDER_APPLE = registerFoodItem("ciderapple", 4, 0.3f);
    public static final Item CIDER = registerFoodItem("cider", 2, 0.2f);
    public static final Item CHICKEN_CURRY = registerFoodItem("chickencurry", 8, 0.8f);
    public static final Item VEG_CURRY = registerFoodItem("vegcurry", 6, 0.6f);
    public static final Item MASA = registerFoodItem("masa", 5, 0.6f);
    public static final Item WINE_BASIC = registerFoodItem("winebasic", 2, 0.2f);
    
    // Materials
    public static final Item OLIVE_OIL = registerItem("oliveoil");
    public static final Item COTTON = registerItem("cotton");
    public static final Item BRICK_MOULD = registerItem("brickmould");
    
    // Paint buckets
    public static final Item PAINT_BUCKET_WHITE = registerItem("paint_bucket_white");
    public static final Item PAINT_BUCKET_RED = registerItem("paint_bucket_red");
    public static final Item PAINT_BUCKET_BLUE = registerItem("paint_bucket_blue");
    public static final Item PAINT_BUCKET_YELLOW = registerItem("paint_bucket_yellow");
    
    // Special items
    public static final Item PURSE = registerItemWithSettings("purse", new Item.Settings().maxCount(1));
    public static final Item PARCHMENT = registerItem("parchment");
    
    // Custom item group
    public static final ItemGroup MILLENAIRE_GROUP = Registry.register(
        Registries.ITEM_GROUP,
        Identifier.of(MillenaireMod.MOD_ID, "millenaire_items"),
        FabricItemGroup.builder()
            .icon(() -> new ItemStack(DENIER_OR))
            .displayName(Text.translatable("itemGroup.millenaire.items"))
            .entries((context, entries) -> {
                entries.add(DENIER);
                entries.add(DENIER_ARGENT);
                entries.add(DENIER_OR);
                entries.add(CIDER_APPLE);
                entries.add(CIDER);
                entries.add(CHICKEN_CURRY);
                entries.add(VEG_CURRY);
                entries.add(MASA);
                entries.add(WINE_BASIC);
                entries.add(OLIVE_OIL);
                entries.add(COTTON);
                entries.add(BRICK_MOULD);
                entries.add(PAINT_BUCKET_WHITE);
                entries.add(PAINT_BUCKET_RED);
                entries.add(PAINT_BUCKET_BLUE);
                entries.add(PAINT_BUCKET_YELLOW);
                entries.add(PURSE);
                entries.add(PARCHMENT);
            })
            .build()
    );
    
    private static Item registerItem(String name) {
        Identifier id = Identifier.of(MillenaireMod.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item item = new Item(new Item.Settings().registryKey(key));
        Item registered = Registry.register(Registries.ITEM, key, item);
        ITEMS.put(name, registered);
        return registered;
    }
    
    private static Item registerItemWithSettings(String name, Item.Settings settings) {
        Identifier id = Identifier.of(MillenaireMod.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item item = new Item(settings.registryKey(key));
        Item registered = Registry.register(Registries.ITEM, key, item);
        ITEMS.put(name, registered);
        return registered;
    }
    
    private static Item registerFoodItem(String name, int nutrition, float saturation) {
        Identifier id = Identifier.of(MillenaireMod.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        
        Item.Settings settings = new Item.Settings()
            .registryKey(key)
            .food(new FoodComponent.Builder()
                .nutrition(nutrition)
                .saturationModifier(saturation)
                .build());
        
        Item item = new Item(settings);
        Item registered = Registry.register(Registries.ITEM, key, item);
        ITEMS.put(name, registered);
        return registered;
    }
    
    public static void register() {
        MillenaireMod.LOGGER.info("Registering Millenaire Items - Phase 1");
        
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(CIDER_APPLE);
            entries.add(CIDER);
            entries.add(CHICKEN_CURRY);
            entries.add(VEG_CURRY);
            entries.add(MASA);
            entries.add(WINE_BASIC);
        });
    }
    
    public static Item getItem(String name) {
        return ITEMS.get(name);
    }
}
