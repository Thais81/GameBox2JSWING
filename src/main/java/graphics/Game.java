package graphics;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Herbert Caffarel
 */
public class Game extends JFrame {

    Dessin dessinpanel;
    MyMenuBar menuBar;

    public Game() {
        super();
        initGui();
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Création de la frame principale
     */
    private void initGui() {

        // Ajoute une BoxLayout sur un axe vertcial à la frame principale
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        // Instanciation de la JMenuBar menuBar qui sera tout en haut de la frame principale
        menuBar = new MyMenuBar();

        // Instanciation de la JTabbedPane jTabbedPane pour créer des onglets dans la première partie de la frame principale
        JTabbedPane jTabbedPane = new JTabbedPane();

        // Instanciation des JPanel Dessin, Calcul, Question et Administration (caché)
        dessinpanel = new Dessin();

        // Ajout des JPanel Dessin, Calcul, Question et Administration (caché) dans le JTabbedPane pour les transformer en onglets
        jTabbedPane.addTab("Dessin", dessinpanel);

        // Ajout de la JMenu Bar MyMenuBar dans la JFrame Game (ui est la frame principale)
        this.setJMenuBar(menuBar);

        // Ajout de la JTabbedPane jTabbedPane dans la JFrame Game (qui est la frame principale)
        this.getContentPane().add(jTabbedPane);
    }
}
