package pl.sda.marijuana.providers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import pl.sda.marijuana.PriceSnapshot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class FromJSONSnapshotProvider implements SnapshotsProvider {
    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final Path path;

    @Override
    public List<PriceSnapshot> getSnapshots() {
        try {
            String fileAsString = Files.readString(path);
            PriceSnapshot[] snapshotsArray = OBJECT_MAPPER.readValue(fileAsString, PriceSnapshot[].class);
            return Arrays.asList(snapshotsArray);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
