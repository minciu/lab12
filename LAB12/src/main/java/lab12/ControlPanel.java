package lab12;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ControlPanel extends JPanel {

	private void className(){
        JLabel label = new JLabel("Specify class name");

        JTextArea shape = new JTextArea(1,10);
    
        Font font = new Font(
                Font.MONOSPACED,
                Font.PLAIN,
                shape.getFont().getSize());
        shape.setFont(font);
        add(label);
        add(shape);

    }
}
