package simplejavaapplication2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReadStrings {
    
    public void reads(String filename, Person newPerson){
        String r_line = null;

    try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int metrhths=0; 
            while((r_line = bufferedReader.readLine()) != null) {
                if(metrhths==0){
                     String[] bits = r_line.split(":");
                     String lastOne = bits[bits.length-1];
                     String[] elements = lastOne.split(",");
                     newPerson.setString(SimpleJavaApplication2.LNAME,elements[0].replaceAll("\\s+","") );
                     newPerson.setString(SimpleJavaApplication2.FNAME,elements[1].replaceAll("\\s+","") );
                     newPerson.setString(SimpleJavaApplication2.FATNAME,elements[2].replaceAll("\\s+","") );
                     metrhths++;
                }else if(metrhths==1){
                     String[] bits2 = r_line.split(":");
                     newPerson.setString(SimpleJavaApplication2.DATEBIRTH,bits2[bits2.length-1].replaceAll("\\s+","") );
                     metrhths++;
                }else{
                    
                }
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            Logger.getLogger(ReadStrings.class.getName()).log(Level.SEVERE, null, ex);              
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + filename + "'");                  
        }
    }
}
            
    