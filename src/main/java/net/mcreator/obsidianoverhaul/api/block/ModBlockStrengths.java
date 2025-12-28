package net.mcreator.obsidianoverhaul.api.block;

import net.mcreator.obsidianoverhaul.api.spec.ContentSpec;
import net.mcreator.obsidianoverhaul.api.spec.ContentSpecs;

import net.minecraft.world.level.block.state.BlockBehaviour;

public final class ModBlockStrengths {
	private ModBlockStrengths() {
	}

	public static ContentSpec.BlockStrengthSpec get(String blockId) {
		ContentSpec.BlockStrengthSpec spec = ContentSpecs.get().blockStrengths().get(blockId);
		if (spec == null) {
			throw new IllegalStateException("Missing block strength spec for block '" + blockId + "' in assets/obsidianoverhaul_api/content/specs.json");
		}
		return spec;
	}

	public static BlockBehaviour.Properties withStrength(BlockBehaviour.Properties properties, String blockId) {
		ContentSpec.BlockStrengthSpec spec = get(blockId);
		return properties.strength(spec.strength(), spec.resistance());
	}
}
