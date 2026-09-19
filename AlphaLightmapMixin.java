package com.alphanostalgia.mixin;

import net.minecraft.client.renderer.LightTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LightTexture.class)
public class AlphaLightmapMixin {
    
    @Inject(method = "getBrightness", at = @At("HEAD"), cancellable = true)
    private static void forceHarshAlphaLighting(float flash, int lightLevel, CallbackInfoReturnable<Float> cir) {
        // Flatten the math: creates a linear 1-15 stepped gradient matching Alpha/Beta light engines
        float rawLight = (float)lightLevel / 15.0f;
        cir.setReturnValue(rawLight);
    }
}
