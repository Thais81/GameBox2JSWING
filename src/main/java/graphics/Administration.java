package graphics;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jopaups
 */
public class Administration extends JPanel {

    JLabel questionLabel, answerLabel;
    JTextField question, answer;
    JButton save;

    public Administration() {
        initGui();
    }

    /**
     * Création de JPanel Administration
     */
    private void initGui() {
        // Initialisation des différents panels et composants
        questionLabel = new JLabel("Question :");
        answerLabel = new JLabel("Réponse :");
        question = new JTextField();
        answer = new JTextField();
        save = new JButton("Sauvegarder");

        // Configuration du layout du panel principal
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(500, 800));
        this.add(questionLabel);
        this.add(question);
        this.add(answerLabel);
        this.add(answer);
        this.add(save);
    }

}
