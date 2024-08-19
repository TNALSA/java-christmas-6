package service.discount;

import domain.constants.WeekInfo;
import org.assertj.core.util.Arrays;

public class SpecialDiscount implements Discount{
    int[] starDay = {3,10,17,24,25,31};

    int days;
    public SpecialDiscount(int days){
        this.days = days;
    }

    @Override
    public int discountPrice() {
        if(Arrays.asList(starDay).contains(days)){
            return 1000;
        }
        return 0;
    }
}
