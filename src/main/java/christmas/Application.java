package christmas;

import controller.EventController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        EventController eventController = new EventController();
        eventController.eventStart();
    }
}
