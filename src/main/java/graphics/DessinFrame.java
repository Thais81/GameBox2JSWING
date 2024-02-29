package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
        dessin = new Dessin();
        this.getContentPane().add(dessin);

    }

    private void initEvents() {

    }

}
