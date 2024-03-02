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

    private JTextField username;
    private JPasswordField password;
    private JPanel panel;

    public LoginPwd() {
        initGui();
    }

    /**
     * Permet la création du JPanel "LoginPwd"
     */
    private void initGui() {

        // Instanciation des différents composants
        username = new JTextField();
        password = new JPasswordField();

        // Ajoute du JPanel "panel"avec un GridLayout
        panel = new JPanel(new GridLayout(2, 2));

        // Ajouter des composants dans le JPanel "LoginPwd"
        panel.add(new JLabel("Nom d'utilisateur:"));
        panel.add(username);
        panel.add(new JLabel("Mot de passe:"));
        panel.add(password);

    }

    /**
     * Permet la réation d'une JOptionPane contenant le JPanel "panel" ainsi que
     * des boutons "OK" et "Annuler" La fonction permet de vérifier si
     * l'utilisateur presse le bouton "OK".
     *
     * @return "true" si le bouton "OK" est préssé sinon return "false"
     */
    public boolean verifLogin() {

        int result = JOptionPane.showConfirmDialog(null, panel, "Login",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return true;
        } else;
        return false;
    }

    public JTextField getUsername() {
        return username;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public void setUsername(JTextField username) {
        this.username = username;
    }

    public void setPassword(JPasswordField password) {
        this.password = password;
    }

}
