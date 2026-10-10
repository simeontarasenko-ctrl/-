package com.pidrilium;

import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

public class ModBlocks {
	public static final Block PIDRILIUM_ORE = register(
			"pidrilium_ore",
			Block::new,
			BlockBehaviour.Properties.of()
					.strength(4.5F, 3.0F)
					.requiresCorrectToolForDrops()
					.sound(SoundType.DEEPSLATE)
	);

	public static final Block PIDRILIUM_BLOCK = register(
			"pidrilium_block",
			Block::new,
			BlockBehaviour.Properties.of()
					.strength(5.0F, 6.0F)
					.requiresCorrectToolForDrops()
					.sound(SoundType.METAL)
	);

	/** Registers a block together with its BlockItem. */
	private static Block register(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
		ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, PidriliumMod.id(name));
		Block block = factory.apply(properties.setId(blockKey));
		Registry.register(BuiltInRegistries.BLOCK, blockKey, block);

		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, PidriliumMod.id(name));
		BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(itemKey));
		Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

		return block;
	}

	public static void initialize() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(tab -> {
			tab.accept(PIDRILIUM_ORE.asItem());
		});
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(tab -> {
			tab.accept(PIDRILIUM_BLOCK.asItem());
		});
	}
}
