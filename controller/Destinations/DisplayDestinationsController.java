package controller.Destinations;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Destination;
import model.Destinations;
import model.Agency;

public class DisplayDestinationsController extends Controller{
    @FXML
    private TableView<Destination> destinationsTable;
    @FXML
    private TableColumn<Destination, String> nameColumn;
    @FXML
    private TableColumn<Destination, String> countryColumn;
    @FXML
    private TextField searchField;    

    private Destinations destinations = Destinations.getInstance(new Agency());
    private ObservableList<Destination> originalList;

    @FXML
    public void initialize() {
        if (!destinations.hasDummyData()) {
            destinations.insertDummyData();
        }
        originalList = destinations.getDestinations();
        // Set table
        destinationsTable.setItems(originalList);

        //columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));    
    }

    @FXML
    private void handleSearch() {//search the oberservable list 
        String searchQuery = searchField.getText().toLowerCase();
        if (searchQuery.isEmpty()) {
            destinationsTable.setItems(originalList);
        } else {
            ObservableList<Destination> filteredList = FXCollections.observableArrayList();
            for (Destination destination : originalList) {
                if (destination.getName().toLowerCase().contains(searchQuery) ||
                        destination.getCountry().toLowerCase().contains(searchQuery)) {
                    filteredList.add(destination);
                }
            }
            destinationsTable.setItems(filteredList);
        }
    }

    @FXML
    private void closeWindow(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();// exit 
    }
}
