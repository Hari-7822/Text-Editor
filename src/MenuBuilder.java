package src;

import javax.swing.*;

public class MenuBuilder {
    private Main main;

    public MenuBuilder(Main main) {
        this.main = main;
    }

    public JMenuBar createMenuBar() {
        JMenuBar mb = new JMenuBar();
        
        mb.add(createFileMenu());
        mb.add(createThemeMenu());
        mb.add(createFontMenu());
        mb.add(createSizeMenu());
        
        return mb;
    }

    private JMenu createFileMenu() {
        JMenu fm = new JMenu("File");
        JMenuItem oi = new JMenuItem("Open");
        JMenuItem si = new JMenuItem("Save");
        JMenuItem sai = new JMenuItem("Save As");
        JMenuItem ei = new JMenuItem("Exit");

        oi.addActionListener(e -> main.getFileManager().open());
        si.addActionListener(e -> main.getFileManager().save());
        sai.addActionListener(e -> main.getFileManager().saveAs());
        ei.addActionListener(e -> System.exit(0));

        fm.add(oi); fm.add(si); fm.add(sai); fm.addSeparator(); fm.add(ei);
        return fm;
    }

    private JMenu createThemeMenu() {
        JMenu tm = new JMenu("Theme");
        JMenuItem li = new JMenuItem("Light");
        JMenuItem di = new JMenuItem("Dark");

        li.addActionListener(e -> main.getThemeManager().lightTheme());
        di.addActionListener(e -> main.getThemeManager().darkTheme());

        tm.add(li); tm.add(di);
        return tm;
    }

    private JMenu createFontMenu() {
        JMenu fontM = new JMenu("Font");
        String[] fonts = {"Monospaced", "Courier New", "Consolas", "DejaVu Sans Mono", "Liberation Mono"};
        ButtonGroup fg = new ButtonGroup();

        for (String f : fonts) {
            JRadioButtonMenuItem fi = new JRadioButtonMenuItem(f);
            fi.addActionListener(e -> main.getFontManager().setFontName(f));
            fg.add(fi);
            fontM.add(fi);
        }
        return fontM;
    }

    private JMenu createSizeMenu() {
        JMenu sizeM = new JMenu("Size");
        int[] sizes = {10, 12, 14, 16, 18, 20, 24};
        ButtonGroup sg = new ButtonGroup();

        for (int s : sizes) {
            JRadioButtonMenuItem sii = new JRadioButtonMenuItem(s + "");
            sii.addActionListener(e -> main.getFontManager().setFontSize(s));
            sg.add(sii);
            if (s == 14) sii.setSelected(true);
            sizeM.add(sii);
        }
        return sizeM;
    }
}
