package mamadou.dia.carteauxtresors.entities;

import java.util.List;

public class GameMap {
    private MapSize mapSize;
    private List<Box> boxes;

    public GameMap(MapSize mapSize, List<Box> boxes) {
        this.mapSize = mapSize;
        this.boxes = boxes;
    }

    public MapSize getMapSize() {
        return mapSize;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public void setMapSize(MapSize mapSize) {

        this.mapSize = mapSize;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }
}
