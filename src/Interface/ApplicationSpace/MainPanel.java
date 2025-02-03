package Interface.ApplicationSpace;

import Interface.Scene.Scene;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    Scene scene;

    public MainPanel(Scene _scene, Dimension size)
    {
        scene = _scene;
        setSize(size);
    }
    public void paint(Graphics g) {
        super.paintComponents(g);
        setDoubleBuffered(true);
        scene.draw(g);
    }
}
