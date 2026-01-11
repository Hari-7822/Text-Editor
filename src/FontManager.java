package src;

import java.awt.*;

public class FontManager {
    private Main main;
    private String fontName = "Monospaced";
    private int fontSize = 14;

    public FontManager(Main main) {
        this.main = main;
    }

    public String getMonoFontName() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();
        String[] monoFonts = {"Monospaced", "Courier New", "Consolas", "DejaVu Sans Mono", "Liberation Mono", "Source Code Pro"};
        for (String f : monoFonts) {
            for (String avail : fonts) {
                if (avail.equalsIgnoreCase(f)) return f;
            }
        }
        return "Monospaced";
    }

    public void setFontName(String name) {
        fontName = name;
        updateFont();
    }

    public void setFontSize(int size) {
        fontSize = size;
        updateFont();
    }

    public void increaseFont() {
        fontSize = Math.min(fontSize + 1, 36);
        updateFont();
    }

    public void decreaseFont() {
        fontSize = Math.max(fontSize - 1, 8);
        updateFont();
    }

    public void resetFont() {
        fontSize = 14;
        updateFont();
    }

    private void updateFont() {
        Font f = new Font(fontName, Font.PLAIN, fontSize);
        main.getTextArea().setFont(f);
        UIManager.put("TextArea.font", f);
        SwingUtilities.updateComponentTreeUI(main);
    }
}
