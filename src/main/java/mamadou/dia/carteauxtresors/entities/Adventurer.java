package mamadou.dia.carteauxtresors.entities;

import java.util.List;
import java.util.Objects;

public class Adventurer {
    private String name;
    private Position position;
    private DIRECTION direction;
    private List<MOVEMENT> movements;

    public Adventurer(String name, Position position, DIRECTION direction, List<MOVEMENT> movements) {
        this.name = name;
        this.position = position;
        this.direction = direction;
        this.movements = movements;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public List<MOVEMENT> getMovements() {
        return movements;
    }

    @Override
    public String toString() {
        return name+" in position "+position.getX()+" : "
                +position.getY()+" in direction "+direction.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        Adventurer adventurer = (Adventurer) obj;
        return adventurer.getName().equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
