/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import containers.LabelAndField;
import dao.QuestionDAO;
import entities.Question;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    private Popup popup;

    public QaPanel() throws SQLException {
        questionPanel = new JLabel("Question");
        questionPanelDisplay = new JLabel(" ");
        answerPanel = new LabelAndField("Answer", 75);
        question = newQuestion();
        showQuestion(question);
        showAnswer(question);
        readAnswer();
        verifPopup();
        this.setPreferredSize(new Dimension(200, 200));
        initGui();
//        initEvents();

    }

    // Fonction permettant affichage des éléments dans le QaPanel
    private void initGui() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        // Ajout des composants au panneau
        this.add(questionPanel);
        this.add(questionPanelDisplay);
        this.add(answerPanel);

    }

    // Initialisation des évènements à l'ouverture de l'onglet Questions
//    public void initEvents() {
//        check.addActionListener(this);
//        result.addActionListener(this);
//        next.addActionListener(this);
//    }

    public LabelAndField getAnswerPanel() {
        return answerPanel;
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
    public void verifPopup() throws SQLException {
        QuestionDAO qdao = new QuestionDAO();
        String resUser = answerPanel.getString();
        String res = qdao.check("question", "answer");
        if (res == null ? resUser != null : !res.equals(resUser)) {
            popup.showPopup(1);
        } else {
            popup.showPopup(0);
        }
    }

    public String readAnswer() {
        QuestionDAO qdao = new QuestionDAO();
        String reponse = qdao.readResult("Votre question");
        return reponse;
    }

// Afficher réponse avec Bouton Solution
    public void showAnswer(Question question) {
        answerPanel.setText(question.getAnswer());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
