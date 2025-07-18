package fuzs.deleteworldstotrash;

import net.minecraft.resources.ResourceLocation;

public class DeleteWorldsToTrashMod extends DeleteWorldsToTrash {

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
