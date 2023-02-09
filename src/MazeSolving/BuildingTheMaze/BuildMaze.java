package BuildingTheMaze;

import javax.swing.JFrame;

import Tile.Tile;

public class BuildMaze extends JFrame {
	private int mazeXSize = 0;
    private int mazeYSize = 0;
    private int windowWidth;
    private int windowHeight;
    private Tile[][] mazeArray;

    private Tile startTile;
    private Tile endTile;

    //This is just to make it so that JFrame doesn't overlap the tiles
    private int borderX = 11;
    private int borderY = 34;

    public BuildMaze() {
        BuildTileArray aMaze = new BuildTileArray();
        mazeXSize = aMaze.getMazeXSize();
        mazeYSize = aMaze.getMazeYSize();
        mazeArray = aMaze.getMazeArray();

        startTile = aMaze.getStartTile();
        endTile = aMaze.getEndTile();

        //The length and height is needed to set the JFrame window size correctly.
        windowWidth = new Tile().windowWidth;
        windowHeight = new Tile().windowHeight;

        setTitle("A* Algorithm");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(mazeXSize * windowWidth + borderX * 2, mazeYSize * windowHeight + borderY + borderX);
        setVisible(true);
        setAlwaysOnTop(true);
        setResizable(false);

        //Rendering all tiles onto the screen
        for (int i = 0; i < mazeArray.length; i ++) { //Y axis length
            for (int j = 0; j < mazeArray[0].length; j ++) { //X axis length
                add(mazeArray[i][j]);
                revalidate();
                repaint();
            }
        }
    }

    //Outputs the maze as it is like in the text file line by line into the terminal.
    @Override
    public String toString() {
        String mazeString = "";
        for (int i = 0; i < mazeYSize; i ++) {
            for (int j = 0; j < mazeXSize; j ++) {
                mazeString = mazeString + mazeArray[i][j].getTileColourNum() + " ";
            }
            mazeString = mazeString + "\n";
        }
        return mazeString;
    }

    public Tile[][] getMazeArray() {
        return mazeArray;
    }

    public Tile getStartTile() {
        return startTile;
    }

    public Tile getEndTile() {
        return endTile;
    }
}