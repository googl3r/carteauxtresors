package mamadou.dia.carteauxtresors.usecases;

import mamadou.dia.carteauxtresors.entities.GameMap;
import mamadou.dia.carteauxtresors.gateways.LoadMapGateway;

public class LoadMapInteractorImpl implements LoadMapInteractor {
    private LoadMapGateway loadMapGateway;
    public LoadMapInteractorImpl(LoadMapGateway loadMapGateway) {
        this.loadMapGateway = loadMapGateway;
    }

    @Override
    public GameMap loadMap(LoadMapRequest loadMapRequest) throws MapFileException {
        return loadMapGateway.loadMap(loadMapRequest.getMapPath());
    }
}
