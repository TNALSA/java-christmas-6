package view;

import domain.Order;
import message.OutputMessage;

import java.util.*;

public class OutputView {
    public void welcome(){
        System.out.println(OutputMessage.WELCOME.getMessage());
    }
    public void benefitPreview(String date){
        System.out.println(OutputMessage.DECEMBER.getMessage() + date + OutputMessage.PREVIEW.getMessage());
    }
    public void showOrderMenu(List<Order> list){
        System.out.println(OutputMessage.ORDER_MENU.getMessage());
        for(Order food:list)
            System.out.println(food.getName()+" "+food.getCount()+OutputMessage.UNIT.getMessage());
    }
     public void showBeforePrice(int price){
         System.out.println(OutputMessage.BEFORE_DISCOUNT.getMessage());
         System.out.println(price + OutputMessage.WON.getMessage());
     }
     public void showFreeMenu(Order isFree){
        System.out.println(OutputMessage.BENEFIT_DETAILS.getMessage());
         if(isFree == null){
             System.out.println("없음");
         }else {
             System.out.println(isFree.getName() + " " + isFree.getCount() + OutputMessage.UNIT.getMessage());
         }
         System.out.println();
     }

}
