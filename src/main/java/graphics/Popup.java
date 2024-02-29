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

    /**
     * @Class Popup Fenêtre Popup qui s'affichera pendant une gestion
     * evènementielle. En     * fonction de la réponse donnée, s'affichera avec les index des tableau
     * pour vrai ou faux.
     */

    private ImageIcon[] icons = {new ImageIcon("win.png"), new ImageIcon("lose.png")};
    private String[] titles = {"Gagné!", "Perdu!"};
    private String[] messages = {"Bonne réponse!", "C'est perdu gros looser, booooouuuuh!"};

    public void showPopup(int i) {
        /**
         * @showPopup         * i correspond à l'indice des différents tableaux. Comme il y a peu de
         * valeurs par tableau (seulement deux), choix d'ordonnacer
         * directement         * les valeurs correspondantes aux mêmes indices au lieux de faire des
         * tableaux de valeurs.
         */
        ImageIcon icon = icons[i];
        String message = messages[i];
        String title = titles[i];

        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
