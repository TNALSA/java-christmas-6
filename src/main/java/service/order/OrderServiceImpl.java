package service.order;

import domain.Discount;
import domain.Order;
import domain.constants.Menu;
import message.ErrorMessage;
import service.order.OrderService;

import java.util.*;

public class OrderServiceImpl implements OrderService {
    List<String> menu;
    List<Order> orderList = new ArrayList<Order>();
    public List<Order> divideOrder(String order){
        menu = Arrays.asList(order.split(",")); // [xxx-1, xxx-1, xxx-2]
        for(int i=0 ; i<menu.size() ; i++){
            String[] temp = menu.get(i).split("-"); // [xxx, 1]의 형태
            Order food = new Order(temp[0],Integer.parseInt(temp[1]));
            orderList.add(food);
        }
        return orderList;
    }

    public void isVaildOrder(List<Order> foodList){
        int totalOrderCount = 0;
        for(int i=0 ; i<foodList.size() ; i++){
            Menu.from(foodList.get(i).getName());
            if(foodList.get(i).getCount()<1){throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());}
            for(int j = i+1 ; j<foodList.size() ; j++){
                if(foodList.get(i).getName().equals(foodList.get(j).getName())){throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());}
            }
            totalOrderCount += foodList.get(i).getCount();
        }
        if(totalOrderCount >= 20){
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    public int beforeDicount(List<Order> foodList){
        int beforeTotalPrice = 0;
        for(Order i:foodList) {
            beforeTotalPrice += (Menu.from(i.getName()).getPrice() * i.getCount());
        }
        return beforeTotalPrice;
    }

    public Order freeMenu(int beforeDiscount){
        if(beforeDiscount > 120000){
            Order champagne = new Order(Menu.CHAMPAGNE.getName(), 1);
            return champagne;
        }
        return null;
    }

    public int totalBenefit(List<Discount> eventList){
        int totalPrice = 0;
        for(Discount event:eventList){
            if(event != null)
                totalPrice += event.getPrice();
        }
        return totalPrice;
    }

    public int afterDiscount(int beforeDiscount, int totalDiscount){
        if(beforeDiscount > 120000){
            return beforeDiscount - totalDiscount + Menu.CHAMPAGNE.getPrice();
        }
        return beforeDiscount - totalDiscount;
    }

}
