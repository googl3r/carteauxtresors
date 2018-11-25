import mamadou.dia.carteauxtresors.entities.*;
import mamadou.dia.carteauxtresors.gateways.MapLoader;
import mamadou.dia.carteauxtresors.usecases.LoadMapInteractor;
import mamadou.dia.carteauxtresors.usecases.LoadMapInteractorImpl;
import mamadou.dia.carteauxtresors.usecases.MapFileException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class LoadMapTest {

    private MapLoader mapLoader;
    private LoadMapInteractor loadMapInteractor;

    private Set<Box> boxes;
    private MapSize mapSize;

    @Before
    public void setup() {
        boxes = createBoxes();
        mapSize = new MapSize(3, 4);

    }
    @Test
    public void should_notify_when_map_can_not_be_loaded() throws MapFileException {
        mapLoader = new MapDoesntExitMapLoaderStub();
        loadMapInteractor = new LoadMapInteractorImpl(mapLoader);
        try {
        loadMapInteractor.loadMap();
        } catch (MapFileException e) {
            String exceptionMessage = "Map doesnt exist";
            Assert.assertEquals(exceptionMessage, e.getMessage());
        }

    }
    @Test
    public void load_treasure_hunt_game() throws MapFileException {
        mapLoader = new MapLoaderStub();
        loadMapInteractor = new LoadMapInteractorImpl(mapLoader);
        GameMap expectedGameMap =createGameMap();
        GameMap gameMap = loadMapInteractor.loadMap();
        verifyMapLoaded(expectedGameMap, gameMap);

    }

    private void verifyMapLoaded(GameMap expectedGameMap, GameMap gameMap) {
        verifyMapBoxLoaded(expectedGameMap, gameMap);
        verifyMapSize(expectedGameMap.getMapSize(), gameMap.getMapSize());
        Assert.assertEquals(expectedGameMap.getAdventurers(), gameMap.getAdventurers());
    }

    private void verifyMapBoxLoaded(GameMap expectedGameMap, GameMap gameMap) {
        Assert.assertEquals(gameMap.getBoxes().size(), expectedGameMap.getBoxes().size());
        Assert.assertTrue(gameMap.getBoxes().containsAll(expectedGameMap.getBoxes()));
    }
    private void verifyMapSize(MapSize result, MapSize expected) {
        Assert.assertEquals(result.getWidth(), expected.getWidth());
        Assert.assertEquals(result.getHeight(), expected.getHeight());
    }

    private Set<Box> createBoxes() {
        Set<Box> boxes = new HashSet<>();
        boxes.add(new Box(new Position(0, 1)));
        boxes.add(new Box(new Position(1, 2)));
        boxes.add(new Box(new Position(2, 3)));
        boxes.add(new Box(new Position(3, 4)));
        return boxes;
    }
    private GameMap createGameMap() {
        Set<Adventurer> adventurers = new HashSet<>();
        List<MOVEMENT> movements = new ArrayList<>();
        movements.add(MOVEMENT.LEFT);
        adventurers.add(new Adventurer("Mamadou", new Position(1,2), DIRECTION.EAST, movements));
        return new GameMap(mapSize, boxes, adventurers);
    }

}
