/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package containers;

import dao.QuestionDAO;
import entities.Question;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Guillaume Rostagnat
 */
public class QaPanel extends JPanel {

    public final JLabel questionPanel;
    private final LabelAndField answerPanel;
    private final JLabel questionPanelDisplay;
    private Question question;

    public QaPanel() {
        questionPanel = new JLabel("Question");
        questionPanelDisplay = new JLabel(" ");
        answerPanel = new LabelAndField("Answer", 75);
        question = newQuestion();
        showQuestion(question);
        this.setPreferredSize(new Dimension(200, 200));
        initGui();

    }

    private void initGui() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Ajout des composants au panneau
        this.add(questionPanel);
        this.add(questionPanelDisplay);
        this.add(answerPanel);

    }

    public LabelAndField getAnswerPanel() {
        return answerPanel;
    }
    
    private Question newQuestion() {
        QuestionDAO qdao = new QuestionDAO();
        Question q = qdao.alea();
        return q;
    }
    
    private void showQuestion(Question question) {
        questionPanelDisplay.setText(question.getQuestion());
    }

}
