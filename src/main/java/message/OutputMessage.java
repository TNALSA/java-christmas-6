package message;

public enum OutputMessage {
    WELCOME("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    DATE_OF_VISIT("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    DECEMBER("12월"),
    PREVIEW("일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU("<주문 메뉴>"),
    BEFORE_DISCOUNT("<할인 전 총 주문 금액>"),
    PRESENTATION("<증정 메뉴>"),
    BENEFIT_DETAILS("<혜택 내역>"),
    TOTAL_BENEFIT_PRICE("<총혜택 금액>"),
    AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    WON("원"),
    EVENT_BADGE("<12월 이벤트 배지>");

    private final String msg;

    OutputMessage(String msg){
        this.msg = msg;
    }

    public String getMessage(){
        return msg;
    }

}
