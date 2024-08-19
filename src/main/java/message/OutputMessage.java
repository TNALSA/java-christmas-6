package message;

public enum OutputMessage {
    WELCOME("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    DECEMBER("12월"),
    PREVIEW("일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU("<주문 메뉴>"),
    BEFORE_DISCOUNT("<할인 전 총 주문 금액>"),
    PRESENTATION("<증정 메뉴>"),
    BENEFIT_DETAILS("<혜택 내역>"),
    TOTAL_BENEFIT_PRICE("<총혜택 금액>"),
    AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    WON("원"),
    EVENT_BADGE("<12월 이벤트 배지>"),
    UNIT("개"),
    CHRISTMAS_DDAY_DISCOUNT("크리스마스 디데이 할인: "),
    WEEKSDAY_DISCOUNT("평일 할인: "),
    WEEKEND_DISCOUNT("주말 할인: "),
    SPECIAL_DISCOUNT("특별 할인: "),
    FREE_EVENT("증정 이벤트: ");

    private final String msg;

    OutputMessage(String msg){
        this.msg = msg;
    }

    public String getMessage(){
        return msg;
    }

}
