package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.GridBagConstraints.*;

public class SpaceMarinePanel extends JFrame {
    private JPanel startMenuPanel;
    private JLabel name;
    private JLabel nameOfMarine;
    private JLabel coordinateX;
    private JLabel coordinateY;
    private JLabel health;
    private JLabel heartCount;
    private JLabel meleeWeapon;
    private JLabel nameOfChapter;
    private JLabel parentLegion;
    private JLabel marinesCount;
    private JLabel nameOfWorld;
    private JTextField nameOfMarineField;
    private JTextField coordinateXField;
    private JTextField coordinateYField;
    private JTextField healthField;
    private JTextField heartCountField;
    private JTextField meleeWeaponField;
    private JTextField nameOfChapterField;
    private JTextField parentLegionField;
    private JTextField marinesCountField;
    private JTextField nameOfWorldField;
    private JButton createButton;
    private JButton registerButton;
    private JButton exitButton;
    private JTextArea errorText;

    public SpaceMarinePanel() {

        initWindow();
        setPositions();
        setActions();
        startMenuPanel.setVisible(true);
    }

    private void initWindow() {
        startMenuPanel = new JPanel();
        name = new JLabel();
        errorText = new JTextArea();
        nameOfMarine = new JLabel("Name of SpaceMarine: ", SwingConstants.LEFT);
        coordinateX = new JLabel("Coordinate X: ", SwingConstants.LEFT);
        coordinateY = new JLabel("Coordinate Y: ", SwingConstants.LEFT);
        health = new JLabel("Health : ", SwingConstants.LEFT);
        heartCount = new JLabel("HeartCount : ", SwingConstants.LEFT);
        meleeWeapon = new JLabel("meleeWeapon : ", SwingConstants.LEFT);
        nameOfChapter = new JLabel("nameOfChapter : ", SwingConstants.LEFT);
        parentLegion = new JLabel("parentLegion : ", SwingConstants.LEFT);
        marinesCount = new JLabel("marinesCount : ", SwingConstants.LEFT);
        nameOfWorld = new JLabel("nameOfWorld : ", SwingConstants.LEFT);
        nameOfMarineField = new JTextField();
        coordinateXField = new JTextField();
        coordinateYField = new JTextField();
        healthField = new JTextField();
        heartCountField = new JTextField();
        meleeWeaponField = new JTextField();
        nameOfChapterField = new JTextField();
        parentLegionField = new JTextField();
        marinesCountField = new JTextField();
        nameOfWorldField = new JTextField();
        createButton = new JButton();
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
        table.gridwidth = 4;
        name.setText("Create SpaceMarine");
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
        nameOfMarine.setFont(typeText);
        startMenuPanel.add(nameOfMarine, table);
        table.gridx = 1;
        table.gridy = 1;
        table.fill = HORIZONTAL;
        table.ipadx = 200;
        table.gridwidth = 2;
        nameOfMarineField.setFont(typeText);
        startMenuPanel.add(nameOfMarineField, table);
        table.gridx = 0;
        table.gridy = 2;
        table.fill = HORIZONTAL;
        table.ipadx = 80;
        table.gridwidth = 1;
        coordinateX.setFont(typeText);
        startMenuPanel.add(coordinateX, table);
        table.gridx = 1;
        table.gridy = 2;
        table.fill = HORIZONTAL;
        table.ipadx = 200;
        table.gridwidth = 2;
        coordinateXField.setFont(typeText);
        startMenuPanel.add(coordinateXField, table);
        table.gridx = 0;
        table.gridy = 3;
        table.fill = HORIZONTAL;
        table.ipadx = 80;
        table.gridwidth = 1;
        coordinateY.setFont(typeText);
        startMenuPanel.add(coordinateY, table);
        table.gridx = 1;
        table.gridy = 3;
        table.fill = HORIZONTAL;
        table.ipadx = 200;
        table.gridwidth = 2;
        coordinateYField.setFont(typeText);
        startMenuPanel.add(coordinateYField, table);
        table.gridx = 0;
        table.gridy = 4;
        table.fill = HORIZONTAL;
        table.ipadx = 80;
        table.gridwidth = 1;
        health.setFont(typeText);
        startMenuPanel.add(health, table);
        table.gridx = 1;
        table.gridy = 4;
        table.fill = HORIZONTAL;
        table.ipadx = 200;
        table.gridwidth = 2;
        healthField.setFont(typeText);
        startMenuPanel.add(healthField, table);
        table.gridx = 0;
        table.gridy = 5;
        table.fill = HORIZONTAL;
        table.ipadx = 80;
        table.gridwidth = 1;
        heartCount.setFont(typeText);
        startMenuPanel.add(heartCount, table);
        table.gridx = 1;
        table.gridy = 5;
        table.fill = HORIZONTAL;
        table.ipadx = 200;
        table.gridwidth = 2;
        heartCountField.setFont(typeText);
        startMenuPanel.add(heartCountField, table);
        table.gridx = 0;
        table.gridy = 6;
        table.fill = HORIZONTAL;
        table.ipadx = 80;
        table.gridwidth = 1;
        meleeWeapon.setFont(typeText);
        startMenuPanel.add(meleeWeapon, table);
        table.gridx = 1;
        table.gridy = 6;
        table.fill = HORIZONTAL;
        table.ipadx = 200;
        table.gridwidth = 2;
        meleeWeaponField.setFont(typeText);
        startMenuPanel.add(meleeWeaponField, table);
        table.gridx = 0;
        table.gridy = 7;
        table.fill = HORIZONTAL;
        table.ipadx = 80;
        table.gridwidth = 1;
        nameOfChapter.setFont(typeText);
        startMenuPanel.add(nameOfChapter, table);
        table.gridx = 1;
        table.gridy = 7;
        table.fill = HORIZONTAL;
        table.ipadx = 200;
        table.gridwidth = 2;
        nameOfChapterField.setFont(typeText);
        startMenuPanel.add(nameOfChapterField, table);
        table.gridx = 0;
        table.gridy = 8;
        table.fill = HORIZONTAL;
        table.ipadx = 80;
        table.gridwidth = 1;
        parentLegion.setFont(typeText);
        startMenuPanel.add(parentLegion, table);
        table.gridx = 1;
        table.gridy = 8;
        table.fill = HORIZONTAL;
        table.ipadx = 200;
        table.gridwidth = 2;
        parentLegionField.setFont(typeText);
        startMenuPanel.add(parentLegionField, table);
        table.gridx = 0;
        table.gridy = 9;
        table.fill = HORIZONTAL;
        table.ipadx = 80;
        table.gridwidth = 1;
        marinesCount.setFont(typeText);
        startMenuPanel.add(marinesCount, table);
        table.gridx = 1;
        table.gridy = 9;
        table.fill = HORIZONTAL;
        table.ipadx = 200;
        table.gridwidth = 2;
        marinesCountField.setFont(typeText);
        startMenuPanel.add(marinesCountField, table);
        table.gridx = 0;
        table.gridy = 10;
        table.fill = HORIZONTAL;
        table.ipadx = 80;
        table.gridwidth = 1;
        nameOfWorld.setFont(typeText);
        startMenuPanel.add(nameOfWorld, table);
        table.gridx = 1;
        table.gridy = 10;
        table.fill = HORIZONTAL;
        table.ipadx = 200;
        table.gridwidth = 2;
        nameOfWorldField.setFont(typeText);
        startMenuPanel.add(nameOfWorldField, table);
        table = new GridBagConstraints(); // reset Constraints settings
        // init button to sign in
        createButton.setText("Create SpaceMarine");
        createButton.setBackground(c2);
        createButton.setForeground(c1);
        createButton.setFont(typeText);
        table.gridx = 0;
        table.gridy = 11;
        table.ipady = 30;
        table.gridwidth = 1;
        startMenuPanel.add(createButton, table);
//
//        table = new GridBagConstraints(); // reset Constraints settings
//        // init button to sign up
//        registerButton.setText("Register");
//        registerButton.setBackground(c2);
//        registerButton.setForeground(c1);
//        registerButton.setFont(typeText);
//        table.gridx = 2;
//        table.gridy = 3;
//        table.ipady = 30;
//        table.gridwidth = 1;
//        startMenuPanel.add(registerButton, table);
//
        table = new GridBagConstraints(); // reset Constraints settings
        // init button to exit from app
        exitButton.setText("Exit");
        exitButton.setBackground(c2);
        exitButton.setForeground(c1);
        exitButton.setFont(typeText);
        table.gridx = 3;
        table.gridy = 12;
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
        table.gridy = 12;
        table.anchor = PAGE_START;
        table.fill = BOTH;
        table.insets = new Insets(10, 0, 0, 100);
        startMenuPanel.add(errorText, table);
    }

    private void setActions() {
        // sign in button listener
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorText.setText("Login!");
            }

        });

        // sign up button listener
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorText.setText("Register!");
            }
        });

        // exit button listener
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public JPanel getPanel() {
        return startMenuPanel;
    }
}
