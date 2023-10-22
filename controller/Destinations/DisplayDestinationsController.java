package controller.Destinations;

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

public class DisplayDestinationsController {
    @FXML
    private TableView<Destination> destinationsTable;
    @FXML
    private TableColumn<Destination, String> nameColumn;
    @FXML
    private TableColumn<Destination, String> countryColumn;
    @FXML
    private TextField searchField;    

    private Destinations destinations = new Destinations(new Agency());
    private ObservableList<Destination> originalList;

    @FXML
    public void initialize() {
        destinations.insertDummyData(); // Insert dummy data before populating the table    
        originalList = destinations.getDestinations();
        // Set items for the table
        destinationsTable.setItems(originalList);

        // Bind the columns to properties
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
    }

    @FXML
    private void handleSearch() {
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

    public void refreshTableView() {
        destinationsTable.setItems(destinations.getDestinations());
        destinationsTable.refresh();

        // Print destinations
        System.out.println("Destinations: ");
        for (Destination destination : destinations.getDestinations()) {
            System.out.println(destination.getName() + " - " + destination.getCountry());
        }
    }

    @FXML
    private void closeWindow(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
