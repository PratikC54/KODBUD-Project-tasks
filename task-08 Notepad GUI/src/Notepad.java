import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Notepad extends JFrame {

    private JTextArea textArea;
    private File currentFile;
    private boolean isModified = false;

    public Notepad() {
        setTitle("Notepad");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        textArea = new JTextArea();
        textArea.setFont(new Font("Consolas", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        textArea.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                isModified = true;
            }
        });

        setJMenuBar(createMenuBar());
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem newFile = new JMenuItem("New");
        JMenuItem openFile = new JMenuItem("Open");
        JMenuItem saveFile = new JMenuItem("Save");
        JMenuItem saveAsFile = new JMenuItem("Save As");

        newFile.addActionListener(e -> newFile());
        openFile.addActionListener(e -> openFile());
        saveFile.addActionListener(e -> saveFile());
        saveAsFile.addActionListener(e -> saveAsFile());

        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.addSeparator();

        menuBar.add(fileMenu);
        return menuBar;
    }

    private void newFile() {
        if (confirmSave()) {
            textArea.setText("");
            currentFile = null;
            isModified = false;
            setTitle("Notepad");
        }
    }

    private void openFile() {
        if (!confirmSave()) return;

        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            loadFile(currentFile);
        }
    }

    private void saveFile() {
        if (currentFile == null) saveAsFile();
        else writeFile(currentFile);
    }

    private void saveAsFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            writeFile(currentFile);
        }
    }

    private void loadFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            textArea.read(br, null);
            isModified = false;
            setTitle("Java Notepad - " + file.getName());
        } catch (IOException e) {
            showError("Error opening file");
        }
    }

    private void writeFile(File file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            textArea.write(bw);
            isModified = false;
            setTitle("Notepad - " + file.getName());
        } catch (IOException e) {
            showError("Error saving file");
        }
    }

    private boolean confirmSave() {
        if (!isModified) return true;

        int choice = JOptionPane.showConfirmDialog(
                this,
                "You have unsaved changes. Save now?",
                "Confirm",
                JOptionPane.YES_NO_CANCEL_OPTION
        );

        if (choice == JOptionPane.CANCEL_OPTION) return false;
        if (choice == JOptionPane.YES_OPTION) saveFile();

        return true;
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
         new Notepad().setVisible(true);
    }
}
