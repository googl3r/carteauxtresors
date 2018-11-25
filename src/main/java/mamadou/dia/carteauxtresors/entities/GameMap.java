package mamadou.dia.carteauxtresors.entities;

import java.util.List;
import java.util.Set;

public class GameMap {
    private MapSize mapSize;
    private Set<Box> boxes;
    private Set<Adventurer> adventurers;


    public GameMap(MapSize mapSize, Set<Box> boxes, Set<Adventurer> adventurers) {
        this.mapSize = mapSize;
        this.boxes = boxes;
        this.adventurers = adventurers;

    }

    public Set<Adventurer> getAdventurers() {
        return adventurers;
    }
    public MapSize getMapSize() {
        return mapSize;
    }

    public Set<Box> getBoxes() {
        return boxes;
    }
}
