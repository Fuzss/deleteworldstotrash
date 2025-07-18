package fuzs.deleteworldstotrash.neoforge.client;

import fuzs.deleteworldstotrash.DeleteWorldsToTrash;
import fuzs.deleteworldstotrash.neoforge.data.client.ModLanguageProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(value = DeleteWorldsToTrash.MOD_ID, dist = Dist.CLIENT)
public class DeleteWorldsToTrashClientNeoForge {

    public DeleteWorldsToTrashClientNeoForge(ModContainer modContainer) {
//        ClientModConstructor.construct(DeleteWorldsToTrash.MOD_ID, DeleteWorldsToTrashClient::new);
        registerLoadingHandlers(modContainer.getEventBus());
    }

    private static void registerLoadingHandlers(IEventBus eventBus) {
        eventBus.addListener((final GatherDataEvent.Client evt) -> {
            evt.getGenerator()
                    .addProvider(true,
                            new ModLanguageProvider(DeleteWorldsToTrash.MOD_ID, evt.getGenerator().getPackOutput()));
        });
    }
}
