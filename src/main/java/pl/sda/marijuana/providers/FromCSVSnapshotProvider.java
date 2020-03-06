package pl.sda.marijuana.providers;

import lombok.RequiredArgsConstructor;
import pl.sda.marijuana.PriceSnapshot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FromCSVSnapshotProvider implements SnapshotsProvider {
    private final Path path;

    @Override
    public List<PriceSnapshot> getSnapshots() {
        try {
            return Files.lines(path)
                    .map(line -> line.split(","))
                    .map(FromCSVLineMapper::new)
                    .map(FromCSVLineMapper::toSnapshot)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
