package com.krinitsky;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<?> choiceButtonId;

    @FXML
    private Button selectButtonId;

    @FXML
    private Button pathButtonId;

    @FXML
    private Button convertButtonId;

    @FXML
    private Label labelInfoId;


    @FXML
    void initialize() {
        assert choiceButtonId != null : "fx:id=\"choiceButtonId\" was not injected: check your FXML file 'converterView.fxml'.";
        assert selectButtonId != null : "fx:id=\"selectButtonId\" was not injected: check your FXML file 'converterView.fxml'.";
        assert pathButtonId != null : "fx:id=\"pathButtonId\" was not injected: check your FXML file 'converterView.fxml'.";
        assert convertButtonId != null : "fx:id=\"convertButtonId\" was not injected: check your FXML file 'converterView.fxml'.";
        assert labelInfoId != null : "fx:id=\"labelInfoId\" was not injected: check your FXML file 'converterView.fxml'.";

    }
}
