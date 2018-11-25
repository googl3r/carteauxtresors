package mamadou.dia.carteauxtresors.usecases;

import mamadou.dia.carteauxtresors.entities.GameMap;
import mamadou.dia.carteauxtresors.gateways.LoadMapGateway;

public interface LoadMapInteractor {
    GameMap loadMap() throws MapFileException;
}
