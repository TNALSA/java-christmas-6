package service.discount;

import domain.constants.Menu;

public class FreeDiscount implements Discount{
    int price;

    public FreeDiscount(int price) {
        this.price = price;
    }
    @Override
    public int discountPrice() {
        if(price > 120000){
            return Menu.CHAMPAGNE.getPrice();
        }
        return 0;
    }
}
