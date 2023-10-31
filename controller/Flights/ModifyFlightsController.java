package controller.Flights;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import model.Agency;
import model.Destination;
import model.Destinations;
import model.Flight;
import model.Flights;
import model.Exceptions.DuplicateItemException;
import model.Exceptions.InvalidCredentialsException;
import model.Exceptions.ItemNotFoundException;

public class ModifyFlightsController extends Controller{

    // Declare the TextField controls
    @FXML
    private TextField airlineField;
    @FXML
    private TextField flightNumberField;
    @FXML
    private TextField takeoffCountryField;
    @FXML
    private TextField landingCountryField;
    @FXML
    private TextField costField;

    private Flights flightsInstance = Flights.getInstance(new Agency());

    @FXML
    public void addFlight() throws DuplicateItemException {
        String airline = airlineField.getText();
        int flightNo = Integer.parseInt(flightNumberField.getText());
        String takeoff = takeoffCountryField.getText();
        String landing = landingCountryField.getText();
        double cost = Double.parseDouble(costField.getText());

        try {
        Flight flight = new Flight(airline, flightNo, takeoff, landing, cost);
        flightsInstance.addFlight(flight);
            System.out.println("Added flight: " + airline + ", " + flightNo +  ", " + takeoff +  ", " + landing +  ", " + cost);
        } catch (DuplicateItemException e) { 
            System.err.println("Error");
            e.printStackTrace();
            DuplicateItemException.show("Error", "DuplicateItemException", "Duplicate found.");            
        }    
    }
    
    @FXML
    public void removeFlight() {
        String takeoff = takeoffCountryField.getText();
        String landing = landingCountryField.getText();
    
        try {
            Flight flightToRemove = flightsInstance.getFlight(takeoff, landing); // get the flight 
            flightsInstance.removeFlight(flightToRemove); // remove  flight
            System.out.println("Removed flight with takeoff from: " + takeoff + " and landing in: " + landing);
        } catch (ItemNotFoundException e) {
            System.err.println("Error");
            e.printStackTrace();
            ItemNotFoundException.show("Error", "ItemNotFoundException", "Item not found.");

        }
    }
    
    
    @FXML
    private void closeWindow(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }     
}

