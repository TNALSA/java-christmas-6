package view;

import domain.Order;
import domain.constants.WeekInfo;
import message.OutputMessage;
import service.discount.WeekdaysDiscount;
import service.discount.WeekendsDiscount;

import java.time.LocalDate;
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
         System.out.println();
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

     public void showBenefitHistory(int beforeDiscount, int days, List<Order> foodList){
         System.out.println(OutputMessage.BENEFIT_DETAILS.getMessage());

     }

     public void showChristmasDiscount(int christmasPrice){
         System.out.println(OutputMessage.CHRISTMAS_DDAY_DISCOUNT.getMessage() + Math.absExact(christmasPrice));
     }

     public void showDayDiscount(LocalDate date, int dayPrice){
         if(WeekInfo.from(date.getDayOfWeek()).equals(WeekInfo.WEEKDAYS)){
             System.out.println(OutputMessage.WEEKSDAY_DISCOUNT.getMessage() + Math.absExact(dayPrice));
         }else{
             System.out.println(OutputMessage.WEEKEND_DISCOUNT.getMessage() + Math.absExact(dayPrice));
         }
     }
    public void showSpecialDiscount(int specialPrice){

    }
    public void showFreeDiscount(int freePrice){

    }

}
