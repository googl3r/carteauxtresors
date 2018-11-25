package builders;

import mamadou.dia.carteauxtresors.entities.DIRECTION;
import mamadou.dia.carteauxtresors.entities.MOVEMENT;
import mamadou.dia.carteauxtresors.entities.Position;
import mamadou.dia.carteauxtresors.usecases.AdventurerBuilder;

import java.util.ArrayList;

public class AdventurerBuilderStub extends AdventurerBuilder {
    public AdventurerBuilderStub aDefaultAdventurer() {
        name = "Mamadou";
        position = new Position(1, 2);
        direction = DIRECTION.EAST;
        movements = new ArrayList<>();
        movements.add(MOVEMENT.LEFT);

        return this;
    }
}
