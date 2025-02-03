package Interface.ApplicationSpace;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {
    JLabel budget;
    JLabel bet;
    private int betAmount = 100;
    public SettingsPanel(Dimension size)
    {
        int panelHeight = 400;
        int panelWidth = 700;
        setBounds((int) size.getWidth() / 2  - panelWidth / 2, (int) size.getHeight() / 2 - panelHeight / 2, panelWidth, panelHeight);
        Color background = new Color(0xEAB89B);
        setBackground(background);
        setBorder(BorderFactory.createRaisedBevelBorder());
        setLayout(null);

        JLabel budgetText = new JLabel("Budget");
        budgetText.setBounds(295, 30, 150, 90);
        budgetText.setFont(new Font("Serif", Font.BOLD, 30));
        budgetText.setForeground(Color.black);

        JLabel betText = new JLabel("Bet");
        betText.setBounds(315, 150, 150, 90);
        betText.setFont(new Font("Serif", Font.BOLD, 30));
        betText.setForeground(Color.black);

        budget = new JLabel ();
        budget.setBounds(270, 70, 200, 90);
        budget.setFont(new Font("Serif", Font.PLAIN, 30));
        budget.setForeground(Color.black);

        bet = new JLabel ();
        bet.setBounds(280, 190, 200, 90);
        bet.setFont(new Font("Serif", Font.PLAIN, 30));
        bet.setForeground(Color.black);

        JButton clearBet = new JButton("Clear");
        clearBet.setFont(new Font("Serif", Font.BOLD, 12));
        clearBet.setBounds(305, 360, 70, 30);
        clearBet.addActionListener(event ->
        {
            betAmount = 0;
            bet.setText(betAmount + " RON");
        });

        JButton bet5 = new JButton("5");
        bet5.setFont(new Font("Serif", Font.BOLD, 12));
        bet5.setBounds(150, 300, 70, 30);
        bet5.addActionListener(event ->
        {
            betAmount += 5;
            bet.setText(betAmount + " RON");
        });

        JButton bet25 = new JButton("25");
        bet25.setFont(new Font("Serif", Font.BOLD, 12));
        bet25.setBounds(250, 300, 70, 30);
        bet25.addActionListener(event ->
        {
            betAmount += 25;
            bet.setText(betAmount + " RON");
        });

        JButton bet100 = new JButton("100");
        bet100.setFont(new Font("Serif", Font.BOLD, 12));
        bet100.setBounds(350, 300, 70, 30);
        bet100.addActionListener(event ->
        {
            betAmount += 100;
            bet.setText(betAmount + " RON");
        });

        JButton bet500 = new JButton("500");
        bet500.setFont(new Font("Serif", Font.BOLD, 12));
        bet500.setBounds(450, 300, 70, 30);
        bet500.addActionListener(event ->
        {
            betAmount += 500;
            bet.setText(betAmount + " RON");
        });

        add(budgetText);
        add(budget);
        add(betText);
        add(bet);
        add(clearBet);
        add(bet5);
        add(bet25);
        add(bet100);
        add(bet500);

    }

    public void displayBudget(int budget) {
        this.budget.setText(budget + " RON");
        this.bet.setText(betAmount + " RON");
    }

    public void setBetAmount(int amount) {
        betAmount = amount;
    }

    public int getBetAmount() {

        return betAmount;
    }
}


