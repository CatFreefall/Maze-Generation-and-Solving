package PrimsAlgorithm;

import java.util.Stack;

import Tile.Tile;

//This is different from the GetNeighbors class used in the AStarAlgorithm.
//The class takes the top, bottom, left, and right neighbors of a tile.
public class Neighbors {

    private Stack<Tile> returnStack = new Stack<Tile>();

    public void getNeighbors(Tile[][] tileMaze, Tile currentTile) {
        if (currentTile.getTileY() - 2 > 0) {
            Tile topTile = tileMaze[currentTile.getTileY() - 2][currentTile.getTileX()];
            if (topTile.getTileColourNum() == "0") {
                //System.out.println(topTile.getTileID() + " " + currentTile.getTileID());
                topTile.setParent(currentTile);
                returnStack.add(topTile);
            }
        }
        if (currentTile.getTileX() + 2 < tileMaze[0].length - 1) {
            Tile rightTile = tileMaze[currentTile.getTileY()][currentTile.getTileX() + 2];
            if (rightTile.getTileColourNum() == "0") {
                //System.out.println(rightTile.getTileID() + " " + currentTile.getTileID());
                rightTile.setParent(currentTile);
                returnStack.add(rightTile);
            }
        }
        if (currentTile.getTileY() + 2 < tileMaze.length - 1) {
            Tile bottomTile = tileMaze[currentTile.getTileY() + 2][currentTile.getTileX()];
            if (bottomTile.getTileColourNum() == "0") {
                //System.out.println(bottomTile.getTileID() + " " + currentTile.getTileID());
                bottomTile.setParent(currentTile);
                returnStack.add(bottomTile);
            }
        }
        if (currentTile.getTileX() - 2 > 0) {
            Tile leftTile = tileMaze[currentTile.getTileY()][currentTile.getTileX() - 2];
            if (leftTile.getTileColourNum() == "0") {
                //System.out.println(leftTile.getTileID() + " " + currentTile.getTileID());
                leftTile.setParent(currentTile);
                returnStack.add(leftTile);
            }
        }
    }

    public Stack<Tile> getReturnStack() {
        return returnStack;
    }
}
