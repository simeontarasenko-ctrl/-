package com.pidrilium;

import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.equipment.ArmorType;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

public class ModItems {
	// Materials
	public static final Item RAW_PIDRILIUM = register("raw_pidrilium", Item::new, new Item.Properties());
	public static final Item PIDRILIUM_INGOT = register("pidrilium_ingot", Item::new, new Item.Properties());

	// Tools
	public static final Item PIDRILIUM_SWORD = register(
			"pidrilium_sword",
			Item::new,
			new Item.Properties().sword(PidriliumMaterials.TOOL_MATERIAL, 3.0F, -2.4F)
	);
	public static final Item PIDRILIUM_PICKAXE = register(
			"pidrilium_pickaxe",
			Item::new,
			new Item.Properties().pickaxe(PidriliumMaterials.TOOL_MATERIAL, 1.0F, -2.8F)
	);
	public static final Item PIDRILIUM_AXE = register(
			"pidrilium_axe",
			settings -> new AxeItem(PidriliumMaterials.TOOL_MATERIAL, 5.0F, -3.0F, settings),
			new Item.Properties()
	);
	public static final Item PIDRILIUM_SHOVEL = register(
			"pidrilium_shovel",
			settings -> new ShovelItem(PidriliumMaterials.TOOL_MATERIAL, 1.5F, -3.0F, settings),
			new Item.Properties()
	);
	public static final Item PIDRILIUM_HOE = register(
			"pidrilium_hoe",
			settings -> new HoeItem(PidriliumMaterials.TOOL_MATERIAL, -3.0F, 0.0F, settings),
			new Item.Properties()
	);

	// Armor
	public static final Item PIDRILIUM_HELMET = register(
			"pidrilium_helmet",
			Item::new,
			new Item.Properties().humanoidArmor(PidriliumMaterials.ARMOR_MATERIAL, ArmorType.HELMET)
					.durability(ArmorType.HELMET.getDurability(PidriliumMaterials.ARMOR_BASE_DURABILITY))
	);
	public static final Item PIDRILIUM_CHESTPLATE = register(
			"pidrilium_chestplate",
			Item::new,
			new Item.Properties().humanoidArmor(PidriliumMaterials.ARMOR_MATERIAL, ArmorType.CHESTPLATE)
					.durability(ArmorType.CHESTPLATE.getDurability(PidriliumMaterials.ARMOR_BASE_DURABILITY))
	);
	public static final Item PIDRILIUM_LEGGINGS = register(
			"pidrilium_leggings",
			Item::new,
			new Item.Properties().humanoidArmor(PidriliumMaterials.ARMOR_MATERIAL, ArmorType.LEGGINGS)
					.durability(ArmorType.LEGGINGS.getDurability(PidriliumMaterials.ARMOR_BASE_DURABILITY))
	);
	public static final Item PIDRILIUM_BOOTS = register(
			"pidrilium_boots",
			Item::new,
			new Item.Properties().humanoidArmor(PidriliumMaterials.ARMOR_MATERIAL, ArmorType.BOOTS)
					.durability(ArmorType.BOOTS.getDurability(PidriliumMaterials.ARMOR_BASE_DURABILITY))
	);

	private static Item register(String name, Function<Item.Properties, Item> factory, Item.Properties settings) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, PidriliumMod.id(name));
		Item item = factory.apply(settings.setId(key));
		return Registry.register(BuiltInRegistries.ITEM, key, item);
	}

	public static void initialize() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(tab -> {
			tab.accept(RAW_PIDRILIUM);
			tab.accept(PIDRILIUM_INGOT);
		});
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(tab -> {
			tab.accept(PIDRILIUM_SHOVEL);
			tab.accept(PIDRILIUM_PICKAXE);
			tab.accept(PIDRILIUM_AXE);
			tab.accept(PIDRILIUM_HOE);
		});
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(tab -> {
			tab.accept(PIDRILIUM_SWORD);
			tab.accept(PIDRILIUM_AXE);
			tab.accept(PIDRILIUM_HELMET);
			tab.accept(PIDRILIUM_CHESTPLATE);
			tab.accept(PIDRILIUM_LEGGINGS);
			tab.accept(PIDRILIUM_BOOTS);
		});
	}
}
