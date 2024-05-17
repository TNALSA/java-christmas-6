package service;

import domain.Food;
import java.util.*;
public interface OrderService {
    // 주문받은 내용을 split하여 List에 저장
    public List<Food> divideOrder(String order);

    public void isVaildOrder(List<Food> foodList);

    // 주문받은 메뉴들에 할인 전 총 주문금액을 계산
     public int beforeDicount(List<Food> foodList);
}
