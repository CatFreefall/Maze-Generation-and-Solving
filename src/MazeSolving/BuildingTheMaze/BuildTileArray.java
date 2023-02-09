package BuildingTheMaze;

import java.io.File;
import java.util.Scanner;

import Tile.Tile;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class BuildTileArray {
    private int mazeXSize = 0;
    private int mazeYSize = 0;

    private Tile[][] mazeArray;

    //An array meant to hold the coordinates for the start and end tiles.
    private Tile startTile;
    private Tile endTile;
    
    public BuildTileArray() {
        int tileIDCount = 0;

        Scanner inputScan = new Scanner(System.in);
        System.out.println("Please enter the file name of the maze: ");
        String mazeFile = inputScan.next();
        inputScan.close();

        try {
            File myFile = new File(mazeFile);
            Scanner fileScanSize = new Scanner(myFile);

            //Finding the number of nodes on the x and y axis.
            String firstLine = fileScanSize.nextLine();
            mazeYSize ++;
            mazeXSize = firstLine.split(" ").length;
            while (fileScanSize.hasNextLine()) {
                fileScanSize.nextLine();
                mazeYSize ++;
            }
            fileScanSize.close();

            //Creating a new 2d array in the size as the rows and columns of the text file.
            mazeArray = new Tile[mazeYSize][mazeXSize];

            Scanner fileScan = new Scanner(myFile);

            /*
            * Putting all contents in the array. If a non-first row is inconsistent with the
            * number of contents of the other lines, the last content in the last line will
            * be excluded from the array
            */
            for (int i = 0; i < mazeYSize; i ++) {
                for (int j = 0; j < mazeXSize; j ++) {
                    mazeArray[i][j] = new Tile(fileScan.next().replace(",", ""));
                    
                    mazeArray[i][j].setTileY(i);
                    mazeArray[i][j].setTileX(j);
                    mazeArray[i][j].setTileID(tileIDCount ++);

                    //Obtaining the array that stores the x and y indices for the start and end tiles of the maze.
                    //If multiple start and end tiles exist, the ones with the highest index will be chosen.
                    if (mazeArray[i][j].getTileColourNum().equals("1")) {
                        startTile = mazeArray[i][j];
                    }
                    else if (mazeArray[i][j].getTileColourNum().equals("2")) {
                        endTile = mazeArray[i][j];
                    }
                }
            }
            fileScan.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error. File not found.");
            System.exit(0);
        }
        catch (NoSuchElementException e) {
            System.out.println("Error. Number of contents in first line of tile do not match number of contents in other lines.");
            System.exit(0);
        }
    }

    public int getMazeXSize() {
        return mazeXSize;
    }

    public int getMazeYSize() {
        return mazeYSize;
    }

    public Tile getStartTile() {
        return startTile;
    }

    public Tile getEndTile() {
        return endTile;
    }

    public Tile[][] getMazeArray() {
        return mazeArray;
    }
}
