package PrimsAlgorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import MazeRecord.MazeRecord;
import Tile.Tile;

public class PrimsAlgorithm {
    private List<Tile> openList = new LinkedList<Tile>();

    private Tile[][] tileMaze;

    private static final int timeDelay = 2;

    public PrimsAlgorithm(int mazeXSize, int mazeYSize) throws InterruptedException {
        Random random = new Random();
        int randInt;

        //Generates an empty maze of (x, y) size
        tileMaze = new EmptyMaze(mazeXSize, mazeYSize).getEmptyMaze();

        //Determining a completely random tile on the tile map and assigning it to currentTile.
        Tile currentTile = tileMaze[random.nextInt(tileMaze.length - 2) + 1][random.nextInt(tileMaze[0].length - 2) + 1];

        Neighbors neighbors = new Neighbors();

        //Marking first tile
        currentTile.setMarked();
        currentTile.setParent(currentTile);

        while (true) {
            neighbors.getNeighbors(tileMaze, currentTile);

            currentTile.setUnmarked();
            new SetBetween(tileMaze, currentTile, currentTile.getParentTile());

            while (neighbors.getReturnStack().size() != 0) {
                if (!openList.contains(neighbors.getReturnStack().get(0))) {
                    neighbors.getReturnStack().get(0).setMarked();
                    openList.add(neighbors.getReturnStack().remove(0));
                }
                else neighbors.getReturnStack().remove(0);
            }

            if (openList.size() == 0) {
                System.out.println("MAZE GENERATION COMPLETED.");
                break;
            }
            else if (openList.size() == 1) {
                currentTile = openList.remove(0);
            }
            else {
                randInt = random.nextInt(openList.size() - 1);
                currentTile = openList.remove(randInt);
            }
            updateDelay();
        }
        new MazeRecord(tileMaze);
    }

    public static void updateDelay() throws InterruptedException {
        Thread.sleep(timeDelay);
    }

}
