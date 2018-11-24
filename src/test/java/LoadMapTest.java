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
import java.util.Map;

public class LoadMapTest {

    private Path mapPath;
    private LoadMapGateway loadMapGateway;
    private LoadMapRequest loadMapRequest;
    private LoadMapInteractor loadMapInteractor;

    @Before
    public void setup() {
        loadMapRequest = new LoadMapRequest();
        mapPath = Paths.get("path_of_existing_file");
    }
    @Test(expected = MapFileException.class)
    public void shouldNotifyError_whenMapFileDoesntExist() throws MapFileException {
        loadMapGateway = new FileDoesntExitLoadMapGatewayStub(mapPath);
        loadMapInteractor = new LoadMapInteractorImpl(loadMapGateway);
        loadMapInteractor.loadMap(loadMapRequest);

    }
    @Test
    public void shouldLoadMapSize() throws MapFileException {
        loadMapGateway = new LoadMapGatewayStub(mapPath);
        loadMapInteractor = new LoadMapInteractorImpl(loadMapGateway);
        GameMap gameMap = loadMapInteractor.loadMap(loadMapRequest);
        MapSize expectedMapSize = loadMapGateway.loadMap(mapPath).getMapSize();
        verifyMapSize(gameMap.getMapSize(), expectedMapSize);
    }
    @Test
    public void shouldLoadMapWithPositionOfEachBox() throws MapFileException {
        loadMapGateway = new LoadMapGatewayStub(mapPath);
        loadMapInteractor = new LoadMapInteractorImpl(loadMapGateway);
        GameMap gameMap = loadMapInteractor.loadMap(loadMapRequest);
        Map<Box, Position> boxes = gameMap.getBoxes();
        Map<Box, Position> expectedBoxes = loadMapGateway.loadMap(mapPath).getBoxes();
        Assert.assertEquals(boxes.size(), expectedBoxes.size());

    }

    private void verifyMapSize(MapSize result, MapSize expected) {
        Assert.assertEquals(result.getWidth(), expected.getWidth());
        Assert.assertEquals(result.getHeight(), expected.getHeight());
    }
}
