import mamadou.dia.carteauxtresors.entities.GameMap;
import mamadou.dia.carteauxtresors.gateways.LoadMapGateway;
import mamadou.dia.carteauxtresors.usecases.MapFileException;

import java.nio.file.Path;

public class FileDoesntExitLoadMapGatewayStub implements LoadMapGateway {
    private Path mapPath;
    public FileDoesntExitLoadMapGatewayStub(Path mapPath) {
        this.mapPath = mapPath;
    }

    @Override
    public GameMap loadMap(Path path) throws MapFileException {
        throw new MapFileException();
    }
}
