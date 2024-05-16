package domain;

public class Food {
    private String name;
    private int count;

    //생성자를 따로 만들고 외부에서 호출하면 error가 발생한다. why?

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public String getName() {
        return name;
    }
    public int getCount(){
        return count;
    }
}
