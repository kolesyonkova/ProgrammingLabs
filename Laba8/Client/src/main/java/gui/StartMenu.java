package gui;

import util.Client;
import util.User;

import javax.swing.*;
import java.awt.*;

import static java.awt.GridBagConstraints.*;

public class StartMenu extends JFrame {
    private JPanel startMenuPanel;
    private JLabel name;
    private JTextArea errorText;
    private JLabel loginText;
    private JLabel passwordText;
    private JTextField loginField;
    private JTextField passwordField;
    private JButton signInButton;
    private JButton registerButton;
    private JButton exitButton;

    public StartMenu() {

        initWindow();
        setPositions();
        setActions();
        startMenuPanel.setVisible(true);
    }

    private void initWindow() {
        startMenuPanel = new JPanel();
        name = new JLabel();
        errorText = new JTextArea();
        loginText = new JLabel("Login", SwingConstants.LEFT);
        passwordText = new JLabel("Password", SwingConstants.LEFT);
        loginField = new JTextField();
        passwordField = new JTextField();
        signInButton = new JButton();
        registerButton = new JButton();
        exitButton = new JButton();
    }

    private void setPositions() {
        GridBagLayout general = new GridBagLayout();
        GridBagConstraints table = new GridBagConstraints();

        startMenuPanel.setLayout(general);

        Color c1 = new Color(125, 183, 144);
        Color c2 = new Color(0, 0, 0);
        Color menuBack = new Color(200, 239, 235);
        Font typeText = new Font("Times New Roman", Font.BOLD, 40);
        Font titleText = new Font("Times New Roman", Font.BOLD, 60);


        // init JPanel (start window)
        startMenuPanel.setBackground(menuBack);
        //startMenuPanel.setBounds(100, 100, 200, 100);

        // init label with name of app
        table.gridx = 0;
        table.gridy = 0;
        table.fill = HORIZONTAL;
        table.gridwidth = 3;
        name.setText("Authorization");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.TOP);
        name.setFont(titleText);
        name.setForeground(c1);
        startMenuPanel.add(name, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init text fields with login and password of user
        table.gridx = 0;
        table.gridy = 1;
        table.fill = HORIZONTAL;
        table.ipadx = 80;
        table.gridwidth = 1;
        loginText.setFont(typeText);
        startMenuPanel.add(loginText, table);
        table.gridx = 1;
        table.gridy = 1;
        table.fill = HORIZONTAL;
        table.ipadx = 200;
        table.gridwidth = 2;
        loginField.setFont(typeText);
        startMenuPanel.add(loginField, table);
        table.gridx = 0;
        table.gridy = 2;
        table.fill = HORIZONTAL;
        table.ipadx = 80;
        table.gridwidth = 1;
        passwordText.setFont(typeText);
        startMenuPanel.add(passwordText, table);
        table.gridx = 1;
        table.gridy = 2;
        table.fill = HORIZONTAL;
        table.ipadx = 200;
        table.gridwidth = 2;
        passwordField.setFont(typeText);
        startMenuPanel.add(passwordField, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init button to sign in
        signInButton.setText("Login");
        signInButton.setBackground(c2);
        signInButton.setForeground(c1);
        signInButton.setFont(typeText);
        table.gridx = 1;
        table.gridy = 3;
        table.ipady = 30;
        table.gridwidth = 1;
        startMenuPanel.add(signInButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init button to sign up
        registerButton.setText("Register");
        registerButton.setBackground(c2);
        registerButton.setForeground(c1);
        registerButton.setFont(typeText);
        table.gridx = 2;
        table.gridy = 3;
        table.ipady = 30;
        table.gridwidth = 1;
        startMenuPanel.add(registerButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init button to exit from app
        exitButton.setText("Exit");
        exitButton.setBackground(c2);
        exitButton.setForeground(c1);
        exitButton.setFont(typeText);
        table.gridx = 4;
        table.gridy = 4;
        table.anchor = PAGE_END;
        table.insets = new Insets(100, 0, 0, 0);
        startMenuPanel.add(exitButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init error label
        errorText.setText("");
        errorText.setLineWrap(true);
        errorText.setBackground(menuBack);
        errorText.setForeground(c1);
        errorText.setFont(typeText);
        table.gridx = 0;
        table.gridy = 4;
        table.anchor = PAGE_START;
        table.fill = BOTH;
        table.insets = new Insets(10, 0, 0, 100);
        startMenuPanel.add(errorText, table);
    }

    private void setActions() {

        signInButton.addActionListener(e -> {
            String login = loginField.getText();
            String password = passwordField.getText();
            User user = new User(login, password);
            Client.readyToExchange("login", "", null, user);
            if (Client.getAnswer().equals("Вы успешно вошли!")) {
                MainFrameManager.getInstance().switchPanel(new GeneralMenu().getPanel());
            } else {
                JOptionPane.showMessageDialog(null, Client.getAnswer());
            }
        });

        registerButton.addActionListener(e -> {
            String login = loginField.getText();
            String password = passwordField.getText();
            User user = new User(login, password);
            Client.readyToExchange("register", "", null, user);
            if (Client.getAnswer().equals("Пользователь успешно создан!")) {
                MainFrameManager.getInstance().switchPanel(new GeneralMenu().getPanel());
            } else {
                JOptionPane.showMessageDialog(null, Client.getAnswer());
            }
        });

        exitButton.addActionListener(e -> System.exit(0));
    }


    public JPanel getStartMenuPanel() {
        return startMenuPanel;
    }
}
