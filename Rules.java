package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {

    JButton b1,b2;
    String username;
    Rules(String username){
        this.username=username;
        setTitle("RULES");
        setBounds(320,100,800,520);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l1 = new JLabel("Hey "+username+"!  Welcome to Quiz Time.");
        l1.setBounds(50,40,700,40);
        l1.setFont(new Font("Times New Roman",Font.BOLD,34));
        l1.setForeground(new Color(50,140,254));
        add(l1);

        JLabel l2 = new JLabel("");
        l2.setBounds(50,100,700,300);
        l2.setFont(new Font("Tahoma",Font.PLAIN,18));
        l2.setText(
                "<html>"+
                        "1. Participation in the quiz is free and open to all persons." + "<br><br>" +
                        "2. Each question holds 10 points." + "<br><br>" +
                        "3. 15 seconds are given for every question." + "<br><br>" +
                        "4. Answer must be given within time otherwise you’ll get zero for that question." + "<br><br>" +
                        "5. Questions are related to general knowledge." + "<br><br>" +
                        "6. Mobile phones are not allowed." + "<br><br>" +
                        "<html>"
        );
        l2.setForeground(Color.black);
        add(l2);

        b1 = new JButton("Back");
        b1.setBounds(250, 400, 100, 40);
        b1.setBackground(new Color(50,140,254));
        b1.setFont(new Font("Mongolian Baiti",Font.PLAIN,20));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Start");
        b2.setBounds(400, 400, 100, 40);
        b2.setBackground(new Color(50,140,254));
        b2.setFont(new Font("Mongolian Baiti",Font.PLAIN,20));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1)
        {
            this.setVisible(false);
            new QuizGame().setVisible(true);
        }
        else if(ae.getSource()==b2)
        {
            this.setVisible(false);
            new Quiz(username).setVisible(true);
        }
    }
    public static void main(String[] args) {

        new Rules("");
    }
}
