package com.supermarket;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginPage{

    public static void main(String[] args) {

        //LOGIN FRAME
        JFrame loginFrame = new JFrame("Log-in");
        loginFrame.setSize(700,400);
        loginFrame.setLayout(null);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Labels
        JLabel title = new JLabel("Welcome to PLM Supermarket!");
        title.setBounds(225, 20, 300,50);
        loginFrame.add(title);

        JLabel userName = new JLabel("Username:");
        userName.setBounds(150, 95, 150,50);
        loginFrame.add(userName);

        JLabel password = new JLabel("Password:");
        password.setBounds(150, 125, 150, 50);
        loginFrame.add(password);

        JLabel menuText = new JLabel("Select an option:");
        menuText.setBounds(150, 75, 150, 20);
        loginFrame.add(menuText);


        //TEXT FIELDS
        JTextField usernameTextField = new JTextField(50);
        usernameTextField.setBounds(220, 110, 300, 20);
        loginFrame.add(usernameTextField);

        JPasswordField passwordTextField = new JPasswordField(50);
        passwordTextField.setBounds(220, 140, 300, 20);
        loginFrame.add(passwordTextField);

        //DROP DOWN MENU
        String[] choices = {"Customer", "Administrator"};
        JComboBox dropDownButton = new JComboBox(choices);
        dropDownButton.setBounds(295, 75, 90, 20);
        dropDownButton.setLayout(null);
        dropDownButton.setVisible(true);
        loginFrame.add(dropDownButton);


        //LOG-IN BUTTON
        JButton login = new JButton("LOG-IN");
        login.setBounds(280, 200, 100, 20);
        loginFrame.add(login);

        login.addActionListener(e -> {
            String username;
            String password1;
            Object menu;
            username = usernameTextField.getText();
            password1 = passwordTextField.getText();
            menu = dropDownButton.getSelectedItem();

            if (username.equals("") && password1.equals("") && menu.equals("Customer")){
                JOptionPane.showMessageDialog(loginFrame, "Welcome, Customer!");
                loginFrame.dispose();
                customer.main(args);
            }
            else if (username.equals("administrator") && password1.equals("12345") && menu.equals("Administrator")){
                JOptionPane.showMessageDialog(loginFrame, " Welcome, Admin!");
                loginFrame.dispose();
                admin.main(args);
            }
            else {
                JOptionPane.showMessageDialog(loginFrame, "Information entered is incorrect. Please Try Again.");
            }
        });

        loginFrame.setVisible(true);
    }
}