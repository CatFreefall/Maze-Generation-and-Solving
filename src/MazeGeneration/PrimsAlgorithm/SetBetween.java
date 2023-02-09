package PrimsAlgorithm;

import Tile.Tile;

//This class is responsible for setting the tile between currentTile and prevCurrentTile to unmarked.
public class SetBetween {
    
    public SetBetween(Tile[][] tileMaze, Tile currentTile, Tile prevCurrentTile) {
        if (currentTile.getTileX() > prevCurrentTile.getTileX()) {
            tileMaze[currentTile.getTileY()][currentTile.getTileX() - 1].setUnmarked();
        }
        else if (currentTile.getTileX() < prevCurrentTile.getTileX()) {
            tileMaze[currentTile.getTileY()][currentTile.getTileX() + 1].setUnmarked();
        }
        else if (currentTile.getTileY() > prevCurrentTile.getTileY()) {
            tileMaze[currentTile.getTileY() - 1][currentTile.getTileX()].setUnmarked();
        }
        else if (currentTile.getTileY() < prevCurrentTile.getTileY()) {
            tileMaze[currentTile.getTileY() + 1][currentTile.getTileX()].setUnmarked();
        }
    }
}
