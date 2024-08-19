package controller;

import domain.Order;
import domain.constants.Menu;
import domain.constants.WeekInfo;
import message.OutputMessage;
import service.OrderServiceImpl;
import service.discount.*;
import view.InputView;
import view.OutputView;

import java.util.*;

public class EventController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    String date, order;
    int beforeDiscount = 0;
    int totalDiscount = 0;
    int afterDiscount = 0;
    List<Order> foodList = new ArrayList<Order>();
    public void eventStart(){
        outputView.welcome();
        date = inputView.readDate();
        order = inputView.order();

        // 주문 구분 하기
        divideOrder(order);

        beforeDiscount(foodList);

        freeMenu(beforeDiscount);

        benefitHistory(Integer.parseInt(date), foodList);
    }

    public void divideOrder(String order){
        foodList = orderServiceImpl.divideOrder(order);
        orderServiceImpl.isVaildOrder(foodList);
        outputView.benefitPreview(date);
        outputView.showOrderMenu(foodList);
    }

    //할인 전 총 주문 금액
    public void beforeDiscount(List<Order> foodList){
        beforeDiscount = orderServiceImpl.beforeDicount(foodList);
        outputView.showBeforePrice(beforeDiscount);
        System.out.println();
    }

    // 증정 메뉴
    public void freeMenu(int beforeDiscount){
        Order isFree = orderServiceImpl.freeMenu(beforeDiscount);
        outputView.showFreeMenu(isFree);
    }

    // 혜택 내역
    public void benefitHistory(int days, List<Order> foodList){
        int christmasPrice = orderServiceImpl.christmasDiscount(days);
        int dayPrice = orderServiceImpl.dayDiscount(days, foodList);

        int weekPrice = 0;
        int weekendPrice = 0;


        System.out.println("크리스마스 디데이 할인: -"+christmasPrice);
        // 해당 날짜가 평일인지? 주말인지? -> 메소드 호출


        // 특별 할인
        SpecialDiscount specialDiscount = new SpecialDiscount(days);
        int specialPrice = specialDiscount.discountPrice();

        // 증정 이벤트
        FreeDiscount freeDiscount = new FreeDiscount(beforeDiscount);
        int freePrice = freeDiscount.discountPrice();

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
