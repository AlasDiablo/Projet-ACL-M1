package fr.poweroff.labyrinthe.engine;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 * <p>
 * un jeu qui peut evoluer (avant de se terminer) sur un plateau width x
 * height
 */
public interface Game {

    /**
     * methode qui contient l'evolution du jeu en fonction de la commande
     *
     * @param userCmd commande utilisateur
     */
    void evolve(Cmd userCmd);

    void Compteur();

    void setFinish(boolean finish);

    boolean isWin();

    /**
     * @return true si et seulement si le jeu est fini
     */
    boolean isFinished();

    void setWin(boolean win);

}
