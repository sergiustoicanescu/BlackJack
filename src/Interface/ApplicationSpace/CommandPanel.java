package Interface.ApplicationSpace;

import Domain.CommandTypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class CommandPanel extends JPanel {
    JButton startGame;
    JButton resume;
    JButton hit;
    JButton stand;
    JButton Double;
    JButton continueGame;
    JButton startRound;
    JButton exit;
    public CommandPanel(Map<CommandTypes, ActionListener> commands, Dimension size)
    {
        int panelHeight = 75;
        int panelWidth = 800;
        setBounds((int) size.getWidth() / 2 - panelWidth / 2, (int) size.getHeight() - panelHeight, panelWidth, panelHeight);
        startGame = new JButton("Start");
        startGame.addActionListener(commands.get(CommandTypes.StartGame));
        add(startGame);
        resume = new JButton("Resume");
        resume.addActionListener(commands.get(CommandTypes.Resume));
        add(resume);
        Double = new JButton("Double");
        Double.addActionListener(commands.get(CommandTypes.Double));
        add(Double);
        hit = new JButton("Hit");
        hit.addActionListener(commands.get(CommandTypes.Hit));
        add(hit);
        stand = new JButton("Stand");
        stand.addActionListener(commands.get(CommandTypes.Stand));
        add(stand);
        continueGame = new JButton("Continue");
        continueGame.addActionListener(commands.get(CommandTypes.Continue));
        add(continueGame);
        startRound = new JButton("Start Round");
        startRound.addActionListener(commands.get(CommandTypes.StartRound));
        add(startRound);
        exit = new JButton("Exit");
        exit.addActionListener(commands.get(CommandTypes.Exit));
        add(exit);

    }

    public void setVisibleCommands(List<CommandTypes> currentCommands) {
        setVisibility(currentCommands, CommandTypes.StartGame, startGame);
        setVisibility(currentCommands, CommandTypes.Resume, resume);
        setVisibility(currentCommands, CommandTypes.Hit, hit);
        setVisibility(currentCommands, CommandTypes.Stand, stand);
        setVisibility(currentCommands, CommandTypes.Double, Double);
        setVisibility(currentCommands, CommandTypes.Continue, continueGame);
        setVisibility(currentCommands, CommandTypes.StartRound, startRound);
        setVisibility(currentCommands, CommandTypes.Exit, exit);

    }

    private static void setVisibility(List<CommandTypes> currentCommands, CommandTypes buttonType, JButton button) {
        if(currentCommands.stream().anyMatch(e -> e.equals(buttonType)))
        {
            button.setVisible(true);
        }
        else
            button.setVisible(false);
    }
}
