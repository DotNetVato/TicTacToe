
package com.raymond;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TicTacToe implements MouseListener {

    private String PLAYER_X = "X";
    private String PLAYER_O = "O";

    private String playerName = PLAYER_X;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    private JLabel playerNumber;
    private java.awt.Panel buttonsPanel;

    protected int trackSquares = 0;

    public void createAndShowGUI() {

        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        frame.setLocationRelativeTo(null);

        buttonsPanel = new java.awt.Panel();
        buttonsPanel.setLayout(new java.awt.GridLayout(3, 3));

        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();

        Font buttonFont = new Font("Times Roman", Font.PLAIN, 72);
        button1.setFont(buttonFont);
        button2.setFont(buttonFont);
        button3.setFont(buttonFont);
        button4.setFont(buttonFont);
        button5.setFont(buttonFont);
        button6.setFont(buttonFont);
        button7.setFont(buttonFont);
        button8.setFont(buttonFont);
        button9.setFont(buttonFont);

        button1.addMouseListener(this);
        button2.addMouseListener(this);
        button3.addMouseListener(this);
        button4.addMouseListener(this);
        button5.addMouseListener(this);
        button6.addMouseListener(this);
        button7.addMouseListener(this);
        button8.addMouseListener(this);
        button9.addMouseListener(this);

        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);
        buttonsPanel.add(button4);
        buttonsPanel.add(button5);
        buttonsPanel.add(button6);
        buttonsPanel.add(button7);
        buttonsPanel.add(button8);
        buttonsPanel.add(button9);

        playerNumber = new JLabel("Player: " + playerName);

        frame.add(buttonsPanel, java.awt.BorderLayout.CENTER);
        frame.add(playerNumber, java.awt.BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void setPlayerName(String playerName) {
        this.playerName = playerName;
        playerNumber.setText("Player: " + playerName + " - squares " + trackSquares);
    }

    public void reset() {
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        setPlayerName(PLAYER_X);
        trackSquares = 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe().createAndShowGUI();
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton currentButton = (JButton) e.getComponent();
        if (currentButton.getText().equals("")) {
            trackSquares++;
            if (playerName.equals(PLAYER_X)) {
                currentButton.setText("X");
                setPlayerName(PLAYER_O);
            } else if (playerName.equals(PLAYER_O)) {
                currentButton.setText("O");
                setPlayerName(PLAYER_X);
            }
        }
        checkForWinner();

    }

    private void checkForWinner() {
        if (findThreeInARow()) {
            String[] str = { "OK" };
            var winnerName = (playerName.equals(PLAYER_X)) ? PLAYER_O : PLAYER_X;
            JOptionPane.showOptionDialog(null, "Player " + winnerName + " wins!", "Game Over",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
            reset();
        }else if (trackSquares == 9) {
            String[] str = { "OK" };
            JOptionPane.showOptionDialog(null, "It's a draw!", "Game Over", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
            reset();
        }
    }

    private boolean findThreeInARow() {
        if (button1.getText().equals(button2.getText()) && button2.getText().equals(button3.getText()) && !button1.getText().equals("") || 
            button4.getText().equals(button5.getText()) && button5.getText().equals(button6.getText()) && !button4.getText().equals("") ||
            button7.getText().equals(button8.getText()) && button8.getText().equals(button9.getText()) && !button7.getText().equals("") ||
            button1.getText().equals(button4.getText()) && button4.getText().equals(button7.getText()) && !button1.getText().equals("") ||
            button2.getText().equals(button5.getText()) && button5.getText().equals(button8.getText()) && !button2.getText().equals("") ||
            button3.getText().equals(button6.getText()) && button6.getText().equals(button9.getText()) && !button3.getText().equals("") ||
            button1.getText().equals(button5.getText()) && button5.getText().equals(button9.getText()) && !button1.getText().equals("") ||
            button3.getText().equals(button5.getText()) && button5.getText().equals(button7.getText()) && !button3.getText().equals("")) {
                return true;
            } else {
                return false;
            }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}