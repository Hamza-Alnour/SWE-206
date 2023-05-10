package com.example.swe_206;

import javafx.scene.control.TextField;

public class Helper{
    TextField textField;
    String info;
    Helper() {
        textField = new TextField("Enter ID");
        info = "Player Not Found";
    }
    
    public TextField getTextField() {
        return textField;
    }
    public String getInfo() {
        return info;
    }
    public void setTextField(TextField textField) {
        this.textField = textField;
    }
    public void setInfo(String info) {
        this.info = info;
    }
}
