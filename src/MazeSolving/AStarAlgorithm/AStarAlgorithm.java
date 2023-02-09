package AStarAlgorithm;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import BuildingTheMaze.BuildMaze;
import Tile.Tile;
import Tile.TileCosts;

import java.lang.NullPointerException;
import java.util.NoSuchElementException;

public class AStarAlgorithm {
    private static final BuildMaze newMaze = new BuildMaze();

    //Variable that holds the update delay of the tiles.
    private static final int timeDelay = 50;
    
    public static void BeginASharpAlgorithm() throws InterruptedException {

        Tile currentTile;
        
        List<Tile> closedList = new LinkedList<Tile>();

        Tile tempNeighbor;
        Queue<Tile> tempNeighborQueue = new LinkedList<Tile>();

        //Creating a new priority queue with an overwritten compare method to sort by lowest tile FCost.
        Comparator<Tile> comparator = new FCostComparator();
        PriorityQueue<Tile> openQueue = new PriorityQueue<Tile>(10, comparator);

        //This list holds all the tiles from the start tile leading to the end tile inclusive.
        List<Tile> pathList = new LinkedList<Tile>();

        try {
            currentTile = newMaze.getStartTile();
            openQueue.add(currentTile);
            currentTile.setPassed();
        }
        catch (NullPointerException e) {
            System.out.println("\nError. Start tile does not exist on the tilemap.");
        }
        try {
            newMaze.getEndTile().getTileID();
        }
        catch (NullPointerException e) {
            System.out.println("\nError. End tile does not exist on the tilemap.");
        }

        while (true) {

            try {

                //Getting the lowest FCost tile in the priority queue.
                try {
                    currentTile = openQueue.remove();
                }
                catch (NoSuchElementException e) {
                    System.out.println("No path was found for this tilemap.");
                    break;
                }

                closedList.add(currentTile);
                updateDelay();
                currentTile.setPassed();

                if (currentTile == newMaze.getEndTile()) {
                    while (currentTile.getParentTile() != null) {
                        currentTile.setPath();
                        pathList.add(0, currentTile.getParentTile());
                        currentTile = currentTile.getParentTile();
                    }
                    pathList.add(0, currentTile);
                    break;
                }

                //Calculating tile costs using the method stored in currentNeighbors.
                //Then, setting tempNeighborQueue equal to all viable neighbors for the current tile.
                tempNeighborQueue = new TileCosts(newMaze, currentTile).getUnmarkedQueue();

                //Going through all nodes in tempNeighborQueue.
                //This while loop is responsible for putting all eligible nodes in the openqueue.
                while (tempNeighborQueue.size() != 0) {
                    tempNeighbor = tempNeighborQueue.remove();

                    if (openQueue.contains(tempNeighbor) || closedList.contains(tempNeighbor)) continue;
                    else {  
                        tempNeighbor.setMarked();
                        openQueue.add(tempNeighbor);
                    }
                }
            }
            
            catch (NoSuchElementException | NullPointerException e) {
                System.out.println("\nPath could not be found. This may be due to one the following reasons:\n1. Start and/or end tile does not exist.\n2. Start tile and/or end tile is blocked by walls.\n3. A combination of both of these issues.");
                break;
            }
        }
    }

    public static void updateDelay() throws InterruptedException {
        Thread.sleep(timeDelay);
    }
}
