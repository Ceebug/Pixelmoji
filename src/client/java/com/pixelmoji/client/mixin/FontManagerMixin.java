package com.pixelmoji.client.mixin;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.metadata.MetadataSectionType;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.IoSupplier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net.minecraft.client.gui.font.FontManager")
public abstract class FontManagerMixin {

    private static final ResourceLocation PIXELMOJI_FONT_FILE =
            ResourceLocation.fromNamespaceAndPath("pixelmoji", "font/pixelmoji.json");
        private static final String PIXELMOJI_FONT_PATH = "pixelmoji/font/pixelmoji.json";
        private static final PackResources PIXELMOJI_FONT_SOURCE = new ProtectedFontSource();
        private static final Resource PIXELMOJI_FONT = new Resource(
                        PIXELMOJI_FONT_SOURCE,
                        () -> {
                                InputStream stream = FontManagerMixin.class.getClassLoader()
                                                .getResourceAsStream(PIXELMOJI_FONT_PATH);
                                if (stream == null) {
                                        throw new IOException("Missing protected Pixelmoji font: " + PIXELMOJI_FONT_PATH);
                                }
                                return stream;
                        }
        );

    @Redirect(
            method = "prepare",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/resources/FileToIdConverter;listMatchingResourceStacks(Lnet/minecraft/server/packs/resources/ResourceManager;)Ljava/util/Map;"
            )
    )
    private Map<ResourceLocation, List<Resource>> pixelmoji$protectFontJson(
            FileToIdConverter converter,
            ResourceManager resourceManager
    ) {
        Map<ResourceLocation, List<Resource>> resources = converter.listMatchingResourceStacks(resourceManager);
                resources.put(PIXELMOJI_FONT_FILE, List.of(PIXELMOJI_FONT));
        return resources;
    }

        private static final class ProtectedFontSource implements PackResources {

                private static final PackLocationInfo LOCATION = new PackLocationInfo(
                                "Pixelmoji Protected Font",
                                net.minecraft.network.chat.Component.literal("Pixelmoji"),
                                PackSource.BUILT_IN,
                                Optional.empty()
                );

                @Override
                public IoSupplier<InputStream> getRootResource(String... path) {
                        return null;
                }

                @Override
                public IoSupplier<InputStream> getResource(PackType type, ResourceLocation location) {
                        return null;
                }

                @Override
                public void listResources(PackType type, String namespace, String prefix, ResourceOutput output) {
                }

                @Override
                public Set<String> getNamespaces(PackType type) {
                        return Set.of("pixelmoji");
                }

                @Override
                public <T> T getMetadataSection(MetadataSectionType<T> type) {
                        return null;
                }

                @Override
                public PackLocationInfo location() {
                        return LOCATION;
                }

                @Override
                public void close() {
                }
        }
}
