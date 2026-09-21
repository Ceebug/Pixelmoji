package com.pixelmoji.client;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.FontDescription;
import net.minecraft.network.chat.Component;
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
		// Register the built-in Pixelmoji resource pack
		ResourceManagerHelper.registerBuiltinResourcePack(
				id("pixelmoji"),
				FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(),
				Component.literal("Pixelmoji"),
				ResourcePackActivationType.ALWAYS_ENABLED
		);

		// Register /testemojis command
		ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(
			// Description: Displays every emoji in chat for testing purposes.
			ClientCommandManager.literal("testemojis").executes(context -> {
				context.getSource().sendFeedback(EmojiCatalog.asComponent());
				return 1;
			})
		));

		// Register /te command as an alias for /testemojis
		ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(
			// Description: Alias for /testemojis; displays every emoji in chat for testing purposes.
			ClientCommandManager.literal("te").executes(context -> {
				context.getSource().sendFeedback(EmojiCatalog.asComponent());
				return 1;
			})
		));

		LOGGER.info("[Pixelmoji] Loading emojis...");
		FontDescription.Resource pixelmojiFont = new FontDescription.Resource(id("pixelmoji"));

		GlomphoscheImpl.LOOKUP
				.withDiscrete('\u2620') // ☠️
				.withDiscrete('\uFE0F') // variation selector
				.fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F480).fontOverride(pixelmojiFont); // 💀
		GlomphoscheImpl.LOOKUP
				.withDiscrete(0x2764) // ❤
				.withDiscrete(0xFE0F) // variation selector
				.withDiscrete(0x200D) // ZWJ
				.withDiscrete(0x1F525) // 🔥
				.codepointOverride(0xE001)
				.fontOverride(pixelmojiFont); // ❤️‍🔥
		GlomphoscheImpl.LOOKUP
				.withDiscrete(0x2764) // ❤
				.withDiscrete(0xFE0F) // variation selector
				.withDiscrete(0x200D) // ZWJ
				.withDiscrete(0x1FA79) // 🩹
				.codepointOverride(0xE002)
				.fontOverride(pixelmojiFont); // ❤️‍🩹
		GlomphoscheImpl.LOOKUP
				.withDiscrete(0x2764) // ❤
				.withDiscrete(0xFE0F) // variation selector
				.codepointOverride(0xE000)
				.fontOverride(pixelmojiFont); // ❤️
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F497).fontOverride(pixelmojiFont); // 💗
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F496).fontOverride(pixelmojiFont); // 💖
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F49D).fontOverride(pixelmojiFont); // 💝
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F48C).fontOverride(pixelmojiFont); // 💌
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F498).fontOverride(pixelmojiFont); // 💘
		GlomphoscheImpl.LOOKUP
				.withDiscrete(0x2763) // ❣
				.withDiscrete(0xFE0F) // variation selector
				.fontOverride(pixelmojiFont); // ❣️
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F9E1).fontOverride(pixelmojiFont); // 🧡
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F49B).fontOverride(pixelmojiFont); // 💛
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F49A).fontOverride(pixelmojiFont); // 💚
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F499).fontOverride(pixelmojiFont); // 💙
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1FA75).fontOverride(pixelmojiFont); // 🩵
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F49C).fontOverride(pixelmojiFont); // 💜
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1FA77).fontOverride(pixelmojiFont); // 🩷
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F90E).fontOverride(pixelmojiFont); // 🤎
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F5A4).fontOverride(pixelmojiFont); // 🖤
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1FA76).fontOverride(pixelmojiFont); // 🩶
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F90D).fontOverride(pixelmojiFont); // 🤍
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F494).fontOverride(pixelmojiFont); // 💔
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F7E5).fontOverride(pixelmojiFont); // 🟥
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F7E7).fontOverride(pixelmojiFont); // 🟧
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F7E8).fontOverride(pixelmojiFont); // 🟨
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F7E9).fontOverride(pixelmojiFont); // 🟩
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F7E6).fontOverride(pixelmojiFont); // 🟦
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F7EA).fontOverride(pixelmojiFont); // 🟪
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F7EB).fontOverride(pixelmojiFont); // 🟫
		GlomphoscheImpl.LOOKUP.withDiscrete(0x2B1B).fontOverride(pixelmojiFont); // ⬛
		GlomphoscheImpl.LOOKUP.withDiscrete(0x2B1C).fontOverride(pixelmojiFont); // ⬜
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F533).fontOverride(pixelmojiFont); // 🔳
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F532).fontOverride(pixelmojiFont); // 🔲
		GlomphoscheImpl.LOOKUP.withDiscrete(0x2B50).fontOverride(pixelmojiFont); // ⭐
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F31F).fontOverride(pixelmojiFont); // 🌟
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F4AB).fontOverride(pixelmojiFont); // 💫
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F320).fontOverride(pixelmojiFont); // 🌠
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F534).fontOverride(pixelmojiFont); // 🔴
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F7E0).fontOverride(pixelmojiFont); // 🟠
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F7E1).fontOverride(pixelmojiFont); // 🟡
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F7E2).fontOverride(pixelmojiFont); // 🟢
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F535).fontOverride(pixelmojiFont); // 🔵
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F7E3).fontOverride(pixelmojiFont); // 🟣
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F7E4).fontOverride(pixelmojiFont); // 🟤
		GlomphoscheImpl.LOOKUP.withDiscrete(0x26AB).fontOverride(pixelmojiFont); // ⚫
		GlomphoscheImpl.LOOKUP.withDiscrete(0x26AA).fontOverride(pixelmojiFont); // ⚪
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F62D).fontOverride(pixelmojiFont); // 😭
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F635).fontOverride(pixelmojiFont); // 😵
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F60A).fontOverride(pixelmojiFont); // 😊
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F618).fontOverride(pixelmojiFont); // 😘
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F617).fontOverride(pixelmojiFont); // 😗
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F619).fontOverride(pixelmojiFont); // 😙
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F61A).fontOverride(pixelmojiFont); // 😚
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F972).fontOverride(pixelmojiFont); // 🥲
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F60B).fontOverride(pixelmojiFont); // 😋
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F61B).fontOverride(pixelmojiFont); // 😛
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F92A).fontOverride(pixelmojiFont); // 🤪
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F61C).fontOverride(pixelmojiFont); // 😜
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F61D).fontOverride(pixelmojiFont); // 😝
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F911).fontOverride(pixelmojiFont); // 🤑
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F60D).fontOverride(pixelmojiFont); // 😍
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F970).fontOverride(pixelmojiFont); // 🥰
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F917).fontOverride(pixelmojiFont); // 🤗
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F600).fontOverride(pixelmojiFont); // 😀
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F929).fontOverride(pixelmojiFont); // 🤩
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F603).fontOverride(pixelmojiFont); // 😃
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F604).fontOverride(pixelmojiFont); // 😄
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F601).fontOverride(pixelmojiFont); // 😁
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F606).fontOverride(pixelmojiFont); // 😆
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F605).fontOverride(pixelmojiFont); // 😅
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F602).fontOverride(pixelmojiFont); // 😂
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F923).fontOverride(pixelmojiFont); // 🤣
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F642).fontOverride(pixelmojiFont); // 🙂
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F643).fontOverride(pixelmojiFont); // 🙃
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1FAE0).fontOverride(pixelmojiFont); // 🫠
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F609).fontOverride(pixelmojiFont); // 😉
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F607).fontOverride(pixelmojiFont); // 😇
		GlomphoscheImpl.LOOKUP
				.withDiscrete(0x1F408) // 🐈
				.codepointOverride(0xE003)
				.fontOverride(pixelmojiFont);
		GlomphoscheImpl.LOOKUP
				.withDiscrete(0x1F408) // 🐈
				.withDiscrete(0x200D) // ZWJ
				.withDiscrete(0x2B1B) // ⬛
				.codepointOverride(0xE004)
				.fontOverride(pixelmojiFont); // 🐈‍⬛
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F63F).fontOverride(pixelmojiFont); // 😿
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F63B).fontOverride(pixelmojiFont); // 😻
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F63D).fontOverride(pixelmojiFont); // 😽
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F63A).fontOverride(pixelmojiFont); // 😺
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F63E).fontOverride(pixelmojiFont); // 😾
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F638).fontOverride(pixelmojiFont); // 😸
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F639).fontOverride(pixelmojiFont); // 😹
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F640).fontOverride(pixelmojiFont); // 🙀
		GlomphoscheImpl.LOOKUP.withDiscrete(0x1F63C).fontOverride(pixelmojiFont); // 😼
	}
}