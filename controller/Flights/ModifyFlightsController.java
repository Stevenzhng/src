package controller.Flights;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Flight;
import model.Flights;
import model.Exceptions.DuplicateItemException;

public class ModifyFlightsController {

    private Flights flights;

    public ModifyFlightsController() {
    }

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

    @FXML
    public void addFlight() throws DuplicateItemException, NumberFormatException {
        String airline = airlineField.getText();
        int flightNo = Integer.parseInt(flightNumberField.getText());
        String takeoff = takeoffCountryField.getText();
        String landing = landingCountryField.getText();
        double cost = Double.parseDouble(costField.getText());
    
        Flight newFlight = new Flight(airline, flightNo, takeoff, landing, cost);
        flights.addFlight(newFlight);
    }
    
}
