package fuzs.deleteworldstotrash.world.level.storage.recycler;

import java.awt.*;
import java.io.File;

/**
 * Support for trashing files was added to desktop class in Java 9.
 * Desktop API was developed to support Windows and Gnome only.
 * <p>To make this work on ubuntu <code>apt-get install libgnome2-0</code> needs to be run.
 * Seems to work occasionally on Mac as well.
 *
 * @see <a href="https://stackoverflow.com/questions/222463/is-it-possible-with-java-to-delete-to-the-recycle-bin">Is it possible with Java to delete to the Recycle Bin?</a>
 * @see <a href="https://stackoverflow.com/questions/102325/not-supported-platforms-for-java-awt-desktop-getdesktop">Not supported platforms for java.awt.Desktop.getDesktop()</a>
 */
public class DesktopRecycler implements WorldRecycler {

    @Override
    public boolean isSupported() {
        return Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.MOVE_TO_TRASH);
    }

    @Override
    public boolean moveToTrash(File file) {
        return Desktop.getDesktop().moveToTrash(file);
    }
}
