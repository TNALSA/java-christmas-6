package domain.constants;

import java.util.*;

public enum Menu {
    MUSHROOM_CREAM_SOUP("에피타이저","양송이수프",6000),
    TAPAS("에피타이저","타파스",5500),
    CAESAR_SALAD("에피타이저","시저 샐러드",8000),
    TBORN_STEAK("메인","티본스테이크",55000),
    BARBEQUE_RIB("메인","바비큐립",54000),
    SEAFOOD_PASTAR("메인","해산물파스타",35000),
    CHRISTMAS_PASTAR("메인","크리스마스파스타",25000),
    CHOCO_CAKE("디저트","초코케이크",15000),
    ICECREAM("디저트","아이스크림",5000),
    ZERO_COKE("음료","제로콜라",3000),
    REDWINE("음료","레드와인",60000),
    CHAMPAGNE("음료","샴페인",25000);
    private String type;
    private String name;
    private int price;

    Menu(String type, String name, int price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public static Menu from(String menu) {
        return Arrays.stream(Menu.values())
                .filter(element -> element.name.equals(menu))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."));
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
