/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package containers;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Guillaume Rostagnat
 */
public class LabelAndField extends JPanel {

    private JLabel label;
    private JTextField textField;
    private String String;

    public LabelAndField(String label, int size) {
        this.setLayout(new BorderLayout());
        this.label = new JLabel(label);
        this.textField = new JTextField(size);
        this.add(this.label, BorderLayout.NORTH);
        this.add(this.textField, BorderLayout.SOUTH);

    }

    public LabelAndField(String label, int size, String toolTip) {
        this(label, size);
        this.textField.setToolTipText(toolTip);
    }

    public JTextField getTextField() {
        return textField;
    }

    public String getString() {
        return String;
    }

    public void setText(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
