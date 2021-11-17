package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener{

    Score(String username,int score){
        setTitle("Score");
        setBounds(300,120,750,500);
        getContentPane().setBackground(Color.black);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/great1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(20, 80, 400, 350);
        add(l1);

        JLabel l2 = new JLabel("Thankyou "+username+" for Playing Time.");
        l2.setBounds(20, 20, 700, 40);
        l2.setForeground(new Color(199, 21, 133));
        l2.setFont(new Font("Jokerman", Font.PLAIN, 28));
        add(l2);

        JLabel l3 = new JLabel("Your Score is "+score);
        l3.setBounds(450, 200, 300, 30);
        l3.setFont(new Font("Jokerman", Font.PLAIN, 30));
        l3.setForeground(new Color(199, 21, 133));
        add(l3);

        JButton b1 = new JButton("Play Again");
        b1.setBackground(new Color(199, 21, 133));
        b1.setForeground(Color.black);
        b1.setBounds(490, 270, 150, 30);
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        b1.addActionListener(this);
        add(b1);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
        new QuizGame().setVisible(true);
    }


    public static void main(String[] args) {

        new Score("",0).setVisible(true);
    }
}
