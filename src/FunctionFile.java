import java.awt.*;

public class FunctionFile {
    Window window;

    FunctionFile(Window window){
        this.window = window;
    }
    public void createNewFile(){
        window.textArea.setText("");
        window.frame.setTitle("New file");
    }
    public void open(){
        FileDialog fileDialog = new FileDialog(window.frame, "Open", FileDialog.LOAD);
    }
}