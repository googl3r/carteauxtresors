package mamadou.dia.carteauxtresors.usecases;

import mamadou.dia.carteauxtresors.entities.GameMap;

public interface LoadMapInteractor {
    GameMap loadMap() throws MapFileException;
}
