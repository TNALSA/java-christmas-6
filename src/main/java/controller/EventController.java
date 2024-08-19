package controller;

import domain.Order;
import message.OutputMessage;
import service.OrderServiceImpl;
import view.InputView;
import view.OutputView;

import java.time.LocalDate;
import java.util.*;

public class EventController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    String date, order;
    int beforeDiscount = 0, totalDiscount = 0, afterDiscount = 0;

    List<Order> foodList = new ArrayList<Order>();
    public void eventStart(){
        outputView.welcome();
        date = inputView.readDate();
        order = inputView.order();

        // 주문 구분 하기
        divideOrder(order);

        // 할인 전 총 주문 금액
        beforeDiscount(foodList);

        // 증정 메뉴
        freeMenu(beforeDiscount);

        // 혜택 내역
        benefitHistory(Integer.parseInt(date), foodList);

    }

    public void divideOrder(String order){
        // 주문 메뉴 List에 담기
        foodList = orderServiceImpl.divideOrder(order);

        // 주문 유효성 검사 -> 메뉴 갯수, 중복 여부, 메뉴 존재 여부,
        orderServiceImpl.isVaildOrder(foodList);

        // 출력
        outputView.benefitPreview(date);
        outputView.showOrderMenu(foodList);
    }

    //할인 전 총 주문 금액
    public void beforeDiscount(List<Order> foodList){
        beforeDiscount = orderServiceImpl.beforeDicount(foodList);
        outputView.showBeforePrice(beforeDiscount);
    }

    // 증정 메뉴
    public void freeMenu(int beforeDiscount){
        Order isFree = orderServiceImpl.freeMenu(beforeDiscount);
        outputView.showFreeMenu(isFree);
    }

    // 혜택 내역
    public void benefitHistory(int days, List<Order> foodList){
        LocalDate date = LocalDate.of(2023, 12, days);
        if(beforeDiscount > 10000){
            int christmasPrice = orderServiceImpl.christmasDiscount(days);
            int dayPrice = orderServiceImpl.dayDiscount(date, foodList);
            int specialPrice = orderServiceImpl.specialDiscount(days);
            int freePrice = orderServiceImpl.freeDiscount(beforeDiscount);

            outputView.showChristmasDiscount(christmasPrice);
            outputView.showDayDiscount(date, dayPrice);
            outputView.showSpecialDiscount(specialPrice);
            outputView.showFreeDiscount(freePrice);

        }else{
            System.out.println("없음");
        }

        public void totalBenefit(){
            orderServiceImpl.
        }
        // 총 혜택 금액
        System.out.println(OutputMessage.TOTAL_BENEFIT_PRICE.getMessage());
        totalDiscount = christmasPrice + weekPrice + weekendPrice + specialPrice +freePrice;
        System.out.println(totalDiscount+OutputMessage.WON.getMessage());


        //할인 후 총 예상 결제 금액
        System.out.println(OutputMessage.AFTER_DISCOUNT.getMessage());
        afterDiscount = beforeDiscount-totalDiscount;
        System.out.println(afterDiscount+OutputMessage.WON.getMessage());


        //12월 이벤트 배지
        System.out.println(OutputMessage.EVENT_BADGE.getMessage());
        if(totalDiscount >= 20000){
            System.out.println("산타");
        }else if(totalDiscount >= 10000){
            System.out.println("트리");
        } else if (totalDiscount >= 5000) {
            System.out.println("별");
        }

        if(totalDiscount==0){
            System.out.println("없음");
        }

    }

}
