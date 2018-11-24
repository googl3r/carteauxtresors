package mamadou.dia.carteauxtresors.entities;

public class MapSize {
    private int height;
    private int width;

    public MapSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
