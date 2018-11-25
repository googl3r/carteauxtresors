package builders;

import mamadou.dia.carteauxtresors.entities.*;
import mamadou.dia.carteauxtresors.usecases.GameMapBuilder;

import java.util.HashSet;


public class GameMapBuilderStub extends GameMapBuilder {
    public GameMapBuilderStub aDefautGameMap() {
        mapSize = new MapSize(3, 4);
        boxes = new HashSet<>();
        boxes.add(new Box(new Position(0,1)));
        boxes.add(new Box(new Position(1,2)));
        boxes.add(new Box(new Position(2,3)));
        boxes.add(new Box(new Position(3,4)));
        adventurers = new HashSet<>();
        adventurers.add(new AdventurerBuilderStub().aDefaultAdventurer().build());
        return this;
    }
}
