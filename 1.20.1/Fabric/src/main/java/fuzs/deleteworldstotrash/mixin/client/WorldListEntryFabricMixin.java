package fuzs.deleteworldstotrash.mixin.client;

import fuzs.deleteworldstotrash.client.handler.TrashScreenHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ConfirmScreen;
import net.minecraft.client.gui.screens.ProgressScreen;
import net.minecraft.client.gui.screens.worldselection.SelectWorldScreen;
import net.minecraft.client.gui.screens.worldselection.WorldSelectionList;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.storage.LevelSummary;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldSelectionList.WorldListEntry.class)
abstract class WorldListEntryFabricMixin extends WorldSelectionList.Entry {
    @Shadow
    @Final
    private Minecraft minecraft;
    @Shadow
    @Final
    private SelectWorldScreen screen;
    @Shadow
    @Final
    private LevelSummary summary;

    @Inject(method = "deleteWorld", at = @At("HEAD"), cancellable = true)
    public void deleteWorld(CallbackInfo callback) {
        this.minecraft.setScreen(new ConfirmScreen(accepted -> {
            if (accepted) {
                this.minecraft.setScreen(new ProgressScreen(true));
                this.doDeleteWorld();
            }
            this.minecraft.setScreen(this.screen);
        }, Component.translatable("selectWorld.deleteQuestion"), TrashScreenHandler.getDeleteWarningComponent(this.summary.getLevelName()), TrashScreenHandler.getDeleteButtonComponent(), CommonComponents.GUI_CANCEL));
        callback.cancel();
    }

    @Shadow
    public abstract void doDeleteWorld();
}
