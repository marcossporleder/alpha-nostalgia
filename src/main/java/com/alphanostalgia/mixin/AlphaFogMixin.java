package com.alphanostalgia.mixin;

import net.minecraft.client.renderer.BackgroundRenderer;
import net.minecraft.client.Camera;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.shaders.FogShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BackgroundRenderer.class)
public class AlphaFogMixin {
    @Inject(method = "applyFog", at = @At("TAIL"))
    private static void injectAlphaFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
        float fogStart = 4.0f;
        float fogEnd = Math.min(viewDistance, 48.0f); 

        RenderSystem.setShaderFogStart(fogStart);
        RenderSystem.setShaderFogEnd(fogEnd);
        RenderSystem.setShaderFogShape(FogShape.CYLINDER);
    }
}
