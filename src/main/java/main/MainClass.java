package main;

import graphics.Calcul;
import graphics.Game;
import graphics.Popup;
import java.sql.SQLException;

/**
 *
 * @author Herbert Caffarel
 */
public class MainClass {

    public static void main(String[] args) throws SQLException {
        Calcul calcul = new Calcul();
        Game game = new Game();
        Popup popup = new Popup();
    }

}
