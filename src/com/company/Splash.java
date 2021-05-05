package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {
    JLabel lkvm, ltrip, li, lfooter, lfkvm;
    JButton bJoinUs;
    Color ckvm = new Color(52, 89, 108), ctrip = new Color(238, 40, 102);

    Splash() {
        super("              Travel Management System");
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("blue.jpeg"));
        li = new JLabel(img);
        li.setBackground(Color.YELLOW);
        li.setBounds(0, 0, 412, 665);
        add(li);

        lfooter = new JLabel("Made with love | developed by");
        lfooter.setFont(new Font("Roboto", Font.PLAIN, 20));
        lfooter.setForeground(Color.WHITE);
        lfooter.setBounds(30, 655, 300, 50);
        add(lfooter);

        lfkvm = new JLabel("kvm");
        lfkvm.setFont(new Font("Segoe Script", Font.BOLD, 20));
        lfkvm.setForeground(Color.WHITE);
        lfkvm.setBounds(300, 655, 150, 50);
        add(lfkvm);

        lkvm = new JLabel("kvm");
        lkvm.setFont(new Font("Segoe Script", Font.BOLD, 50));
        lkvm.setForeground(ckvm);
        lkvm.setBounds(100, 266, 117, 50);
        li.add(lkvm);

        ltrip = new JLabel("Trip");
        ltrip.setFont(new Font("Roboto", Font.BOLD, 40));
        ltrip.setForeground(ctrip);
        ltrip.setBounds(220, 266, 100, 50);
        li.add(ltrip);

        bJoinUs = new JButton("Join Us");
        bJoinUs.setFont(new Font("Roboto", Font.BOLD, 20));
        bJoinUs.setBackground(new Color(112, 173, 181));
        bJoinUs.setForeground(new Color(19, 39, 67));
        bJoinUs.setBounds(125, 366, 150, 50);
        bJoinUs.addActionListener(this);
        add(bJoinUs);


        setLocation(500, 50);
        setSize(412, 732);
        getContentPane().setBackground(new Color(52, 89, 108));
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bJoinUs) {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}

