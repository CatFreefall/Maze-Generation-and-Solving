package AStarAlgorithm;

import java.util.Comparator;

import Tile.Tile;

//This comparator class is responsible for sorting 2 tiles in order from lowest to highest FCost.
//It will later be used to maintain the lowest to highest FCost order in a priority queue.
public class FCostComparator implements Comparator<Tile> {

    @Override
    public int compare(Tile aTile, Tile bTile) {
        
        if (aTile.getFCost() > bTile.getFCost()) return 1;
        else return -1;
    }
}
