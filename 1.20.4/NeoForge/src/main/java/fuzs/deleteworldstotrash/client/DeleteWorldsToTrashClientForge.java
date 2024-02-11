package fuzs.deleteworldstotrash.client;

import fuzs.deleteworldstotrash.DeleteWorldsToTrash;
import fuzs.deleteworldstotrash.client.handler.TrashScreenHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

@Mod.EventBusSubscriber(modid = DeleteWorldsToTrash.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DeleteWorldsToTrashClientForge {

    @SubscribeEvent
    public static void onConstructMod(final FMLConstructModEvent evt) {
        registerHandlers();
    }

    private static void registerHandlers() {
        MinecraftForge.EVENT_BUS.addListener((final ScreenEvent.Opening evt) -> {
            TrashScreenHandler.onScreenOpen(evt.getNewScreen()).ifPresent(evt::setNewScreen);
        });
    }
}
