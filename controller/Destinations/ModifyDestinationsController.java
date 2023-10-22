package controller.Destinations;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Destinations;
import model.Destination;
import model.Agency;

public class ModifyDestinationsController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField countryField;

    private Destinations destinations;

    public ModifyDestinationsController() {
        this.destinations = new Destinations(new Agency()); // Replace with your logic to get Destinations instance
    }
    DisplayDestinationsController displayDestinationsController;

    public void setDisplayDestinationsController(DisplayDestinationsController controller) {
        this.displayDestinationsController = controller;
    }

    @FXML
    private void addDestination() {
        String name = nameField.getText();
        String country = countryField.getText();

        if (name.isEmpty() || country.isEmpty()) {
            // Show error message
            System.out.println("Name and country cannot be empty");
            return;
        }

        Destination destination = new Destination(name, country);
        try {
            destinations.addDestination(destination);
            // Show success message
            System.out.println("Destination added successfully!");
            System.out.println(destinations.getDestinations());
            displayDestinationsController.refreshTableView();
        } catch (Exception e) {
            // Show error message
            System.out.println("Failed to add destination: " + e.getMessage());
        }
    }
}
