import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;  

public class teste {
     public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);  
        // Prompt the user to enter a date  
        System.out.print("Enter a date (dd/mm/yyyy): ");  
        // Read the input using the next() method  
        String dateStr = sc.next();  
        // Parse the input string into a Date object using SimpleDateFormat  
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
        try {  
            Date date = sdf.parse(dateStr);  
            System.out.println("Input date: " + sdf.format(date));  
        } catch (ParseException e) {  
            System.out.println("Invalid date format");  
        }  
        sc.close();  
    }  
}  

