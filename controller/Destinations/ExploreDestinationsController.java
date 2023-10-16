package controller.Destinations;

import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ExploreDestinationsController extends Controller{
    // Your existing code here

    @FXML
    public void handleViewAllDestinations(ActionEvent event) {
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Destinations/DisplayDestinationsView.fxml"));
            
            // Load scene 
            Scene scene = new Scene(loader.load());
            
            Stage popupStage = new Stage();
    
            popupStage.setScene(scene);
            popupStage.setTitle("View Destinations");
            popupStage.show();
            
            } catch (IOException e) {
                e.printStackTrace();
        }    
    }

    @FXML
    public void handleViewFilterDestinations(ActionEvent event) {
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Destinations/DisplayFilteredDestinationsView.fxml"));
            
            // Load scene 
            Scene scene = new Scene(loader.load());
            
            Stage popupStage = new Stage();
    
            popupStage.setScene(scene);
            popupStage.setTitle("Display Filtered Destination");
            popupStage.show();
            
            } catch (IOException e) {
                e.printStackTrace();
        }    
    }

    @FXML
    public void handleAddDestination(ActionEvent event) {
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Destinations/AddDestinationView.fxml"));
            
            // Load scene 
            Scene scene = new Scene(loader.load());
            
            Stage popupStage = new Stage();
    
            popupStage.setScene(scene);
            popupStage.setTitle("Add Destination");
            popupStage.show();
            
            } catch (IOException e) {
                e.printStackTrace();
        }    
    }

    @FXML
    public void handleRemoveDestination(ActionEvent event) {
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Destinations/RemoveDestinationView.fxml"));
            
            // Load scene 
            Scene scene = new Scene(loader.load());
            
            Stage popupStage = new Stage();
    
            popupStage.setScene(scene);
            popupStage.setTitle("Remove Destination");
            popupStage.show();
            
            } catch (IOException e) {
                e.printStackTrace();
        }    
    }

    @FXML
    public void handleCloseMenu(ActionEvent event) {
        // Implement logic for closing the agency menu
    }
}


