package domain;

public class Discount {
    int price;
    String name;

    public Discount(int price, String name){
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
