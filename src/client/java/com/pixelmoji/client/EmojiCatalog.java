package com.pixelmoji.client;

import java.util.stream.Collectors;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.MutableComponent;

final class EmojiCatalog {

	private EmojiCatalog() {
	}

	static final Emoji[] SUPPORTED = {
			new Emoji("☠️", "Skull and crossbones"),
			new Emoji("💀", "Skull"),
			new Emoji("❤️", "Red heart"),
			new Emoji("🧡", "Orange heart"),
			new Emoji("💛", "Yellow heart"),
			new Emoji("💚", "Green heart"),
			new Emoji("💙", "Blue heart"),
			new Emoji("🩵", "Light blue heart"),
			new Emoji("💜", "Purple heart"),
			new Emoji("🩷", "Pink heart"),
			new Emoji("🤎", "Brown heart"),
			new Emoji("🖤", "Black heart"),
			new Emoji("🩶", "Grey heart"),
			new Emoji("🤍", "White heart"),
			new Emoji("💔", "Broken heart"),
			new Emoji("❤️‍🔥", "Heart on fire"),
			new Emoji("❤️‍🩹", "Mending heart"),
			new Emoji("💗", "Growing heart"),
			new Emoji("💖", "Sparkling heart"),
			new Emoji("💝", "Heart with ribbon"),
			new Emoji("💌", "Love letter"),
			new Emoji("💘", "Heart with arrow"),
			new Emoji("❣️", "Heart exclamation"),
			new Emoji("🟥", "Red square"),
			new Emoji("🟧", "Orange square"),
			new Emoji("🟨", "Yellow square"),
			new Emoji("🟩", "Green square"),
			new Emoji("🟦", "Blue square"),
			new Emoji("🟪", "Purple square"),
			new Emoji("🟫", "Brown square"),
			new Emoji("⬛", "Black square"),
			new Emoji("⬜", "White square"),
			new Emoji("🔲", "Black square button"),
			new Emoji("🔳", "White square button"),
			new Emoji("⭐", "Star"),
			new Emoji("🌟", "Glowing star"),
			new Emoji("💫", "Dizzy star"),
			new Emoji("🌠", "Shooting star"),
			new Emoji("🔴", "Red circle"),
			new Emoji("🟠", "Orange circle"),
			new Emoji("🟡", "Yellow circle"),
			new Emoji("🟢", "Green circle"),
			new Emoji("🔵", "Blue circle"),
			new Emoji("🟣", "Purple circle"),
			new Emoji("🟤", "Brown circle"),
			new Emoji("⚫", "Black circle"),
			new Emoji("⚪", "White circle"),
			new Emoji("😭", "Loudly crying face"),
			new Emoji("😵", "Dizzy face"),
			new Emoji("😊", "Smiling face with smiling eyes"),
			new Emoji("😘", "Face blowing a kiss"),
			new Emoji("😗", "Kissing face"),
			new Emoji("😙", "Kissing face with smiling eyes"),
			new Emoji("😚", "Kissing face with closed eyes"),
			new Emoji("🥲", "Smiling face with tear"),
			new Emoji("😋", "Face savoring food"),
			new Emoji("😛", "Face with tongue"),
			new Emoji("🤪", "Zany face"),
			new Emoji("😜", "Winking face with tongue"),
			new Emoji("😝", "Squinting face with tongue"),
			new Emoji("🤑", "Money-mouth face"),
			new Emoji("😍", "Smiling face with heart-eyes"),
			new Emoji("🥰", "Smiling face with hearts"),
			new Emoji("🤗", "Hugging face"),
			new Emoji("😀", "Grinning face"),
			new Emoji("🤩", "Star-struck"),
			new Emoji("😃", "Grinning face with big eyes"),
			new Emoji("😄", "Grinning face with smiling eyes"),
			new Emoji("😁", "Beaming face with smiling eyes"),
			new Emoji("😆", "Grinning squinting face"),
			new Emoji("😅", "Grinning face with sweat"),
			new Emoji("😂", "Face with tears of joy"),
			new Emoji("🤣", "Rolling on the floor laughing"),
			new Emoji("🙂", "Slightly smiling face"),
			new Emoji("🙃", "Upside-down face"),
			new Emoji("🫠", "Melting face"),
			new Emoji("😉", "Winking face"),
			new Emoji("😇", "Smiling face with halo"),
			new Emoji("🐈", "Cat"),
			new Emoji("🐈‍⬛", "Black cat"),
			new Emoji("😿", "Crying cat"),
			new Emoji("😻", "Smiling cat with heart-eyes"),
			new Emoji("😽", "Kissing cat"),
			new Emoji("😺", "Grinning cat"),
			new Emoji("😾", "Pouting cat"),
			new Emoji("😸", "Grinning cat with smiling eyes"),
			new Emoji("😹", "Grinning cat with tears of joy"),
			new Emoji("🙀", "Weary cat"),
			new Emoji("😼", "Cat with wry smile")
	};

	static MutableComponent asComponent() {
		MutableComponent message = Component.empty();
		for (Emoji emoji : SUPPORTED) {
			message.append(emoji.component()).append(" ");
		}
		return message;
	}

	record Emoji(String value, String name) {
		MutableComponent component() {
			String codepoints = value.codePoints()
					.mapToObj(codepoint -> String.format("U+%04X", codepoint))
					.collect(Collectors.joining(" "));
			return Component.literal(value).withStyle(style -> style.withHoverEvent(
					new HoverEvent.ShowText(Component.literal(name + "\n" + codepoints))));
		}
	}
}