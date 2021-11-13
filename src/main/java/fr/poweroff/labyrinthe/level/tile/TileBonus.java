package fr.poweroff.labyrinthe.level.tile;

import fr.poweroff.labyrinthe.level.Level;
import fr.poweroff.labyrinthe.utils.Coordinate;
import fr.poweroff.labyrinthe.utils.FilesUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TileBonus extends Tile {

    private Type state;
    private int image;

    public TileBonus(int x, int y) {
        super(x, y, FilesUtils.getImage("tile_bonus.png"), FilesUtils.getImage("tile_ground.png"));
        state = Type.BONUS;
        image = 0;
    }

    public TileBonus(Coordinate coordinate) {
        super(coordinate, FilesUtils.getImage("tile_bonus.png"), FilesUtils.getImage("tile_ground.png"));
        state = Type.BONUS;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        int x = this.getCoordinate().getX();
        int y = this.getCoordinate().getY();

    /**
        int image;

        if (state == Type.BONUS) {
            image = 0;
        }else {
            image = 1;
        }
     **/
        graphics2D.drawImage(this.getSprites()[image], x, y, Level.TITLE_SIZE, Level.TITLE_SIZE, null);
    }

    @Override
    public Type getType() {
        return state;
    }

    public void changeType(){
        if (state == Type.BONUS) {
            state = Type.GROUND;
            image = 1;
        }
    }
}
