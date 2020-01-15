import javax.swing.*;

public class DragLabel {
    JTextArea label;
    String labelName;
    String labelContent;

    DragLabel(){
        //label = pLabel;
    }

    public void setLabelName(String pName){
        labelName = pName;
    }

    public void setLabelContent(String pContent){
        labelContent = pContent;
    }

    public String getLabelName(){
        return labelName;
    }

    public String getLabelContent( ){
        return  labelContent;
    }

    public JTextArea getLabel( ){
        return  label;
    }
}
