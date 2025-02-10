package fuzs.deleteworldstotrash.data.client;

import fuzs.deleteworldstotrash.client.handler.TrashScreenHandler;
import net.minecraft.data.PackOutput;

public class ModLanguageProvider extends AbstractLanguageProvider {

    public ModLanguageProvider(String modId, PackOutput packOutput) {
        super(modId, packOutput);
    }

    @Override
    public void addTranslations(TranslationBuilder builder) {
        builder.add(TrashScreenHandler.KEY_DELETE_WARNING_TRASH, "'%s' will be moved to the trash, so you can restore it later if necessary.");
        builder.add(TrashScreenHandler.KEY_DELETE_WARNING_RECYCLE_BIN, "'%s' will be moved to the recycle bin, so you can restore it later if necessary.");
    }
}
