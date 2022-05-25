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


public class FilterController {
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
    public TextField txtYear;
    public TextField txtCountry;
    public TextField txtCategory;
    private ObservableList<Noblista> observableList;
    private String dataRowCheck;

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
        tvNoblista.setItems(observableList);
        FilteredList<Noblista> filteredData = new FilteredList<>(observableList, p -> true);

        txtYear.textProperty().addListener((observableValue, oldVal, newVal) -> {
            filteredData.setPredicate(noblista -> {
                if (newVal == null || newVal.isEmpty()) {
                    return true;
                }

                int caseFilterYear = Integer.parseInt(newVal);
                if (noblista.getDataRow().contains(String.valueOf(caseFilterYear))) {
                    dataRowCheck += String.valueOf(caseFilterYear);
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

                String caseFilterCountry = newVal;

                if (noblista.getDataRow().contains(caseFilterCountry)) {
                    dataRowCheck += caseFilterCountry;
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
                    dataRowCheck += caseFilterCategory;
                    return true;
                }
                return false;
            });
        });

        SortedList<Noblista> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvNoblista.comparatorProperty());
        tvNoblista.setItems(sortedData);
    }

//    public void dataRowTableCheck(Noblista nob) {
//        if(nob.getDataRow().contains(dataRowCheck)){
//
//        }
//    }

    public void btnSaveFileAction(ActionEvent actionEvent) {
    }
}
