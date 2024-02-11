package fuzs.deleteworldstotrash.mixin.client;

import fuzs.deleteworldstotrash.world.level.storage.WorldTrashUtil;
import net.minecraft.util.DirectoryLock;
import net.minecraft.world.level.storage.LevelStorageSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.file.Path;

@Mixin(LevelStorageSource.LevelStorageAccess.class)
abstract class LevelStorageAccessMixin {
    @Shadow
    @Final
    DirectoryLock lock;
    @Shadow
    @Final
    LevelStorageSource.LevelDirectory levelDirectory;

    @Inject(method = "deleteLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/LevelStorageSource$LevelStorageAccess;checkLock()V", shift = At.Shift.AFTER), cancellable = true)
    public void deleteLevel(CallbackInfo callback) {
        if (WorldTrashUtil.tryMoveToTrash(this.lock, this.levelDirectory.path())) callback.cancel();
    }
}
