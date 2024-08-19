package service.discount;

import domain.Order;
import domain.constants.Menu;

import java.util.*;

public class WeekendsDiscount implements Discount{
    List<Order> foodList = new ArrayList<>();
    public WeekendsDiscount(List<Order> foodList){
        this.foodList = foodList;
    }
    @Override
    public int discountPrice() {
        int discountPrice = 0;
        for(Order food:foodList){
            if(Menu.from(food.getName()).getType() == "메인"){
                discountPrice += 2023;
            }
        };
        return discountPrice;
    }
}
