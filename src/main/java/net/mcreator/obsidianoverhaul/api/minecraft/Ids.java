package net.mcreator.obsidianoverhaul.api.minecraft;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class Ids {
	private Ids() {
	}

	public static Identifier id(String id) {
		return Identifier.parse(id);
	}

	public static TagKey<Item> itemTag(String id) {
		return TagKey.create(Registries.ITEM, id(id));
	}
}
