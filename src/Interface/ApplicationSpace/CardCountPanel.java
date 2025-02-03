package Interface.ApplicationSpace;

import Interface.Scene.GameScene;

import javax.swing.*;
import java.awt.*;

public class CardCountPanel extends JPanel {
    JLabel labelDealer;
    JLabel labelPlayer;
    public CardCountPanel(Dimension size)
    {
        int panelHeight = 800;
        int panelWidth = 200;
        setBounds((int) size.getWidth() / 2 - panelWidth / 2 - 300, (int) size.getHeight() / 2 - panelHeight / 2, panelWidth, panelHeight);
        setLayout(null);

        labelDealer = new JLabel ();
        labelDealer.setBounds(140, 50, 100, 90);
        labelDealer.setFont(new Font("Serif", Font.BOLD, 30));
        labelDealer.setForeground(Color.black);

        labelPlayer = new JLabel ();
        labelPlayer.setBounds(140, 600, 100, 90);
        labelPlayer.setFont(new Font("Serif", Font.BOLD, 30));
        labelPlayer.setForeground(Color.black);

        add(labelDealer);
        add(labelPlayer);
    }
    public void displayCardCountLabel(int dealerCardCount, int playerCardCount)
    {
        if(dealerCardCount == 0 && playerCardCount == 0)
        {
            labelDealer.setText("");
            labelPlayer.setText("");
        }
        else {
            labelDealer.setText(String.valueOf(dealerCardCount));
            labelPlayer.setText(String.valueOf(playerCardCount));
        }
    }
}
