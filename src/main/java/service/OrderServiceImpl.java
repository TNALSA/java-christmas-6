package service;

import domain.Order;
import domain.constants.Menu;
import domain.constants.WeekInfo;
import message.ErrorMessage;
import message.OutputMessage;
import service.discount.ChristmasDiscount;
import service.discount.WeekdaysDiscount;
import service.discount.WeekendsDiscount;

import java.time.LocalDate;
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

    public int christmasDiscount(int days){
        ChristmasDiscount christmasDiscount = new ChristmasDiscount(days);
        return christmasDiscount.discountPrice();
    }

    public int dayDiscount(int days, List<Order> foodList){
        LocalDate date = LocalDate.of(2023, 12, days);
        if(WeekInfo.from(date.getDayOfWeek()).equals(WeekInfo.WEEKDAYS)){
            // WeekdaysDiscount
            WeekdaysDiscount weekdaysDiscount = new WeekdaysDiscount(foodList);
            return weekdaysDiscount.discountPrice();

        }else{
            // WeekendsDiscount
            WeekendsDiscount weekendsDiscount = new WeekendsDiscount(foodList);
            return weekendsDiscount.discountPrice();
        }
    }
}
