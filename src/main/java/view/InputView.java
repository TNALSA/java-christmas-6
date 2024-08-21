package view;
import camp.nextstep.edu.missionutils.Console;
import message.Error;
import message.Input;

public class InputView {

    //방문 날짜 입력받기
    public String readDate(){
        System.out.println(Input.DATE_OF_VISIT.getMessage());

        String input = Console.readLine();
        if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > 31){
            throw new IllegalArgumentException(Error.INVALID_DATE.getMessage());
        }
        return input;
    }
    //주문 메뉴와 갯수 입력받기
    public String order(){
        System.out.println(Input.ORDER.getMessage());
        String order = Console.readLine();
        return order;
    }
}
