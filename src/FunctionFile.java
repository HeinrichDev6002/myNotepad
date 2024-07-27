import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.*;

public class FunctionFile {
    Window window;
    String fileName, fileAdress;
    String editableText;
    FunctionFile(Window window){
        this.window = window;
    }
    public void createNewFile(){
        window.textArea.setText("");
        window.frame.setTitle("New file");
        fileName = null;
        fileAdress = null;
    }
    public void open(){
        FileDialog fileDialog = new FileDialog(window.frame, "Files", FileDialog.LOAD);
        fileDialog.setVisible(true);
        if(fileDialog.getFile()!=null){
            fileName = fileDialog.getFile();
            fileAdress = fileDialog.getDirectory();
            window.frame.setTitle(fileName);
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAdress + File.separator + fileName));
            window.textArea.setText("");
            String line = null;
            while((line = br.readLine())!=null){ 
                window.textArea.append(line + "\n");

            }
            br.close();
        }catch (Exception e){
e.printStackTrace();
        }
    }
    public void save(){
        if(fileName==null){
            saveAs();
        } else{
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileAdress + File.separator + fileName));
                writer.write(window.textArea.getText());
                writer.close();

            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    public void saveAs(){
        FileDialog fileDialog = new FileDialog(window.frame, "Save as", FileDialog.SAVE);
        fileDialog.setVisible(true);
        if(fileDialog.getFile()!=null){
            fileName = fileDialog.getFile();
            fileAdress = fileDialog.getDirectory();
            window.frame.setTitle(fileName);
        }
        try{
            FileWriter fileWriter = new FileWriter(fileAdress + File.separator + fileName);
            fileWriter.write(window.textArea.getText());
            fileWriter.close();
            System.out.println("Success");
        } catch (IOException e){
            e.getStackTrace();

        }

    }
    public void colorChooser(int c){
       switch (c){
           case 1: window.textArea.setBackground(Color.black); window.textArea.setForeground(Color.white);
          break;
           case 2: window.textArea.setBackground(Color.white); window.textArea.setForeground(Color.black);
           break;
           case 3: window.textArea.setBackground(Color.blue); window.textArea.setForeground(Color.white);
           break;
           case 4: window.textArea.setBackground(Color.red); window.textArea.setForeground(Color.white);
           break;
       }
    }
    public void pasteText(){
        if(window.textArea.getText()!=null){
            String text = window.textArea.getText();
            StringSelection strSelection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            try{
                Transferable contents = clipboard.getContents(null);
                if(contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)){
                    text = (String) contents.getTransferData(DataFlavor.stringFlavor);
                    window.textArea.replaceSelection(text);


                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void copyText(){
        String text = window.textArea.getSelectedText();
        if(text != null){
            StringSelection strSelection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(strSelection, null);
        }
    }
    public void undoText(){
        if(window.textArea.getText() != null && fileName != null && fileAdress != null){
            editableText = window.textArea.getText();
            try{
            BufferedReader br = new BufferedReader(new FileReader(fileAdress + File.separator + fileName));
            window.textArea.setText("");
            String line = null;
            if(fileName != null && fileAdress != null){
                while ((line = br.readLine()) != null){
                    window.textArea.append(line + "\n");
                    window.iUndo.setEnabled(false);
                    window.iRedo.setEnabled(true);
                }
            } } catch (Exception e){
                e.printStackTrace();
            }
        }

        if(window.textArea.getText()==null && fileName == null || fileAdress == null){
           saveAs();
        }

    }
    public void redoText(){
        if(window.textArea.getText() != null && editableText != null){
            try {
                BufferedReader br = new BufferedReader(new FileReader(fileAdress + File.separator + fileName));
                String text = br.readLine();
                if(!editableText.equals(text)){
                    window.textArea.setText("");
                    window.textArea.append(editableText + "\n");
                    window.iUndo.setEnabled(true);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }



}