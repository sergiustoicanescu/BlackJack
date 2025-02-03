package Interface.Tool;

import Interface.ApplicationSpace.ApplicationSpace;

import javax.swing.*;
import java.awt.*;

public class Message extends JDialog {
    private void setSize(JDialog dialog)
    {
        int width = 400;
        int height = 200;
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setBounds(size.width / 2 - width / 2, size.height / 2 - height / 2,width, height);
    }
    public void reshuffle(ApplicationSpace applicationSpace)
    {
        JDialog dialog = new JDialog(applicationSpace, "Reshuffle", ModalityType.APPLICATION_MODAL);
        setSize(dialog);
        dialog.setUndecorated(true);
        dialog.setLayout(null);

        JLabel text = new JLabel("Reshuffling...");
        text.setBounds(110, 55, 250, 90);
        text.setFont(new Font("Serif", Font.BOLD, 30));
        text.setForeground(Color.black);
        dialog.add(text);

        Timer timer = new Timer(5000, e -> {
            dialog.setVisible(false);
            dialog.dispose();
        });
        timer.setRepeats(false);
        timer.start();

        dialog.setVisible(true);
    }
}
