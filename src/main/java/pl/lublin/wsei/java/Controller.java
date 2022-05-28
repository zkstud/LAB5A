package pl.lublin.wsei.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Controller {
    @FXML
    public Label lbYear;
    @FXML
    public Label lbCategory;
    @FXML
    public Label lbCountry;
    @FXML
    public Label lbMotivation;
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
    private final File fPictureNobel = new File("nobel_prize.png");
    private final FileChooser fileChooser = new FileChooser();
    private final FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("Pliki CSV (*.csv)", "*.csv");
    private ObservableList<Noblista> observableList;
    private static String pathToCSVFile;
    private static Stage staticEksportStage = null;

    @FXML
    public void initialize() {
        ivNobel.setImage(new Image(fPictureNobel.getAbsolutePath()));
        fileChooser.getExtensionFilters().add(csvFilter);

        initializeTable();
        initializeLabelInSelectionMode();
    }

    private void initializeTable() {
        colFirstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        colSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMotivation.setCellValueFactory(new PropertyValueFactory<>("motivation"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
    }

    private void initializeLabelInSelectionMode() {
        tvNoblista.getSelectionModel().selectedItemProperty().addListener((observableValue, noblista, t1) -> {
            lbYear.setText(String.valueOf(t1.getYear()));
            lbCategory.setText(t1.getCategory());
            lbCountry.setText(t1.getCountry());
            lbMotivation.setText(t1.getMotivation());
        });
    }

    @FXML
    public void btnOpenFileAction(ActionEvent actionEvent) {
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            lbFile.setText(file.getAbsolutePath());
            pathToCSVFile = file.getAbsolutePath();
            observableList = FXCollections.observableArrayList(
                    new ListNoblista(file.getAbsolutePath()).getNoblisci()
            );
            tvNoblista.setItems(observableList);
        } else {
            lbFile.setText("Proszę wczytać plik ...");
            pathToCSVFile = "";
        }
    }

    private void createAndOpenEksportStage() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("filter-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Lab5 ZK-37652 'Filtr noblisci'");
        stage.setScene(scene);
        File fIconsStage = new File("medal_award_icon.png");
        stage.getIcons().add(new Image(fIconsStage.getAbsolutePath()));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        staticEksportStage = stage;
    }
    public static void closeEksportStage(){
        staticEksportStage.close();
    }
    public void btnExportFileAction(ActionEvent actionEvent) throws IOException {
        if (pathToCSVFile != null) {
            createAndOpenEksportStage();
        }
    }

    public static String getPathToCSVFile() {
        return pathToCSVFile;
    }
}