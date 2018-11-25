package mamadou.dia.carteauxtresors.entities;

import java.util.Objects;

public class Box {
    private Position position;
    public Box(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Box:" +position.getX()+ " "+position.getY();
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object box) {
        if (box == null)
            return false;
        Box currentBox = (Box) box;
        return currentBox.getPosition().equals(this.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
