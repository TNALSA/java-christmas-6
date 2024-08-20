package service.order;

import domain.Order;
import java.util.*;
public interface OrderService {
    // 주문받은 내용을 split하여 List에 저장
    public List<Order> divideOrder(String order);

    public void isVaildOrder(List<Order> foodList);

    // 주문받은 메뉴들에 할인 전 총 주문 금액을 계산
     public int beforeDicount(List<Order> foodList);

     public Order freeMenu(int beforeDiscount);
}
