package graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class Dessin extends JPanel {

    JPanel drawPanel, toolPanel;
    JButton delete;
    JLabel colorLabel;
    JLabel titleJLabel;
    JComboBox<String> colorBox;
    int x, y = 0;

    public Dessin() {
        initGui();
        initEvents();
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

        String[] options = {"Rouge", "Bleu", "Vert"};
        colorBox = new JComboBox<>(options);

        // Configurez le panel d'outils
        toolPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        toolPanel.add(delete);
        colorLabel.setText("Color :");
        toolPanel.add(colorLabel);
        colorBox.setRenderer(new ColorBoxRenderer());
        toolPanel.add(colorBox);

        this.add(toolPanel);
    }

    private void initEvents() {
        drawPanel.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseMoved(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = drawPanel.getGraphics();
                g.drawLine(x, y, e.getX(), e.getY());
                x = e.getX();
                y = e.getY();
            }
        });
    }

    private class ColorBoxRenderer extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value != null) {
                String text = value.toString();
                Color color = getColorFromText(text);
                renderer.setBackground(color);
                renderer.setForeground(getContrastColor(color));
            }

            return renderer;
        }

        private Color getColorFromText(String text) {
            switch (text) {
                case "Rouge":
                    return Color.RED;
                case "Bleu":
                    return Color.BLUE;
                case "Vert":
                    return Color.GREEN;
                default:
                    return Color.BLACK;
            }
        }

        private Color getContrastColor(Color color) {
            int luminance = (int) (0.299 * color.getRed() + 0.587 * color.getGreen() + 0.114 * color.getBlue());
            return luminance > 128 ? Color.BLACK : Color.WHITE;
        }
    }
}
