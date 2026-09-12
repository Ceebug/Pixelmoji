package com.pixelmoji.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.FontDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.startsmercury.glomphosche.impl.client.GlomphoscheImpl;

public class PixelmojiClient implements ClientModInitializer {

	public static final String MOD_ID = "pixelmoji";
	private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitializeClient() {
		LOGGER.info("Pixelmoji client initializer loaded");
		FontDescription.Resource pixelmojiFont = new FontDescription.Resource(id("pixelmoji"));

		GlomphoscheImpl.LOOKUP
				.withDiscrete('\u2620')
				.withDiscrete('\uFE0F')
				.fontOverride(pixelmojiFont);

		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F480).fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F62D).fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F60A).fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F600).fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F603).fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F604).fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F601).fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F606).fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F605).fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F602).fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F923).fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F642).fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F643).fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1FAE0).fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F609).fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F607).fontOverride(pixelmojiFont);
	}
}