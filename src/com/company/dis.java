package com.company;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dis extends JFrame implements ActionListener {
    JLabel hkvm, htrip;
    JTextField lsearch;
    JButton home, bsearch;
    JTable table;
    Color ckvm = new Color(52, 89, 108), ctrip = new Color(238, 40, 102);
    String value = "";

    dis() {
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

        lsearch = new JTextField();
        lsearch.setFont(new Font("Indie Flower", Font.PLAIN, 35));
        lsearch.setBackground(new Color(0x8BCDCD));
        lsearch.setBounds(8, 50, 303, 60);
        add(lsearch);

        bsearch = new JButton(new ImageIcon(ClassLoader.getSystemResource("Icon ionic-md-search.png")));
        bsearch.setBackground(new Color(0x8BCDCD));
        bsearch.setBounds(325, 50, 60, 60);
        bsearch.addActionListener(this);
        add(bsearch);

        table = new JTable();
        table.setBounds(10, 150, 380, 500);
        try {
            conn c = new conn();

            String displayCustomersql = "select name,email,phone from inventory";
            ResultSet rs = c.s.executeQuery(displayCustomersql);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        add(table);

        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(5, 145, 385, 505);
        add(scrollPane);

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
            new admin();
        }
        if (e.getSource() == bsearch) {
            value = lsearch.getText();
            try {
                conn con = new conn();
                PreparedStatement st = con.c.prepareStatement("select name,email,phone from inventory where name=?");
                st.setString(1, value);
                ResultSet rs = st.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
//                JOptionPane.showMessageDialog(null, "Record not Found");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}