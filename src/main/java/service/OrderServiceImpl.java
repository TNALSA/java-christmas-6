package service;

import domain.Food;
import domain.constants.Menu;
import message.ErrorMessage;

import java.util.*;

public class OrderServiceImpl implements OrderService {
    List<String> menu;
    List<Food> orderList = new ArrayList<Food>();
    public List<Food> divideOrder(String order){
        menu = Arrays.asList(order.split(",")); // [xxx-1, xxx-1, xxx-2]
        for(int i=0 ; i<menu.size() ; i++){
            String[] temp = menu.get(i).split("-"); // [xxx, 1]의 형태
            Food food = new Food();
            food.setName(temp[0]);
            food.setCount(Integer.parseInt(temp[1]));
            orderList.add(food);
        }
        return orderList;
    }

    public void isVaildOrder(List<Food> foodList){
        for(int i=0 ; i<foodList.size() ; i++){
            // 메뉴 검증
            Menu.from(foodList.get(i).getName());
            // 수량 검증
            if(foodList.get(i).getCount()<1){throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());}
            // 중복 검증
            for(int j = i+1 ; j<foodList.size() ; j++){
                if(foodList.get(i).getName().equals(foodList.get(j).getName())){throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());}
            }
        }
    }

    public int beforeDicount(List<Food> foodList){
        int beforeTotalPrice = 0;
        for(Food i:foodList) {
            beforeTotalPrice += Menu.from(i.getName()).getPrice();
        }
        return beforeTotalPrice;
    }
}
