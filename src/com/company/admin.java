package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin extends JFrame implements ActionListener {
    JLabel hkvm, htrip, lbg, lfooter, lfkvm;
    JButton home, bcustomer, bIS;
    Color ckvm = new Color(52, 89, 108), ctrip = new Color(238, 40, 102);

    admin() {
        hkvm = new JLabel("kvm");
        hkvm.setFont(new Font("Segoe Script", Font.BOLD, 20));
        hkvm.setForeground(new Color(255, 255, 255));
        hkvm.setBounds(161, 0, 47, 32);
        add(hkvm);

        htrip = new JLabel("Trip");
        htrip.setFont(new Font("Roboto", Font.ITALIC, 20));
        htrip.setForeground(ctrip);
        htrip.setBounds(208, 3, 35, 24);
        add(htrip);

        home = new JButton(new ImageIcon(ClassLoader.getSystemResource("home.png")));
        home.setBackground(new Color(0x5DB9DB));
        home.setBounds(2, 1, 50, 28);
        home.addActionListener(this);
        add(home);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("shome.png"));
        lbg = new JLabel(img);
        lbg.setBounds(0, 32, 412, 263);
        add(lbg);

        bcustomer = new JButton(new ImageIcon(ClassLoader.getSystemResource("Customer.png")));
        bcustomer.setBackground(new Color(0x5DB9DB));
        bcustomer.setBounds(100, 357, 200, 80);
        bcustomer.addActionListener(this);
        add(bcustomer);

        bIS = new JButton(new ImageIcon(ClassLoader.getSystemResource("IS.png")));
        bIS.setBackground(new Color(0x5DB9DB));
        bIS.setBounds(100, 470, 200, 80);
        bIS.addActionListener(this);
        add(bIS);

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

        setLayout(null);
        setSize(412, 732);
        setLocation(500, 50);
        getContentPane().setBackground(new Color(0x5DB9DB));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home) {
            setVisible(false);
            new AdminLogin();
        }
        if (e.getSource() == bcustomer) {
            setVisible(false);
            new dcustomer();
        }
        if (e.getSource() == bIS) {
            setVisible(false);
            new dis();
        }
    }
}