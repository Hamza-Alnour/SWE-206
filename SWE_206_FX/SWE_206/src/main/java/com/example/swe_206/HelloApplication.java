package com.example.swe_206;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class HelloApplication extends Application {
    static ArrayList<Tournament> tournamentList = new ArrayList<>();
    @Override
    public void start(Stage stage) throws IOException {
        // Load the login screen
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginScene.fxml"));
        Scene loginScene = new Scene(fxmlLoader.load(), 600, 600);

        // Load the scene for creating a new tournament
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreateNewTournament.fxml"));
        //TournamentCreateScene.scene = new Scene(fxmlLoader.load(), 500, 500);
        
        // Set some properties of the stage
        stage.setResizable(false);
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

    // Method generates a unique id which is different from all ids in the tournament list
    public static int generateUniqueID() {
        ArrayList<Integer> idArray = new ArrayList<>();
        for (Tournament e : tournamentList) {
            idArray.add(e.getid());
        }

        Random r = new Random();
        int randomID = r.nextInt(0, 10000);
        while (idArray.contains(randomID)) {
            randomID = r.nextInt(0, 10000);
        }
        return randomID;
        
    }
}