package fr.poweroff.labyrinthe.engine.menu;

import fr.poweroff.labyrinthe.utils.FilesUtils;

import java.awt.image.BufferedImage;

public class BestScore {
    private static final BufferedImage sprites = FilesUtils.getImage("assets/textures/gui/score.jpg");

    public static BufferedImage getSprites() {
        return sprites;
    }
}
