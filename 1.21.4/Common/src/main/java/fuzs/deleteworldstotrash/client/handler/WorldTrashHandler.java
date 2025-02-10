package fuzs.deleteworldstotrash.client.handler;

import com.google.common.collect.Maps;
import fuzs.deleteworldstotrash.DeleteWorldsToTrash;
import fuzs.deleteworldstotrash.client.recycler.DesktopRecycler;
import fuzs.deleteworldstotrash.client.recycler.FileUtilsRecycler;
import fuzs.deleteworldstotrash.client.recycler.WorldRecycler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.DirectoryLock;

import java.nio.file.Path;
import java.util.Map;

public class WorldTrashHandler {
    private static final Map<ResourceLocation, WorldRecycler> SUPPORTED_RECYCLERS = Maps.newHashMap();

    static {
        registerRecycler(DeleteWorldsToTrash.id("file_utils"), new FileUtilsRecycler());
        registerRecycler(DeleteWorldsToTrash.id("desktop"), new DesktopRecycler());
    }

    private static final int MAX_DELETE_WORLD_ATTEMPTS = 5;

    public static void registerRecycler(ResourceLocation resourceLocation, WorldRecycler worldRecycler) {
        SUPPORTED_RECYCLERS.put(resourceLocation, worldRecycler);
    }

    public static boolean tryMoveToTrash(DirectoryLock lock, Path levelPath, String levelId) {
        for (Map.Entry<ResourceLocation, WorldRecycler> entry : SUPPORTED_RECYCLERS.entrySet()) {
            if (entry.getValue().isSupported()) {
                for (int i = 0; i < MAX_DELETE_WORLD_ATTEMPTS; ++i) {
                    DeleteWorldsToTrash.LOGGER.info("Attempt {} moving {} to trash using {}",
                            i + 1, levelId, entry.getKey()
                    );
                    try {
                        lock.close();
                        if (entry.getValue().moveToTrash(levelPath.toFile())) {
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
        for (WorldRecycler worldRecycler : SUPPORTED_RECYCLERS.values()) {
            if (worldRecycler.isSupported()) {
                return true;
            }
        }
        return false;
    }
}
