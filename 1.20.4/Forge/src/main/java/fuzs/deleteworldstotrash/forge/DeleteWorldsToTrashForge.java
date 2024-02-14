package fuzs.deleteworldstotrash.forge;

import fuzs.deleteworldstotrash.DeleteWorldsToTrash;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

@Mod(DeleteWorldsToTrash.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DeleteWorldsToTrashForge {

    @SubscribeEvent
    public static void onConstructMod(final FMLConstructModEvent evt) {
//        ModConstructor.construct(DeleteWorldsToTrash.MOD_ID, DeleteWorldsToTrash::new);
    }
}
