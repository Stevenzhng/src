package controller;

import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AgencyController extends Controller {

    @FXML
    private Label NameLabel; 
    
    @FXML
    public void ExploreFlight(ActionEvent event) {
    try {
        // Load FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Flights/ExploreFlightsView.fxml"));
        
        // Load scene 
        Scene scene = new Scene(loader.load());
        
        Stage popupStage = new Stage();

        popupStage.setScene(scene);
        popupStage.setTitle("Explore Flights");
        popupStage.show();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ExploreDestination(ActionEvent event) {
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Destinations/ExploreDestinationsView.fxml"));
            
            // Load scene 
            Scene scene = new Scene(loader.load());
            
            Stage popupStage = new Stage();
    
            popupStage.setScene(scene);
            popupStage.setTitle("Explore Destinations");
            popupStage.show();
            
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
    @FXML
    public void BookTrip(ActionEvent event) {
    try {
        // Load FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Trip/DisplayTripView.fxml"));
        
        // Load scene 
        Scene scene = new Scene(loader.load());
        
        Stage popupStage = new Stage();

        popupStage.setScene(scene);
        popupStage.setTitle("Book Trip");
        popupStage.show();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ExitButton(ActionEvent event) {
        System.exit(0); // This will terminate the application.
    }

    public void setName(String name) {
        NameLabel.setText(name);
    }
}
