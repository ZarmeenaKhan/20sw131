package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizGame extends JFrame implements ActionListener {

    JButton b1,b2;
    JTextField t1;

    QuizGame() {
        setTitle("QUIZ APPLICATION");
        setBounds(235, 120, 900, 460);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/Aliyah.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,420,420);
        add(l1);

        JLabel l2 = new JLabel("QUIZ TIME");
        l2.setFont(new Font("ALGERIAN",Font.BOLD,70));
        l2.setForeground(new Color(50,140,254));
        l2.setBounds(480,60,400,70);
        add(l2);

        JLabel l3 = new JLabel("Enter your name");
        l3.setFont(new Font("Mongolian Baiti",Font.BOLD,25));
        l3.setForeground(new Color(50,140,254));
        l3.setBounds(570,180,200,30);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(533,230,250,30);
        t1.setFont(new Font("Times New Roman",Font.PLAIN,18));
        add(t1);

        b1 = new JButton("RULES");
        b1.setBounds(533,290,110,35);
        b1.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        b1.setBackground(new Color(50,140,254));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("EXIT");
        b2.setBounds(675,290,110,35);
        b2.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        b2.setBackground(new Color(50,140,254));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1)
        {
            String name = t1.getText();
            this.setVisible(false);
            new Rules(name);
        }
        else
        {
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        new QuizGame();
    }
}