package mamadou.dia.carteauxtresors.entities;

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
}
