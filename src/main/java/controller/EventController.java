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
        outputView.benefitPreview(date);
    }
    public void divideOrder(String order){
        foodList = orderServiceImpl.divideOrder(order);
        outputView.showOrderMenu(foodList);
    }



}
