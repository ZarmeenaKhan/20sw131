package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

    JButton next,lifeline,submit;
    public static int count = 0;
    public static int timer = 15;
    public static int ans_given=0;
    public static int score = 0;
    JLabel qno,question;
    String q[][] = new String[10][5];
    String pa[][]= new String[10][1];
    String qa[][]= new String[10][2];
    JRadioButton opt1,opt2,opt3,opt4;
    ButtonGroup options;
    String username;

    Quiz(String username){
        this.username=username;
        setTitle("Quiz");
        setBounds(120, 20, 1036, 700);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/xyz1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 370, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(10,0,1000,350);
        add(l1);

        qno = new JLabel("");
        qno.setBounds(70,380,100,30);
        qno.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(qno);

        question = new JLabel("");
        question.setBounds(98,380,700,30);
        question.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(question);

        q[0][0] = "Which one is the smallest ocean in the World?";
        q[0][1] = "Indian";
        q[0][2] = "Arctic";
        q[0][3] = "Pacific";
        q[0][4] = "Atlantic";

        q[1][0] = "Dead sea is located between which two countries?";
        q[1][1] = "Jordan and Israel";
        q[1][2] = "Jordan and Sudan";
        q[1][3] = "Turkey and UAE";
        q[1][4] = "UAE and Egypt";

        q[2][0] = "Which country is known as the “Playground of Europe?";
        q[2][1] = "Switzerland";
        q[2][2] = "Holland";
        q[2][3] = "Austria";
        q[2][4] = "Italy";

        q[3][0] = "Which continent has the highest number of countries?";
        q[3][1] = "Asia";
        q[3][2] = "North America";
        q[3][3] = "Africa";
        q[3][4] = "Europe";

        q[4][0] = "Total number of oceans in the world?";
        q[4][1] = "12";
        q[4][2] = "7";
        q[4][3] = "3";
        q[4][4] = "5";

        q[5][0] = "Only continent without desert is?";
        q[5][1] = "Asia";
        q[5][2] = "Europe";
        q[5][3] = "Africa";
        q[5][4] = "North America";

        q[6][0] = "Which country has the highest number of time zones?";
        q[6][1] = "France";
        q[6][2] = "China";
        q[6][3] = "Russia";
        q[6][4] = "England";

        q[7][0] = "Which country has the highest Muslim population in the world?";
        q[7][1] = "Pakistan";
        q[7][2] = "Indonesia";
        q[7][3] = "Iran";
        q[7][4] = "Morocco";

        q[8][0] = "Yen is the currency of which country?";
        q[8][1] = "Japan";
        q[8][2] = "Malaysia";
        q[8][3] = "North Korea";
        q[8][4] = "South Korea";

        q[9][0] = "International Women’s Day is celebrated on?";
        q[9][1] = "8th March";
        q[9][2] = "5th April";
        q[9][3] = "9th December";
        q[9][4] = "26th January";


        qa[0][1] = "Arctic";
        qa[1][1] = "Jordan and Israel";
        qa[2][1] = "Switzerland";
        qa[3][1] = "Africa";
        qa[4][1] = "5";
        qa[5][1] = "Europe";
        qa[6][1] = "France";
        qa[7][1] = "Indonesia";
        qa[8][1] = "Japan";
        qa[9][1] = "8th March";


        opt1 = new JRadioButton("");
        opt1.setBounds(70, 420, 400, 30);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt1.setBackground(Color.WHITE);
        add(opt1);

        opt2 = new JRadioButton("");
        opt2.setBounds(70, 460, 400, 30);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt2.setBackground(Color.WHITE);
        add(opt2);

        opt3 = new JRadioButton("");
        opt3.setBounds(70, 500, 400, 30);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt3.setBackground(Color.WHITE);
        add(opt3);

        opt4 = new JRadioButton("");
        opt4.setBounds(70, 540, 400, 30);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt4.setBackground(Color.WHITE);
        add(opt4);

        options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);

        next = new JButton("Next");
        next.setFont(new Font("Tahoma", Font.PLAIN, 18));
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.setBounds(800, 490, 150, 40);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.setBounds(800, 540, 150, 40);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);


        start(0);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            repaint();
            ans_given=1;
            if(options.getSelection()==null){
                pa[count][0]="";
            }
            else{
                pa[count][0]=options.getSelection().getActionCommand();
            }
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }

        else if(ae.getSource()==submit){
            if (options.getSelection() == null) {
                pa[count][0] = "";
            } else {
                pa[count][0] = options.getSelection().getActionCommand();
            }

            for (int i = 0; i < pa.length; i++) {

                if (pa[i][0].equals(qa[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            this.setVisible(false);
            new Score(username,score).setVisible(true);
        }

    }

    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time left - " + timer;
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman", Font.BOLD, 28));

        if (timer > 0) {
            g.drawString(time, 800, 440);
        } else {
            g.drawString("Times Up!", 800, 440);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given=0;
            timer = 15;
        }
        if (timer < 0) {
            timer = 15;

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                if (options.getSelection() == null) {
                    pa[count][0] = "";
                } else {
                    pa[count][0] = options.getSelection().getActionCommand();
                }

                for (int i = 0; i < pa.length; i++) {

                    if (pa[i][0].equals(qa[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                this.setVisible(false);
                new Score(username,score).setVisible(true);
            }
            else{
                if (options.getSelection() == null) {
                    pa[count][0] = "";
                } else {
                    pa[count][0] = options.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }

        }
    }
    public void start(int count){
        qno.setText(""+(count+1)+".");
        question.setText(q[count][0]);
        opt1.setLabel(q[count][1]);
        opt1.setActionCommand(q[count][1]);
        opt2.setLabel(q[count][2]);
        opt2.setActionCommand(q[count][2]);
        opt3.setLabel(q[count][3]);
        opt3.setActionCommand(q[count][3]);
        opt4.setLabel(q[count][4]);
        opt4.setActionCommand(q[count][4]);
        options.clearSelection();

    }

    public static void main(String[] args) {

        new Quiz("").setVisible(true);
    }
}
