package src;

import javax.swing.*;
import java.awt.*;

public class ThemeManager {
    private Main main;
    private boolean darkMode;

    public ThemeManager(Main main) {
        this.main = main;
    }

    public void lightTheme() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            darkMode = false;
            SwingUtilities.updateComponentTreeUI(main);
            main.updateFont();
        } catch (Exception ex) {
            main.showError("Light theme failed");
        }
    }

    public void darkTheme() {
        UIManager.put("TextArea.background", Color.DARK_GRAY);
        UIManager.put("TextArea.foreground", Color.WHITE);
        UIManager.put("TextArea.selectionBackground", new Color(100, 150, 255));
        UIManager.put("TextArea.selectionForeground", Color.BLACK);
        UIManager.put("Panel.background", Color.DARK_GRAY);
        UIManager.put("MenuBar.background", Color.GRAY);
        UIManager.put("Menu.background", Color.GRAY);
        UIManager.put("Menu.foreground", Color.WHITE);
        UIManager.put("MenuItem.background", Color.GRAY);
        UIManager.put("MenuItem.foreground", Color.WHITE);
        UIManager.put("RadioButtonMenuItem.foreground", Color.WHITE);
        darkMode = true;
        SwingUtilities.updateComponentTreeUI(main);
        main.updateFont();
    }
}
