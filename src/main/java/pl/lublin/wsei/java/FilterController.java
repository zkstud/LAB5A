package pl.lublin.wsei.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


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
    private FilteredList<Noblista> filteredData;
    private SortedList<Noblista> sortedData;
    private Alert alertSucSave;

    @FXML
    public void initialize() {
        initColumns();
        try {
            observableList = FXCollections.observableArrayList(
                    new ListNoblista(Controller.getPathToCSVFile()).getNoblisci()
            );
            tvNoblista.setItems(observableList);
            filteredData = new FilteredList<>(observableList, p -> true);
        } catch (Exception e) {
            System.out.println("Blad wczytywania pliku nobel_prize_by_winner.csv => " + e.getLocalizedMessage());
            e.printStackTrace();
        }

        filterYear();
        filterCategory();
        filterCountry();

        sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvNoblista.comparatorProperty());
        tvNoblista.setItems(sortedData);
    }

    private void initColumns() {
        colFirstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        colSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMotivation.setCellValueFactory(new PropertyValueFactory<>("motivation"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
    }

    private void filterYear() {
        txtYear.textProperty().addListener((observableValue, oldVal, newVal) -> {
            filteredData.setPredicate(noblista -> {
                if (newVal == null || newVal.isEmpty()) {
                    return true;
                }

                int caseFilterYear = Integer.parseInt(newVal);
                if (String.valueOf(noblista.getYear()).contains(String.valueOf(caseFilterYear))) {
                    return true;
                }
                return false;
            });
        });
    }

    private void filterCategory() {
        txtCategory.textProperty().addListener((observableValue, oldVal, newVal) -> {
            filteredData.setPredicate(noblista -> {
                if (newVal == null || newVal.isEmpty()) {
                    return true;
                }

                String caseFilterCategory = newVal;

                if (noblista.getCategory().contains(caseFilterCategory)) {
                    return true;
                }
                return false;
            });
        });
    }

    private void filterCountry() {
        txtCountry.textProperty().addListener((observableValue, oldVal, newVal) -> {
            filteredData.setPredicate(noblista -> {
                if (newVal == null || newVal.isEmpty()) {
                    return true;
                }

                String caseFilterCountry = newVal;

                if (noblista.getCountry().contains(caseFilterCountry)) {
                    return true;
                }
                return false;
            });
        });
    }

    public void btnSaveFileAction(ActionEvent actionEvent) throws IOException {
        BufferedWriter out = null;
        ObservableList<Noblista> OLNoblista = null;
        try {
            out = new BufferedWriter(new FileWriter("noblista_filtr.csv"));
            OLNoblista = FXCollections.observableArrayList();
            OLNoblista.setAll(sortedData);
            String line = "firstname, surname, year, category, motivation, country";
            line.split("\\,");
            out.write(line);
            out.newLine();
            for (Noblista n: OLNoblista) {
                out.write(n.getDataRow());
                out.newLine();
            }
            Controller.closeEksportStage();
            alertSucSave();
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
    private void alertSucSave(){
        alertSucSave = new Alert(Alert.AlertType.INFORMATION);
        alertSucSave.setTitle("Information Dialog");
        alertSucSave.setHeaderText(null);
        alertSucSave.setContentText("Filtr został pomyślnie zapisany do pliku \"noblista_filtr.csv\""
                + "\nznajdujący się : " + Controller.getPathToCSVFile());
        alertSucSave.show();
    }
}
