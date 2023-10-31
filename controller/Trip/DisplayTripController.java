package controller.Trip;

import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class DisplayTripController extends Controller{
    // Your existing code here

    @FXML
    private Label NameLabel;

    public void setName(String name) {
        NameLabel.setText(name);
    }
        
    @FXML
    public void handleViewAddDestination(ActionEvent event) {
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Destinations/AddDestinationView.fxml"));
            
            // Load scene 
            Scene scene = new Scene(loader.load());
            
            Stage popupStage = new Stage();
            popupStage.getIcons().add(new Image("/image/destination_icon.png"));    
            popupStage.setScene(scene);
            popupStage.setTitle("Display Trip Destination");
            popupStage.show();
            
            } catch (IOException e) {
                e.printStackTrace();
        }    
    }

    @FXML
    public void handleViewRemoveDestination(ActionEvent event) {
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Destinations/RemoveDestinationView.fxml"));
            
            // Load scene 
            Scene scene = new Scene(loader.load());
            
            Stage popupStage = new Stage();
            popupStage.getIcons().add(new Image("/image/destination_icon.png"));    
            popupStage.setScene(scene);
            popupStage.setTitle("Remove Trip Destination");
            popupStage.show();
            
            } catch (IOException e) {
                e.printStackTrace();
        }     }

    @FXML
    public void handleAddConnectingFlight(ActionEvent event) {
        // Implement logic for adding a new flight
    }

    @FXML
    public void handleViewTrip(ActionEvent event) {
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Trip/BookTripView.fxml"));
            
            // Load scene 
            Scene scene = new Scene(loader.load());
            
            Stage popupStage = new Stage();
            popupStage.getIcons().add(new Image("/image/trip_icon.png"));    
            popupStage.setScene(scene);
            popupStage.setTitle("Your Trip");
            popupStage.show();
            
            } catch (IOException e) {
                e.printStackTrace();
        }     
    }

    @FXML
    public void handleCloseMenu(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    } 
}


