package controller.Destinations;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Destination;
import model.Destinations;
import model.Exceptions.DuplicateItemException;

public class ModifyDestinationsController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField countryField;

    private Destinations destinations;

    // Dependency Injection: Accepting a destinations instance from the caller
    public void setDestinations(Destinations destinations) {
        this.destinations = destinations;
    }

    @FXML
    public void addDestination() {
        String name = nameField.getText().trim();
        String country = countryField.getText().trim();
        if (destinations == null) {
            System.err.println("Destinations object is null");
            return;
        }
        
        if(!name.isEmpty() && !country.isEmpty()) {
            Destination newDestination = new Destination(name, country);
            try {
                destinations.addDestination(newDestination);
            } catch (DuplicateItemException e) {
                // Handle duplicate item exception (e.g. show an error dialog)
            }
        }
    }
}
