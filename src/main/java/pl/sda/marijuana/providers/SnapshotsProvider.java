package pl.sda.marijuana.providers;

import pl.sda.marijuana.PriceSnapshot;

import java.util.List;

public interface SnapshotsProvider {
    List<PriceSnapshot> getSnapshots();
}
