import builders.GameMapBuilderStub;
import mamadou.dia.carteauxtresors.entities.*;
import mamadou.dia.carteauxtresors.gateways.MapLoader;



public class MapLoaderStub implements MapLoader{

    @Override
    public GameMap loadMap() {
        GameMap gameMap = new GameMapBuilderStub().aDefautGameMap().build();
        return gameMap;
    }
}
