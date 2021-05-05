package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class supply extends JFrame implements ActionListener {
    JLabel hkvm, htrip, lbg, lfooter, lfkvm, lbuck, ldepart, ldest;
    JTextField tfdepart, tfdest, tfbuck;
    JButton home, add;
    Color ckvm = new Color(52, 89, 108), ctrip = new Color(238, 40, 102);

    supply() {

        hkvm = new JLabel("kvm");
        hkvm.setFont(new Font("Segoe Script", Font.BOLD, 20));
        hkvm.setForeground(ckvm);
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

        ldepart = new JLabel("Departure: ");
        ldepart.setFont(new Font("Roboto", Font.PLAIN, 25));
        ldepart.setBounds(14, 340, 154, 32);
        add(ldepart);

        tfdepart = new JTextField("London");
        tfdepart.setFont(new Font("Indie Flower", Font.PLAIN, 25));
        tfdepart.setBackground(new Color(0x8BCDCD));
        tfdepart.setBounds(8, 380, 382, 30);
        add(tfdepart);

        ldest = new JLabel("Destination: ");
        ldest.setFont(new Font("Roboto", Font.PLAIN, 25));
        ldest.setBounds(14, 420, 154, 32);
        add(ldest);

        tfdest = new JTextField("Georgia");
        tfdest.setFont(new Font("Indie Flower", Font.PLAIN, 25));
        tfdest.setBackground(new Color(0x8BCDCD));
        tfdest.setBounds(8, 460, 382, 30);
        add(tfdest);

        lbuck = new JLabel("Price: ");
        lbuck.setFont(new Font("Roboto", Font.PLAIN, 25));
        lbuck.setBounds(14, 500, 154, 32);
        add(lbuck);

        tfbuck = new JTextField("2500");
        tfbuck.setFont(new Font("Indie Flower", Font.PLAIN, 25));
        tfbuck.setBackground(new Color(0x8BCDCD));
        tfbuck.setBounds(8, 540, 382, 30);
        add(tfbuck);

        add = new JButton("Add");
        add.setFont(new Font("Roboto", Font.BOLD, 20));
        add.setBackground(new Color(112, 173, 181));
        add.setForeground(new Color(19, 39, 67));
        add.setBounds(141, 598, 100, 50);
        add.addActionListener(this);
        add(add);

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
            new InventorySupplierLogin();
        }
        if (e.getSource() == add) {
            try {
                conn connect = new conn();
                String udepart = tfdepart.getText();
                String udest = tfdest.getText();
                String uprice = tfbuck.getText();
                String q1 = "insert into supply values('" + udepart + "','" + udest + "','" + uprice + "')";
                connect.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Data inserted successfully");
                setVisible(false);
                new supply();
            } catch (Exception ee) {
//            e.printStackTrace();
                System.out.println("Error :" + ee);
            }

        }
    }
}