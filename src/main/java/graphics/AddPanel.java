package graphics;

import dao.QuestionDAO;
import entities.Question;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jopaups
 */
public class AddPanel extends JPanel {

    private JLabel messageLabel, questionLabel, answerLabel, emptyLabel;
    private JTextField question, answer;
    private JButton btnSave;
    private JPanel savePanel;

    public AddPanel() {
        initGui();
        initEvent();
    }

    /**
     * Permet la création du JPanel "AddPanel".
     */
    private void initGui() {

        // Instanciation des différents composants
        messageLabel = new JLabel("Veuillez entrer une nouvelle question : ");
        questionLabel = new JLabel("Question :");
        answerLabel = new JLabel("Réponse :");
        emptyLabel = new JLabel(" ");
        question = new JTextField();
        answer = new JTextField();
        btnSave = new JButton("Sauvegarder");
        savePanel = new JPanel();

        // Configuration des différents JLabel
        messageLabel.setPreferredSize(new Dimension(300, 80));
        questionLabel.setPreferredSize(new Dimension(300, 50));
        answerLabel.setPreferredSize(new Dimension(300, 50));
        emptyLabel.setPreferredSize(new Dimension(300, 50));

        // Configuration des layout des différents JPanel
        this.setLayout(new GridLayout(0, 1));
        savePanel.setLayout(new BoxLayout(savePanel, BoxLayout.Y_AXIS));

        // Ajout des composants dans le JPanel "savePanel"
        savePanel.add(emptyLabel);
        savePanel.add(btnSave);
        savePanel.add(emptyLabel);

        // Ajout des composants dans le JPanel principal "AddPanel"
        this.add(messageLabel);
        this.add(questionLabel);
        this.add(question);
        this.add(answerLabel);
        this.add(answer);
        this.add(savePanel);
    }

    public void setQuestion(JTextField question) {
        this.question = question;
    }

    public void setAnswer(JTextField answer) {
        this.answer = answer;
    }

    private void initEvent() {
        btnSave.addActionListener((ae) -> {
            if (question.getText().isEmpty() || answer.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Les champs ne doivent pas être vides", "ERROR", 2);
            } else {
                String newQuestion = question.getText();
                String newAnswer = answer.getText();
                Question q = new Question();
                QuestionDAO qdao = new QuestionDAO();
                qdao.addGraphics(q, newQuestion, newAnswer);
                JOptionPane.showMessageDialog(null, "Sauvegarde effectuée");
            }
        });
    }

}
