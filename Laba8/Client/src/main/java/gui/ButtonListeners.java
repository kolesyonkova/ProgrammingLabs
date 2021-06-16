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

    public static void invokeRemoveFirstCommand() {
        Client.readyToExchange("remove_first", "", null);
        JOptionPane.showMessageDialog(null, Client.getAnswer());
    }

    public static void invokeRemoveByIdCommand() {
        String answer = "";
        try {
            String key = JOptionPane.showInputDialog(null, "Input key(id)");
            Client.readyToExchange("remove_by_id", key, null);

        } catch (Exception e) {
            answer = e.getMessage();
        } finally {
            JOptionPane.showMessageDialog(null, Client.getAnswer());
        }
    }

    public static void invokeRemoveAllByHealthCommand() {
        String answer = "";
        try {
            String key = JOptionPane.showInputDialog(null, "Input key(health)");
            Client.readyToExchange("remove_all_by_health", key, null);

        } catch (Exception e) {
            answer = e.getMessage();
        } finally {
            JOptionPane.showMessageDialog(null, Client.getAnswer());
        }
    }

    public static void invokeRemoveAnyByAchievementsCommand() {
        String answer = "";
        try {
            String key = JOptionPane.showInputDialog(null, "Input key(achievements)");
            Client.readyToExchange("remove_any_by_achievements", key, null);

        } catch (Exception e) {
            answer = e.getMessage();
        } finally {
            JOptionPane.showMessageDialog(null, Client.getAnswer());
        }
    }
}
