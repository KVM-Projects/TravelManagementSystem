package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventorySupplierSignUp extends JFrame implements ActionListener {
    JLabel hkvm, htrip, lbg, lname, lemail, lphone, lpassword;
    JButton home, signUp, login, submit;
    JTextField tfname, tfemail, tfphone, tfpassword;
    Color ckvm = new Color(52, 89, 108), ctrip = new Color(238, 40, 102);

    InventorySupplierSignUp() {
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

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("eiffel_tower.png"));
        lbg = new JLabel(img);
        lbg.setBounds(0, 32, 412, 263);
        add(lbg);

        signUp = new JButton("SignUP");
        signUp.setFont(new Font("Segoe Print", Font.BOLD, 20));
        signUp.setForeground(new Color(255, 255, 255));
        signUp.setBackground(new Color(0x14274E));
        signUp.setEnabled(false);
        signUp.setBounds(0, 295, 206, 50);
        add(signUp);

        login = new JButton("Login");
        login.setFont(new Font("Segoe Print", Font.BOLD, 20));
        login.setForeground(new Color(0x14274E));
        login.setBackground(new Color(0x5DB9DB));
        login.setBounds(206, 295, 206, 50);
        login.addActionListener(this);
        add(login);

        lname = new JLabel("Enter Name: ");
        lname.setFont(new Font("Roboto", Font.PLAIN, 25));
        lname.setBounds(14, 350, 154, 32);
        add(lname);

        tfname = new JTextField("Kaustubh Mishra");
        tfname.setFont(new Font("Indie Flower", Font.PLAIN, 25));
        tfname.setBackground(new Color(0x8BCDCD));
        tfname.setBounds(8, 380, 382, 30);
        add(tfname);

        lemail = new JLabel("Enter Email: ");
        lemail.setFont(new Font("Roboto", Font.PLAIN, 25));
        lemail.setBounds(14, 420, 154, 32);
        add(lemail);

        tfemail = new JTextField("8956.kaustubh.secomb@gmail.com");
        tfemail.setFont(new Font("Indie Flower", Font.PLAIN, 25));
        tfemail.setBackground(new Color(0x8BCDCD));
        tfemail.setBounds(8, 450, 382, 30);
        add(tfemail);

        lphone = new JLabel("Enter Phone No.: ");
        lphone.setFont(new Font("Roboto", Font.PLAIN, 25));
        lphone.setBounds(14, 490, 204, 32);
        add(lphone);

        tfphone = new JTextField("7796850929");
        tfphone.setFont(new Font("Indie Flower", Font.PLAIN, 25));
        tfphone.setBackground(new Color(0x8BCDCD));
        tfphone.setBounds(8, 520, 382, 30);
        add(tfphone);

        lpassword = new JLabel("Enter Password: ");
        lpassword.setFont(new Font("Roboto", Font.PLAIN, 25));
        lpassword.setBounds(14, 560, 204, 32);
        add(lpassword);

        tfpassword = new JTextField("1618518141");
        tfpassword.setFont(new Font("Indie Flower", Font.PLAIN, 25));
        tfpassword.setBackground(new Color(0x8BCDCD));
        tfpassword.setBounds(8, 590, 382, 30);
        add(tfpassword);

        submit = new JButton("Submit");
        submit.setFont(new Font("Patric Hand", Font.BOLD, 25));
        submit.setForeground(new Color(0x070D59));
        submit.setBackground(new Color(139, 205, 205));
        submit.setBounds(130, 640, 150, 50);
        submit.addActionListener(this);
        add(submit);

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
            new Home();
        } else if (e.getSource() == login) {
            setVisible(false);
            new InventorySupplierLogin();
        } else if (e.getSource() == submit) {
            if (tfname.getText().equals("") || tfemail.getText().equals("") || tfphone.getText().equals("") || tfpassword.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Incomplete data");
            } else {
                try {
                    conn connect = new conn();
                    String uname = tfname.getText();
                    String uemail = tfemail.getText();
                    String uphone = tfphone.getText();
                    String upass = tfpassword.getText();
                    String q1 = "insert into inventory values('" + uname + "','" + uemail + "','" + uphone + "','" + upass + "')";
                    connect.s.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Data inserted successfully");
                    setVisible(false);
                    new InventorySupplierLogin();
                } catch (Exception ee) {
//            e.printStackTrace();
                    System.out.println("Error :" + ee);
                }
            }
        }
    }
}