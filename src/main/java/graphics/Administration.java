package graphics;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Jopaups
 */
public final class Administration extends JPanel {

    private JPanel saveOrUpdatePanel;
    private AddPanel addPanel;
    private UpdatePanel updatePanel;
    private JMenuBar myMenuBar;
    private JMenu menu;
    private JMenuItem save, update;

    public Administration() {
        initGui();
        initEvents();
    }

    /**
     * Permet la création du JPanel Administration.
     */
    private void initGui() {

        // Initialisation des différents panels et composants
        addPanel = new AddPanel();
        updatePanel = new UpdatePanel();
        saveOrUpdatePanel = new JPanel();
        myMenuBar = new JMenuBar();
        menu = new JMenu("Fichier");
        save = new JMenuItem("Ajouter");
        update = new JMenuItem("Modifier");

        // Ajout des composants dans la JMenuBar
        menu.add(save);
        menu.add(update);
        myMenuBar.add(menu);

        // Configuration du layout du panel principal
        this.setLayout(new BorderLayout());
        saveOrUpdatePanel.setLayout(new CardLayout());
        saveOrUpdatePanel.add(addPanel, "add");
        saveOrUpdatePanel.add(updatePanel, "update");
        this.add(myMenuBar, BorderLayout.NORTH);
        this.add(saveOrUpdatePanel, BorderLayout.CENTER);
    }

    /**
     * Permet la gestion évenementielle des sous-menus "Ajouter" et "Modifier"
     * dans le menu "Fichier" qui change le JPanel affiché grace à un CardLayout
     * On peut passer du JPanel "addPanel" au "updatePanel" et inversement.
     */
    public void initEvents() {

        // Affiche le JPanel "addPanel"
        save.addActionListener((ActionEvent e) -> {
            CardLayout cardLayout = (CardLayout) saveOrUpdatePanel.getLayout();
            cardLayout.show(saveOrUpdatePanel, "add");
        });

        // Affiche le JPanel "updatePanel"
        update.addActionListener((ActionEvent e) -> {
            CardLayout cardLayout = (CardLayout) saveOrUpdatePanel.getLayout();
            cardLayout.show(saveOrUpdatePanel, "update");
        });
    }
}
