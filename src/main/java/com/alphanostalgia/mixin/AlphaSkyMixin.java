package com.alphanostalgia.mixin;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientLevel.Properties.class)
public class AlphaSkyMixin {
    @Inject(method = "getSkyColor", at = @At("HEAD"), cancellable = true)
    private void overrideSkyColor(CallbackInfoReturnable<Vec3> cir) {
        cir.setReturnValue(new Vec3(0.533, 0.702, 1.0));
    }
}
