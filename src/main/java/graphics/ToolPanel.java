//
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package graphics;
//
//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import javax.swing.JButton;
//import javax.swing.JPanel;
//
///**
// *
// * @author Thaïs GENIN
// */
///**
// * Classe créee afin de factoriser le code des graphics Question et Calcul
// *
// */
//public abstract class ToolPanel extends JPanel implements ActionListener {
//
//    private JButton next, result, check;
//    //Popup personalisées dans le package graphics
//    private final Popup popup;
//    private final Calcul parentCalcul;
//
//    public ToolPanel(Calcul parentCalcul) {
//
//        next = new JButton("Suivant");
//        result = new JButton("Résultat");
//        check = new JButton("Vérifier");
//        popup = new Popup();
//        this.parentCalcul = parentCalcul;
//
//        initGui();
//        initEvents();
//        this.setVisible(true);
//    }
//
//    public ToolPanel getTool() {
//        return this;
//    }
//    public JButton getNext() {
//        return next;
//    }
//
//    public void setNext(JButton next) {
//        this.next = next;
//    }
//
//    public JButton getResult() {
//        return result;
//    }
//
//    public void setResult(JButton result) {
//        this.result = result;
//    }
//
//    public JButton getCheck() {
//        return check;
//    }
//
//    public void setCheck(JButton check) {
//        this.check = check;
//    }
//
//    private void initGui() {
//        this.setLayout(new FlowLayout(5, 5, 5));
//
//        //accélérateur:
//        check.setMnemonic(KeyEvent.VK_V);
//        result.setMnemonic(KeyEvent.VK_R);
//        next.setMnemonic(KeyEvent.VK_S);
//
//        //Ajout des boutons dans ToolPanel:
//        this.add(check);
//        this.add(result);
//        this.add(next);
//        //Accès à la classe Cacul avec la variable parentCalcul
//        //Pour placer le toolPanel
//        this.add(parentCalcul.operation, BorderLayout.SOUTH);
//    }
//
////GESTION EVENEMENTIELLE: btn next, result, check
//    public void initEvents() {
//        check.addActionListener(this);
//        result.addActionListener(this);
//        next.addActionListener(this);
//        }
//
//
////FONCTIONS:
//    //vérifier la réponse
//    public void checkAnswer() {
////if((getText.repUtilisatteur == resultat)= true){
//        //showPopup(0)
//        //}else{
//        //showPopup(1);}
//
//    }
//
//    //Donner la solution
//    public void showResult() {
//        //en attendant d'avoir le résult qui se trouve dans Cacul
//    }
//    //Calcul suivant
//
//    public void nextCalculate() {
//        //delete les données dans le textField
//    }
//
//    /**
//     *
//     * @param ae
//     */
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        Object source = ae.getSource();
//
//        if (source instanceof JButton) {
//            JButton button = (JButton) source;
//
//            if (button == this.getResult()) {
//                showResult();
//            } else if (button == this.getNext()) {
//                nextCalculate();
//            } else if (button == this.getCheck()) {
//                checkAnswer();
//            }
//        } else {
//            setVisible(false);
//        }
//    }
//}
