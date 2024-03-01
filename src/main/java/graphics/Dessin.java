package graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
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

    private JPanel drawPanel, toolPanel;
    JButton delete;
    private JLabel colorLabel;
    private Color currentColor;
    private final String[] options = {"Noir", "Rouge", "Bleu", "Vert"};
    private JComboBox<String> colorBox;
    private int x, y = 0;

    public Dessin() {
        initGui();
        initEvents();
    }

    /**
     * Création de JPanel Dessin
     */
    private void initGui() {
        // Initialisation des différents panels et composants
        drawPanel = new JPanel();
        toolPanel = new JPanel();
        delete = new JButton("Delete");
        colorLabel = new JLabel();
        colorBox = new JComboBox<>(options);

        // Configuration du layout du panel principal
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Configuration duJPanel drawPanel
        drawPanel.setPreferredSize(new Dimension(500, 800));
        drawPanel.setBackground(Color.WHITE);

        // Configuration duJPanel toolPanel
        toolPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        colorLabel.setText("Color :");
        colorBox.setRenderer(new ColorBoxRenderer());

        // Ajout des composants dans le JPanel toolPanel
        toolPanel.add(delete);
        toolPanel.add(colorLabel);
        toolPanel.add(colorBox);

        // Ajout des composants dans le panel principal
        this.add(drawPanel);
        this.add(toolPanel);
    }

    /**
     * Permet de récupérer une couleur par rapport à un texte
     *
     * @param text
     * @return La couleur associée au texte
     */
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

    /**
     * Création des fonctions asssociés au JPanel Dessin
     */
    private void initEvents() {

        /**
         * Permet dessiner avec la souris
         */
        drawPanel.addMouseMotionListener(new MouseMotionListener() {

            /**
             * Permet de suivre le mouvement de la souris
             *
             * @param me
             */
            @Override
            public void mouseMoved(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

            /**
             * Permet de tracer une ligne entre deux points parcourus par la
             * souris à partir du moment où le bouton gauche est enfoncé,
             * jusqu'à son relachement
             *
             * @param e
             */
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = drawPanel.getGraphics();
                g.setColor(currentColor);
                g.drawLine(x, y, e.getX(), e.getY());
                x = e.getX();
                y = e.getY();
            }
        });

        /**
         * Lance la fonction clearDrawPanel quand le JButton delete est pressé
         */
        delete.addActionListener((ae) -> {
            clearDrawPanel();
        });

        /**
         * Mise à jour de la couleur du trait par sélection de la couleur
         * correspondante dans le menu déroulant de la JComboBox colorBox
         */
        colorBox.addActionListener(e -> {
            String selectedColor = (String) colorBox.getSelectedItem();
            currentColor = getColorFromText(selectedColor);
        });
    }

    /**
     * Réinitialise le JPanel drawPanel afin d'avoir une nouvelle zone de dessin
     */
    private void clearDrawPanel() {
        Graphics g = drawPanel.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, drawPanel.getWidth(), drawPanel.getHeight());
    }

    /**
     * Classe qui permet de mettre un fond coloré au texte de selection des
     * couleurs dans le menu déroulant JComboBox colorBox, selon la couleur
     * sélectionnée. Les deux fonctions qu'elle contient permettent de retouter
     * la couleur voulue.
     */
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
    }

    private Color getContrastColor(Color color) {
        int luminance = (int) (0.299 * color.getRed() + 0.587 * color.getGreen() + 0.114 * color.getBlue());
        return luminance > 128 ? Color.BLACK : Color.WHITE;
    }
}
