package mamadou.dia.carteauxtresors.usecases;

import java.nio.file.Path;

public class LoadMapRequest {
    private Path mapPath;
    public LoadMapRequest(Path mapPath) {
        this.mapPath = mapPath;
    }

    public Path getMapPath() {
        return mapPath;
    }
}
