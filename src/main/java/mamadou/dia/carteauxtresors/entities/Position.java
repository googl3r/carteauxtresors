package mamadou.dia.carteauxtresors.entities;

import java.util.Objects;

public class Position {
    private int x;
    private int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        Position position = (Position) obj;
        return ((position.getX() == this.x) && (position.getY() == this.y));
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
