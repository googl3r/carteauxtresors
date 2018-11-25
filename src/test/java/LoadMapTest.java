import mamadou.dia.carteauxtresors.entities.Box;
import mamadou.dia.carteauxtresors.entities.GameMap;
import mamadou.dia.carteauxtresors.entities.MapSize;
import mamadou.dia.carteauxtresors.entities.Position;
import mamadou.dia.carteauxtresors.gateways.MapLoader;
import mamadou.dia.carteauxtresors.usecases.LoadMapInteractor;
import mamadou.dia.carteauxtresors.usecases.LoadMapInteractorImpl;
import mamadou.dia.carteauxtresors.usecases.MapFileException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class LoadMapTest {

    private MapLoader mapLoader;
    private LoadMapInteractor loadMapInteractor;

    private List<Box> boxes;
    private GameMap expectedGameMap;
    private MapSize mapSize;

    @Before
    public void setup() {
        boxes = new ArrayList<>();
        mapSize = new MapSize(3, 4);

    }
    @Test(expected = MapFileException.class)
    public void shouldNotifyError_whenMapFileDoesntExist() throws MapFileException {
        mapLoader = new MapDoesntExitMapLoaderStub();
        loadMapInteractor = new LoadMapInteractorImpl(mapLoader);
        loadMapInteractor.loadMap();

    }
    @Test
    public void shouldLoadMapSize() throws MapFileException {
        mapLoader = new MapLoaderStub();
        loadMapInteractor = new LoadMapInteractorImpl(mapLoader);
        expectedGameMap = new GameMap(mapSize, boxes);
        GameMap gameMap = loadMapInteractor.loadMap();
        verifyMapSize(gameMap.getMapSize(), expectedGameMap.getMapSize());
    }
    @Test
    public void shouldLoadMapWithPositionOfEachBox() throws MapFileException {
        mapLoader = new MapLoaderStub();
        loadMapInteractor = new LoadMapInteractorImpl(mapLoader);
        boxes = createBoxes();
        expectedGameMap = new GameMap(mapSize, boxes);
        GameMap gameMap = loadMapInteractor.loadMap();
        verifyMapBoxLoadedWithTheirPositions(expectedGameMap, gameMap);

    }

    private void verifyMapBoxLoadedWithTheirPositions(GameMap expectedGameMap, GameMap gameMap) {
        Assert.assertEquals(gameMap.getBoxes().size(), expectedGameMap.getBoxes().size());
        Assert.assertEquals(gameMap.getBoxes(), expectedGameMap.getBoxes());
    }

    private List<Box> createBoxes() {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(new Position(0, 1)));
        boxes.add(new Box(new Position(1, 2)));
        boxes.add(new Box(new Position(2, 3)));
        boxes.add(new Box(new Position(3, 4)));
        return boxes;
    }

    private void verifyMapSize(MapSize result, MapSize expected) {
        Assert.assertEquals(result.getWidth(), expected.getWidth());
        Assert.assertEquals(result.getHeight(), expected.getHeight());
    }
}
