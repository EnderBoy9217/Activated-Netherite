package com.enderboy9217.netherite.item;

import com.enderboy9217.netherite.EndersNetherite;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item ACTIVATED_NETHERITE_UPGRADE = registerItem("activated_netherite_upgrade_smithing_template",
                new SmithingTemplateItem(
            Text.translatable("enderboy9217.smithing_template.activated_netherite_upgrade.applies_to").formatted(Formatting.AQUA), // "Diamond Equipment"
            Text.translatable("enderboy9217.smithing_template.activated_netherite_upgrade.ingredients").formatted(Formatting.DARK_AQUA), // "Netherite Ingot"
            Text.translatable("enderboy9217.upgrade.activated_netherite_upgrade").formatted(Formatting.GOLD), // "Activated Netherite Upgrade"
            Text.translatable("item.minecraft.smithing_template.netherite_upgrade.base_slot_description"), // "Add Diamond Armor, Weapon, or Tool"
            Text.translatable("item.minecraft.smithing_template.netherite_upgrade.additions_slot_description"), // "Add Netherite Ingot"
            List.of(new Identifier("minecraft", "item/empty_slot_sword")), // Base slot texture (TODO: Should be changed to a rotating one, but I don't know the resource location)
            List.of(new Identifier("minecraft", "item/empty_slot_ingot")) // Additions slot texture
    ));

    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(ACTIVATED_NETHERITE_UPGRADE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(EndersNetherite.MOD_ID, name), item);
    }
    public static void registerModItems() {
        EndersNetherite.LOGGER.info("Registering Mod Items for " + EndersNetherite.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
    }

}
