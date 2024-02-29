package graphics;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

/**
 *
 * @author Jopaups
 */
public class DessinFrame extends JFrame {

    Dessin dessinpanel;

    public DessinFrame() {
        super();
        initGui();
        initEvents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void initGui() {
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JMenuBar jmb = new JMenuBar();
        JMenu activites = new JMenu("Activités");
        JMenu administration = new JMenu("Administration");
        JMenuItem dessinItem = new JMenuItem("Dessin");
        JMenuItem calculItem = new JMenuItem("Calcul");
        JMenuItem questionItem = new JMenuItem("Question");

        activites.add(dessinItem);
        activites.add(calculItem);
        activites.add(questionItem);
        jmb.add(activites);
        jmb.add(administration);

        JTabbedPane jTabbedPane = new JTabbedPane();
        dessinpanel = new Dessin();
        jTabbedPane.addTab("Dessin", dessinpanel);

        this.setJMenuBar(jmb);
        this.getContentPane().add(jTabbedPane);
    }

    private void initEvents() {

    }

}
