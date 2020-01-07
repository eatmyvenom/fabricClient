package io.github.eatmyvenom.nofog.mixin;

import net.minecraft.client.render.BackgroundRenderer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BackgroundRenderer.class)
public class ExampleMod {
	@Inject(at = @At("INVOKE"), method = "applyFog", cancellable = true)
	private static void nofog(CallbackInfo ci) {
		ci.cancel();
	}
}
