import mamadou.dia.carteauxtresors.entities.GameMap;
import mamadou.dia.carteauxtresors.gateways.MapLoader;
import mamadou.dia.carteauxtresors.usecases.MapFileException;


public class MapDoesntExitMapLoaderStub implements MapLoader {

    @Override
    public GameMap loadMap() throws MapFileException {
        throw new MapFileException("Map doesnt exist");
    }
}
