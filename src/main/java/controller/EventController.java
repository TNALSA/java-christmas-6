package controller;

import service.OrderService;
import service.OrderServiceImpl;
import view.InputView;
import view.OutputView;

public class EventController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    String date, order;
    public void eventStart(){
        outputView.welcome();
        date = inputView.readDate();
        order = inputView.order();
        outputView.benefitPreview(date);
    }
    public void divideMenu(String order){
        orderServiceImpl.divideOrder(order);
    }


}
