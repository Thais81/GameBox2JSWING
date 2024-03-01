package graphics;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jopaups
 */
public class LoginPwd extends JPanel {

    JTextField username;
    JPasswordField password;
    JPanel panel;

    public LoginPwd() {
        initGui();
    }

    private void initGui() {
        username = new JTextField();
        password = new JPasswordField();
        panel = new JPanel(new GridLayout(2, 2));

        // Ajouter des composants au panneau
        panel.add(new JLabel("Nom d'utilisateur:"));
        panel.add(username);
        panel.add(new JLabel("Mot de passe:"));
        panel.add(password);

    }

    public boolean verifLogin() {
        // Afficher la boîte de dialogue
        int result = JOptionPane.showConfirmDialog(null, panel, "Login",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Vérifier si l'utilisateur a appuyé sur OK
        if (result == JOptionPane.OK_OPTION) {
            return true;
        } else;
        return false;
    }

}
