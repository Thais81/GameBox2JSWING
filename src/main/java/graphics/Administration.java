package graphics;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jopaups
 */
public class Administration extends JPanel {

    JMenuBar myMenuBar;
    JMenu menu;
    JMenuItem save, update;
    JLabel messageLabel, questionLabel, answerLabel;
    JTextField question, answer;
    JButton btnSave;

    public Administration() {
        initGui();
    }

    /**
     * Création de JPanel Administration
     */
    private void initGui() {
        // Initialisation des différents panels et composants
        messageLabel = new JLabel("Veuillez entrer une nouvelle question : ");
        questionLabel = new JLabel("Question :");
        messageLabel.setPreferredSize(new Dimension(WIDTH, 50));
        answerLabel = new JLabel("Réponse :");
        question = new JTextField();
        answer = new JTextField();
        btnSave = new JButton("Sauvegarder");

        // Configuration du layout du panel principal
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(500, 800));
        this.add(messageLabel);
        this.add(questionLabel);
        this.add(question);
        this.add(answerLabel);
        this.add(answer);
        this.add(save);
    }

}
