package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jopaups
 */
public class UpdatePanel extends JPanel {

    private JComboBox<Integer> idQuestion;
    private JLabel messageLabel, questionLabel, questionToUpdate, answerLabel, answerToUpdate, emptyLabel;
    private JTextField question, answer;
    private JButton btnSave;
    private JPanel nbrQuestionPanel, questionPanel, answerPanel, savePanel;

    public UpdatePanel() {
        initGui();
    }

    /**
     * Permet la création du JPanel "UpdatePanel".
     */
    private void initGui() {

        // Instanciation des différents composants
        idQuestion = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        nbrQuestionPanel = new JPanel();
        messageLabel = new JLabel("Choisissez la question à modifier : ");
        questionLabel = new JLabel("Question actuelle :");
        questionToUpdate = new JLabel("ex: Quelle est la capitale de la France");
        answerLabel = new JLabel("Réponse actuelle :");
        emptyLabel = new JLabel(" ");
        answerToUpdate = new JLabel("ex: Paris");
        question = new JTextField();
        answer = new JTextField();
        btnSave = new JButton("Sauvegarder");
        questionPanel = new JPanel();
        answerPanel = new JPanel();
        savePanel = new JPanel();

        // Configuration des différents JLabel
        messageLabel.setPreferredSize(new Dimension(250, 50));
        questionLabel.setPreferredSize(new Dimension(170, 50));
        answerLabel.setPreferredSize(new Dimension(170, 50));

        // Configuration des layout des différents JPanel
        this.setLayout(new GridLayout(0, 1));
        nbrQuestionPanel.setLayout(new FlowLayout(5, 5, 5));
        questionPanel.setLayout(new FlowLayout(5, 5, 5));
        answerPanel.setLayout(new FlowLayout(5, 5, 5));
        savePanel.setLayout(new BorderLayout());

        // Ajout des composants dans le JPanel "nbrQuestionPanel"
        nbrQuestionPanel.add(messageLabel);
        nbrQuestionPanel.add(idQuestion);

        // Ajout des composants dans le JPanel "questionPanel"
        questionPanel.add(questionLabel);
        questionPanel.add(questionToUpdate);

        // Ajout des composants dans le JPanel "answerPanel"
        answerPanel.add(answerLabel);
        answerPanel.add(answerToUpdate);

        // Ajout des composants dans le JPanel "savePanel"
        savePanel.add(emptyLabel, BorderLayout.NORTH);
        savePanel.add(btnSave, BorderLayout.WEST);

        // Ajout des composants dans le JPanel principal "UpdatePanel"
        this.add(nbrQuestionPanel);
        this.add(questionPanel);
        this.add(question);
        this.add(answerPanel);
        this.add(answer);
        this.add(savePanel);
        this.add(emptyLabel);
    }

    public JLabel getQuestionToUpdate() {
        return questionToUpdate;
    }

    public JLabel getAnswerToUpdate() {
        return answerToUpdate;
    }

    public void setQuestion(JTextField question) {
        this.question = question;
    }

    public void setAnswer(JTextField answer) {
        this.answer = answer;
    }

    public JComboBox<Integer> getIdQuestion() {
        return idQuestion;
    }
}
