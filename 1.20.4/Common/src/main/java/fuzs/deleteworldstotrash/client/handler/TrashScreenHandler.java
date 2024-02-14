package fuzs.deleteworldstotrash.client.handler;

import fuzs.deleteworldstotrash.DeleteWorldsToTrash;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ConfirmScreen;
import net.minecraft.client.gui.screens.ProgressScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.worldselection.WorldSelectionList;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.storage.LevelSummary;

public class TrashScreenHandler {
    public static final String KEY_DELETE_WARNING_TRASH =
            DeleteWorldsToTrash.MOD_ID + ".selectWorld.deleteButton.trash";
    public static final String KEY_DELETE_WARNING_RECYCLE_BIN =
            DeleteWorldsToTrash.MOD_ID + ".selectWorld.deleteButton.recycle_bin";

    public static void setDeleteWorldScreen(Minecraft minecraft, Screen lastScreen, WorldSelectionList.WorldListEntry worldListEntry, LevelSummary summary) {
        minecraft.setScreen(new ConfirmScreen((boolean accepted) -> {
            if (accepted) {
                minecraft.setScreen(new ProgressScreen(true));
                worldListEntry.doDeleteWorld();
            }
            minecraft.setScreen(lastScreen);
        },
                Component.translatable("selectWorld.deleteQuestion"),
                getDeleteWarningComponent(summary.getLevelName()),
                Component.translatable("selectWorld.deleteButton"),
                CommonComponents.GUI_CANCEL
        ));
    }

    private static Component getDeleteWarningComponent(Object o) {
        return Component.translatable(hasRecycleBin() ? KEY_DELETE_WARNING_RECYCLE_BIN : KEY_DELETE_WARNING_TRASH, o);
    }

    private static boolean hasRecycleBin() {
        return Util.getPlatform() == Util.OS.WINDOWS;
    }

    public static void setVanillaDeleteWorldScreen(Minecraft minecraft, Screen lastScreen, WorldSelectionList.WorldListEntry worldListEntry, LevelSummary summary) {
        // maybe fall back to this when moving to trash fails? but how to get last screen and world data?
        minecraft.setScreen(new ConfirmScreen((boolean accepted) -> {
            if (accepted) {
                minecraft.setScreen(new ProgressScreen(true));
                worldListEntry.doDeleteWorld();
            }
            minecraft.setScreen(lastScreen);
        },
                Component.translatable("selectWorld.deleteQuestion"),
                Component.translatable("selectWorld.deleteWarning", summary.getLevelName()),
                Component.translatable("selectWorld.deleteButton"),
                CommonComponents.GUI_CANCEL
        ));
    }
}
