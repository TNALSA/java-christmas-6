package view;
import camp.nextstep.edu.missionutils.Console;
import message.ErrorMessage;
import message.InputMessage;

import java.util.*;
public class InputView {
    Scanner sc = new Scanner(System.in);
    //방문 날짜 입력받기
    public String readDate(){
        System.out.println(InputMessage.DATE_OF_VISIT.getMessage());

        String input = Console.readLine();
        if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > 31){
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getMessage());
        }
        return input;
    }
    //주문 메뉴와 갯수 입력받기
    public String order(){
        System.out.println(InputMessage.ORDER.getMessage());
        String order = sc.next();
        return order;
    }
}
