package com.example.swe_206;

import java.io.Serializable;

import javafx.scene.control.Button;

public class Tournament implements Serializable {
    String name;
    String type;
    Button button;
    Tournament() {
        name = "example";
        type = "Individual";
        button = new Button("");
    }

    public Button getButton() {
        return button;
    }
    public String getType() {
        return type;
    }
    
}
