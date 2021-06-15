package gui;


import util.Client;

import javax.swing.*;
import java.util.Scanner;

public abstract class ButtonListeners {
    public static Scanner scanner = new Scanner(System.in);

    public static void invokeHelpCommand() {
        Client.readyToExchange("help", "", null);
        JOptionPane.showMessageDialog(null, Client.getAnswer());
    }

    public static void invokeInfoCommand() {
        Client.readyToExchange("info", "", null);
        JOptionPane.showMessageDialog(null, Client.getAnswer());
    }

    public static void invokeClearCommand() {
        Client.readyToExchange("clear", "", null);
        JOptionPane.showMessageDialog(null, Client.getAnswer());
    }


    public static void invokeHistoryCommand() {
        Client.readyToExchange("history", "", null);
        JOptionPane.showMessageDialog(null, Client.getAnswer());
    }

    public static void invokeAddCommand() {
        MainFrameManager.getInstance().switchPanel(new SpaceMarinePanel().getPanel());
    }
}
