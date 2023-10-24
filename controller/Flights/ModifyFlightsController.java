package controller.Flights;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Agency;
import model.Destination;
import model.Destinations;
import model.Flight;
import model.Flights;
import model.Exceptions.DuplicateItemException;
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

        Flight flight = new Flight(airline, flightNo, takeoff, landing, cost);
        flightsInstance.addFlight(flight);
            System.out.println("Added flight: " + airline + ", " + flightNo +  ", " + takeoff +  ", " + landing +  ", " + cost);
    }

    public void removeFlight() throws DuplicateItemException {
        String airline = airlineField.getText();
        int flightNo = Integer.parseInt(flightNumberField.getText());
        String takeoff = takeoffCountryField.getText();
        String landing = landingCountryField.getText();
        double cost = Double.parseDouble(costField.getText());

        Flight flightToRemove = new Flight(airline, flightNo, takeoff, landing, cost);

        try {
            flightsInstance.removeFlight(flightToRemove);
            System.out.println("Removed flight: " + airline + ", " + flightNo +  ", " + takeoff +  ", " + landing +  ", " + cost);
        } catch (ItemNotFoundException e) {
            System.err.println("Error: flight not found!");
        }
    }
}

