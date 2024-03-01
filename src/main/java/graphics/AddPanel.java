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
public class AddPanel extends JPanel {

    JLabel messageLabel, questionLabel, answerLabel, emptyLabel;
    JTextField question, answer;
    JButton btnSave;

    public AddPanel() {
        initGui();
    }

    private void initGui() {
        messageLabel = new JLabel("Veuillez entrer une nouvelle question : ");
        messageLabel.setPreferredSize(new Dimension(300, 80));
        questionLabel = new JLabel("Question :");
        questionLabel.setPreferredSize(new Dimension(300, 50));
        answerLabel = new JLabel("Réponse :");
        answerLabel.setPreferredSize(new Dimension(300, 50));
        emptyLabel = new JLabel(" ");
        emptyLabel.setPreferredSize(new Dimension(300, 50));
        question = new JTextField();
        answer = new JTextField();
        btnSave = new JButton("Sauvegarder");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(messageLabel);
        this.add(questionLabel);
        this.add(question);
        this.add(answerLabel);
        this.add(answer);
        this.add(emptyLabel);
        this.add(btnSave);
    }
}
