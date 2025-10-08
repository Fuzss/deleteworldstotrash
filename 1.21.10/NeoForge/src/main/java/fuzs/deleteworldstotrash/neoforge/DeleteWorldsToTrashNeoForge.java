package fuzs.deleteworldstotrash.neoforge;

import fuzs.deleteworldstotrash.DeleteWorldsToTrash;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(DeleteWorldsToTrash.MOD_ID)
public class DeleteWorldsToTrashNeoForge {

    public DeleteWorldsToTrashNeoForge(ModContainer modContainer) {
        registerLoadingHandlers(modContainer.getEventBus());
    }

    private static void registerLoadingHandlers(IEventBus eventBus) {
        eventBus.addListener((final GatherDataEvent.Client event) -> {
            event.getGenerator()
                    .addProvider(true,
                            PackMetadataGenerator.forFeaturePack(event.getGenerator().getPackOutput(),
                                    Component.literal(event.getModContainer().getModInfo().getDescription())));
        });
    }
}
