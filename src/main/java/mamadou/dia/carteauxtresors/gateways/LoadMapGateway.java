package mamadou.dia.carteauxtresors.gateways;

import mamadou.dia.carteauxtresors.entities.GameMap;
import mamadou.dia.carteauxtresors.usecases.MapFileException;

import java.nio.file.Path;

public interface LoadMapGateway {
    public GameMap loadMap(Path path) throws MapFileException;
}
