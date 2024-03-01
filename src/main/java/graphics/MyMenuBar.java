package graphics;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Jopaups
 */
public class MyMenuBar extends JMenuBar {

    JMenu activites, administration;
    JMenuItem dessinItem, calculItem, questionItem, settings;

    public MyMenuBar() {
        initGui();
    }

    /**
     * Création de la JMenuBar
     */
    private void initGui() {

        // Initialisation des différents panels et composants
        activites = new JMenu("Activités");
        administration = new JMenu("Administration");
        dessinItem = new JMenuItem("Dessin");
        calculItem = new JMenuItem("Calcul");
        questionItem = new JMenuItem("Question");
        settings = new JMenuItem("Settings");

        // Ajout des composants dans la JMenuBar
        activites.add(dessinItem);
        activites.add(calculItem);
        activites.add(questionItem);
        administration.add(settings);
        this.add(activites);
        this.add(administration);
    }
}
