package fuzs.deleteworldstotrash.world.level.storage;

import net.minecraft.Util;
import net.minecraft.network.chat.Component;

public class TrashComponentUtil {
    private static final Component RECYCLE_BIN_COMPONENT = Component.translatable("deleteworldstotrash.selectWorld.recycleBin");
    private static final Component TRASH_COMPONENT = Component.translatable("deleteworldstotrash.selectWorld.trash");
    private static final Component RECYCLE_BIN_BUTTON_COMPONENT = Component.translatable("deleteworldstotrash.selectWorld.recycleBinButton");
    private static final Component TRASH_BUTTON_COMPONENT = Component.translatable("deleteworldstotrash.selectWorld.trashButton");

    public static Component getTrashComponent() {
        return hasRecycleBin() ? RECYCLE_BIN_COMPONENT : TRASH_COMPONENT;
    }

    public static Component getTrashButtonComponent() {
        return hasRecycleBin() ? RECYCLE_BIN_BUTTON_COMPONENT : TRASH_BUTTON_COMPONENT;
    }

    private static boolean hasRecycleBin() {
        return Util.getPlatform() == Util.OS.WINDOWS;
    }
}
