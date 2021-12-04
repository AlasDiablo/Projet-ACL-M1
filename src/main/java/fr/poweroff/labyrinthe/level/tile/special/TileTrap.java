package fr.poweroff.labyrinthe.level.tile.special;

import fr.poweroff.labyrinthe.level.Level;
import fr.poweroff.labyrinthe.level.tile.Tile;
import fr.poweroff.labyrinthe.utils.Coordinate;
import fr.poweroff.labyrinthe.utils.FilesUtils;

import java.awt.*;

/**
 * Bonus tile
 */
public class TileTrap extends Tile {

    /**
     * The current state of the tile
     * <ul>
     *     <li>BONUS when not visited</li>
     *     <li>GROUND when visited</li>
     * </ul>
     */

    private Type state;
    /**
     * The current sprite use by the tile
     * <ul>
     *     <li>0 when not visited</li>
     *     <li>1 when not visited</li>
     * </ul>
     */
    private int  image;

    /**
     * Constructor how take coordinate
     *
     * @param x X coordinate
     * @param y Y coordinate
     */
    public TileTrap(int x, int y) {
        super(x, y, FilesUtils.getImage("cases/piege.png"), FilesUtils.getImage("tile_ground.png"));
        state = Type.TRAP;
        image = 0;
    }

    /**
     * Constructor how take coordinate
     *
     * @param coordinate Coordinate object
     */
    public TileTrap(Coordinate coordinate) {
        super(coordinate, FilesUtils.getImage("cases/piege.png"), FilesUtils.getImage("tile_ground.png"));
        state = Type.TRAP;
    }

    /**
     * Function how draw the tile
     *
     * @param graphics2D drawing object
     */
    @Override
    public void draw(Graphics2D graphics2D) {
        int x = this.getCoordinate().getX();
        int y = this.getCoordinate().getY();
        graphics2D.drawImage(this.getSprites()[image], x, y, Level.TITLE_SIZE, Level.TITLE_SIZE, null);
    }

    /**
     * Function used to return the type of the tile
     *
     * @return Type on the tile
     */
    @Override
    public Type getType() {
        return state;
    }

    /**
     * Function used to change the current state of the tile, to GROUND from BONUS
     */
    public void changeType() {
        if (state == Type.TRAP) {
            state = Type.GROUND;
            image = 1;
        }
    }
}
