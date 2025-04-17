package fuzs.deleteworldstotrash.neoforge;

import fuzs.deleteworldstotrash.DeleteWorldsToTrash;
import fuzs.deleteworldstotrash.data.client.ModLanguageProvider;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(DeleteWorldsToTrash.MOD_ID)
public class DeleteWorldsToTrashNeoForge {

    public DeleteWorldsToTrashNeoForge(ModContainer modContainer) {
//        ModConstructor.construct(DeleteWorldsToTrash.MOD_ID, DeleteWorldsToTrash::new);
        modContainer.getEventBus().addListener((final GatherDataEvent.Client evt) -> {
            evt.getGenerator()
                    .addProvider(true,
                            new ModLanguageProvider(DeleteWorldsToTrash.MOD_ID, evt.getGenerator().getPackOutput()));
        });
    }
}
