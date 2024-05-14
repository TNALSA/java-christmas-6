package view;
import java.util.*;
public class InputView {
    Scanner sc = new Scanner(System.in);
    public int inputDate(){
        int date = sc.nextInt();
        return date;
    }

    public String order(){
        String order = sc.next();
        return order;
    }
}
