package gui;

import util.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.GridBagConstraints.BOTH;
import static java.awt.GridBagConstraints.PAGE_END;

public class GeneralMenu extends JFrame {
    private JPanel generalMenuPanel;
    public JPanel logPanel;
    public JLabel clientHello;
    public JTextArea logText;
    public JTextField logInput;
    public JButton helpButton;
    public JButton infoButton;
    public JButton showButton;
    public JButton addButton;
    public JButton updateButton;
    public JButton removeByIdButton;
    public JButton clearButton;
    public JButton executeScriptButton;
    public JButton removeFirstButton;
    public JButton historyButton;
    public JButton removeGreaterButton;
    public JButton removeAnyByAchievementsButton;
    public JButton groupCountingByIdButton;
    public JButton removeAllByHealthButton;
    public JButton backToRegistrationButton;
    public JButton exitButton;

    public GeneralMenu() {
        initWindow();
        setPosition();
        setActions();
        generalMenuPanel.setVisible(true);
    }

    private void initWindow() {
        generalMenuPanel = new JPanel();
        logPanel = new JPanel();
        clientHello = new JLabel();
        logText = new JTextArea();
        logInput = new JTextField();
        helpButton = new JButton();
        infoButton = new JButton();
        showButton = new JButton();
        addButton = new JButton();
        updateButton = new JButton();
        removeByIdButton = new JButton();
        clearButton = new JButton();
        executeScriptButton = new JButton();
        removeFirstButton = new JButton();
        historyButton = new JButton();
        removeGreaterButton = new JButton();
        removeAnyByAchievementsButton = new JButton();
        groupCountingByIdButton = new JButton();
        removeAllByHealthButton = new JButton();
        backToRegistrationButton = new JButton();
        exitButton = new JButton();
    }

