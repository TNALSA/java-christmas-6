package view;

import domain.Food;
import message.OutputMessage;

import java.util.*;

public class OutputView {
    public void welcome(){
        System.out.println(OutputMessage.WELCOME.getMessage());
    }
    public void benefitPreview(String date){
        System.out.println(OutputMessage.DECEMBER.getMessage() + date + OutputMessage.PREVIEW.getMessage());
    }
    public void showOrderMenu(List<Food> list){
        System.out.println(OutputMessage.ORDER_MENU.getMessage());
        for(Food food:list)
            System.out.println(food.getName()+" "+food.getCount()+OutputMessage.UNIT.getMessage());
    }
     public void showBeforePrice(int price){
         System.out.println(OutputMessage.BEFORE_DISCOUNT.getMessage());
         System.out.println(price);
     }

}
