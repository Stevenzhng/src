package controller.Flights;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import model.Flight;
import model.Flights;

public class ModifyFlightsController {

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

    private Flights flights;

    public void setFlights(Flights flights) {
        this.flights = flights;
    }

    @FXML
    private void handleAddFlight(ActionEvent event) {
        String airline = airlineField.getText();
        int flightNumber = Integer.parseInt(flightNumberField.getText());
        String takeoffCountry = takeoffCountryField.getText();
        String landingCountry = landingCountryField.getText();
        double cost = Double.parseDouble(costField.getText());

        // Create a new flight object
        Flight newFlight = new Flight(airline, flightNumber, takeoffCountry, landingCountry, cost);

        // Add the new flight to the observable list
        flights.getFlights().add(newFlight);

        // Clear the text fields
        airlineField.clear();
        flightNumberField.clear();
        takeoffCountryField.clear();
        landingCountryField.clear();
        costField.clear();
    }
}
