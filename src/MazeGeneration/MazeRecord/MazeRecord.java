package MazeRecord;

import Tile.Tile;

import java.io.FileWriter;
import java.io.IOException;

//This class will record all generated mazes into the file variable "mazeGenFile" is assigned to
//Start and end tiles will not be generated. It is up to the user to place them on the tile map.
public class MazeRecord {
    private String mazeGenFile = "GeneratedMaze.txt";

    public MazeRecord(Tile[][] mazeArray) {
        try {
            FileWriter fileWriter = new FileWriter(mazeGenFile);
            for (int i = 0; i < mazeArray.length; i ++) {
                for (int j = 0; j < mazeArray[i].length; j ++) {
                    fileWriter.write(mazeArray[i][j].getTileColourNum() + " ");   
                }
                fileWriter.write("\n");
            }

            fileWriter.close();
        }
        catch (IOException e) {
            System.out.println("Error. Insufficient permissions to write in this file.");
            return;
        }
    }
}
