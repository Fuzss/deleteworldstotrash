package fuzs.deleteworldstotrash.data;

import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(GatherDataEvent evt, String modId) {
        super(evt.getGenerator().getPackOutput(), modId, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add("deleteworldstotrash.selectWorld.deleteWarning", "'%s' will be moved to the %s, so you can restore it later if necessary.");
        this.add("deleteworldstotrash.selectWorld.deleteFailure", "Failed to move to %s");
        this.add("deleteworldstotrash.selectWorld.recycleBin", "recycle bin");
        this.add("deleteworldstotrash.selectWorld.trash", "trash");
        this.add("deleteworldstotrash.selectWorld.deleteButton", "Move To %s");
        this.add("deleteworldstotrash.selectWorld.recycleBinButton", "Recycle Bin");
        this.add("deleteworldstotrash.selectWorld.trashButton", "Trash");
    }
}
