package mamadou.dia.carteauxtresors.usecases;

import mamadou.dia.carteauxtresors.entities.Adventurer;
import mamadou.dia.carteauxtresors.entities.Box;
import mamadou.dia.carteauxtresors.entities.GameMap;
import mamadou.dia.carteauxtresors.entities.MapSize;

import java.util.Set;

public class GameMapBuilder {
    protected MapSize mapSize;
    protected Set<Box> boxes;
    protected Set<Adventurer> adventurers;

    public  GameMapBuilder withMapSize(MapSize mapSize) {
        this.mapSize = mapSize;
        return this;
    }
    public GameMapBuilder withBoxes(Set<Box> boxes) {
        this.boxes = boxes;
        return this;
    }
    public GameMapBuilder withAdventurers(Set<Adventurer> adventurers) {
        this.adventurers = adventurers;
        return this;
    }
    public GameMap build() {
        return new GameMap(this.mapSize, this.boxes, this.adventurers);
    }
}
