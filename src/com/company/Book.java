package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Book extends JFrame implements ActionListener, ItemListener {
    JLabel lbg, hkvm, htrip, lname, lpackage, ldeparture, ldestination;
    JTextField tfname, tfid;
    JButton home, breceipt, btotal, breset, bexit, bview;
    JTextArea ta;
    JCheckBox cti, cel, creturn;
    JComboBox ID, PACKAGE, DEPART, DEST;
    int PRICE[] = new int[10000];
    int iid, idepart, price;
    Double tempprice, classprice, tempclass;
    Color ckvm = new Color(52, 89, 108), ctrip = new Color(238, 40, 102);
    String oid[] = {"Passport:", "Aadhar:"}, opackage[] = {"business", "first class", "premium economy", "economy"}, odepart[] = {"Mumbai", "Prayagraj"}, odest[] = {"Prayagraj", "Mumbai"};
    String sdest[], uname, upass;

    Book(String uname, String upass) {
        this.uname = uname;
        this.upass = upass;
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("aircraft.png"));
        lbg = new JLabel();
//        lbg = new JLabel(img);
        lbg.setBounds(0, 0, 732, 412);
        add(lbg);

        hkvm = new JLabel("kvm");
        hkvm.setFont(new Font("Segoe Script", Font.BOLD, 20));
        hkvm.setForeground(ckvm);
        hkvm.setBounds(161, 0, 47, 32);
        lbg.add(hkvm);

        htrip = new JLabel("Trip");
        htrip.setFont(new Font("Roboto", Font.ITALIC, 20));
        htrip.setForeground(ctrip);
        htrip.setBounds(208, 3, 35, 24);
        lbg.add(htrip);

        home = new JButton(new ImageIcon(ClassLoader.getSystemResource("home.png")));
        home.setBackground(new Color(0x5DB9DB));
        home.setBounds(2, 1, 50, 28);
        home.addActionListener(this);
        lbg.add(home);

        lname = new JLabel("Name:");
        lname.setFont(new Font("Roboto", Font.PLAIN, 25));
        lname.setBounds(11, 40, 85, 32);
        lbg.add(lname);

        tfname = new JTextField(uname);
        tfname.setFont(new Font("Indie Flower", Font.PLAIN, 25));
        tfname.setEditable(false);
        tfname.setBackground(new Color(0x8BCDCD));
        tfname.setBounds(150, 42, 180, 30);
        lbg.add(tfname);

        ID = new JComboBox(oid);
        ID.setFont(new Font("Roboto", Font.PLAIN, 25));
        ID.setBackground(new Color(0x5DB9DB));
        ID.setBounds(11, 98, 132, 32);
        lbg.add(ID);

        tfid = new JTextField("");
        tfid.setFont(new Font("Indie Flower", Font.PLAIN, 25));
        tfid.setBackground(new Color(0x8BCDCD));
        tfid.setBounds(150, 98, 180, 30);
        lbg.add(tfid);

        lpackage = new JLabel("Package:");
        lpackage.setFont(new Font("Roboto", Font.PLAIN, 25));
        lpackage.setBounds(11, 152, 175, 32);
        lbg.add(lpackage);

        PACKAGE = new JComboBox(opackage);
        PACKAGE.setFont(new Font("Roboto", Font.PLAIN, 18));
        PACKAGE.setBackground(new Color(229, 228, 226));
        PACKAGE.setBounds(150, 152, 180, 32);
        lbg.add(PACKAGE);


        DEPART = new JComboBox();
        try {
            String dep = "select * from supply";
            conn conns = new conn();
            PreparedStatement pst = conns.c.prepareStatement(dep);
            ResultSet drs = pst.executeQuery();
            String sdepart[] = new String[100000];
            int i = 1, j = 0;
            while (drs.next()) {
                sdepart[j] = drs.getString("departure");
//                System.out.println(sdepart[j]);
                DEPART.addItem(sdepart[j]);
                PRICE[j] = Integer.parseInt(drs.getString("price"));
//                System.out.println(PRICE[j]);
                i++;
                j++;
            }
            price = PRICE[0];
        } catch (Exception ex) {
            System.out.println(ex);
        }

//        DEPART = new JComboBox(odepart);
        DEPART.setFont(new Font("Roboto", Font.PLAIN, 25));
        DEPART.setForeground((new Color(0x14274E)));
        DEPART.setBackground(new Color(0x8BCDCD));
        DEPART.setBounds(11, 210, 130, 34);
        DEPART.addItemListener(this);
        lbg.add(DEPART);


        DEST = new JComboBox();
        try {
            String dep = "select * from supply";
            conn conns = new conn();
            PreparedStatement pst = conns.c.prepareStatement(dep);
            ResultSet drs = pst.executeQuery();
            sdest = new String[100000];
            int i = 1, j = 0;
            while (drs.next()) {
                sdest[j] = drs.getString("destination");
//                System.out.println(sdest[j]);
                i++;
                j++;
            }
            DEST.addItem(sdest[0]);
        } catch (Exception ex) {
            System.out.println(ex);
        }

//        DEST = new JComboBox(odest);
        DEST.setFont(new Font("Roboto", Font.PLAIN, 25));
        DEST.setForeground((new Color(0x14274E)));
        DEST.setBackground(new Color(0x8BCDCD));
        DEST.setBounds(170, 210, 130, 34);
        lbg.add(DEST);


        cti = new JCheckBox("Travel Insurance");
        cti.setFont(new Font("Itim", Font.PLAIN, 12));
        cti.setBounds(11, 270, 113, 20);
        cti.addItemListener(this);
        lbg.add(cti);

        cel = new JCheckBox("EXtra Luggage");
        cel.setFont(new Font("Itim", Font.PLAIN, 12));
        cel.setBounds(130, 270, 105, 20);
        cel.addItemListener(this);
        lbg.add(cel);

        creturn = new JCheckBox("Return Ticket");
        creturn.setFont(new Font("Itim", Font.PLAIN, 12));
        creturn.setBounds(241, 270, 96, 20);
        creturn.addItemListener(this);
        lbg.add(creturn);

        breceipt = new JButton("Print");
        breceipt.setFont(new Font("Segoe Print", Font.BOLD, 23));
        breceipt.setForeground(new Color(255, 255, 255));
        breceipt.setBackground(new Color(0x8BCDCD));
        breceipt.setBounds(11, 310, 95, 40);
        breceipt.addActionListener(this);
        lbg.add(breceipt);

        btotal = new JButton("Book");
        btotal.setFont(new Font("Segoe Print", Font.BOLD, 23));
        btotal.setForeground(new Color(255, 255, 255));
        btotal.setBackground(new Color(0x8BCDCD));
        btotal.setBounds(110, 310, 95, 40);
        btotal.addActionListener(this);
        lbg.add(btotal);

        breset = new JButton("X");
        breset.setFont(new Font("Segoe Print", Font.BOLD, 23));
        breset.setForeground(new Color(255, 255, 255));
        breset.setBackground(new Color(0x8BCDCD));
        breset.setBounds(210, 310, 60, 40);
        breset.addActionListener(this);
        lbg.add(breset);

        bexit = new JButton("Exit");
        bexit.setFont(new Font("Segoe Print", Font.BOLD, 23));
        bexit.setForeground(new Color(255, 255, 255));
        bexit.setBackground(new Color(0x8BCDCD));
        bexit.setBounds(275, 310, 95, 40);
        bexit.addActionListener(this);
        lbg.add(bexit);

        ta = new JTextArea("\n\n\n\n    Your ticket\n       will be displayed here");
        ta.setEditable(false);
        ta.setFont(new Font("Segoe Script", Font.PLAIN, 16));
        ta.setForeground(new Color(0));
        ta.setBackground(new Color(0xFFFFFF));
        ta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ta.setBounds(385, 40, 335, 280);
        lbg.add(ta);

        JScrollPane scroll = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(380, 35, 340, 285);
        add(scroll);

        bview = new JButton("View");
        bview.setFont(new Font("Segoe Print", Font.BOLD, 23));
        bview.setForeground(new Color(255, 255, 255));
        bview.setBackground(new Color(0x8BCDCD));
        bview.setBounds(500, 330, 100, 40);
        bview.addActionListener(this);
        lbg.add(bview);

        setLayout(null);
        setVisible(true);
        setSize(732, 412);
        getContentPane().setBackground(new Color(0x5DB9DB));
        setLocation(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home) {
            setVisible(false);
            new CustomerLogin();

        }
        if (e.getSource() == bview) {

            try {
                FileReader fr = new FileReader("D:\\JAVA\\Project\\Travel\\src\\confidential\\" + uname + upass + ".txt");
                BufferedReader br = new BufferedReader(fr);
                String line = null;
                String message = new String();
                final StringBuffer buffer = new StringBuffer(10000);
                while ((line = br.readLine()) != null) {
                    // buffer.append(line);
                    message += line + "\n";
                    ta.setText(message);
//                    br.close();
//                    fr.close();
                }
            } catch (Exception exe) {
//                ioException.printStackTrace();
//                ta.setText("\n\n\n\n    No record\n       found");
                System.out.println(exe);
            }
        }
        if (e.getSource() == breset) {
            tfid.setText("");
            ta.setText("\n\n\n\n    Your ticket\n       will be displayed here");
        }
        if (e.getSource() == bexit) {
            JOptionPane.showInputDialog(null, "Write us a review");
            setVisible(false);
        }
        if (e.getSource() == breceipt) {
            if (PACKAGE.getSelectedIndex() == 0) {
                classprice = price + (0.4 * price);
//                System.out.println("selected");
            } else if (PACKAGE.getSelectedIndex() == 1) {
                classprice = price + (0.3 * price);

            } else if (PACKAGE.getSelectedIndex() == 2) {
                classprice = price + (0.2 * price);

            } else if (PACKAGE.getSelectedIndex() == 3) {
                classprice = price + (0.1 * price);

            }

            if (cti.isSelected() && cel.isSelected() && creturn.isSelected()) {
                tempprice = (classprice + 2500 + 1000) * 2;
            } else if (cti.isSelected() && cel.isSelected() && !(creturn.isSelected())) {
                tempprice = (classprice + 2500 + 1000);
            } else if (cel.isSelected() && creturn.isSelected() && !cti.isSelected()) {
                tempprice = (classprice + 1000) * 2;
            } else if (cti.isSelected() && creturn.isSelected() && !cel.isSelected()) {
                tempprice = (classprice + 2500) * 2;
            } else if (cel.isSelected()) {
                tempprice = (classprice + 1000);
            } else if (cti.isSelected()) {
                tempprice = classprice + 2500;
            } else if (creturn.isSelected()) {
                tempprice = classprice * 2;
            } else {
                tempprice = classprice;
            }
            System.out.println(tempprice);


            Double totalprice = tempprice + 999.9;

            try {
                conn c1 = new conn();
                String d = "select * from customer where name = '" + uname + "' and pass = '" + upass + " '";
                ResultSet login = c1.s.executeQuery(d);
                if (login.next()) {
                    ta.setText("            Travel System:\n" +
                            "-------------------------------------------\n" +
                            "Name:       " + uname + "\n" +
                            "Email:     " + login.getString("email") + "\n" +
                            "Phone:     " + login.getString("phone") + "\n" +
                            ID.getSelectedItem() + "     " + tfid.getText() + "\n" +
                            "Tax:           " + "999.9$\n" +
                            "Sub Total:      " + tempprice + "\n" +
                            "Total:         " + totalprice + "$\n" +
                            "-------------------------------------------\n" +
                            "            Thanks for Using ^_^\n" +
                            "           KVM Trip");
                }
            } catch (Exception ex) {
//            e.printStackTrace();
                System.out.println("Error :" + ex);
            }
        }
        if (e.getSource() == btotal) {
            if (!(tfid.getText().equals(""))) {
                if (PACKAGE.getSelectedIndex() == 0) {
                    classprice = price + (0.4 * price);
//                System.out.println("selected");
                } else if (PACKAGE.getSelectedIndex() == 1) {
                    classprice = price + (0.3 * price);

                } else if (PACKAGE.getSelectedIndex() == 2) {
                    classprice = price + (0.2 * price);

                } else if (PACKAGE.getSelectedIndex() == 3) {
                    classprice = price + (0.1 * price);

                }

                if (cti.isSelected() && cel.isSelected() && creturn.isSelected()) {
                    tempprice = (classprice + 2500 + 1000) * 2;
                } else if (cti.isSelected() && cel.isSelected() && !(creturn.isSelected())) {
                    tempprice = (classprice + 2500 + 1000);
                } else if (cel.isSelected() && creturn.isSelected() && !cti.isSelected()) {
                    tempprice = (classprice + 1000) * 2;
                } else if (cti.isSelected() && creturn.isSelected() && !cel.isSelected()) {
                    tempprice = (classprice + 2500) * 2;
                } else if (cel.isSelected()) {
                    tempprice = (classprice + 1000);
                } else if (cti.isSelected()) {
                    tempprice = classprice + 2500;
                } else if (creturn.isSelected()) {
                    tempprice = classprice * 2;
                } else {
                    tempprice = classprice;
                }
//            System.out.println(tempprice);

                Double totalprice = tempprice + 999.9;

                try {
                    conn c1 = new conn();
                    String d = "select * from customer where name = '" + uname + "' and pass = '" + upass + " '";
                    ResultSet login = c1.s.executeQuery(d);
                    if (login.next()) {
                        ta.setText("            Travel System:\n" +
                                "-------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                                "Name:       " + uname + "\n" +
                                "Email:     " + login.getString("email") + "\n" +
                                "Phone:     " + login.getString("phone") + "\n" +
                                ID.getSelectedItem() + "     " + tfid.getText() + "\n" +
                                "Package:   " + PACKAGE.getSelectedItem() + "\n" +
                                "Departure:     " + DEPART.getSelectedItem() + "\n" +
                                "Destination:     " + DEST.getSelectedItem() + "\n" +
                                "Travel Insurance:  " + cti.isSelected() + "\n" +
                                "Extra Luggage:     " + cel.isSelected() + "\n" +
                                "Return Ticket:     " + creturn.isSelected() + "\n" +
                                "Tax:           " + "999.9$\n" +
                                "Sub Total:      " + tempprice + "$\n" +
                                "Total:         " + totalprice + "$\n" +
                                "-------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                                "            Thanks for Using ^_^\n" +
                                "           KVM Trip");
                    }
                } catch (Exception ex) {
//            e.printStackTrace();
                    System.out.println("Error :" + ex);
                }
                try {
                    FileWriter writer = new FileWriter("D:\\JAVA\\Project\\Travel\\src\\confidential\\" + uname + upass + ".txt");
                    BufferedWriter buffer = new BufferedWriter(writer);
                    buffer.write(ta.getText());
                    buffer.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    String addsql = "update customer set book=? where pass='" + upass + " ' and name='" + uname + " '";
                    conn connect = new conn();
                    PreparedStatement stmt = connect.c.prepareStatement(addsql);
                    stmt.setString(1, uname + upass + ".txt");
                    stmt.executeUpdate();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Booked Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Incomplete Details");
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == DEPART) {
            DEST.removeAllItems();
            DEST.addItem(sdest[DEPART.getSelectedIndex()]);
            price = PRICE[DEPART.getSelectedIndex()];
        }
    }
}
