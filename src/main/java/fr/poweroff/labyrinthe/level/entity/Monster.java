package fr.poweroff.labyrinthe.level.entity;

import fr.poweroff.labyrinthe.engine.Cmd;
import fr.poweroff.labyrinthe.level.Level.LevelEvolve;
import fr.poweroff.labyrinthe.model.PacmanGame;
import fr.poweroff.labyrinthe.utils.Coordinate;
import fr.poweroff.labyrinthe.utils.FilesUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Monster extends Entity {

    /**
     * The player sprite path
     */
    private static final String  SPRITE_PATH = "assets/ghost/";
    private final        int     spriteIndex;
    private final        boolean vertical;
    private              Cmd     direction;

    public Monster(Coordinate coordinate) {
        super(
                coordinate,
                Monster.getSprite("monster_blinky.png"),
                Monster.getSprite("monster_clyde.png"),
                Monster.getSprite("monster_inky.png"),
                Monster.getSprite("monster_pinky.png")
        );
        this.spriteIndex = PacmanGame.RANDOM.ints(0, this.sprite.length).findAny().orElse(0);
        this.vertical    = PacmanGame.RANDOM.nextBoolean();
        var bool = PacmanGame.RANDOM.nextBoolean();
        if (this.vertical) {
            this.direction = bool ? Cmd.DOWN : Cmd.UP;
        } else {
            this.direction = bool ? Cmd.RIGHT : Cmd.LEFT;
        }
    }

    /**
     * Funcion use to get the player sprite
     *
     * @param name the name of the sprite
     *
     * @return the sprite as a buffered image
     */
    private static BufferedImage getSprite(String name) {
        return FilesUtils.getImage(SPRITE_PATH + name);
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.drawImage(this.getSprite()[this.spriteIndex], this.getCoordinate().getX(), this.getCoordinate().getY(), ENTITY_SIZE, ENTITY_SIZE, null);
        //TODO Orientation des sprite en fondtion de la direction de deplacement
    }

    @Override
    public void evolve(Cmd cmd, LevelEvolve levelEvolve) {
        //TODO Depalcement des monstre en ligne
        var x = this.coordinate.getX();
        var y = this.coordinate.getY();

        if (this.direction == Cmd.UP || this.direction == Cmd.LEFT) {
            var newX = x - (this.vertical ? 0 : MOVE_SPEED);
            var newY = y - (this.vertical ? MOVE_SPEED : 0);
            if (levelEvolve.notOverlap(newX, newY, ENTITY_SIZE, ENTITY_SIZE)) {
                this.coordinate.setX(newX);
                this.coordinate.setY(newY);
            } else {
                this.direction = this.vertical ? Cmd.DOWN : Cmd.RIGHT;
            }
        } else if (this.direction == Cmd.DOWN || this.direction == Cmd.RIGHT) {
            var newX = x + (this.vertical ? 0 : MOVE_SPEED);
            var newY = y + (this.vertical ? MOVE_SPEED : 0);
            if (levelEvolve.notOverlap(newX, newY, ENTITY_SIZE, ENTITY_SIZE)) {
                this.coordinate.setX(newX);
                this.coordinate.setY(newY);
            } else {
                this.direction = this.vertical ? Cmd.UP : Cmd.LEFT;
            }
        }
    }
}