package fuzs.deleteworldstotrash;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteWorldsToTrash {
    public static final String MOD_ID = "deleteworldstotrash";
    public static final String MOD_NAME = "Delete Worlds To Trash";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
