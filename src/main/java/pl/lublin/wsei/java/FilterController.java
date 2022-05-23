package pl.lublin.wsei.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;

public class FilterController {
    @FXML
    public TableView<Noblista> tvFilterNoblista;
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
    public TextField txtYear;
    public TextField txtCountry;
    public TextField txtCategory;
    private ObservableList<Noblista> observableList;

    @FXML
    public void initialize() {
        colFirstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        colSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMotivation.setCellValueFactory(new PropertyValueFactory<>("motivation"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));

        try {
            observableList = FXCollections.observableArrayList(
                    new ListNoblista(Controller.getPathToCSVFile()).getNoblisci()
            );
        } catch (Exception e) {
            System.out.println("Blad wczytywania pliku nobel_prize_by_winner.csv => " + e.getLocalizedMessage());
            e.printStackTrace();
        }
        tvFilterNoblista.setItems(observableList);
    }

    public void btnSaveFileAction(ActionEvent actionEvent) {
    }

    public void changedTxtYear(InputMethodEvent inputMethodEvent) {
        
    }

    public void changedTxtCountry(InputMethodEvent inputMethodEvent) {
    }

    public void changedTxtCategory(InputMethodEvent inputMethodEvent) {
    }
}
