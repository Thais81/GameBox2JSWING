package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dessin extends JPanel {
    
    JPanel drawPanel, toolPanel;
    JButton delete;
    JLabel colorLabel;
    JLabel titleJLabel;
    JComboBox<Color> colorBox;
    
    public Dessin() {
        initGui();
    }

    private void initGui() {
        // Initialisez les panels et les composants
        drawPanel = new JPanel();
        toolPanel = new JPanel();
        delete = new JButton("Delete");
        colorLabel = new JLabel();

        // Configurez le layout du panel principal
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Configurez le panel de dessin
        drawPanel.setPreferredSize(new Dimension(300, 300));
        drawPanel.setBackground(Color.WHITE);
        this.add(drawPanel);
        
        Color[] options = {Color.RED, Color.BLUE, Color.GREEN};
        colorBox = new JComboBox<>(options);

        // Configurez le panel d'outils
        toolPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        toolPanel.add(delete);
        colorLabel.setText("Color :");
        toolPanel.add(colorLabel);
        toolPanel.add(colorBox);

        this.add(toolPanel);
    }
}
