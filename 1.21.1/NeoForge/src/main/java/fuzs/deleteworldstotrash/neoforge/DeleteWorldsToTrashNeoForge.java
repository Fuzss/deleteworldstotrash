package fuzs.deleteworldstotrash.neoforge;

import fuzs.deleteworldstotrash.DeleteWorldsToTrash;
import fuzs.deleteworldstotrash.data.client.ModLanguageProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(DeleteWorldsToTrash.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DeleteWorldsToTrashNeoForge {

    @SubscribeEvent
    public static void onConstructMod(final FMLConstructModEvent evt) {
//        ModConstructor.construct(DeleteWorldsToTrash.MOD_ID, DeleteWorldsToTrash::new);
    }

    @SubscribeEvent
    public static void onGatherData(final GatherDataEvent evt) {
        evt.getGenerator().addProvider(true, new ModLanguageProvider(DeleteWorldsToTrash.MOD_ID, evt.getGenerator().getPackOutput()));
    }
}
