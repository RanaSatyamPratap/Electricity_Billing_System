package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {
    Choice loginAscho;
    TextField meterText, EmployerText, usernameText, nameText, passwordText;
    JButton createButton, backButton;

    Signup() {
        super("SignUp");
        getContentPane().setBackground(new Color(168, 203, 255));

        JLabel createAs = new JLabel("Create Account As");
        createAs.setBounds(30, 50, 125, 20);
        add(createAs);

        loginAscho = new Choice();
        loginAscho.add("Admin");
        loginAscho.add("Customer");
        loginAscho.setBounds(170, 50, 125, 20);
        add(loginAscho);

        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(30, 100, 125, 20);
        meterNo.setVisible(false);
        add(meterNo);

        meterText = new TextField();
        meterText.setBounds(170, 100, 125, 20);
        meterText.setVisible(false);
        add(meterText);

        JLabel Employer = new JLabel("Employer ID");
        Employer.setBounds(30, 100, 125, 20);
        Employer.setVisible(true);
        add(Employer);

        EmployerText = new TextField();
        EmployerText.setBounds(170, 100, 125, 20);
        EmployerText.setVisible(true);
        add(EmployerText);

        JLabel Username = new JLabel("Username");
        Username.setBounds(30, 140, 125, 20);
        add(Username);

        usernameText = new TextField();
        usernameText.setBounds(170, 140, 125, 20);
        add(usernameText);

        JLabel Name = new JLabel("Name");
        Name.setBounds(30, 180, 125, 20);
        add(Name);

        nameText = new TextField("");
        nameText.setBounds(170, 180, 125, 20);
        add(nameText);

        meterText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    database c = new database();
                    ResultSet resultSet = c.statement.executeQuery("SELECT * FROM Signup WHERE meter_no = '" + meterText.getText() + "'");
                    if (resultSet.next()) {
                        nameText.setText(resultSet.getString("name"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JLabel Password = new JLabel("Password");
        Password.setBounds(30, 220, 125, 20);
        add(Password);

        passwordText = new TextField();
        passwordText.setBounds(170, 220, 125, 20);
        add(passwordText);

        loginAscho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = loginAscho.getSelectedItem();
                if (user.equals("Customer")) {
                    Employer.setVisible(false);
                    EmployerText.setVisible(false);
                    nameText.setEditable(false);
                    meterNo.setVisible(true);
                    meterText.setVisible(true);
                } else {
                    Employer.setVisible(true);
                    EmployerText.setVisible(true);
                    meterNo.setVisible(false);
                    meterText.setVisible(false);
                }
            }
        });

        createButton = new JButton("Create");
        createButton.setBackground(new Color(33, 150, 243));
        createButton.setForeground(new Color(0, 0, 0));
        createButton.setBounds(50, 285, 120, 25);
        createButton.addActionListener(this);
        add(createButton);

        backButton = new JButton("Back");
        backButton.setBackground(new Color(33, 150, 243));
        backButton.setForeground(new Color(0, 0, 0));
        backButton.setBounds(180, 285, 120, 25);
        backButton.addActionListener(this);
        add(backButton);

        ImageIcon boyIcon = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image boyImg = boyIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon boyIcon2 = new ImageIcon(boyImg);
        JLabel boylabel = new JLabel(boyIcon2);
        boylabel.setBounds(320, 30, 250, 250);
        add(boylabel);

        setSize(600, 380);
        setLocation(500, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            String sloginAs = loginAscho.getSelectedItem();
            String suserName = usernameText.getText();
            String sname = nameText.getText();
            String spassword = passwordText.getText();
            String smeter = meterText.getText();
            try {
                database c = new database();
                String query;

                if (sloginAs.equals("Admin")) {
                    query = "INSERT INTO Signup (meter_no, username, name, password, usertype) VALUES ('" + smeter + "', '" + suserName + "', '" + sname + "', '" + spassword + "', '" + sloginAs + "')";
                } else {
                    query = "UPDATE Signup SET username = '" + suserName + "', password = '" + spassword + "', usertype = '" + sloginAs + "' WHERE meter_no = '" + smeter + "'";
                }
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created");
                setVisible(false);
                new Login();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == backButton) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
