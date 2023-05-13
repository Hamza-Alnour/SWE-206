package com.example.swe_206;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HelloApplication extends Application {
    static ArrayList<Tournament> tournamentListOG = new ArrayList<>();
    static ArrayList<Tournament> tournamentListOGArchived = new ArrayList<>();
    static ObservableList<String> sportsList = FXCollections.observableArrayList(Arrays.asList("Football", "Volleyball", "Basketball", "Tennis"));
    static Stage stage;
    static int loggedInStudentId;
    @Override
    public void start(Stage stage) throws IOException {
        HelloApplication.stage = stage;
        // Load the login screen
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginScene.fxml"));
        LoginSceneController.scene = new Scene(fxmlLoader.load(), 600, 600);

        // Load the scene for creating a new tournament
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreateNewTournament.fxml"));
        CreateNewTournament.scene = new Scene(fxmlLoader.load(), 500, 500);
        
        // Load the scene for selecting a tournament to modify
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("modifyTournament.fxml"));
        SelectTournamentToModify.scene = new Scene(fxmlLoader.load(), 500, 500);

        // Load the scene for selecting a tournament to view
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SelectTournamentToViewArchived.fxml"));
        SelectTournamentToViewArchivedController.scene = new Scene(fxmlLoader.load(), 500, 500);
        // Set some properties of the stage
        stage.setResizable(true);
        stage.setTitle("login!");
        stage.setScene(LoginSceneController.scene);
        stage.show();
    }

    public static void main(String[] args) {

        try (FileInputStream inFile = new FileInputStream("currentTournaments.dat");
                ObjectInputStream inObj = new ObjectInputStream(inFile);
                FileInputStream inFileArchive = new FileInputStream("archivedTournaments.dat");
                ObjectInputStream inObjArchive = new ObjectInputStream(inFileArchive);) {
            Compressor c = (Compressor) inObj.readObject();          
            ArrayList<SerializableTournament> st = c.getTournamentList();
            ArrayList<Tournament> tournamentList = new ArrayList<>();
            for (SerializableTournament _st : st) {
                tournamentList.add(new Tournament(_st));
            }

            Compressor cArchived = (Compressor) inObjArchive.readObject();
            ArrayList<SerializableTournament> stArchived = cArchived.getTournamentList();
            ArrayList<Tournament> tournamentListArchived = new ArrayList<>();
            for (SerializableTournament _st : stArchived) {
                tournamentListArchived.add(new Tournament(_st));
            }
            tournamentListOG = (ArrayList<Tournament>) tournamentList.clone();
            tournamentListOGArchived = (ArrayList<Tournament>) tournamentListArchived.clone();
            System.out.println(tournamentListOG.size());
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try (ObjectInputStream inObj = new ObjectInputStream(new FileInputStream("savedSports.dat"));) {
            
            while (true) {
                String sport = (String) inObj.readObject();
                if(!sportsList.contains(sport)) {
                    sportsList.add(sport);
                }
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(sportsList);
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        launch();
    }

    public ArrayList<Tournament> getTournamentList() {
        return tournamentListOG;
    }

    // Method generates a unique id which is different from all ids in the
    // tournament list
    public static int generateUniqueID() {
        ArrayList<Integer> idArray = new ArrayList<>();
        for (Tournament e : tournamentListOG) {
            idArray.add(e.getid());
        }

        Random r = new Random();
        int randomID = r.nextInt(1000, 10000);
        while (idArray.contains(randomID)) {
            randomID = r.nextInt(1000, 10000);
        }
        return randomID;

    }

    public static void saveTournaments(String fileName, ArrayList<Tournament> tList) {
        try (FileOutputStream outFile = new FileOutputStream(fileName);
                ObjectOutputStream outObj = new ObjectOutputStream(outFile);) {
            ArrayList<SerializableTournament> t = new ArrayList<>();
            for (Tournament tour : tList) {
                t.add(new SerializableTournament(tour));
            }
            Compressor c = new Compressor(t);
            outObj.writeObject(c);
            System.out.println("saved");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveSports() {
        try (ObjectOutputStream objOutStream = new ObjectOutputStream(new FileOutputStream("savedSports.dat"));) {
            for (String sport : sportsList) {
                objOutStream.writeObject(sport);
                System.out.println("Saved " + sport);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isNonNegativeInt(String s) {
        int length = s.length();
        for(int i = 0; i < length; i++) {
            if(!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

}