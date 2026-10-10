package com.pidrilium;

import java.util.Map;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.level.block.Block;

public class PidriliumMaterials {
	/** Items that repair pidrilium tools/armor in an anvil (data/pidrilium/tags/item/repairs_pidrilium_armor.json). */
	public static final TagKey<Item> REPAIRS_PIDRILIUM = TagKey.create(
			Registries.ITEM, PidriliumMod.id("repairs_pidrilium_armor")
	);

	/** Blocks that drop nothing when mined with pidrilium tools (data/pidrilium/tags/block/incorrect_for_pidrilium_tool.json). */
	public static final TagKey<Block> INCORRECT_FOR_PIDRILIUM_TOOL = TagKey.create(
			Registries.BLOCK, PidriliumMod.id("incorrect_for_pidrilium_tool")
	);

	// Between iron and diamond.
	public static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(
			INCORRECT_FOR_PIDRILIUM_TOOL,
			1200, // durability
			7.0F, // mining speed
			2.5F, // attack damage bonus
			18, // enchantment value
			REPAIRS_PIDRILIUM
	);

	public static final int ARMOR_BASE_DURABILITY = 30;

	// assets/pidrilium/equipment/pidrilium.json
	public static final ResourceKey<EquipmentAsset> ARMOR_ASSET = ResourceKey.create(
			EquipmentAssets.ROOT_ID, PidriliumMod.id("pidrilium")
	);

	public static final ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(
			ARMOR_BASE_DURABILITY,
			Map.of(
					ArmorType.HELMET, 3,
					ArmorType.CHESTPLATE, 8,
					ArmorType.LEGGINGS, 6,
					ArmorType.BOOTS, 3
			),
			18,
			SoundEvents.ARMOR_EQUIP_IRON,
			1.0F, // toughness
			0.0F, // knockback resistance
			REPAIRS_PIDRILIUM,
			ARMOR_ASSET
	);
}
