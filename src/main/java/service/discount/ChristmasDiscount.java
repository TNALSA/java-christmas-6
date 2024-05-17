package service.discount;

public class ChristmasDiscount implements Discount {
    private final int EVENT_START = 1;
    private final int EVENT_END = 25;

    int discount = 1000;

    @Override
    public int discountPrice(int days) {

        return discount;
    }
}
