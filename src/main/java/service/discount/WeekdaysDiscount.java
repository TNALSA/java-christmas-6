package service.discount;

import domain.Order;
import domain.constants.Menu;
import domain.constants.WeekInfo;

import java.time.LocalDate;
import java.util.*;

public class WeekdaysDiscount implements Discount{
    private List<Order> foodList;

    LocalDate date;

    public WeekdaysDiscount(List<Order> foodList){
        this.foodList = foodList;
    }

    @Override
    public int discountPrice() {
        int discountPrice = 0;
        for(Order food:foodList){
          if(Menu.from(food.getName()).getType() == "디저트"){
              discountPrice += 2023 * food.getCount();
          }
        };
        return discountPrice;
    }
}
