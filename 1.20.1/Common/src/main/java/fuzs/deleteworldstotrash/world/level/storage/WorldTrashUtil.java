package fuzs.deleteworldstotrash.world.level.storage;

import fuzs.deleteworldstotrash.DeleteWorldsToTrash;
import fuzs.deleteworldstotrash.world.level.storage.recycler.DesktopRecycler;
import fuzs.deleteworldstotrash.world.level.storage.recycler.FileUtilsRecycler;
import fuzs.deleteworldstotrash.world.level.storage.recycler.WorldRecycler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.network.chat.Component;
import net.minecraft.util.DirectoryLock;

import java.nio.file.Path;
import java.util.List;

public class WorldTrashUtil {
    private static final List<WorldRecycler> SUPPORTED_RECYCLERS = List.of(new FileUtilsRecycler(), new DesktopRecycler());

    public static boolean tryMoveToTrash(DirectoryLock lock, Path levelPath) {
        // vanilla method checks lock is valid before deletion, we inject after the check, so not necessary to repeat it
        for (WorldRecycler recycler : SUPPORTED_RECYCLERS) {
            if (recycler.isSupported()) {
                for (int i = 1; i <= 5; ++i) {
                    DeleteWorldsToTrash.LOGGER.info("Attempt {} moving world to trash...", i);
                    try {
                        lock.close();
                        if (recycler.moveToTrash(levelPath.toFile())) {
                            return true;
                        }
                    } catch (Throwable e) {
                        DeleteWorldsToTrash.LOGGER.warn("Failed to move world to trash {}", levelPath, e);
                    }
                }
            }
        }
        final Minecraft minecraft = Minecraft.getInstance();
        SystemToast.add(minecraft.getToasts(), SystemToast.SystemToastIds.WORLD_ACCESS_FAILURE, Component.translatable("deleteworldstotrash.selectWorld.deleteFailure", TrashComponentUtil.getTrashComponent()), Component.literal(levelPath.getFileName().toString()));
        DeleteWorldsToTrash.LOGGER.warn("Definitively failed to move world to trash {}", levelPath);
        return false;
    }

    public static boolean isTrashSupported() {
        return SUPPORTED_RECYCLERS.stream().anyMatch(WorldRecycler::isSupported);
    }
}
