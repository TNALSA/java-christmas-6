package view;

import domain.Discount;
import domain.Order;
import domain.constants.WeekInfo;
import message.OutputMessage;

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
         System.out.println(formmatter.format(price) + OutputMessage.WON.getMessage());
         System.out.println();
     }

     public void showFreeMenu(Order isFree){
        System.out.println(OutputMessage.PRESENTATION.getMessage());

         if(isFree != null){
             System.out.println(isFree.getName() + " " + isFree.getCount() + OutputMessage.UNIT.getMessage());
         }

         if(isFree == null){
             System.out.println("없음");
         }

         System.out.println();
     }

     public void showBenefitHistory(List<Discount> eventList){
        System.out.println(OutputMessage.BENEFIT_DETAILS.getMessage());
        if(eventList.isEmpty())
            System.out.println("없음");

        if(!eventList.isEmpty()){
            for(Discount event: eventList){
                if(event != null)
                    System.out.println(event.getName() + ": " + formmatter.format(-1 * event.getPrice()) + "원");
            }
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
