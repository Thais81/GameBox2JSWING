package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Jopaups
 */
public class DessinFrame extends JFrame {

    Dessin dessin;

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
        JTabbedPane j = new JTabbedPane();
        dessin = new Dessin();
        j.addTab("Dessin", dessin);
        this.getContentPane().add(j);

    }

    private void initEvents() {

    }

}
