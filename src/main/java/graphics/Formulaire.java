package graphics;

import containers.QaPanel;
import dao.Connection;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Herbert Caffarel
 */
public class Formulaire extends JFrame {

    private static final long serialVersionUID = 1L;

    private QaPanel qapanel;
    private Connection connection;

    public Formulaire() {
        super(" Questions");
        // Création de l'onglet

        // Initialisation du contenu graphique
        this.initGui();

        // Configuration de la fenêtre A SUPPRIMER
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture
        this.setResizable(false); // Fenêtre non-redimensionnable
        this.pack(); // Ajustement de la taille au contenu
        this.setLocationRelativeTo(null); // On positionne la fenêtre au milieu de l'écran
        this.setVisible(true); // Affichage de la fenêtre
        qapanel.getAnswerPanel().getTextField().requestFocus();

    }

    private void initGui() {

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        // Ajout des différents panneaux dans le contenu
        JTabbedPane tabbedPane = new JTabbedPane();
        qapanel = new QaPanel();
        tabbedPane.addTab("Question", qapanel);
        // Ajout de l'onglet à la fenêtre
        this.getContentPane().add(tabbedPane);

    }

}
