package io.github.eatmyvenom.nofog.mixin;

import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LightmapTextureManager.class)
public class MixinLightmapTextureManager {
    @Inject(method = "getBrightness", at = @At("HEAD"), cancellable = true)
    private void OnGetBrightness(World world, int i, CallbackInfoReturnable<Float> cir)
    {
        cir.setReturnValue(1.0f);
    }
}
