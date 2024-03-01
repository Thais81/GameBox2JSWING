package graphics;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Jopaups
 */
public class Administration extends JPanel {

    JPanel saveOrUpdatePanel;
    AddPanel addPanel;
    UpdatePanel updatePanel;
    JMenuBar myMenuBar;
    JMenu menu;
    JMenuItem save, update;

    public Administration() {
        initGui();
        initEvents();
    }

    /**
     * Création de JPanel Administration
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

    public void initEvents() {

        save.addActionListener((ActionEvent e) -> {
            CardLayout cardLayout = (CardLayout) saveOrUpdatePanel.getLayout();
            cardLayout.show(saveOrUpdatePanel, "add");
        });

        update.addActionListener((ActionEvent e) -> {
            CardLayout cardLayout = (CardLayout) saveOrUpdatePanel.getLayout();
            cardLayout.show(saveOrUpdatePanel, "update");
        });
    }
}
