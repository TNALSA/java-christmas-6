package service.event;

import domain.Discount;
import domain.Order;
import domain.constants.Menu;
import domain.constants.WeekInfo;
import org.assertj.core.util.Arrays;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.List;

public class EventServiceImpl implements EventService {
    private final int EVENT_START = 1;
    private final int EVENT_END = 25;
    private int STANDARD = 1000;


    @Override
    public Discount christmasEvent(int days) {
        int EVENT_START = 1;
        int EVENT_END = 25;
        int STANDARD = 1000;

        if(EVENT_START <= days && days <= EVENT_END){
            return new Discount(STANDARD += (days - EVENT_START) * 100, "크리스마스 디데이 할인");
        }
        return null;
    }

    @Override
    public Discount giftEvent(int beforeDiscount) {
        int STANDARD = 120000;
        if(beforeDiscount > STANDARD){
            return new Discount(25000, "증정 이벤트");
        }
        return null;
    }

    @Override
    public Discount specialEvent(int days) {
        final int[] starDay = {3,10,17,24,25,31};
        int STANDARD = 1000;
        if(Arrays.asList(starDay).contains(days)) {
            return new Discount(STANDARD, "특별 할인");
        }
        return null;
    }

    @Override
    public Discount weekendsEvent(List<Order> foodList) {
        int discountPrice = 0;
        for(Order food:foodList){
            if(Menu.from(food.getName()).getType() == "메인"){
                discountPrice += 2023 * food.getCount();
            }
        };
        return new Discount(discountPrice, "주말 할인");
    }

    @Override
    public Discount weekdaysEvent(List<Order> foodList) {
        int discountPrice = 0;
        for(Order food:foodList){
            if(Menu.from(food.getName()).getType() == "디저트"){
                discountPrice += 2023 * food.getCount();
            }
        };

        return new Discount(discountPrice, "평일 할인");
    }
}
