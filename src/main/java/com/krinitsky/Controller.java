package com.krinitsky;

import java.io.File;
import java.io.IOException;
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
    private ConverterPDF converterPDF;
    private boolean isErrorPath;
    private boolean isErrorFile;
    private boolean isErrorChoiceFormat;
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
        isErrorPath = true;
        isErrorFile = true;
        isErrorChoiceFormat = true;
        fillChoiceBox();
    }

    @FXML
    private void selectButtonClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = new Stage();
        selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            if (selectedFile.getName().endsWith(".pdf")) {
                isErrorFile = false;
                labelForSelectButton.setText(selectedFile.getName());
            } else {
                isErrorFile = true;
                labelForSelectButton.setText(WRONG_FORMAT);
            }
        } else {
            isErrorFile = true;
            labelForSelectButton.setText(FILE_IS_MISSING);
        }
    }

    @FXML
    private void pathButtonClick(ActionEvent actionEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        pathToDirectory = directoryChooser.showDialog(new Stage());
        if (pathToDirectory != null) {
            isErrorPath = false;
            labelForPathButton.setText(pathToDirectory.getAbsolutePath());
        } else {
            isErrorPath = true;
            labelForPathButton.setText(PATH_IS_MISSING);
        }
    }

    @FXML
    private void choiceButtonClick(ActionEvent actionEvent) {
        isErrorChoiceFormat = false;
    }

    @FXML
    private void convertButtonClick(ActionEvent actionEvent) {
        if (!isErrorFile & !isErrorPath & !isErrorChoiceFormat) {
            converterPDF = new ConverterPDF(pathToDirectory, selectedFile);
            try {
                if (choiceButton.getValue().equals(FormatName.PDF_TO_JPEG.getFormat())) {
                    converterPDF.convertToImg(ConverterPDF.EXTENSION_JPEG);
                }
                if (choiceButton.getValue().equals(FormatName.PDF_TO_PNG.getFormat())) {
                    converterPDF.convertToImg(ConverterPDF.EXTENSION_PNG);
                }
                if (choiceButton.getValue().equals(FormatName.PDF_TO_HTML.getFormat())) {
                    converterPDF.convertToHTML();
                }
                if (choiceButton.getValue().equals(FormatName.PDF_TO_TEXT.getFormat())) {
                    converterPDF.convertToText();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void fillChoiceBox() {
        choiceButton.getItems().add(FormatName.PDF_TO_JPEG.getFormat());
        choiceButton.getItems().add(FormatName.PDF_TO_PNG.getFormat());
        choiceButton.getItems().add(FormatName.PDF_TO_HTML.getFormat());
        choiceButton.getItems().add(FormatName.PDF_TO_TEXT.getFormat());
    }

}
