package service;

import domain.Food;
import java.util.*;
public interface OrderService {
    public List<Food> divideOrder(String order);
}
