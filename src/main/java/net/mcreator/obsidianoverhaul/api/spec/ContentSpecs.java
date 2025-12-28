package net.mcreator.obsidianoverhaul.api.spec;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public final class ContentSpecs {
	// Specs now ship with the API mod.
	private static final String RESOURCE_PATH = "/assets/obsidianoverhaul_api/content/specs.json";
	private static final Gson GSON = new Gson();

	private static volatile ContentSpec cached;

	private ContentSpecs() {
	}

	public static ContentSpec get() {
		ContentSpec local = cached;
		if (local != null) {
			return local;
		}
		synchronized (ContentSpecs.class) {
			local = cached;
			if (local != null) {
				return local;
			}
			cached = local = load();
			return local;
		}
	}

	private static ContentSpec load() {
		try (InputStream in = ContentSpecs.class.getResourceAsStream(RESOURCE_PATH)) {
			if (in == null) {
				return ContentSpec.empty();
			}
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
				ContentSpec parsed = GSON.fromJson(reader, ContentSpec.class);
				return parsed != null ? parsed : ContentSpec.empty();
			}
		} catch (JsonSyntaxException ex) {
			return ContentSpec.empty();
		} catch (Exception ex) {
			return ContentSpec.empty();
		}
	}
}
