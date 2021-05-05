package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JLabel lbg, lfooter, lfkvm, hkvm, htrip;
    JButton badmin, bis, buser;
    Color ckvm = new Color(52, 89, 108), ctrip = new Color(238, 40, 102);

    Home() {
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("vert.png"));
        lbg = new JLabel(imageIcon);
        lbg.setBounds(0, 0, 412, 665);
        add(lbg);

        hkvm = new JLabel("kvm");
        hkvm.setFont(new Font("Segoe Script", Font.BOLD, 50));
        hkvm.setForeground(ckvm);
        hkvm.setBounds(179, 0, 150, 50);
        lbg.add(hkvm);

        htrip = new JLabel("Trip");
        htrip.setFont(new Font("Roboto", Font.BOLD, 40));
        htrip.setForeground(ctrip);
        htrip.setBounds(299, 0, 100, 50);
        lbg.add(htrip);

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

        badmin = new JButton("Administrator");
        badmin.setFont(new Font("Roboto", Font.BOLD, 25));
        badmin.setForeground(new Color(81, 173, 207));
        badmin.setBackground(new Color(0x323643));
        badmin.setBounds(10, 405, 302, 50);
        badmin.addActionListener(this);
        lbg.add(badmin);

        bis = new JButton("Inventory Supplier");
        bis.setFont(new Font("Roboto", Font.BOLD, 25));
        bis.setForeground(new Color(81, 173, 207));
        bis.setBackground(new Color(0x323643));
        bis.setBounds(10, 475, 302, 50);
        bis.addActionListener(this);
        lbg.add(bis);

        buser = new JButton("Customer");
        buser.setFont(new Font("Roboto", Font.BOLD, 25));
        buser.setForeground(new Color(81, 173, 207));
        buser.setBackground(new Color(0x323643));
        buser.setBounds(10, 545, 302, 50);
        buser.addActionListener(this);
        lbg.add(buser);

        setLayout(null);
        setSize(412, 732);
        setLocation(500, 50);
        getContentPane().setBackground(new Color(52, 89, 108));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == badmin) {
            setVisible(false);
            new AdminLogin();
        } else if (e.getSource() == bis) {
            setVisible(false);
            new InventorySupplierLogin();
        } else if (e.getSource() == buser) {
            setVisible(false);
            new CustomerLogin();
        }
    }
}
