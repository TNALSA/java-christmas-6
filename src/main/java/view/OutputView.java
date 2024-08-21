package view;

import domain.Discount;
import domain.Order;
import domain.constants.Badge;
import message.Output;

import java.text.DecimalFormat;
import java.util.*;

public class OutputView {
    DecimalFormat formmatter = new DecimalFormat("###,###");

    public void welcome(){
        System.out.println(Output.WELCOME.getMessage());
    }

    public void benefitPreview(String date){
        System.out.println(Output.DECEMBER.getMessage() + date + Output.PREVIEW.getMessage());
        System.out.println();
    }

    public void showOrderMenu(List<Order> list){
        System.out.println(Output.ORDER_MENU.getMessage());
        for(Order food:list)
            System.out.println(food.getName()+" "+food.getCount()+ Output.UNIT.getMessage());
        System.out.println();
    }

     public void showBeforePrice(int price){
         System.out.println(Output.BEFORE_DISCOUNT.getMessage());
         System.out.println(formmatter.format(price) + Output.WON.getMessage());
         System.out.println();
     }

     public void showFreeMenu(Order isFree){
        System.out.println(Output.PRESENTATION.getMessage());

         if(isFree != null){
             System.out.println(isFree.getName() + " " + isFree.getCount() + Output.UNIT.getMessage());
         }

         if(isFree == null){
             System.out.println("없음");
         }

         System.out.println();
     }

     public void showBenefitHistory(List<Discount> eventList){
        System.out.println(Output.BENEFIT_DETAILS.getMessage());
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
        System.out.println(Output.TOTAL_BENEFIT_PRICE.getMessage());
        System.out.println(formmatter.format(Math.negateExact(totalBenefitPrice)) + Output.WON.getMessage());
        System.out.println();
    }

    public void showAfterDiscount(int afterDiscount){
        System.out.println(Output.AFTER_DISCOUNT.getMessage());
        System.out.println(formmatter.format(afterDiscount) + Output.WON.getMessage());
        System.out.println();
    }

    public void showEventBadge(int totalDiscount){
        //12월 이벤트 배지
        System.out.println(Output.EVENT_BADGE.getMessage());
        String badge = null;

        if(totalDiscount < Badge.NONE.getLimit()){
            badge = Badge.NONE.getGrade();
        }
        if(totalDiscount >= Badge.STAR.getLimit()){
            badge = Badge.STAR.getGrade();
        }
        if(totalDiscount >= Badge.TREE.getLimit()){
            badge = Badge.TREE.getGrade();
        }
        if (totalDiscount >= Badge.SANTA.getLimit()) {
            badge = Badge.SANTA.getGrade();
        }

        System.out.println(badge);
    }

}