    private void setPosition() {
        GridBagLayout general = new GridBagLayout();
        GridBagConstraints table;

        generalMenuPanel.setLayout(general);

        Color c1 = new Color(0, 0, 0);
        Color c2 = new Color(125, 183, 144);
        Font typeText = new Font("Arial Black", Font.PLAIN, 30);
        Font titleText = new Font("Arial Black", Font.PLAIN, 60);


        // init JPanel (general window)
        generalMenuPanel.setBackground(new Color(200, 239, 235));

        table = new GridBagConstraints(); // reset Constraints settings
        // init label about client
        clientHello.setText("Nice to see you, " + Client.getUser().getLogin());
        clientHello.setBackground(c2);
        clientHello.setForeground(c1);
        clientHello.setFont(titleText);
        clientHello.setVerticalTextPosition(SwingConstants.TOP);
        table.gridx = 0;
        table.gridy = 0;
        table.gridwidth = 5;
        table.weightx = 1.0;
        table.weighty = 0.2;
        generalMenuPanel.add(clientHello, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init help button
        helpButton.setText("help");
        helpButton.setBackground(c2);
        helpButton.setForeground(c1);
        helpButton.setFont(typeText);
        table.gridx = 0;
        table.gridy = 1;
        table.weightx = 1.0;
        table.weighty = 1.0;
        table.fill = BOTH;
        generalMenuPanel.add(helpButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init info button
        infoButton.setText("info");
        infoButton.setBackground(c2);
        infoButton.setForeground(c1);
        infoButton.setFont(typeText);
        table.gridx = 1;
        table.gridy = 1;
        table.weightx = 1.0;
        table.weighty = 1.0;
        table.fill = BOTH;
        generalMenuPanel.add(infoButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init show button
        showButton.setText("show");
        showButton.setBackground(c2);
        showButton.setForeground(c1);
        showButton.setFont(typeText);
        table.gridx = 2;
        table.gridy = 1;
        table.weightx = 1.0;
        table.weighty = 1.0;
        table.fill = BOTH;
        generalMenuPanel.add(showButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init insert button
        addButton.setText("add");
        addButton.setBackground(c2);
        addButton.setForeground(c1);
        addButton.setFont(typeText);
        table.gridx = 3;
        table.gridy = 1;
        table.weightx = 1.0;
        table.weighty = 1.0;
        table.fill = BOTH;
        generalMenuPanel.add(addButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init update button
        updateButton.setText("update");
        updateButton.setBackground(c2);
        updateButton.setForeground(c1);
        updateButton.setFont(typeText);
        table.gridx = 4;
        table.gridy = 1;
        table.weightx = 1.0;
        table.weighty = 1.0;
        table.fill = BOTH;
        generalMenuPanel.add(updateButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init removeByIdButton button
        removeByIdButton.setText("remove_by_id");
        removeByIdButton.setBackground(c2);
        removeByIdButton.setForeground(c1);
        removeByIdButton.setFont(typeText);
        table.gridx = 0;
        table.gridy = 2;
        table.weightx = 1.0;
        table.weighty = 1.0;
        table.fill = BOTH;
        generalMenuPanel.add(removeByIdButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init clear button
        clearButton.setText("clear");
        clearButton.setBackground(c2);
        clearButton.setForeground(c1);
        clearButton.setFont(typeText);
        table.gridx = 1;
        table.gridy = 2;
        table.weightx = 1.0;
        table.weighty = 1.0;
        table.fill = BOTH;
        generalMenuPanel.add(clearButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init execute script button
        executeScriptButton.setText("execute_script");
        executeScriptButton.setBackground(c2);
        executeScriptButton.setForeground(c1);
        executeScriptButton.setFont(typeText);
        table.gridx = 2;
        table.gridy = 2;
        table.weightx = 1.0;
        table.weighty = 1.0;
        table.fill = BOTH;
        generalMenuPanel.add(executeScriptButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init remove lower area button
        removeFirstButton.setText("remove_first");
        removeFirstButton.setBackground(c2);
        removeFirstButton.setForeground(c1);
        removeFirstButton.setFont(typeText);
        table.gridx = 3;
        table.gridy = 2;
        table.weightx = 1.0;
        table.weighty = 1.0;
        table.fill = BOTH;
        generalMenuPanel.add(removeFirstButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init history button
        historyButton.setText("history");
        historyButton.setBackground(c2);
        historyButton.setForeground(c1);
        historyButton.setFont(typeText);
        table.gridx = 4;
        table.gridy = 2;
        table.weightx = 1.0;
        table.weighty = 1.0;
        table.fill = BOTH;
        generalMenuPanel.add(historyButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init replace if lower button
        removeGreaterButton.setText("remove_greater");
        removeGreaterButton.setBackground(c2);
        removeGreaterButton.setForeground(c1);
        removeGreaterButton.setFont(typeText);
        table.gridx = 0;
        table.gridy = 3;
        table.weightx = 1.0;
        table.weighty = 1.0;
        table.fill = BOTH;
        generalMenuPanel.add(removeGreaterButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init min by id button
        removeAnyByAchievementsButton.setText("remove_any_by_achievements");
        removeAnyByAchievementsButton.setBackground(c2);
        removeAnyByAchievementsButton.setForeground(c1);
        removeAnyByAchievementsButton.setFont(typeText);
        table.gridx = 1;
        table.gridy = 3;
        table.weightx = 1.0;
        table.fill = BOTH;
        generalMenuPanel.add(removeAnyByAchievementsButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init count less than number of bathrooms button
        groupCountingByIdButton.setText("group_counting_by_id");
        groupCountingByIdButton.setBackground(c2);
        groupCountingByIdButton.setForeground(c1);
        groupCountingByIdButton.setFont(typeText);
        table.gridx = 2;
        table.gridy = 3;
        table.weightx = 1.0;
        table.fill = BOTH;
        generalMenuPanel.add(groupCountingByIdButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init filter starts by name button
        removeAllByHealthButton.setText("remove_all_by_health");
        removeAllByHealthButton.setBackground(c2);
        removeAllByHealthButton.setForeground(c1);
        removeAllByHealthButton.setFont(typeText);
        table.gridx = 3;
        table.gridy = 3;
        table.weightx = 1.0;
        table.fill = BOTH;
        generalMenuPanel.add(removeAllByHealthButton, table);

        table = new GridBagConstraints(); // reset Constraints settings
        // init back to registration button
        backToRegistrationButton.setText("Back");
        backToRegistrationButton.setBackground(c2);
        backToRegistrationButton.setForeground(c1);
        backToRegistrationButton.setFont(typeText);
        table.gridx = 4;
        table.gridy = 3;
        table.weightx = 1.0;
        table.fill = BOTH;
        generalMenuPanel.add(backToRegistrationButton, table);


        table = new GridBagConstraints(); // reset Constraints settings
        // init exit button
        exitButton.setText("Exit");
        exitButton.setBackground(c2);
        exitButton.setForeground(c1);
        exitButton.setFont(typeText);
        table.gridx = 4;
        table.gridy = 5;
        table.weightx = 1.0;
        table.fill = BOTH;
        table.anchor = PAGE_END;
        table.insets = new Insets(10, 0, 0, 0);
        generalMenuPanel.add(exitButton, table);
    }

    public void setActions() {
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonListeners.invokeHelpCommand();
            }
        });
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonListeners.invokeHistoryCommand();
            }
        });
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonListeners.invokeInfoCommand();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonListeners.invokeClearCommand();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(-1);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonListeners.invokeAddCommand();
            }
        });
        removeFirstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonListeners.invokeRemoveFirstCommand();
            }
        });
        removeByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonListeners.invokeRemoveByIdCommand();
            }
        });
        removeAllByHealthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonListeners.invokeRemoveAllByHealthCommand();
            }
        });
        removeAnyByAchievementsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonListeners.invokeRemoveAnyByAchievementsCommand();
            }
        });
        backToRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameManager.getInstance().switchPanel(new GeneralMenu().getPanel());
            }
        });


    }

    public JPanel getPanel() {
        return generalMenuPanel;
    }
}
