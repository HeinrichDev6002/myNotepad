import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements ActionListener {
    JTextArea textArea; //Text go here
    JScrollPane scrollPane; //Scroll
    JFrame frame; //The main window
    JMenuBar menu; //Menu bar
    JMenu menuFile, menuEdit, menuFormat, menuColor, menuSize; //Menu options
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit, iBlack, iWhite, iBlue, iRed, iCopy, iPaste,
    iRedo, iUndo; //Menu options items
    JMenuItem iComicSans, iArial, iTimesNewRomans, iHelvetica; //Fonts of format
    String command;
    FunctionFile file = new FunctionFile(this);
    public Window(){
        generateWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFont();


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
        menuSize = new JMenu("Size");
        menu.add(menuSize);
    }
    public void createFileMenu() {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);
        //New File
        iOpen = new JMenuItem("Open");
        iOpen.setActionCommand("Open");
        iOpen.addActionListener(this);
        menuFile.add(iOpen);
        //Open file dialog
        iSave = new JMenuItem("Save");
        iSave.setActionCommand("Save");
        iSave.addActionListener(this);
        menuFile.add(iSave);
        //Save overriding
        iSaveAs = new JMenuItem("Save As");
        iSaveAs.setActionCommand("SaveAs");
        iSaveAs.addActionListener(this);
        menuFile.add(iSaveAs);
        //Save as new file
        iExit = new JMenuItem("Exit");
        menuFile.add(iExit);
        iExit.setActionCommand("Exit");
        iExit.addActionListener(this);
        //Exit
        iBlack = new JMenuItem("Black");
        iBlack.addActionListener(this);
        iBlack.setActionCommand("Black");
        menuColor.add(iBlack);

        iWhite = new JMenuItem("White");
        iWhite.addActionListener(this);
        iWhite.setActionCommand("White");
        menuColor.add(iWhite);

        iBlue = new JMenuItem("Blue");
        iBlue.addActionListener(this);
        iBlue.setActionCommand("Blue");
        menuColor.add(iBlue);

        iRed = new JMenuItem("Red");
        iRed.addActionListener(this);
        iRed.setActionCommand("Red");
        menuColor.add(iRed);

        //Colors

        iCopy = new JMenuItem("Copy");
        iCopy.addActionListener(this);
        iCopy.setActionCommand("Copy");
        menuEdit.add(iCopy);

        //Copy

        iPaste = new JMenuItem("Paste");
        iPaste.addActionListener(this);
        iPaste.setActionCommand("Paste");
        menuEdit.add(iPaste);
        //Paste

        iUndo = new JMenuItem("Undo");
        iUndo.setActionCommand("Undo");
        iUndo.addActionListener(this);
        menuEdit.add(iUndo);
        //Undo
        iRedo = new JMenuItem("Redo");
        iRedo.setActionCommand("Redo");
        iRedo.addActionListener(this);
        iRedo.setEnabled(false);
        menuEdit.add(iRedo);

    }

    public void createFont(){
        iArial = new JMenuItem("Arial");
        iArial.addActionListener(this);
        iArial.setActionCommand("Arial");
        menuFormat.add(iArial);

        iComicSans = new JMenuItem("Comic Sans");
        iComicSans.addActionListener(this);
        iComicSans.setActionCommand("Comic Sans");
        menuFormat.add(iComicSans);

        iTimesNewRomans = new JMenuItem("Times New Romans");
        iTimesNewRomans.addActionListener(this);
        iTimesNewRomans.setActionCommand("Times New Romans");
        menuFormat.add(iTimesNewRomans);

        iHelvetica = new JMenuItem("Helvetica");
        iHelvetica.addActionListener(this);
        iHelvetica.setActionCommand("Helvetica");
        menuFormat.add(iHelvetica);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          command = e.getActionCommand();
        switch(command){
            case "New": file.createNewFile();
            break;
            case "Open": file.open();
            break;
            case "SaveAs": file.saveAs();
            break;
            case "Save": file.save();
            break;
            case "Exit": file.save(); System.exit(0);
            break;
            //File items

            case "Black": file.colorChooser(1);
            break;
            case "White": file.colorChooser(2);
            break;
            case "Blue": file.colorChooser(3);
            break;
            case "Red": file.colorChooser(4);
            break;
            //Color items

            case "Paste": file.pasteText();
            break;
            case "Copy": file.copyText();
            break;
            case "Undo": file.undoText();
            break;
            case "Redo": file.redoText();
            break;
            case "Comic Sans": file.chooseFont(12);
            break;
            case "Arial": file.chooseFont(12);
            break;
            case "Times New Romans": file.chooseFont(12);
            break;
            case "Helvetica": file.chooseFont(12);
            break;

        }


    }
}
