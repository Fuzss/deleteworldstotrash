package fuzs.deleteworldstotrash.client.recycler;

import java.awt.*;
import java.io.File;

/**
 * Support for trashing files was added to desktop class in Java 9. Desktop API was developed to support Windows and
 * Gnome only.
 * <p>
 * To make this work on ubuntu {@code apt-get install libgnome2-0} needs to be run. Seems to work occasionally on Mac as
 * well.
 *
 * @see <a
 *         href="https://stackoverflow.com/questions/222463/is-it-possible-with-java-to-delete-to-the-recycle-bin">Is
 *         it possible with Java to delete to the Recycle Bin?</a>
 * @see <a
 *         href="https://stackoverflow.com/questions/102325/not-supported-platforms-for-java-awt-desktop-getdesktop">Not
 *         supported platforms for java.awt.Desktop.getDesktop()</a>
 */
public final class DesktopRecycler implements WorldRecycler {
    public static final WorldRecycler INSTANCE = new DesktopRecycler();

    private DesktopRecycler() {
        // NO-OP
    }

    @Override
    public String getName() {
        return "Desktop";
    }

    @Override
    public boolean isSupported() {
        return Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.MOVE_TO_TRASH);
    }

    @Override
    public boolean moveToTrash(File file) {
        return Desktop.getDesktop().moveToTrash(file);
    }
}
