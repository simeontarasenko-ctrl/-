package com.pidrilium;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

public class PidriliumMod implements ModInitializer {
	public static final String MOD_ID = "pidrilium";

	public static final ResourceKey<PlacedFeature> PIDRILIUM_ORE_PLACED = ResourceKey.create(
			Registries.PLACED_FEATURE, id("pidrilium_ore")
	);

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		ModItems.initialize();

		// Ore generation: the feature itself is defined in data/pidrilium/worldgen/*.
		// It is limited to Y -64..-1 there; here it is added to every Overworld biome.
		BiomeModifications.addFeature(
				BiomeSelectors.foundInOverworld(),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				PIDRILIUM_ORE_PLACED
		);
	}
}
