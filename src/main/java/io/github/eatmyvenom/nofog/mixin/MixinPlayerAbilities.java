package io.github.eatmyvenom.nofog.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerAbilities;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerAbilities.class)
public abstract class MixinPlayerAbilities
{
    @Inject(method = "getFlySpeed", at = @At("HEAD"), cancellable = true)
    private void overrideFlySpeed(CallbackInfoReturnable<Float> cir)
    {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;

        if (player != null && player.abilities.allowFlying)
        {
            cir.setReturnValue(0.128f);
            cir.cancel();
        }
    }
}
