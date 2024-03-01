package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Herbert Caffarel
 */
public class Game extends JFrame {

    Dessin dessinpanel;
    Administration administrationPanel;
    MyMenuBar menuBar;
    JTabbedPane jtp;

    public Game() {
        super();
        initGui();
        initEvents();
        this.setSize(500, 300);
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
        jtp = new JTabbedPane();

        // Instanciation des JPanel Dessin, Calcul, Question et Administration (caché)
        dessinpanel = new Dessin();
        administrationPanel = new Administration();

        // Ajout des JPanel Dessin, Calcul, Question et Administration (caché) dans le JTabbedPane pour les transformer en onglets
        jtp.addTab("Dessin", dessinpanel);

        // Ajout de la JMenu Bar MyMenuBar dans la JFrame Game (ui est la frame principale)
        this.setJMenuBar(menuBar);

        // Ajout de la JTabbedPane jTabbedPane dans la JFrame Game (qui est la frame principale)
        this.getContentPane().add(jtp);
    }

    private void initEvents() {
        menuBar.settings.addActionListener((ActionEvent ae) -> {
            jtp.addTab("Administration", administrationPanel);
        });
    }
}

//jTabbedPane.removeTabAt(jTabbedPane.indexOfTab("Administration"));
