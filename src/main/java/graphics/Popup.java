/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Thaïs GENIN
 */
public class Popup {

    private ImageIcon[] icons = {new ImageIcon("win.png"), new ImageIcon("L.png")};

    private String[] titles = {"Gagné!", "Perdu!"};
    private String[] messages = {"Bonne réponse!", "C'est perdu gros looser, booooouuuuh!"};

    public void showPopup(int i) {
        ImageIcon icon = icons[i];
        String message = messages[i];
        String title = titles[i];

        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
