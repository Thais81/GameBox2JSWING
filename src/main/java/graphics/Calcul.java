/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author Thaïs GENIN
 */
public class Calcul extends JPanel implements ActionListener {

    private Popup popup;
    private final JPanel displayPanel;
    private final JPanel toolPanel;
    private final JButton next, result, check;
    private final JPanel operation;
    private final JLabel Va1;
    private final JLabel Va2;
    private final JLabel operator;
    private final JLabel equal;
    private final JTextField answer;
    private static final String[] oper = {"+", "-"};
    private static final int[] val = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    // variables pour stocker les valeurs des tableaux
    private int va1, va2;
    private String getOperator;

    public Calcul() {

        //instanciation et esthetique panel du haut
        operation = new JPanel();
        operation.setLayout(new FlowLayout());
        operation.setPreferredSize(new Dimension(500, 800));
        operation.setBackground(Color.WHITE);
        //pannel dans operation pour gérer l'affichage
        displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        displayPanel.setBackground(Color.pink);
        //instanciation des labels
        operator = new JLabel();
        operator.setPreferredSize(new Dimension(100, 100));

        Va1 = new JLabel();
        Va1.setPreferredSize(new Dimension(100, 100));
        Va1.setFont(Va1.getFont().deriveFont(400));
        Va1.setFont(Va1.getFont().deriveFont(400));

        Va2 = new JLabel();
        Va2.setPreferredSize(new Dimension(100, 100));
        Va2.setFont(Va2.getFont().deriveFont(400));

        equal = new JLabel("=");
        equal.setPreferredSize(new Dimension(100, 100));
        equal.setFont(equal.getFont().deriveFont(400));
        //Champs de réponse:
        answer = new JTextField();
        answer.setPreferredSize(new Dimension(100, 100));
        answer.setBackground(Color.WHITE);
        answer.setFont(answer.getFont().deriveFont(400));
        //instanciation panel du bas
        toolPanel = new JPanel();
        toolPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        //instanciation des bouttons
        next = new JButton("Suivant");
        result = new JButton("Résultat");
        check = new JButton("Vérifier");
        popup = new Popup();
        //lancement d'un calcul aléatoire dès le chargement de la page:
        randomCalcul();
        //gestion evènementielle de la touche entrée
        // Ajouter la liaison de touche pour Enter au panneau
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "checkAction");
        getActionMap().put("checkAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });

        initGui();
        initEvents();
        this.setVisible(true);
        //fonction focus sur le champs de réponse:
        answer.requestFocus();
        answer.setVerifyInputWhenFocusTarget(true);
    }

    public JTextField getAnswer() {
        return answer;
    }

    public int getVa1() {
        return va1;
    }

    public void setVa1(int va1) {
        this.va1 = va1;
    }

    public int getVa2() {
        return va2;
    }

    public void setVa2(int va2) {
        this.va2 = va2;
    }

    public String getGetOperator() {
        return getOperator;
    }

    public void setGetOperator(String getOperator) {
        this.getOperator = getOperator;
    }

    public JButton getNext() {
        return next;
    }

    public JButton getResult() {
        return result;
    }

    public JButton getCheck() {
        return check;
    }

    private void initGui() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //intégration du panel du dessus:
        this.add(operation);
        //intégration du panel en bas:
        this.add(toolPanel);
        //integration du panneau display dans le panneau du haut
        operation.add(displayPanel);

        //intégration des éléments au panel du haut:
        Va1.setText(String.valueOf(va1));
        Va2.setText(String.valueOf(va2));
        displayPanel.add(Va1);
        displayPanel.add(operator);
        displayPanel.add(Va2);
        displayPanel.add(equal);
        displayPanel.add(answer);

        //accélérateur:
        check.setMnemonic(KeyEvent.VK_V);
        result.setMnemonic(KeyEvent.VK_R);
        next.setMnemonic(KeyEvent.VK_S);

        //Ajout des boutons dans ToolPanel:
        toolPanel.add(check);
        toolPanel.add(result);
        toolPanel.add(next);

        // Activation des boutons
        next.setEnabled(true);
        result.setEnabled(true);
        check.setEnabled(true);

    }
//GESTION EVENEMENTIELLE: btn next, result, check

    public void initEvents() {
        check.addActionListener(this);
        result.addActionListener(this);
        next.addActionListener(this);
    }

    //FONCTIONS:
    /**
     * générer un calcul random avec la fonction randomCalcul()
     */
    private void randomCalcul() {
        //Sélection d'un index au hasard
        //dans le tabeau de valeur grace à la methode Random()
        // l'opérande
        getOperator = oper[new Random().nextInt(oper.length)];
        //faire apparaître l'opérateur dans son label
        operator.setText(getOperator);
        //Maintenant avec les chiffres
        // les valeurs qui vont prendre l'index du tableau de valeurs
        //On en a besoin de deux pour faire une opération:
        va1 = val[new Random().nextInt(val.length)];
        va2 = val[new Random().nextInt(val.length)];
        // Convertir le texte des valeurs en integer pour faire les opérations
        Va1.setText(String.valueOf(va1));
        Va2.setText(String.valueOf(va2));

    }

    public int calcGenerator() {
        int res = 0;
// Puis gérer affecter l'opérande avec une condition:
// Comparaison de String grace à la methode equals()
        if (getOperator.equals("+")) {

            res = va1 + va2;
        } else if (getOperator.equals("-")) {
            if ((va2 > va1)) {
                randomCalcul();
            } else {
                res = va1 - va2;
            }
        }
        return res;
    }
//générer des valeurs:

    public void rand(int[] val, int length) {
        Random random = new Random();

        // Parcourir le tableau à partir de l'index de fin
        for (int i = length - 1; i > 0; i--) {
            // Générer un nouvel index j compris entre 0 et i:
            int j = random.nextInt(i + 1);

            // échange des elements aux positions i et j
            int temp = val[i];
            val[i] = val[j];
            val[j] = temp;
        }
    }

    //vérifier la réponse
    public void checkAnswer() {
        //transformer le texte retiré du champs de réponse en Integer
        //pour pouvoir le comparer au résultat de calcGenerator
        int resCostumer = Integer.parseInt(answer.getText());
        int res = calcGenerator();
        if (res != resCostumer) {
            popup.showPopup(1);
        } else {
            popup.showPopup(0);
        }

    }

    //Donner la solution
    public void showResult() {
        //test
        System.out.println("resultat");
        //on récupère le résultat de calcGenerator();
        int res = calcGenerator();
        answer.setText("" + res);
    }
    //Calcul suivant

    public void nextCalculate() {
        //test
        System.out.println("nouveau Calcul");
        //delete les données dans le textField
        answer.setText("");
        randomCalcul();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            checkAnswer();
        }
    }

    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae
    ) {
        Object source = ae.getSource();

        if (source instanceof JButton) {
            JButton button = (JButton) source;

            if (button == this.result) {
                showResult();
            } else if (button == this.next) {
                nextCalculate();
            } else if (button == this.check) {
                checkAnswer();
            }
        } else {
            setVisible(false);
        }
    }

}
