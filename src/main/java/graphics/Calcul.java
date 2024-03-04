/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Thaïs GENIN
 */
public class Calcul extends JPanel implements ActionListener {

    private Popup popup;
    private final JPanel toolPanel;
    private final JButton next, result, check;
    protected final JPanel operation;
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

        operation = new JPanel();
        operation.setLayout(new FlowLayout());
        Va1 = new JLabel();
        Va1.setPreferredSize(new Dimension(100, 100));
        operator = new JLabel();
        operator.setPreferredSize(new Dimension(100, 100));
        Va2 = new JLabel();
        Va2.setPreferredSize(new Dimension(100, 100));
        va1 = 0;
        va2 = 0;
        equal = new JLabel("=");
        equal.setPreferredSize(new Dimension(100, 100));
        //champs de saisie de la réponse, 3 caractères
        answer = new JTextField(3);
        answer.setPreferredSize(new Dimension(100, 100));
        toolPanel = new JPanel();
        next = new JButton("Suivant");
        result = new JButton("Résultat");
        check = new JButton("Vérifier");
        popup = new Popup();

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

        //intégration des éléments au panel du haut:
        Va1.setText(String.valueOf(va1));
        Va2.setText(String.valueOf(va2));
        operation.add(Va1);
        operation.add(operator);
        operation.add(Va2);
        operation.add(equal);
        operation.add(answer);

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
    //effacer le conteneur réponse de l'utilisateur
    //deleteAnswer();
    //pour contraindre la reponse en int taille max 3
    //public void restrictLengthField()
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
        // les valeurs
        va1 = val[new Random().nextInt(val.length)];
        va2 = val[new Random().nextInt(val.length)];
        // Convertir le texte des valeurs en integer pour faire les opérations
        Va1.setText(String.valueOf(va1));
        Va2.setText(String.valueOf(va2));
    }

    public int calcGenerator() {
        int res = 0;
// Puis gérer les calculs (avec une simple if condition)
// Comparaison grace à equals()
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

    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
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
