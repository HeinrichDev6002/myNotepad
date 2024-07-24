import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements ActionListener {
    JTextArea textArea;
    JScrollPane scrollPane;
    JFrame frame;
    JMenuBar menu;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    FunctionFile file = new FunctionFile(this);
    public Window(){
        generateWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        frame.setVisible(true);
    }

    public void generateWindow(){
        frame = new JFrame("MyNote");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);


    }

    public void createTextArea(){
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollPane);
    }
    public void createMenuBar(){
        menu = new JMenuBar();
        frame.setJMenuBar(menu);
        menuFile = new JMenu("File");
        menu.add(menuFile);
        menuEdit = new JMenu("Edit");
        menu.add(menuEdit);
        menuFormat = new JMenu("Format");
        menu.add(menuFormat);
        menuColor = new JMenu("Color");
        menu.add(menuColor);
    }
    public void createFileMenu(){
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);
        iOpen = new JMenuItem("Open");
        iOpen.setActionCommand("Open");
        iOpen.addActionListener(this);
        menuFile.add(iOpen);
        iSave = new JMenuItem("Save");
        iSave.setActionCommand("Save");
        iSave.addActionListener(this);
        menuFile.add(iSave);
        iSaveAs = new JMenuItem("Save As");
        iSaveAs.setActionCommand("SaveAs");
        iSaveAs.addActionListener(this);
        menuFile.add(iSaveAs);
        iExit = new JMenuItem("Exit");
        menuFile.add(iExit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command){
            case "New": file.createNewFile();
            break;
            case "Open": file.open();
            break;
            case "SaveAs": file.saveAs();
            break;
            case "Save": file.save();
            break;
        }
    }
}
