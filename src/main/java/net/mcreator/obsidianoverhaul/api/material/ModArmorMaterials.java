package net.mcreator.obsidianoverhaul.api.material;

import net.mcreator.obsidianoverhaul.api.minecraft.Ids;
import net.mcreator.obsidianoverhaul.api.spec.ContentSpec;
import net.mcreator.obsidianoverhaul.api.spec.ContentSpecs;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public final class ModArmorMaterials {
	private ModArmorMaterials() {
	}

	public static ArmorMaterial forSet(String setId) {
		ContentSpec.ArmorMaterialSpec spec = ContentSpecs.get().armorMaterials().get(setId);
		if (spec == null) {
			throw new IllegalStateException("Missing armor material spec for set '" + setId + "' in assets/obsidianoverhaul_api/content/specs.json");
		}
		return new ArmorMaterial(
				spec.durability(),
				Map.of(
						ArmorType.BOOTS, spec.boots(),
						ArmorType.LEGGINGS, spec.leggings(),
						ArmorType.CHESTPLATE, spec.chestplate(),
						ArmorType.HELMET, spec.helmet(),
						ArmorType.BODY, spec.body()
				),
				spec.enchantmentValue(),
				BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.EMPTY),
				spec.toughness(),
				spec.knockbackResistance(),
				Ids.itemTag(spec.repairTag()),
				ResourceKey.create(EquipmentAssets.ROOT_ID, Ids.id(spec.equipmentAsset()))
		);
	}
}
