package com.enderboy9217.netherite.datagen;

import com.enderboy9217.netherite.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

import java.util.List;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    private static final List<Item> standardItems = List.of(
            ModItems.ACTIVATED_NETHERITE_UPGRADE
    );

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for (Item item : standardItems) {
            itemModelGenerator.register(item, Models.GENERATED);
        }

    }
}
