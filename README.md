# Obsidian Overhaul API

Shared API library for **Obsidian Overhaul** and addons.

## Compatibility

- Minecraft: **1.21.11** (declared range: `1.21.11`)
- NeoForge: **21.11.x** (declared range: `21.11.0+`)
- Side: **Client + Dedicated Server** (`BOTH`)

## What this API provides

This API is meant to keep **identical stats** across multiple mods (main mod + addons) by centralizing definitions in a single place.

- Tool materials (durability, mining speed, damage bonus, enchantability, repair tag)
- Armor materials (durability, protection values, toughness, knockback resistance, repair tag)
- Block strengths (hardness + blast resistance)

All values ship inside the API jar as:

- `assets/obsidianoverhaul_api/content/specs.json`

## Using the API in your mod

### 1) Runtime

Put the API jar in your `mods/` folder alongside your mod.

### 2) Development dependency (simple)

Copy the API jar into your mod project (for example `libs/`), then add:

```gradle
dependencies {
    implementation files('libs/obsidianoverhaul_api-<version>.jar')
}
```

## Code examples

### Tool material

```java
import net.mcreator.obsidianoverhaul.api.material.ModToolMaterials;
import net.minecraft.world.item.ToolMaterial;

ToolMaterial mat = ModToolMaterials.forItem("obsidian_pickaxe");
```

### Armor material

```java
import net.mcreator.obsidianoverhaul.api.material.ModArmorMaterials;
import net.minecraft.world.item.equipment.ArmorMaterial;

ArmorMaterial mat = ModArmorMaterials.forSet("obsidian");
```

### Block strength

```java
import net.mcreator.obsidianoverhaul.api.block.ModBlockStrengths;
import net.minecraft.world.level.block.state.BlockBehaviour;

BlockBehaviour.Properties props = BlockBehaviour.Properties.of();
props = ModBlockStrengths.withStrength(props, "obsidian_polished");
```

## License

Apache-2.0. See [LICENSE](LICENSE).
