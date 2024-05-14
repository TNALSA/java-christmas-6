package view;

import message.OutputMessage;

public class OutputView {
    public void welcome(){
        System.out.println(OutputMessage.WELCOME.getMessage());
    }
    public void benefitPreview(String date){
        System.out.println(OutputMessage.DECEMBER + date + OutputMessage.PREVIEW);
    }
}
