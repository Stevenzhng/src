package controller.Destinations;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Destinations; // Assuming the correct class is here
import model.Exceptions.DuplicateItemException;
import model.Exceptions.ItemNotFoundException;
import model.Agency;
import model.Destination; // Assuming the correct class is here

public class ModifyDestinationsController {       

    @FXML
    private TextField nameField;

    @FXML
    private TextField countryField;

    private Destinations destinationsInstance = Destinations.getInstance(new Agency());

    public void addDestination() throws DuplicateItemException {
        String name = nameField.getText();
        String country = countryField.getText();

        Destination destination = new Destination(name, country);
        destinationsInstance.addDestination(destination);
        System.out.println("Added destination: " + name + ", " + country);
    }
    
    public void removeDestination() throws ItemNotFoundException {
        String name = nameField.getText();
        String country = countryField.getText();

        Destination destinationToRemove = new Destination(name, country);

        try {
            destinationsInstance.removeDestination(destinationToRemove);
            System.out.println("Removed destination: " + name + ", " + country);
        } catch (ItemNotFoundException e) {
            System.err.println("Error: Destination not found!");
        }
    }
}
