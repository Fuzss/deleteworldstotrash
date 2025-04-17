package fuzs.deleteworldstotrash.neoforge.data.client;

import fuzs.deleteworldstotrash.client.handler.TrashScreenHandler;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(String modId, PackOutput packOutput) {
        super(packOutput, modId, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add(TrashScreenHandler.KEY_DELETE_WARNING_TRASH,
                "'%s' will be moved to the trash, so you can restore it later if necessary.");
        this.add(TrashScreenHandler.KEY_DELETE_WARNING_RECYCLE_BIN,
                "'%s' will be moved to the recycle bin, so you can restore it later if necessary.");
    }
}
