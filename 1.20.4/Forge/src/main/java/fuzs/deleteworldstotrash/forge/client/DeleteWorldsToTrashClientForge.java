package fuzs.deleteworldstotrash.forge.client;

import fuzs.deleteworldstotrash.DeleteWorldsToTrash;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

@Mod.EventBusSubscriber(modid = DeleteWorldsToTrash.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DeleteWorldsToTrashClientForge {

    @SubscribeEvent
    public static void onConstructMod(final FMLConstructModEvent evt) {
//        ClientModConstructor.construct(DeleteWorldsToTrash.MOD_ID, DeleteWorldsToTrashClient::new);
    }
}
