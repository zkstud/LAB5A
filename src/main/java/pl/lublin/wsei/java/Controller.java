package pl.lublin.wsei.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {
    @FXML
    public Button btnOpenFile;
    @FXML
    public Label lbFile;
    @FXML
    public TableView tvNobel;
    @FXML
    public ImageView ivNobel;


    File fPictureNobel = new File("nobel_prize.png");

    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("Pliki CSV (*.csv)", "*.csv");

    @FXML
    public void initialize() {
        fileChooser.getExtensionFilters().add(csvFilter);
        ivNobel.setImage(new Image(fPictureNobel.getAbsolutePath()));
    }

    @FXML
    public void btnOpenFileAction(ActionEvent actionEvent) {
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            lbFile.setText(file.getAbsolutePath());
        } else {
            lbFile.setText("Proszę wczytać plik ...");
        }
    }

    public void btnSaveFileAction(ActionEvent actionEvent) {
    }

    public void btnExportFileAction(ActionEvent actionEvent) {
    }
}