package pl.lublin.wsei.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    @FXML
    public Label lbFile;

    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("Pliki CSV (*.csv)", "*.csv");

    @FXML
    public void initialize(){
        fileChooser.getExtensionFilters().add(csvFilter);
    }
    @FXML
    public void btnOpenFileAction(ActionEvent actionEvent){
        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            lbFile.setText(file.getAbsolutePath());
        }else{
            lbFile.setText("Proszę wczytać plik ...");
        }
    }
}