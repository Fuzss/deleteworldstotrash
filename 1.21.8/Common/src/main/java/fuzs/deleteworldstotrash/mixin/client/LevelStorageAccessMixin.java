package fuzs.deleteworldstotrash.mixin.client;

import fuzs.deleteworldstotrash.client.handler.WorldTrashHandler;
import net.minecraft.util.DirectoryLock;
import net.minecraft.world.level.storage.LevelStorageSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelStorageSource.LevelStorageAccess.class)
abstract class LevelStorageAccessMixin {
    @Shadow
    @Final
    DirectoryLock lock;
    @Shadow
    @Final
    LevelStorageSource.LevelDirectory levelDirectory;
    @Shadow
    @Final
    private String levelId;

    @Inject(method = "deleteLevel", at = @At("HEAD"), cancellable = true)
    public void deleteLevel(CallbackInfo callback) {
        if (WorldTrashHandler.isTrashSupported()) {
            this.checkLock();
            WorldTrashHandler.tryMoveToTrash(this.lock, this.levelDirectory.path(), this.levelId);
            callback.cancel();
        }
    }

    @Shadow
    private void checkLock() {
        throw new RuntimeException();
    }
}
