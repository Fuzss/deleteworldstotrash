package fuzs.deleteworldstotrash.client.recycler;

import com.sun.jna.platform.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Designed to work on Windows and Mac.
 *
 * @see <a href="https://www.rgagnon.com/javadetails/java-move-files-to-windows-trash-jna.html">Move files to Windows
 *         Trash (JNA)</a>
 */
public class FileUtilsRecycler implements WorldRecycler {

    @Override
    public boolean isSupported() {
        return FileUtils.getInstance().hasTrash();
    }

    @Override
    public boolean moveToTrash(File file) throws IOException {
        FileUtils.getInstance().moveToTrash(file);
        return true;
    }
}
