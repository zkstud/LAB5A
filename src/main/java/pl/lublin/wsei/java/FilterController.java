package pl.lublin.wsei.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;

import java.util.Locale;

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

        FilteredList<Noblista> filteredData = new FilteredList<>(observableList, p -> true);

        txtYear.textProperty().addListener((observableValue, oldVal, newVal) -> {
            filteredData.setPredicate(noblista -> {
                if (newVal == null || newVal.isEmpty()) {
                    return true;
                }

                int caseFilterYear = Integer.parseInt(newVal);

                if (noblista.getDataRow().contains(String.valueOf(caseFilterYear))) {
                    return true;
                }
                return false;
            });
        });

        txtCountry.textProperty().addListener((observableValue, oldVal, newVal) -> {
            filteredData.setPredicate(noblista -> {
                if (newVal == null || newVal.isEmpty()) {
                    return true;
                }

                String lowerCaseFilterCountry = newVal.toLowerCase();

                if (noblista.getDataRow().contains(lowerCaseFilterCountry)) {
                    return true;
                }
                return false;
            });
        });

        txtCategory.textProperty().addListener((observableValue, oldVal, newVal) -> {
            filteredData.setPredicate(noblista -> {
                if (newVal == null || newVal.isEmpty()) {
                    return true;
                }

                String caseFilterCategory = newVal.toLowerCase();

                if (noblista.getDataRow().contains(caseFilterCategory)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<Noblista> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvFilterNoblista.comparatorProperty());
        tvFilterNoblista.setItems(sortedData);
    }

    public void btnSaveFileAction(ActionEvent actionEvent) {
    }
}
