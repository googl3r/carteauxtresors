package mamadou.dia.carteauxtresors.usecases;

import mamadou.dia.carteauxtresors.entities.Adventurer;
import mamadou.dia.carteauxtresors.entities.DIRECTION;
import mamadou.dia.carteauxtresors.entities.MOVEMENT;
import mamadou.dia.carteauxtresors.entities.Position;

import java.util.List;

public class AdventurerBuilder {
    protected String name;
    protected Position position;
    protected DIRECTION direction;
    protected List<MOVEMENT> movements;

    public AdventurerBuilder withName(String name) {
        this.name = name;
        return this;
    }
    public AdventurerBuilder withPosition(Position position) {
        this.position = position;
        return this;
    }
    public AdventurerBuilder withDirection(DIRECTION direction) {
        this.direction = direction;
        return this;
    }
    public AdventurerBuilder withMovements(List<MOVEMENT> movements) {
        this.movements = movements;
        return this;
    }
    public Adventurer build() {
        return new Adventurer(name, position, direction, movements);
    }
}
