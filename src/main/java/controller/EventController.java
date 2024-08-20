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
    private OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    String date, order;
    int beforeDiscount = 0, totalDiscount = 0, afterDiscount = 0;
    int christmasPrice=0, dayPrice=0, specialPrice=0, freePrice = 0;

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

        // 총혜택 금액
        totalBenefit(christmasPrice, dayPrice, specialPrice, freePrice);

        //할인 후 예상 결제 금액
        afterDiscount(beforeDiscount, totalDiscount);

        //12월 이벤트 배지
        eventBadge(totalDiscount);

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
            christmasPrice = orderServiceImpl.christmasDiscount(days);
            dayPrice = orderServiceImpl.dayDiscount(date, foodList);
            specialPrice = orderServiceImpl.specialDiscount(days);
            freePrice = orderServiceImpl.freeDiscount(beforeDiscount);
        }

        outputView.showBenefitHistory(beforeDiscount, christmasPrice, date, dayPrice, specialPrice, freePrice);
    }

    public void totalBenefit(int christmasPrice, int dayPrice, int specialPrice, int freePrice){
        totalDiscount = orderServiceImpl.totalBenefit(christmasPrice, dayPrice, specialPrice, freePrice);
        outputView.showTotalBenefit(totalDiscount);
    }

    public void afterDiscount(int beforeDiscount, int totalDiscount){
         afterDiscount = orderServiceImpl.afterDiscount(beforeDiscount, totalDiscount, freePrice);
         outputView.showAfterDiscount(afterDiscount);
    }

    public void eventBadge(int totalDiscount){
        outputView.showEventBadge(totalDiscount);
    }

}
