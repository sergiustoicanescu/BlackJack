package Interface.ApplicationSpace;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {
    JLabel bet;
    public ResultPanel(Dimension size)
    {
        int panelHeight = 200;
        int panelWidth = 400;
        setBounds((int) size.getWidth() / 2  - panelWidth / 2, (int) size.getHeight() / 2 - panelHeight / 2, panelWidth, panelHeight);
        setLayout(null);

        bet = new JLabel ();
        bet.setBounds(50, 50, 300, 90);
        bet.setFont(new Font("Serif", Font.BOLD, 30));

        add(bet);
    }

    public void displayResult(String message, int bet, Color color) {
        if(bet == 0)
            this.bet.setText(message);
        else
            this.bet.setText(message + " " + bet + " RON");
        this.bet.setForeground(color);
    }
}
