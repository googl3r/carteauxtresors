import mamadou.dia.carteauxtresors.entities.Box;
import mamadou.dia.carteauxtresors.entities.GameMap;
import mamadou.dia.carteauxtresors.entities.MapSize;
import mamadou.dia.carteauxtresors.entities.Position;
import mamadou.dia.carteauxtresors.gateways.MapLoader;
import mamadou.dia.carteauxtresors.usecases.MapFileException;

import java.nio.file.Path;
import java.util.ArrayList;

import java.util.List;


public class MapLoaderStub implements MapLoader{

    @Override
    public GameMap loadMap() throws MapFileException {
        MapSize mapSize = new MapSize(3, 4);
        List<Box> boxes = createBoxesWithTheirPositions();
        GameMap gameMap = new GameMap(mapSize, boxes);
        gameMap.setBoxes(boxes);
        gameMap.setMapSize(mapSize);
        return gameMap;
    }

    private List<Box> createBoxesWithTheirPositions() {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(new Position(0,1)));
        boxes.add(new Box(new Position(1,2)));
        boxes.add(new Box(new Position(2,3)));
        boxes.add(new Box(new Position(3,4)));
        return boxes;
    }
}
