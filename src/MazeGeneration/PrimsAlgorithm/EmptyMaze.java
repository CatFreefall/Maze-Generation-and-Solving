package PrimsAlgorithm;

import javax.swing.JFrame;

import Tile.Tile;

//This class is responsible for generating and outputting an array of walls onto JFrame
public class EmptyMaze extends JFrame {

    //The 2d array to store all tile objects.
    public Tile[][] emptyMaze;

    public EmptyMaze(int mazeXSize, int mazeYSize) {
        emptyMaze = new Tile[mazeYSize][mazeXSize];
        int tileIDCount = 0;

        setTitle("Prims Algorithm");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(mazeXSize * new Tile().windowWidth + 22, mazeYSize * new Tile().windowHeight + 45);
        setVisible(true);
        setAlwaysOnTop(true);
        setResizable(true);

        for (int i = 0; i < mazeYSize; i++) {
            for (int j = 0; j < mazeXSize; j ++) {

                emptyMaze[i][j] = new Tile("0");
                emptyMaze[i][j].setTileID(tileIDCount ++);
                emptyMaze[i][j].setTileY(i);
                emptyMaze[i][j].setTileX(j);

                //Adding tiles to JFrame.
                add(emptyMaze[i][j]);
                revalidate();
                repaint();
            }
        }
    }

    public Tile[][] getEmptyMaze() {
        return emptyMaze;
    }
}
