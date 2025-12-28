package net.mcreator.obsidianoverhaul.api.spec;

import java.util.Map;

public record ContentSpec(
		Map<String, ToolMaterialSpec> toolMaterials,
		Map<String, ArmorMaterialSpec> armorMaterials,
		Map<String, BlockStrengthSpec> blockStrengths
) {
	public record ToolMaterialSpec(int durability, float speed, float attackDamageBonus, int enchantmentValue, String repairTag) {
	}

	public record ArmorMaterialSpec(
			int durability,
			int boots,
			int leggings,
			int chestplate,
			int helmet,
			int body,
			int enchantmentValue,
			float toughness,
			float knockbackResistance,
			String repairTag,
			String equipmentAsset
	) {
	}

	public record BlockStrengthSpec(float strength, float resistance) {
	}

	public static ContentSpec empty() {
		return new ContentSpec(Map.of(), Map.of(), Map.of());
	}
}
