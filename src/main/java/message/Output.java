package message;

public enum Output {
    WELCOME("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    DECEMBER("12월"),
    PREVIEW("일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU("<주문 메뉴>"),
    BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    PRESENTATION("<증정 메뉴>"),
    BENEFIT_DETAILS("<혜택 내역>"),
    TOTAL_BENEFIT_PRICE("<총혜택 금액>"),
    AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    WON("원"),
    EVENT_BADGE("<12월 이벤트 배지>"),
    UNIT("개");

    private final String msg;

    Output(String msg){
        this.msg = msg;
    }

    public String getMessage(){
        return msg;
    }

}
