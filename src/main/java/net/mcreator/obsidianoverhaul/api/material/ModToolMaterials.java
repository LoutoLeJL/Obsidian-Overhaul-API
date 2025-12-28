package net.mcreator.obsidianoverhaul.api.material;

import net.mcreator.obsidianoverhaul.api.minecraft.Ids;
import net.mcreator.obsidianoverhaul.api.spec.ContentSpec;
import net.mcreator.obsidianoverhaul.api.spec.ContentSpecs;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

public final class ModToolMaterials {
	private ModToolMaterials() {
	}

	public static ToolMaterial forItem(String itemId) {
		ContentSpec.ToolMaterialSpec spec = ContentSpecs.get().toolMaterials().get(itemId);
		if (spec == null) {
			throw new IllegalStateException("Missing tool material spec for item '" + itemId + "' in assets/obsidianoverhaul_api/content/specs.json");
		}
		return new ToolMaterial(
				BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
				spec.durability(),
				spec.speed(),
				spec.attackDamageBonus(),
				spec.enchantmentValue(),
				Ids.itemTag(spec.repairTag())
		);
	}
}
