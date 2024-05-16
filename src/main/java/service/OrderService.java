package service;

import domain.Food;
import java.util.*;
public interface OrderService {
    public List<Food> divideOrder(String order);
    //할인 전 총주문 금액

}
