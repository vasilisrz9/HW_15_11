package simplejavaapplication2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WriteString {
    private static PrintWriter writer = null;
    private String filename;
    
    public WriteString(String filename) {
        this.filename = filename;
    }
    
    public void writes(int lin, String s){
        
        if(lin == 1) {
            try {
                 writer = new PrintWriter(this.filename);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(WriteString.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        writer.println("Line " + lin + ": " + s);
        if(lin == 3) writer.close();

        
    }
    
    
}
