package healthindicatorsound.mixin;


import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import healthindicatorsound.config.HealthWarningConfig;
import net.minecraft.client.MinecraftClient;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    private float lastHealth = -1;

    @Inject(method = "tick", at = @At("HEAD"))
    public void onTick(CallbackInfo ci) {
        ClientPlayerEntity player = (ClientPlayerEntity)(Object)this;
        float currentHealth = player.getHealth();

        if (lastHealth > 0 && currentHealth < lastHealth) {
            if (currentHealth <= HealthWarningConfig.get().threshold && HealthWarningConfig.get().enabled) {
                MinecraftClient.getInstance().getSoundManager().play(
                    PositionedSoundInstance.master(SoundEvents.BLOCK_NOTE_BLOCK_PLING, HealthWarningConfig.get().soundmultiplier)
                );
            }
        }

        lastHealth = currentHealth;
    }
}