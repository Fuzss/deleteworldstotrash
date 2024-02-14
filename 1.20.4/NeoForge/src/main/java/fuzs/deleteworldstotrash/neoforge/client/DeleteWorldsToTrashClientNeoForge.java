package fuzs.deleteworldstotrash.neoforge.client;

import fuzs.deleteworldstotrash.DeleteWorldsToTrash;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;

@Mod.EventBusSubscriber(modid = DeleteWorldsToTrash.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DeleteWorldsToTrashClientNeoForge {

    @SubscribeEvent
    public static void onConstructMod(final FMLConstructModEvent evt) {
//        ClientModConstructor.construct(DeleteWorldsToTrash.MOD_ID, DeleteWorldsToTrashClient::new);
    }
}
