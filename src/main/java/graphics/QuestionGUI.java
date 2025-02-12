/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import containers.QaPanel;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 * classe de test du panel question
 * @author Guillaume Rostagnat
 */
public class QuestionGUI extends JFrame {

    public QuestionGUI() throws SQLException {
        this.setContentPane(new QaPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture
        this.setResizable(false); // Fenêtre non-redimensionnable
        this.setSize(600, 600);
        this.setLocationRelativeTo(null); // On positionne la fenêtre au milieu de l'écran
        this.setVisible(true);
    }
    
    public static void main(String[] args) throws SQLException {
        new QuestionGUI();
    }
    
    
}
