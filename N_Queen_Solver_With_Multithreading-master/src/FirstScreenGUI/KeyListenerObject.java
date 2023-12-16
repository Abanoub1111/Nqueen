package FirstScreenGUI;

import static FirstScreenGUI.InputScreen.CAN_STOP;
import static FirstScreenGUI.InputScreen.N;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class KeyListenerObject implements KeyListener {

    public javax.swing.JTextField input;
    public JFrame frame;

    KeyListenerObject(javax.swing.JTextField input, JFrame frame) {
        this.input = input;
        this.frame = frame;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int n = 0;
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            String inputx = input.getText();
            try {
                n = Integer.parseInt(inputx);
            } catch (Exception ex) {
            }
            if (!(n == (int) n) || n < 4 || n > 15) {
                JOptionPane.showMessageDialog(frame, "You should enter an integer number bigger than 3 and smaller than 16");
                this.input.setText("");
            } else {
                N = n;
                CAN_STOP = true;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
