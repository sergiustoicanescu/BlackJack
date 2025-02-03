package Interface.ApplicationSpace;

import Interface.Scene.Scene;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class NamePanel extends JPanel{
    public NamePanel(Dimension size)
    {
        int panelHeight = 300;
        int panelWidth = 800;
        setBounds((int) size.getWidth() / 2 - panelWidth / 2, (int) size.getHeight() / 2 - panelHeight / 2, panelWidth, panelHeight);
        JLabel label = new JLabel("BLACKJACK");
        label.setFont(new Font("Serif", Font.BOLD, 100));
        label.setForeground(Color.black);
        add(label);
    }
}
