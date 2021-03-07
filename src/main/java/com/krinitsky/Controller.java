package com.krinitsky;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
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
    private ChoiceBox<?> choiceButton;

    @FXML
    private Button selectButton;

    @FXML
    private Button pathButton;

    @FXML
    private Button convertButton;

    @FXML
    private Label labelInfo;

    @FXML
    void initialize() {

    }
}
