package ReusableFiles;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeReverse {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number days to go back");
        int value= scanner.nextInt();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/YYYY");
        LocalDate now=LocalDate.now();
        LocalDate returnValue=now.minusDays(value);
        System.out.println(dtf.format(returnValue));
    }
}
