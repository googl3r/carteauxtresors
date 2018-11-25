package mamadou.dia.carteauxtresors.gateways;

import mamadou.dia.carteauxtresors.entities.GameMap;
import mamadou.dia.carteauxtresors.usecases.MapFileException;


public interface MapLoader {
    GameMap loadMap() throws MapFileException;
}
