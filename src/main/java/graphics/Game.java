package graphics;

import java.util.List;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author Jopaups
 */
public class Game extends JFrame {

    private Dessin dessinPanel;
    private Administration administrationPanel;
    private MyMenuBar menuBar;
    private JTabbedPane jtp;

    public Game() {
        super();
        initGui();
        initEvents();
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Permet la création de la JFrame principale "Game"
     */
    private void initGui() {

        // Ajoute une BoxLayout sur un axe vertcial à la JFrame principale
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        // Instanciation de la JMenuBar "menuBar" qui sera tout en haut de la JFrame principale
        menuBar = new MyMenuBar();

        // Instanciation de la JTabbedPane "jTabbedPane" pour créer des onglets dans la première partie de la JFrame principale
        jtp = new JTabbedPane();

        // Instanciation des JPanel "Dessin", "Calcul", "Question" et "Administration" (caché)
        dessinPanel = new Dessin();
        administrationPanel = new Administration();

        // Ajout des JPanel "Dessin", "Calcul", "Question" dans le JTabbedPane pour les transformer en onglets
        jtp.addTab("Dessin", dessinPanel);

        // Ajout de la JMenuBar "MyMenuBar" dans la JFrame principale
        this.setJMenuBar(menuBar);

        // Ajout de la JTabbedPane "jTabbedPane" dans la JFrame principale
        this.getContentPane().add(jtp);
    }

    /**
     * Création des fonctions associés à la JFrame principale.
     */
    private void initEvents() {

        // Lance le JPanel "LoginPwd" lorsque le sous-menu "settings" est pressé
        // Si le login et le mot de passe sont mauvais, une JOptionPane apparait avec un message d'erreur
        // Sinon le JPanel "administration" est ajouté dans les onlgets du JTabbedPane "jtabbedpane"
        // Le code récupère également le login et le mot de passe dans un fichier externe.
        menuBar.getSettings().addActionListener((ActionEvent ae) -> {
            LoginPwd log = new LoginPwd();

            if (log.verifLogin()) {
                List<String> lines = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/adm")))
                        .lines()
                        .collect(Collectors.toList());
                if (!lines.isEmpty()) {
                    String[] credentials = lines.get(0).split(",");
                    String storedUsername = credentials[0].trim();
                    String storedPassword = credentials[1].trim();

                    String enteredUsername = log.getUsername().getText();
                    String enteredPassword = log.getPassword().getText();

                    if (storedUsername.equals(enteredUsername) && storedPassword.equals(enteredPassword)) {
                        int adminPanelIdx = jtp.indexOfComponent(administrationPanel);

                        if (adminPanelIdx == -1) {
                            // Si l'onglet n'est pas présent, ajoutez-le
                            jtp.addTab("Administration", administrationPanel);
                        } else {
                            // Si l'onglet est déjà présent, sélectionnez-le
                            jtp.remove(adminPanelIdx);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Mauvais login ou/et mot de passe", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Fichier de configuration vide", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Permet de fermer le programme  en cliquant sur le JMenuItem "Exit"
        // aprés confirmation dans une JOptionPane,
        // ou en utilisant le raccourci clavier associé "CTLR+E"
        menuBar.getExitItem().addActionListener((ActionEvent ae) -> {
            int choice = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter le programme?", "Confirmation", 2);
            if (choice == JOptionPane.YES_OPTION) {
                // Fermez la fenêtre principale
                dispose();
            }
        });

        // Permet d'afficher le JPanel "Dessin" en cliquant le JMenuItem "Dessin" de la barre des menus
        // ou en utilisant le raccourci clavier associé "CTLR+D"
        menuBar.getDessinItem().addActionListener((ActionEvent ae) -> {
            int dessinPanelIdx = jtp.indexOfComponent(dessinPanel);
            jtp.setSelectedIndex(dessinPanelIdx);
        });

//        // Permet d'afficher le JPanel "Calcul" en cliquant le JMenuItem "Calcul" de la barre des menus
//        // ou en utilisant le raccourci clavier associé "CTLR+C"
//        menuBar.getCalculItem().addActionListener((ActionEvent ae) -> {
//            int calculePanelIdx = jtp.indexOfComponent(calculPanel);
//            jtp.setSelectedIndex(calculePanelIdx);
//        });
//
//        // Permet d'afficher le JPanel "Question" en cliquant le JMenuItem "Question" de la barre des menus
//        // ou en utilisant le raccourci clavier associé "CTLR+Q"
//        menuBar.getQuestionItem().addActionListener((ActionEvent ae) -> {
//            int questionPanelIdx = jtp.indexOfComponent(questionPanel);
//            jtp.setSelectedIndex(questionPanelIdx);
//        });
    }
}
