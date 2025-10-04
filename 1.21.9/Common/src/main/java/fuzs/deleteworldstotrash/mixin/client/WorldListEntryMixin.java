package fuzs.deleteworldstotrash.mixin.client;

import fuzs.deleteworldstotrash.client.handler.TrashScreenHandler;
import fuzs.deleteworldstotrash.client.handler.WorldTrashHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.worldselection.WorldSelectionList;
import net.minecraft.world.level.storage.LevelSummary;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldSelectionList.WorldListEntry.class)
abstract class WorldListEntryMixin extends WorldSelectionList.Entry {
    @Shadow
    @Final
    private Minecraft minecraft;
    @Shadow
    @Final
    private WorldSelectionList list;
    @Shadow
    @Final
    private LevelSummary summary;

    @Inject(method = "deleteWorld", at = @At("HEAD"), cancellable = true)
    public void deleteWorld(CallbackInfo callback) {
        if (WorldTrashHandler.isTrashSupported()) {
            TrashScreenHandler.setDeleteWorldScreen(this.minecraft,
                    this.list,
                    WorldSelectionList.WorldListEntry.class.cast(this),
                    this.summary);
            callback.cancel();
        }
    }
}
