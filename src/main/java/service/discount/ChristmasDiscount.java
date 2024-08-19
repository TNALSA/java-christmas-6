package service.discount;

public class ChristmasDiscount implements Discount {
    private final int EVENT_START = 1;
    private final int EVENT_END = 25;
    int days=0;

    int discount = 1000;

    public ChristmasDiscount(int days) {
        this.days = days;
    }
    @Override
    public int discountPrice() {
        if(EVENT_START <= days && days <= EVENT_END){
           discount += (days - EVENT_START) * 100;
            System.out.println();
           return discount;
        }
        return 0;
    }
}
