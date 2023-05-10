package com.example.swe_206;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CreateNewTournament {
    static Scene scene;
    @FXML // fx:id="A"
    private ToggleGroup A; // Value injected by FXMLLoader

    @FXML // fx:id="B"
    private ToggleGroup B; // Value injected by FXMLLoader

    @FXML // fx:id="cancelButton"
    private Button cancelButton; // Value injected by FXMLLoader

    @FXML // fx:id="createButton"
    private Button createButton; // Value injected by FXMLLoader

    @FXML // fx:id="endDatePicker"
    private DatePicker endDatePicker; // Value injected by FXMLLoader

    @FXML // fx:id="nameTextField"
    private TextField nameTextField; // Value injected by FXMLLoader

    @FXML // fx:id="participationTypeRadioButton1"
    private RadioButton participationTypeRadioButton1; // Value injected by FXMLLoader

    @FXML // fx:id="participationTypeRadioButton2"
    private RadioButton participationTypeRadioButton2; // Value injected by FXMLLoader

    @FXML // fx:id="sportComboBox"
    private ComboBox<String> sportComboBox; // Value injected by FXMLLoader

    @FXML // fx:id="startDatePicker"
    private DatePicker startDatePicker; // Value injected by FXMLLoader

    @FXML // fx:id="teamSizeTextField"
    private TextField teamSizeTextField; // Value injected by FXMLLoader

    @FXML // fx:id="tournamentSizeTextField"
    private TextField tournamentSizeTextField; // Value injected by FXMLLoader

    @FXML // fx:id="tournamentTypeRadioButton1"
    private RadioButton tournamentTypeRadioButton1; // Value injected by FXMLLoader

    @FXML // fx:id="tournamentTypeRadioButton2"
    private RadioButton tournamentTypeRadioButton2; // Value injected by FXMLLoader

    @FXML // fx:id="warningLabel"
    private Label warningLabel; // Value injected by FXMLLoader

    @FXML
    void invokeOnSingle(ActionEvent event) {
        if(!participationTypeRadioButton1.isSelected())
            return;
        teamSizeTextField.setDisable(true);
    }

    @FXML
    void invokeOnTeam(ActionEvent e) {
        if(!participationTypeRadioButton2.isSelected())
            return;
        teamSizeTextField.setDisable(false);
    }

    @FXML
    void cancelButtonAction(ActionEvent event) {
        // Change this to homepage when implemented
        HelloApplication.stage.setScene(LoginSceneController.scene);
    }
    @FXML
    void createButtonAction(ActionEvent event) {
        boolean[] errorArray = new boolean[4];
        boolean error = false;
        if(nameTextField.getText().length() == 0) {
            errorArray[0] = true;
            error = true;
        }
        if(sportComboBox.getValue() == null || sportComboBox.getValue().length() == 0) {
            errorArray[1] = true;
            error = true;
        }
        if(teamSizeTextField.getText().length() == 0 || tournamentSizeTextField.getText().length() == 0 || !HelloApplication.isNonNegativeInt(tournamentSizeTextField.getText()) || !HelloApplication.isNonNegativeInt(teamSizeTextField.getText())) {
            errorArray[2] = true;
            error = true;
        }
        if(startDatePicker.getValue() == null || endDatePicker.getValue() == null || startDatePicker.getValue().isAfter(endDatePicker.getValue()) || endDatePicker.getValue().isBefore(LocalDate.now())) {
            errorArray[3] = true;
            error = true;
        }
        
        if(error) {
            String errorMsg = "Invalid tournament info.\n";
            if(errorArray[0]) errorMsg = errorMsg.concat("Must provide a name for the tournament.\n");
            if(errorArray[1]) errorMsg = errorMsg.concat("Must provide a sport for the tournament.\n");
            if(errorArray[2]) errorMsg = errorMsg.concat("Must provide a valid number of participants and number of students in a team.\n");
            if(errorArray[3]) errorMsg = errorMsg.concat("Start date cannot be after end date, and end date must not have already passed.");
            warningLabel.setText(errorMsg);
        }

        else {
            String participationType = participationTypeRadioButton1.isSelected() ? "Single" : "Team";
            String tournamentType = tournamentTypeRadioButton1.isSelected() ? "Elimination" : "Round Robin";
            
            new Tournament(nameTextField.getText(), participationType, tournamentType, sportComboBox.getValue(), Integer.parseInt(tournamentSizeTextField.getText()), Integer.parseInt(teamSizeTextField.getText()), startDatePicker.getValue(), endDatePicker.getValue());
            if(!HelloApplication.sportsList.contains(sportComboBox.getValue())) {
                HelloApplication.sportsList.add(sportComboBox.getValue());
            }
            nameTextField.setText("");
            sportComboBox.setValue("");
            tournamentSizeTextField.setText("");
            sportComboBox.setValue("");
            sportComboBox.setItems(HelloApplication.sportsList);
            warningLabel.setText("");
            tournamentTypeRadioButton1.setSelected(false);
            tournamentTypeRadioButton2.setSelected(true);
            participationTypeRadioButton2.setSelected(false);
            participationTypeRadioButton1.setSelected(true);
            startDatePicker.setValue(LocalDate.now());
            endDatePicker.setValue(LocalDate.now());
            HelloApplication.stage.setScene(LoginSceneController.scene);
        }
        
    }
    
    
    

    /*
	public Button getButton() {
        return button;
    }
    public String getType() {
        return type;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public String getName() {
        return name;
    }
    public int getPlayersPerTeam() {
        return playersPerTeam;
    }
    public int getRounds() {
        return rounds;
    }
    public String getSport() {
        return sport;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
	*/
}
