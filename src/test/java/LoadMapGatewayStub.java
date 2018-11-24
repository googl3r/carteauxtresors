import mamadou.dia.carteauxtresors.entities.Box;
import mamadou.dia.carteauxtresors.entities.GameMap;
import mamadou.dia.carteauxtresors.entities.MapSize;
import mamadou.dia.carteauxtresors.entities.Position;
import mamadou.dia.carteauxtresors.gateways.LoadMapGateway;
import mamadou.dia.carteauxtresors.usecases.MapFileException;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class LoadMapGatewayStub implements LoadMapGateway{
    public LoadMapGatewayStub(Path mapPath) {

    }

    @Override
    public GameMap loadMap(Path path) throws MapFileException {
        GameMap gameMap = new GameMap();
        MapSize mapSize = new MapSize(3, 4);
        Map<Box, Position> boxes = createBoxesWithTheirPositions();
        gameMap.setBoxes(boxes);
        gameMap.setMapSize(mapSize);
        return gameMap;
    }

    private Map<Box, Position> createBoxesWithTheirPositions() {
        Map<Box, Position> boxes = new HashMap<>();
        boxes.put(new Box(), new Position());
        boxes.put(new Box(), new Position());
        boxes.put(new Box(), new Position());
        boxes.put(new Box(), new Position());
        return boxes;
    }
}
