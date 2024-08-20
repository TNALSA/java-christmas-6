package view;

import domain.Order;
import domain.constants.WeekInfo;
import message.OutputMessage;
import service.discount.WeekdaysDiscount;
import service.discount.WeekendsDiscount;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

public class OutputView {
    DecimalFormat formmatter = new DecimalFormat("###,###");

    public void welcome(){
        System.out.println(OutputMessage.WELCOME.getMessage());
    }

    public void benefitPreview(String date){
        System.out.println(OutputMessage.DECEMBER.getMessage() + date + OutputMessage.PREVIEW.getMessage());
        System.out.println();
    }

    public void showOrderMenu(List<Order> list){
        System.out.println(OutputMessage.ORDER_MENU.getMessage());
        for(Order food:list)
            System.out.println(food.getName()+" "+food.getCount()+OutputMessage.UNIT.getMessage());
        System.out.println();
    }

     public void showBeforePrice(int price){
         System.out.println(OutputMessage.BEFORE_DISCOUNT.getMessage());
         System.out.println(price + OutputMessage.WON.getMessage());
         System.out.println();
     }

     public void showFreeMenu(Order isFree){
        System.out.println(OutputMessage.PRESENTATION.getMessage());
         if(isFree == null){
             System.out.println("없음");
         }else {
             System.out.print(isFree.getName() + " " + isFree.getCount() + OutputMessage.UNIT.getMessage());
         }
         System.out.println();
     }

     public void showBenefitHistory(int beforeDiscount, int christmasPrice, LocalDate date, int dayPrice, int specialPrice, int freePrice){
         System.out.println(OutputMessage.BENEFIT_DETAILS.getMessage());

        if(beforeDiscount > 10000){
            System.out.println(OutputMessage.CHRISTMAS_DDAY_DISCOUNT.getMessage() + formmatter.format(Math.negateExact(christmasPrice)) + OutputMessage.WON.getMessage());

            if(WeekInfo.from(date.getDayOfWeek()).equals(WeekInfo.WEEKDAYS)){
                System.out.println(OutputMessage.WEEKSDAY_DISCOUNT.getMessage() + formmatter.format(Math.negateExact(dayPrice)) + OutputMessage.WON.getMessage());
            }
            if(WeekInfo.from(date.getDayOfWeek()).equals(WeekInfo.WEEKENDS)){
                System.out.println(OutputMessage.WEEKEND_DISCOUNT.getMessage() + formmatter.format(Math.negateExact(dayPrice))+ OutputMessage.WON.getMessage());
            }

            System.out.println(OutputMessage.SPECIAL_DISCOUNT.getMessage() + formmatter.format(Math.negateExact(specialPrice)) + OutputMessage.WON.getMessage());

            System.out.println(OutputMessage.FREE_EVENT.getMessage() + formmatter.format(Math.negateExact(freePrice)) + OutputMessage.WON.getMessage());
        }

        if(beforeDiscount < 10000){
            System.out.println("없음");
        }

         System.out.println();
     }

    public void showTotalBenefit(int totalBenefitPrice){
        System.out.println(OutputMessage.TOTAL_BENEFIT_PRICE.getMessage());
        System.out.println(formmatter.format(Math.negateExact(totalBenefitPrice)) + OutputMessage.WON.getMessage());
        System.out.println();
    }

    public void showAfterDiscount(int afterDiscount){
        System.out.println(OutputMessage.AFTER_DISCOUNT.getMessage());
        System.out.println(formmatter.format(afterDiscount) +OutputMessage.WON.getMessage());
        System.out.println();
    }

    public void showEventBadge(int totalDiscount){
        //12월 이벤트 배지
        System.out.println(OutputMessage.EVENT_BADGE.getMessage());
        String badge = null;

        if(totalDiscount < 5000){
            badge = "없음";
        }
        if(totalDiscount >= 5000){
            badge = "별";
        }
        if(totalDiscount >= 10000){
            badge = "트리";
        }
        if (totalDiscount >= 20000) {
            badge = "산타";
        }
        System.out.println(badge);
    }

}
