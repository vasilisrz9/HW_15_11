package simplejavaapplication2;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


public class SimpleJavaApplication2 {
    
    public static final int LNAME=0;
    public static final int FNAME=1;
    public static final int FATNAME=2;
    public static final int DATEBIRTH=3;

    
    public static void main(String[] args) throws ParseException, Exception {
        
        String d1= "C:\\temp\\";
        String d2= "C:\\temp\\temp1\\";
        
        File f1 = new File(d1);
        File f2 = new File(d2);
        
        boolean check1 = f1.exists();
        boolean check2 = f2.exists();
        
        if(!check1){
            f1.mkdirs();
        }
        
        if(!check2){
            f2.mkdirs();
        }
         
       Person prs = new Person();
       Scanner stdin = new Scanner(System.in);
       
       System.out.println("What is your last_name?");
       prs.setString(LNAME,stdin.nextLine());
       System.out.println("What is your first_name?");
       prs.setString(FNAME,stdin.nextLine());
       System.out.println("What is your father_name?");
       prs.setString(FATNAME,stdin.nextLine());
       System.out.println("Give your date of birth on format DD/MM/YYYY");
       prs.setString(DATEBIRTH,stdin.nextLine());
       
       stdin.close();
       System.out.println("printing........");
       String filename="file.txt";
       String file_nam =d2+filename;
       
       WriteString wrs = new WriteString(file_nam);
       
       for(int i=1;i<=3;i++){
           if(i==1){
               String k=""+ prs.getString(LNAME) +", "+prs.getString(FNAME)+", "+prs.getString(FATNAME)+"";
               wrs.writes(i, k);
           }else if(i==2){
               String k=prs.getString(DATEBIRTH);
               wrs.writes(i, k);
           }else{
               SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY"); 
               Calendar dob = Calendar.getInstance(); 
               dob.setTime(sdf.parse(prs.getString(DATEBIRTH))); 
               String k = ""+getAge(dob)+"";
               wrs.writes(i, k); 
           }
       }
       System.out.println("file is ready");
       Person newPerson = new Person();
       ReadStrings rds = new ReadStrings();
       rds.reads(file_nam, newPerson);
       
         /*System.out.println(prs.getString(FNAME).equals(newPerson.getString(FNAME)));
         System.out.println(prs.getString(LNAME).equals(newPerson.getString(LNAME)));
         System.out.println(prs.getString(DATEBIRTH).equals(newPerson.getString(DATEBIRTH)));
         
         System.out.println("Prs last name "+prs.getString(LNAME));
         System.out.println("New person last name "+newPerson.getString(LNAME));
         System.out.println("Prs first name "+prs.getString(FNAME));
         System.out.println("New person first name "+newPerson.getString(FNAME));
         System.out.println("Prs father name "+prs.getString(FATNAME));
         System.out.println("New person father name "+newPerson.getString(FATNAME));
         System.out.println("Prs date of birth "+prs.getString(DATEBIRTH));
         System.out.println("New person date of birth "+newPerson.getString(DATEBIRTH));*/
            
    }
    
    public static int getAge(Calendar dob) throws Exception {
        Calendar today = Calendar.getInstance();

        int curYear = today.get(Calendar.YEAR);
        int dobYear = dob.get(Calendar.YEAR);

        int age = curYear - dobYear;
        int curMonth = today.get(Calendar.MONTH);
        int dobMonth = dob.get(Calendar.MONTH);
        if (dobMonth > curMonth) { 
            age--;
        } else if (dobMonth == curMonth) { 
            int curDay = today.get(Calendar.DAY_OF_MONTH);
            int dobDay = dob.get(Calendar.DAY_OF_MONTH);
            if (dobDay > curDay) { 
                age--;
            }
        }
        return age;
    }
    
}