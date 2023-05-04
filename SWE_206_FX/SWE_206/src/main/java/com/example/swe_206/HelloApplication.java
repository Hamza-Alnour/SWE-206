package com.example.swe_206;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    static ArrayList<Tournament> tournamentList = new ArrayList<>();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoaderLoginScene = new FXMLLoader(HelloApplication.class.getResource("LoginScene.fxml"));
        Scene loginScene = new Scene(fxmlLoaderLoginScene.load(), 600, 600);
        stage.setTitle("login!");
        stage.setScene(loginScene);
        stage.show();
    }

    public static void main(String[] args) {   
        for (int i = 0; i < 5; i++) {
            tournamentList.add(new Tournament("Individual"));
            tournamentList.add(new Tournament("Team"));
            System.out.println("added a few tournaments");
        }     
        launch();
    }
    public ArrayList<Tournament> getTournamentList() {
        return tournamentList;
    }
}