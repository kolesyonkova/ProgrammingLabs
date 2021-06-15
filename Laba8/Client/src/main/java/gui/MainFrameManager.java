package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrameManager extends JFrame {


    private static MainFrameManager isInstance;

    private MainFrameManager() {
    }

    // the Singleton realization
    public static MainFrameManager getInstance() {
        if (isInstance == null) {
            isInstance = new MainFrameManager();
        }
        return isInstance;
    }

    public void initialization(JPanel startMenuPanel) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(200, 200, dimension.width / 3, dimension.height / 3);
        this.setContentPane(startMenuPanel);
        this.setVisible(true);
    }

    public void switchPanel(JPanel panel) {
        this.setVisible(false);
        try {
            Thread.sleep(1000);
            this.setContentPane(panel);
            this.setVisible(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
