package fuzs.deleteworldstotrash.client.recycler;

import java.io.File;
import java.io.IOException;

public interface WorldRecycler {

    boolean isSupported();

    boolean moveToTrash(File file) throws IOException;
}
