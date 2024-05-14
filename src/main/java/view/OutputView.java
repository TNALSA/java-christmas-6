package view;

import message.OutputMessage;

public class OutputView {
    public void welcome(){
        System.out.println(OutputMessage.WELCOME.getMessage());
    }
    public void benefitPreview(int date){
        System.out.println(OutputMessage.DECEMBER + String.valueOf(date) + OutputMessage.PREVIEW);
    }
}
