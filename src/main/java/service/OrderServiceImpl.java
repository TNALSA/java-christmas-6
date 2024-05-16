package service;

import domain.Food;

import java.util.*;

public class OrderServiceImpl implements OrderService {
    List<String> menu;
    List<Food> orderList = new ArrayList<Food>();
    public List<Food> divideOrder(String order){
        menu = Arrays.asList(order.split(",")); // [xxx-1, xxx-1, xxx-2]
        for(int i=0 ; i<menu.size() ; i++){
            String[] temp = menu.get(i).split("-");
            Food food = new Food();

            food.setName(temp[0]);
            food.setCount(Integer.parseInt(temp[1]));
            orderList.add(food);
        }
        return orderList;
    }




}
