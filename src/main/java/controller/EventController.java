package controller;

import view.InputView;
import view.OutputView;

public class EventController {
    OutputView outputView;
    InputView inputView;

    int date;
    String order;
    EventController(){
        outputView.welcome();
        date = inputView.inputDate();
        order = inputView.order();
        outputView.benefitPreview(date);
    }
}
