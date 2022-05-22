package pl.lublin.wsei.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    @FXML
    public Label lbFile;
    @FXML
    public ImageView ivNobel;
    @FXML
    public TableView<Noblista> tvNoblista;
    @FXML
    public TableColumn<Noblista, String> colFirstname;
    @FXML
    public TableColumn<Noblista, String> colSurname;
    @FXML
    public TableColumn<Noblista, Integer> colYear;
    @FXML
    public TableColumn<Noblista, String> colCategory;
    @FXML
    public TableColumn<Noblista, String> colMotivation;
    @FXML
    public TableColumn<Noblista, String> colCountry;
    File fPictureNobel = new File("nobel_prize.png");
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("Pliki CSV (*.csv)", "*.csv");

    @FXML
    public void initialize() {
        ivNobel.setImage(new Image(fPictureNobel.getAbsolutePath()));
        fileChooser.getExtensionFilters().add(csvFilter);
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