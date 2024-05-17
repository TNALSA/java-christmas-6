package controller;

import domain.Food;
import service.OrderService;
import service.OrderServiceImpl;
import view.InputView;
import view.OutputView;
import java.util.*;

public class EventController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    String date, order;
    List<Food> foodList = new ArrayList<Food>();
    public void eventStart(){
        outputView.welcome();
        date = inputView.readDate();
        order = inputView.order();
        divideOrder(order);
    }

    public void divideOrder(String order){
        foodList = orderServiceImpl.divideOrder(order);
        orderServiceImpl.isVaildOrder(foodList);
        outputView.benefitPreview(date);
        outputView.showOrderMenu(foodList);

        beforeDiscount(foodList);
    }

    //할인 전 총 주문 금액을 계산하는 메소드 호출
    public void beforeDiscount(List<Food> foodList){
        int price = orderServiceImpl.beforeDicount(foodList);
        System.out.println(price);
        outputView.showBeforePrice(price);
    }



}
