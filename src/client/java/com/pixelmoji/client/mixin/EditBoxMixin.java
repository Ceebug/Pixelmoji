package com.pixelmoji.client.mixin;

import net.minecraft.client.gui.components.EditBox;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EditBox.class)
public abstract class EditBoxMixin {

    private static final String[] SPECIAL_SEQUENCES = {
        "\u2620\uFE0F",
        "\u2764\uFE0F"
    };

    @Shadow
    private String value;

    @Shadow
    private int cursorPos;

    @Shadow
    private int highlightPos;

    @Shadow
    public abstract void deleteCharsToPos(int position);

    @Inject(method = "deleteChars", at = @At("HEAD"), cancellable = true)
    private void pixelmoji$deleteSpecialSequence(int offset, CallbackInfo ci) {
        if (offset != -1 || this.cursorPos != this.highlightPos) {
            return;
        }

        for (String sequence : SPECIAL_SEQUENCES) {
            int sequenceLength = sequence.length();
            if (this.cursorPos >= sequenceLength
                && this.value.regionMatches(this.cursorPos - sequenceLength, sequence, 0, sequenceLength)) {
                this.deleteCharsToPos(this.cursorPos - sequenceLength);
                ci.cancel();
                return;
            }
        }
    }
}