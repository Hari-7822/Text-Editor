package src;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileManager {
    private Main main;
    private File curFile;

    public FileManager(Main main) {
        this.main = main;
    }

    public void open() {
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(main) == JFileChooser.APPROVE_OPTION) {
            curFile = fc.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(curFile))) {
                main.getTextArea().read(br, null);
                main.setTitle("Text Editor - " + curFile.getName());
            } catch (IOException ex) {
                main.showError("Can't open: " + ex.getMessage());
            }
        }
    }

    public void save() {
        if (curFile == null) saveAs();
        else writeFile();
    }

    public void saveAs() {
        JFileChooser fc = new JFileChooser();
        if (fc.showSaveDialog(main) == JFileChooser.APPROVE_OPTION) {
            curFile = fc.getSelectedFile();
            writeFile();
        }
    }

    private void writeFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(curFile))) {
            main.getTextArea().write(bw);
            main.setTitle("Text Editor - " + curFile.getName());
        } catch (IOException ex) {
            main.showError("Can't save: " + ex.getMessage());
        }
    }
}
