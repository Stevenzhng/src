package controller.Destinations;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    
    @FXML
    public void addDestination() throws DuplicateItemException {
        String name = nameField.getText();//get destination name
        String country = countryField.getText(); //get destination country

        try {
        Destination destination = new Destination(name, country);
        destinationsInstance.addDestination(destination);
        System.out.println("Added destination: " + name + ", " + country);
        } catch (DuplicateItemException e) { 
            System.err.println("Error");
            e.printStackTrace();
            DuplicateItemException.show("Error", "DuplicateItemException", "Duplicate found.");            
        }

    }
    
    public void removeDestination() throws ItemNotFoundException {
        String name = nameField.getText(); //get destination name
        String country = countryField.getText(); //get destination country 

        try {
            Destination destinationToRemove = destinationsInstance.destination(name, country);
            destinationsInstance.removeDestination(destinationToRemove); //remove
            System.out.println("Removed destination " + name + ", " + country);
        } catch (ItemNotFoundException e) {
            System.err.println("Error");
            e.printStackTrace();
            ItemNotFoundException.show("Error", "ItemNotFoundException", "Item not found.");            
        }
    }

    @FXML
    private void closeWindow(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close(); //exit 
    }   
}
