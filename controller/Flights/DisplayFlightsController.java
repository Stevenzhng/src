package controller.Flights;

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
import model.Flights;
import model.Agency;
import model.Destinations;
import model.Flight;


public class DisplayFlightsController {
    @FXML
    private TableView<Flight> flightsTable;
    @FXML
    private TableColumn<Flight, String> airlineColumn;
    @FXML
    private TableColumn<Flight, Integer> flightNumberColumn;
    @FXML
    private TableColumn<Flight, String> takeoffCountryColumn;
    @FXML
    private TableColumn<Flight, String> landingCountryColumn;
    @FXML
    private TableColumn<Flight, Double> costColumn;
    @FXML
    private TextField searchField;

    private Flights flights = Flights.getInstance(new Agency());
    private ObservableList<Flight> originalList;

    
    @FXML
    public void initialize() {    
        originalList = flights.getFlights();
        // Set table
        flightsTable.setItems(originalList);

        // columns
        airlineColumn.setCellValueFactory(new PropertyValueFactory<>("airline"));
        flightNumberColumn.setCellValueFactory(new PropertyValueFactory<>("flightNo"));
        takeoffCountryColumn.setCellValueFactory(new PropertyValueFactory<>("takeoff"));
        landingCountryColumn.setCellValueFactory(new PropertyValueFactory<>("landing"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
    }

    @FXML
    private void handleSearch() { //search the oberservable list 
        String searchQuery = searchField.getText().toLowerCase();
        if (searchQuery.isEmpty()) {
            flightsTable.setItems(originalList);
        } else {
            ObservableList<Flight> filteredList = FXCollections.observableArrayList();
            for (Flight flight : originalList) {
                if (flight.getTakeoff().toLowerCase().contains(searchQuery) ||
                        flight.getLanding().toLowerCase().contains(searchQuery)) {
                    filteredList.add(flight);
                }
            }
            flightsTable.setItems(filteredList);
        }
    }

    @FXML
    private void closeWindow(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close(); //exit 
    }    
}