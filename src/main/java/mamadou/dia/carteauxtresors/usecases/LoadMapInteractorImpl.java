package mamadou.dia.carteauxtresors.usecases;

import mamadou.dia.carteauxtresors.entities.GameMap;
import mamadou.dia.carteauxtresors.gateways.MapLoader;

public class LoadMapInteractorImpl implements LoadMapInteractor {
    private MapLoader mapLoader;
    public LoadMapInteractorImpl(MapLoader mapLoader) {
        this.mapLoader = mapLoader;
    }

    @Override
    public GameMap loadMap() throws MapFileException {
        return mapLoader.loadMap();
    }
}
