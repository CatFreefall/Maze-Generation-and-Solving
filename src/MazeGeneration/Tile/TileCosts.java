package Tile;

import java.util.LinkedList;
import java.util.Queue;

import BuildingTheMaze.BuildMaze;

//This class is responsible for calculating the G, H, and F costs of each node.
//It is also responsible for setting the neighbors of each node.
//BuildTileArray() needs to be called before this as the class finds the start and end node.
public class TileCosts {
    private Queue<Tile> unmarkedQueue = new LinkedList<Tile>();

    public TileCosts(BuildMaze newMaze, Tile currentTile) {

        unmarkedQueue.clear();

        //i < 8 because each node has 8 possible neighbor indices.
        for (int i = 0; i < 8; i ++) {
            Tile currNeighborTile = currentTile.getNeighbor(newMaze.getMazeArray(), i);

            //Null meaning an invalid 2d array index ([-1][0]) and blocked meaning a wall.
            if (currNeighborTile == null || currNeighborTile.isBlocked()) continue;

            /*Both passed and fCost != 0 mean that the Tile was previously visited.
            * This else if block is responsible for updating a neighbor tile's G and F costs and
            * parent tile, but only if the fCost of the current tile is less than or equal to 
            * the fCost of the neighbor's parent fCost. If this is true, the neighbor tile is
            * also added into the unmarked queue (Responsible for holding all nodes that are viable
            * paths for a current tile).
            */
            else if (currNeighborTile.isPassed() || currNeighborTile.getFCost() != 0) {

                int potentialGCost = (int) (Math.sqrt(Math.pow(currNeighborTile.getTileCoordLoc()[0] - currentTile.getTileCoordLoc()[0], 2) + Math.pow(currNeighborTile.getTileCoordLoc()[1] - currentTile.getTileCoordLoc()[1], 2))) + currentTile.getGCost();

                //Using diagonal distance as the heuristic for the algorithm.
                int neighborToEndX = Math.abs(currNeighborTile.getTileCoordLoc()[0] - newMaze.getEndTile().getTileCoordLoc()[0]) / newMaze.getEndTile().windowWidth;
                int neighborToEndY = Math.abs(currNeighborTile.getTileCoordLoc()[1] - newMaze.getEndTile().getTileCoordLoc()[1]) / newMaze.getEndTile().windowHeight;
                int potentialHCost;
                if (neighborToEndX > neighborToEndY) potentialHCost = (currNeighborTile.windowWidth * 2 * neighborToEndY) + (currNeighborTile.windowHeight * (neighborToEndX - neighborToEndY));
                else potentialHCost = (currNeighborTile.windowHeight * (neighborToEndY - neighborToEndX)) + (currNeighborTile.windowWidth * 2 * neighborToEndX);

                int potentialFCost = potentialGCost + potentialHCost;

                if (currNeighborTile.getFCost() < potentialFCost) continue;

                else {currNeighborTile.setGCost(potentialGCost);
                    currNeighborTile.setFCost(potentialFCost);
                    currNeighborTile.setParent(currentTile);
                    unmarkedQueue.add(currNeighborTile);
                }
            }
            
            //This is for all nodes that are unmarked and nothing more.
            else {
                currNeighborTile.setGCost((int) (Math.sqrt(Math.pow(currNeighborTile.getTileCoordLoc()[0] - currentTile.getTileCoordLoc()[0], 2) + Math.pow(currNeighborTile.getTileCoordLoc()[1] - currentTile.getTileCoordLoc()[1], 2))) + currentTile.getGCost());
                
                //Diagonal distance heuristic.
                int neighborToEndX = Math.abs(currNeighborTile.getTileCoordLoc()[0] - newMaze.getEndTile().getTileCoordLoc()[0]) / newMaze.getEndTile().windowWidth;
                int neighborToEndY = Math.abs(currNeighborTile.getTileCoordLoc()[1] - newMaze.getEndTile().getTileCoordLoc()[1]) / newMaze.getEndTile().windowHeight;
                if (neighborToEndX > neighborToEndY) currNeighborTile.setHCost((currNeighborTile.windowWidth * 2 * neighborToEndY) + (currNeighborTile.windowHeight * (neighborToEndX - neighborToEndY)));
                else currNeighborTile.setHCost((currNeighborTile.windowHeight * (neighborToEndY - neighborToEndX)) + (currNeighborTile.windowWidth * 2 * neighborToEndX));
                
                currNeighborTile.setFCost(currNeighborTile.getGCost() + currNeighborTile.getHCost());
                currNeighborTile.setParent(currentTile);

                unmarkedQueue.add(currentTile.getNeighbor(newMaze.getMazeArray(), i));
            }
        }
    }

    public Queue<Tile> getUnmarkedQueue() {
        return unmarkedQueue;
    }
}
