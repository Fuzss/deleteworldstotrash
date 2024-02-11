package fuzs.deleteworldstotrash.client.handler;

import fuzs.deleteworldstotrash.mixin.client.accessor.ConfirmScreenAccessor;
import fuzs.deleteworldstotrash.world.level.storage.TrashComponentUtil;
import fuzs.deleteworldstotrash.world.level.storage.WorldTrashUtil;
import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import net.minecraft.client.gui.screens.ConfirmScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;

import java.util.Optional;

public class TrashScreenHandler {

    public static Optional<Screen> onScreenOpen(Screen newScreen) {
        if (newScreen instanceof ConfirmScreen && WorldTrashUtil.isTrashSupported()) {
            if (newScreen.getTitle().getContents() instanceof TranslatableContents titleContents && titleContents.getKey().equals("selectWorld.deleteQuestion") && ((ConfirmScreenAccessor) newScreen).deleteworldstotrash$getMessage().getContents() instanceof TranslatableContents messageContents) {
                BooleanConsumer callback = ((ConfirmScreenAccessor) newScreen).deleteworldstotrash$getCallback();
                return Optional.of(new ConfirmScreen(callback, newScreen.getTitle(), getDeleteWarningComponent(messageContents.getArgs()[0]), getDeleteButtonComponent(), CommonComponents.GUI_CANCEL));
            }
        }
        return Optional.empty();
    }

    public static Component getDeleteWarningComponent(Object arg) {
        return Component.translatable("deleteworldstotrash.selectWorld.deleteWarning", arg, TrashComponentUtil.getTrashComponent());
    }

    public static Component getDeleteButtonComponent() {
        return Component.translatable("deleteworldstotrash.selectWorld.deleteButton", TrashComponentUtil.getTrashButtonComponent());
    }
}
