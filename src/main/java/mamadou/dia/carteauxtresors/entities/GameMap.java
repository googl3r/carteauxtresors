package mamadou.dia.carteauxtresors.entities;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    private MapSize mapSize;
    private Map<Box, Position> boxes;

    public MapSize getMapSize() {
        return mapSize;
    }

    public Map<Box, Position> getBoxes() {
        return boxes;
    }

    public void setMapSize(MapSize mapSize) {

        this.mapSize = mapSize;
    }

    public void setBoxes(Map<Box, Position> boxes) {
        this.boxes = boxes;
    }
}
