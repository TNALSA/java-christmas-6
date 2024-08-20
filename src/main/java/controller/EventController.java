package controller;

import domain.Discount;
import domain.Order;
import domain.constants.WeekInfo;
import service.order.OrderServiceImpl;
import service.event.EventServiceImpl;
import view.InputView;
import view.OutputView;
import java.time.LocalDate;
import java.util.*;

public class EventController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    EventServiceImpl eventServiceImpl = new EventServiceImpl();
    String date, order;
    int beforeDiscount = 0, totalDiscount = 0, afterDiscount = 0;
    List<Order> foodList = new ArrayList<Order>();
    List<Discount> eventList = new ArrayList<>();

    public void start(){
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
        totalBenefit();

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
        LocalDate date = LocalDate.of(2023,12,days);

        if(beforeDiscount > 10000){
            eventList.add(eventServiceImpl.christmasEvent(days));
            eventList.add(eventServiceImpl.specialEvent(days));
            eventList.add(eventServiceImpl.giftEvent(beforeDiscount));
            if(WeekInfo.from(date.getDayOfWeek()).equals(WeekInfo.WEEKENDS))
                eventList.add(eventServiceImpl.weekendsEvent(foodList));
            if (WeekInfo.from(date.getDayOfWeek()).equals(WeekInfo.WEEKDAYS))
                eventList.add(eventServiceImpl.weekdaysEvent(foodList));
        }

        outputView.showBenefitHistory(eventList);
    }

    public void totalBenefit(){
        totalDiscount = orderServiceImpl.totalBenefit(eventList);
        outputView.showTotalBenefit(totalDiscount);
    }

    public void afterDiscount(int beforeDiscount, int totalDiscount){
         afterDiscount = orderServiceImpl.afterDiscount(beforeDiscount, totalDiscount);
         outputView.showAfterDiscount(afterDiscount);
    }

    public void eventBadge(int totalDiscount){
        outputView.showEventBadge(totalDiscount);
    }

}
