/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package containers;

import dao.QuestionDAO;
import entities.Question;
import graphics.Popup;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Guillaume Rostagnat
 */
public final class QaPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    public final JLabel questionPanel;
    private final LabelAndField answerPanel;
    private final JLabel questionPanelDisplay;
    private Question question;
    private final JPanel toolPanel;
    private JButton next;
    private JButton result;
    private JButton check;
    private Popup popup;

    public QaPanel() throws SQLException {
        questionPanel = new JLabel("Question");
        questionPanelDisplay = new JLabel(" ");
        answerPanel = new LabelAndField("Answer", 75);
        question = newQuestion();
        toolPanel = new JPanel();
        next = new JButton("Suivant");
        result = new JButton("Résultat");
        check = new JButton("Vérifier");
        popup = new Popup();
        question = newQuestion();

        this.setPreferredSize(new Dimension(200, 200));
        initGui();
        initEvents();

    }

    public LabelAndField getAnswerPanel() {
        return answerPanel;
    }

    // Fonction permettant affichage des éléments dans le QaPanel
    private void initGui() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        // Ajout des composants au panneau
        this.add(questionPanel);
        this.add(questionPanelDisplay);
        this.add(answerPanel);
        this.add(toolPanel);
        // Ajout des boutons
        toolPanel.add(check);
        toolPanel.add(result);
        toolPanel.add(next);
        // afficher la question
        showQuestion(question);

        // Activation des boutons
        next.setEnabled(true);
        result.setEnabled(true);
        check.setEnabled(true);

    }

    // Initialisation des évènements à l'ouverture de l'onglet Questions
    public void initEvents() {
        check.addActionListener(this);
        result.addActionListener(this);
        next.addActionListener(this);
    }

    /**
     * Fonctions qui agiront sur les boutons "vérifier" "solution" et "suivant"
     *
     * @return
     */
    // Générer nouvelle question aléatoirement avec fonction alea
    public Question newQuestion() {
        QuestionDAO qdao = new QuestionDAO();
        Question q = qdao.alea();
        return q;
    }

    //Afficher nouvelle question dans champ question
    public void showQuestion(Question question) {
        questionPanelDisplay.setText(question.getQuestion());
    }

    // Check si réponse juste avec Bouton Vérifier et affichage pop up
    public void verifPopup() {
        String resUser = answerPanel.getTextField().getText().trim();
        if (!question.getAnswer().equalsIgnoreCase(resUser)) {
            popup.showPopup(1);
        } else {
            popup.showPopup(0);
        }
    }

// Afficher réponse avec Bouton Solution
    public void showAnswer(Question question) {
        answerPanel.getTextField().setText(question.getAnswer());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if (source instanceof JButton) {
            JButton button = (JButton) source;

            if (button == this.result) {
                showAnswer(question);
            } else if (button == this.next) {
                question = newQuestion();
                showQuestion(question);
                answerPanel.getTextField().setText((""));
            } else if (button == this.check) {
                verifPopup();
            }
        } else {
            setVisible(false);
        }
    }
}
