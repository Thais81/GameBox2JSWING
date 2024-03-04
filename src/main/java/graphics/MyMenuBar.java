package graphics;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

/**
 *
 * @author Jopaups
 */
public class MyMenuBar extends JMenuBar {

    private JMenu activites, administration;
    private JMenuItem dessinItem, calculItem, questionItem, settings, exitItem;

    public MyMenuBar() {
        initGui();
    }

    /**
     * Création de la JMenuBar "MyMenuBar"
     */
    private void initGui() {

        // Instanciation des différents panels et composants
        activites = new JMenu("Activités");
        administration = new JMenu("Administration");
        dessinItem = new JMenuItem("Dessin", KeyEvent.VK_D);
        calculItem = new JMenuItem("Calcul", KeyEvent.VK_C);
        questionItem = new JMenuItem("Question", KeyEvent.VK_Q);
        settings = new JMenuItem("Settings", KeyEvent.VK_S);
        exitItem = new JMenuItem("Exit", KeyEvent.VK_E);
        
        // Ajout des accelerators sur les différents composants de la JMenuBar "MyMenuBar"
        dessinItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
        calculItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        questionItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        settings.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        
        // Ajout des composants dans la JMenuBar
        activites.add(dessinItem);
        activites.add(calculItem);
        activites.add(questionItem);
        activites.add(new JSeparator());
        activites.add(exitItem);
        administration.add(settings);
        this.add(activites);
        this.add(administration);
    }

    public JMenuItem getSettings() {
        return settings;
    }

    public JMenuItem getDessinItem() {
        return dessinItem;
    }

    public JMenuItem getCalculItem() {
        return calculItem;
    }

    public JMenuItem getQuestionItem() {
        return questionItem;
    }

    public JMenuItem getExitItem() {
        return exitItem;
    }
}
