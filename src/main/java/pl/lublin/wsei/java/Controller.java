package pl.lublin.wsei.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    public TableColumn<ListNoblista, String> colFirstname;
    @FXML
    public TableColumn<ListNoblista, String> colSurname;
    @FXML
    public TableColumn<ListNoblista, Integer> colYear;
    @FXML
    public TableColumn<ListNoblista, String> colCategory;
    @FXML
    public TableColumn<ListNoblista, String> colMotivation;
    @FXML
    public TableColumn<ListNoblista, String> colCountry;
    private String PathToFile = "";
    File fPictureNobel = new File("nobel_prize.png");
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("Pliki CSV (*.csv)", "*.csv");
    private ObservableList<Noblista> observableList;

    @FXML
    public void initialize() {
        ivNobel.setImage(new Image(fPictureNobel.getAbsolutePath()));
        fileChooser.getExtensionFilters().add(csvFilter);

        colFirstname.setCellValueFactory(new PropertyValueFactory<ListNoblista, String>("firstname"));
        colSurname.setCellValueFactory(new PropertyValueFactory<ListNoblista, String>("surname"));
        colYear.setCellValueFactory(new PropertyValueFactory<ListNoblista, Integer>("year"));
        colCategory.setCellValueFactory(new PropertyValueFactory<ListNoblista, String>("category"));
        colMotivation.setCellValueFactory(new PropertyValueFactory<ListNoblista, String>("motivation"));
        colCountry.setCellValueFactory(new PropertyValueFactory<ListNoblista, String>("country"));
    }
    @FXML
    public void btnOpenFileAction(ActionEvent actionEvent) {
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            lbFile.setText(file.getAbsolutePath());
             observableList = FXCollections.observableArrayList(
                    new ListNoblista(file.getAbsolutePath()).getNoblisci()
            );
            tvNoblista.setItems(observableList);
        } else {
            lbFile.setText("Proszę wczytać plik ...");
        }
    }

    public void btnSaveFileAction(ActionEvent actionEvent) {
    }

    public void btnExportFileAction(ActionEvent actionEvent) {
    }
}