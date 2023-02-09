package Tile;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

//Stores all the properties of a tile like colour, isMarked, neighbors, coordinates, gCost, etc...
public class Tile extends JComponent {
    private boolean passed;
    private boolean blocked;
    private Color tileType;
    private String tileColourNum;
    private int tileID;

    //Responsible for storing their index locations relative to the mazeArray.
    private int tileX;
    private int tileY;

    //Responsible for storing their coordinates relative to JFrame.
    private int[] tileCoordLoc = new int[2];

    //Represents the size of each tile.
    public final int windowWidth = 10;
    public final int windowHeight = 10;

    //Stores the horizontal and vertical border for JPanel
    private final int borderX = 4;
    private final int borderY = 4;

    private int gCost;
    private int hCost;
    private int fCost;

    private Tile parent;

    public Tile() {
        passed = false;
        blocked = false;

        gCost = 0;
        hCost = 0;
        fCost = 0;
    }

    //Constructor that assigns tileType and more.
    public Tile(String type) {
        tileColourNum = type;
        blocked = false;

        if (type.equals("0")) {
            tileType = TileColours.WALL;
            blocked = true;
        }
        else if (type.equals("1")) {
            tileType = TileColours.BEGINNING;
        }
        else if (type.equals("2")) {
            tileType = TileColours.END;
        }
        else if (type.equals("3")) {
            tileType = TileColours.MARKED;
        }
        else if (type.equals("4")) {
            tileType = TileColours.PASSED;
        }
        else {
            tileType = TileColours.DEFAULT;
        }
    }

    public void setMarked() {
        if (!tileType.equals(TileColours.BEGINNING) && !tileType.equals(TileColours.END)) {
            tileColourNum = "3";
            tileType = TileColours.MARKED;
            repaint();
        }
    }

    public void setPassed() {
        if (!tileType.equals(TileColours.BEGINNING) && !tileType.equals(TileColours.END)) {
            passed = true;
            tileColourNum = "4";
            tileType = TileColours.PASSED;
            repaint();
        }
        else passed = true;
    }

    public void setUnmarked() {
        tileColourNum = "5";
        tileType = TileColours.DEFAULT;
        blocked = false;
        repaint();
    }

    public void setPath() {
        if (!tileType.equals(TileColours.BEGINNING) && !tileType.equals(TileColours.END)) {
            tileType = TileColours.PATH;
            repaint();
        }
    }

    public void setTileX(int xIndex) {
        tileX = xIndex;
    }

    public void setTileY(int yIndex) {
        tileY = yIndex;
    }

    public void setTileID(int tileID) {
        this.tileID = tileID;
    }

    public void setGCost(int gCost) {
        this.gCost = gCost;
    }

    public void setHCost(int hCost) {
        this.hCost = hCost;
    }

    public void setFCost(int fCost) {
        this.fCost = fCost;
    }

    public void setParent(Tile currentTile) {
        parent = currentTile;
    }

    public boolean isPassed() {
        return passed;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public String getTileColourNum() {
        return tileColourNum;
    }

    public int getTileID() {
        return tileID;
    }

    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public int[] getTileCoordLoc() {
        return tileCoordLoc;
    }

    public Tile getNeighbor(Tile[][] mazeArray, int index) {
        try {
            if (index == 0) return mazeArray[tileY - 1][tileX];
            else if (index == 1) return mazeArray[tileY - 1][tileX + 1];
            else if (index == 2) return mazeArray[tileY][tileX + 1];
            else if (index == 3) return mazeArray[tileY + 1][tileX + 1];
            else if (index == 4) return mazeArray[tileY + 1][tileX];
            else if (index == 5) return mazeArray[tileY + 1][tileX - 1];
            else if (index == 6) return mazeArray[tileY][tileX - 1];
            else return mazeArray[tileY - 1][tileX - 1];
        }

        catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public int getGCost() {
        return gCost;
    }

    public int getHCost() {
        return hCost;
    }

    public int getFCost() {
        return fCost;
    }

    public Tile getParentTile() {
        return parent;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        tileCoordLoc[0] = windowWidth * tileX + borderX;
        tileCoordLoc[1] = windowHeight * tileY + borderY;

        g.setColor(tileType);
        g.fillRect(tileCoordLoc[0], tileCoordLoc[1], windowWidth, windowHeight);
        g.setColor(new Color(110, 110, 110));
        g.drawRect(tileCoordLoc[0], tileCoordLoc[1], windowWidth, windowHeight);
    }
}
