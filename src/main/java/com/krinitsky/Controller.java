package com.krinitsky;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {

    private static final String FILE_IS_MISSING = "File is missing";
    private static final String PATH_IS_MISSING = "Path is missing";

    private File selectedFile;
    private File pathToDirectory;
    private boolean isError;
    private static final String WRONG_FORMAT = "Wrong format";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> choiceButton;

    @FXML
    private Button selectButton;

    @FXML
    private Button pathButton;

    @FXML
    private Button convertButton;

    @FXML
    private Label labelInfo;

    @FXML
    private Label labelForSelectButton;

    @FXML
    private Label labelForPathButton;

    @FXML
    void initialize() {
      fillChoiceBox();
    }

    @FXML
    private void selectButtonClick(ActionEvent actionEvent){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = new Stage();
        selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            if (selectedFile.getName().endsWith(".pdf")){
                isError = false;
                labelForSelectButton.setText(selectedFile.getName());
            }else {
                isError = true;
                labelForSelectButton.setText(WRONG_FORMAT);
            }
        }else {
            isError = true;
            labelForSelectButton.setText(FILE_IS_MISSING);
        }
    }

    @FXML
    private void pathButtonClick(ActionEvent actionEvent){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        pathToDirectory = directoryChooser.showDialog(new Stage());
        if (pathToDirectory != null){
            isError = false;
            labelForPathButton.setText(pathToDirectory.getAbsolutePath());
        }else {
            isError = true;
            labelForPathButton.setText(PATH_IS_MISSING);
        }
    }


    private void fillChoiceBox(){
        choiceButton.getItems().add(FormatName.PDF_TO_JPG.getFormat());
        choiceButton.getItems().add(FormatName.PDF_TO_JPEG.getFormat());
        choiceButton.getItems().add(FormatName.PDF_TO_PNG.getFormat());
        choiceButton.getItems().add(FormatName.PDF_TO_HTML.getFormat());
        choiceButton.getItems().add(FormatName.PDF_TO_DOCX.getFormat());
        choiceButton.getItems().add(FormatName.PDF_TO_EXEL.getFormat());
    }
}
