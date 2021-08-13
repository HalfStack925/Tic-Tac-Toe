package com.mikewinchel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Random random = new Random(); //used to determine who goes first
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel(); //title bar
    JPanel buttonPanel = new JPanel();//holds buttons
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1Turn; //true player 1 turn, false player 2 turn


    //constructor
    TicTacToe()  {
        //frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //textField
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        //titlePanel
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);

        //buttonPanel
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));

        //buttons
        for (int i=0; i<9; i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD,120 ));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }


        titlePanel.add(textField);
        frame.add(titlePanel,BorderLayout.NORTH); //keeps title panel at the top
        frame.add(buttonPanel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //checks all 9 buttons everytime one is clicked
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1Turn) {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1Turn = false;
                        textField.setText("O Turn");
                        check();

                    }
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1Turn = true;
                        textField.setText("X Turn");
                        check();
                    }
                }
            }

        }
    }
    //determines who goes first
    public void firstTurn() {

        //pauses thread so title will display
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            if(random.nextInt(2)==0){
            player1Turn = true;
            textField.setText("X Turn");
        }
        else{
            player1Turn = false;
            textField.setText("O Turn");
        }
    }

    //checks if winning condition
    public void check(){

        //check X win conditions
        //if array index match, player wins
        //check X win conditions
        if(     
             //top row horizontal
             (Objects.equals(buttons[0].getText(), "X")) &&
             (Objects.equals(buttons[1].getText(), "X")) &&
             (Objects.equals(buttons[2].getText(), "X"))
        ) {
            xWins(0,1,2);
        }
        if(
            //second row horizontal
             (Objects.equals(buttons[3].getText(), "X")) &&
             (Objects.equals(buttons[4].getText(), "X")) &&
             (Objects.equals(buttons[5].getText(), "X"))
        ) {
            xWins(3,4,5);
        }
        if(
             //third row horizontal
             (Objects.equals(buttons[6].getText(), "X")) &&
             (Objects.equals(buttons[7].getText(), "X")) &&
             (Objects.equals(buttons[8].getText(), "X"))
        ) {
            xWins(6,7,8);
        }
        if(
            //first row vertical 
            (Objects.equals(buttons[0].getText(), "X")) &&
            (Objects.equals(buttons[3].getText(), "X")) &&
            (Objects.equals(buttons[6].getText(), "X"))
        ) {
            xWins(0,3,6);
        }
        if(
            //second row vertical
            (Objects.equals(buttons[1].getText(), "X")) &&
            (Objects.equals(buttons[4].getText(), "X")) &&
            (Objects.equals(buttons[7].getText(), "X"))
        ) {
            xWins(1,4,7);
        }
        if(
            //third row vertical    
            (Objects.equals(buttons[2].getText(), "X")) &&
            (Objects.equals(buttons[5].getText(), "X")) &&
            (Objects.equals(buttons[8].getText(), "X"))
        ) {
            xWins(2,5,8);
        }
        if(
            //diagonal top left bottom right     
            (Objects.equals(buttons[0].getText(), "X")) &&
            (Objects.equals(buttons[4].getText(), "X")) &&
            (Objects.equals(buttons[8].getText(), "X"))
        ) {
            xWins(0,4,8);
        }
        if(
            //diagonal top right bottom left 
            (Objects.equals(buttons[2].getText(), "X")) &&
            (Objects.equals(buttons[4].getText(), "X")) &&
            (Objects.equals(buttons[6].getText(), "X"))
        ) {
            xWins(2,4,6);
        }
        //check O win conditions

        if(
            //top row horizontal
            (Objects.equals(buttons[0].getText(), "O")) &&
            (Objects.equals(buttons[1].getText(), "O")) &&
            (Objects.equals(buttons[2].getText(), "O"))
        ) {
            oWins(0,1,2);
        }
        if(
            //second row horizontal
            (Objects.equals(buttons[3].getText(), "O")) &&
            (Objects.equals(buttons[4].getText(), "O")) &&
            (Objects.equals(buttons[5].getText(), "O"))
        ) {
            oWins(3,4,5);
        }
        if(
            //third row horizontal
            (Objects.equals(buttons[6].getText(), "O")) &&
            (Objects.equals(buttons[7].getText(), "O")) &&
            (Objects.equals(buttons[8].getText(), "O"))
        ) {
            oWins(6,7,8);
        }
        if(
            //first row vertical 
            (Objects.equals(buttons[0].getText(), "O")) &&
            (Objects.equals(buttons[3].getText(), "O")) &&
            (Objects.equals(buttons[6].getText(), "O"))
        ) {
            oWins(0,3,6);
        }
        if(
            //second row vertical
            (Objects.equals(buttons[1].getText(), "O")) &&
            (Objects.equals(buttons[4].getText(), "O")) &&
            (Objects.equals(buttons[7].getText(), "O"))
        ) {
            oWins(1,4,7);
        }
        if(
            //third row vertical    
            (Objects.equals(buttons[2].getText(), "O")) &&
            (Objects.equals(buttons[5].getText(), "O")) &&
            (Objects.equals(buttons[8].getText(), "O"))
        ) {
            oWins(2,5,8);
        }
        if(
            //diagonal top left bottom right     
            (Objects.equals(buttons[0].getText(), "O")) &&
            (Objects.equals(buttons[4].getText(), "O")) &&
            (Objects.equals(buttons[8].getText(), "O"))
        ) {
            oWins(0,4,8);
        }
        if(
            //diagonal top right bottom left 
            (Objects.equals(buttons[2].getText(), "O")) &&
            (Objects.equals(buttons[4].getText(), "O")) &&
            (Objects.equals(buttons[6].getText(), "O"))
        ) {
            oWins(2,4,6);
        }

}

    //if X wins
    public void xWins(int a, int b, int c){
        //changes winning buttons to green
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        //disables all buttons
        for (int i=0;i<9;i++){
            buttons[i].setEnabled(false);
            textField.setText("X Wins!");
        }


    }

    //if O wins
    public void oWins(int a, int b, int c){
        //changes winning buttons to green
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        //disables all buttons
        for (int i=0;i<9;i++){
            buttons[i].setEnabled(false);
            textField.setText("O Wins!");
        }

    }
}
