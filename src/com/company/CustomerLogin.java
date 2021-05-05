package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerLogin extends JFrame implements ActionListener {
    JLabel hkvm, htrip, lbg, lname, lpassword;
    JButton home, signUp, login, submit;
    JTextField tfname;
    JPasswordField tfpassword;
    Color ckvm = new Color(52, 89, 108), ctrip = new Color(238, 40, 102);

    CustomerLogin() {
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
        signUp.setForeground(new Color(0x14274E));
        signUp.setBackground(new Color(0x5DB9DB));
        signUp.setBounds(0, 295, 206, 50);
        signUp.addActionListener(this);
        add(signUp);

        login = new JButton("Login");
        login.setFont(new Font("Segoe Print", Font.BOLD, 20));
        login.setForeground(new Color(255, 255, 255));
        login.setBackground(new Color(0x14274E));
        login.setEnabled(false);
        login.setBounds(206, 295, 206, 50);
        add(login);

        lname = new JLabel("Enter Name: ");
        lname.setFont(new Font("Roboto", Font.PLAIN, 25));
        lname.setBounds(14, 350, 154, 32);
        add(lname);

        tfname = new JTextField("kaustubh mishra");
        tfname.setFont(new Font("Indie Flower", Font.PLAIN, 25));
        tfname.setBackground(new Color(0x8BCDCD));
        tfname.setBounds(8, 400, 382, 50);
        add(tfname);

        lpassword = new JLabel("Enter Password: ");
        lpassword.setFont(new Font("Roboto", Font.PLAIN, 25));
        lpassword.setBounds(14, 500, 204, 32);
        add(lpassword);

        tfpassword = new JPasswordField("1618518141");
        tfpassword.setFont(new Font("Indie Flower", Font.PLAIN, 25));
        tfpassword.setBackground(new Color(0x8BCDCD));
        tfpassword.setBounds(8, 550, 382, 50);
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
        } else if (e.getSource() == signUp) {
            setVisible(false);
            new CustomerSignUp();
        } else if (e.getSource() == submit) {
            try {
                conn c1 = new conn();
                String uname = tfname.getText();
                String upass = tfpassword.getText();
                String d = "select * from customer where name = '" + uname + "' and pass = '" + upass + " '";
                ResultSet rs = c1.s.executeQuery(d);
                if (rs.next()) {
                    setVisible(false);
                    new Book(uname, upass);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials");
                }
            } catch (Exception ee) {
//            e.printStackTrace();
                System.out.println("Error :" + ee);
            }
        }
    }
}