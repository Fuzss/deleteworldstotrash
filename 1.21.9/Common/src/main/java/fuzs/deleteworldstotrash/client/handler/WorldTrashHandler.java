package fuzs.deleteworldstotrash.client.handler;

import com.google.common.collect.ImmutableList;
import fuzs.deleteworldstotrash.DeleteWorldsToTrash;
import fuzs.deleteworldstotrash.client.recycler.DesktopRecycler;
import fuzs.deleteworldstotrash.client.recycler.FileUtilsRecycler;
import fuzs.deleteworldstotrash.client.recycler.WorldRecycler;
import fuzs.deleteworldstotrash.services.CommonAbstractions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.util.DirectoryLock;

import java.nio.file.Path;
import java.util.List;

public class WorldTrashHandler {
    private static final int MAX_DELETE_WORLD_ATTEMPTS = 5;
    private static final List<WorldRecycler> SYSTEM_RECYCLERS =
            CommonAbstractions.INSTANCE.isForgeLike() ? ImmutableList.of(FileUtilsRecycler.INSTANCE) :
                    ImmutableList.of(FileUtilsRecycler.INSTANCE, DesktopRecycler.INSTANCE);

    public static boolean tryMoveToTrash(DirectoryLock lock, Path levelPath, String levelId) {
        for (WorldRecycler recycler : SYSTEM_RECYCLERS) {
            if (recycler.isSupported()) {
                for (int i = 0; i < MAX_DELETE_WORLD_ATTEMPTS; ++i) {
                    DeleteWorldsToTrash.LOGGER.info("Attempt {} moving {} to trash using {}",
                            i + 1,
                            levelId,
                            recycler.getName());
                    try {
                        lock.close();
                        if (recycler.moveToTrash(levelPath.toFile())) {
                            return true;
                        }
                    } catch (Throwable throwable) {
                        DeleteWorldsToTrash.LOGGER.warn("Failed to delete {}", levelPath, throwable);
                    }
                }
            }
        }

        SystemToast.onWorldDeleteFailure(Minecraft.getInstance(), levelId);
        return false;
    }

    public static boolean isTrashSupported() {
        for (WorldRecycler worldRecycler : SYSTEM_RECYCLERS) {
            if (worldRecycler.isSupported()) {
                return true;
            }
        }

        return false;
    }
}
