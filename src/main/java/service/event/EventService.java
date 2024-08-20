package service.event;

import domain.Discount;
import domain.Order;

import java.util.List;

public interface EventService {

    public Discount christmasEvent(int days);
    public Discount giftEvent(int beforeDiscount);
    public Discount specialEvent(int days);

    public Discount weekendsEvent(List<Order> foodList);
    public Discount weekdaysEvent(List<Order> foodList);

}
