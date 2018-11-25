import mamadou.dia.carteauxtresors.entities.Box;
import mamadou.dia.carteauxtresors.entities.GameMap;
import mamadou.dia.carteauxtresors.entities.MapSize;
import mamadou.dia.carteauxtresors.entities.Position;
import mamadou.dia.carteauxtresors.gateways.LoadMapGateway;
import mamadou.dia.carteauxtresors.usecases.LoadMapInteractor;
import mamadou.dia.carteauxtresors.usecases.LoadMapInteractorImpl;
import mamadou.dia.carteauxtresors.usecases.LoadMapRequest;
import mamadou.dia.carteauxtresors.usecases.MapFileException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadMapTest {

    private Path mapPath;
    private LoadMapGateway loadMapGateway;
    private LoadMapRequest loadMapRequest;
    private LoadMapInteractor loadMapInteractor;

    private List<Box> boxes;
    private GameMap expectedGameMap;
    private MapSize mapSize;

    @Before
    public void setup() {
        mapPath = Paths.get("path_of_existing_file");
        loadMapRequest = new LoadMapRequest(mapPath);
        boxes = new ArrayList<>();
        mapSize = new MapSize(3, 4);

    }
    @Test(expected = MapFileException.class)
    public void shouldNotifyError_whenMapFileDoesntExist() throws MapFileException {
        loadMapGateway = new FileDoesntExitLoadMapGatewayStub(mapPath);
        loadMapInteractor = new LoadMapInteractorImpl(loadMapGateway);
        loadMapInteractor.loadMap(loadMapRequest);

    }
    @Test
    public void shouldLoadMapSize() throws MapFileException {
        loadMapGateway = new LoadMapGatewayStub();
        loadMapInteractor = new LoadMapInteractorImpl(loadMapGateway);
        expectedGameMap = new GameMap(mapSize, boxes);
        GameMap gameMap = loadMapInteractor.loadMap(loadMapRequest);
        verifyMapSize(gameMap.getMapSize(), expectedGameMap.getMapSize());
    }
    @Test
    public void shouldLoadMapWithPositionOfEachBox() throws MapFileException {
        loadMapGateway = new LoadMapGatewayStub();
        loadMapInteractor = new LoadMapInteractorImpl(loadMapGateway);
        boxes = createBoxes();
        expectedGameMap = new GameMap(mapSize, boxes);
        GameMap gameMap = loadMapInteractor.loadMap(loadMapRequest);
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
