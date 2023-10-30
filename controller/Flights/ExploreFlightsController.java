package controller.Flights;

import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Flights;

public class ExploreFlightsController extends Controller{
    private Flights flightsModel;

    public void setFlights(Flights flights) {
        this.flightsModel = flights;
    }
    @FXML
    public void handleViewAllFlights(ActionEvent event) {
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Flights/DisplayFlightsView.fxml"));
    
            // Load scene 
            Scene scene = new Scene(loader.load());                        
            Stage popupStage = new Stage();
            popupStage.getIcons().add(new Image("/image/flights_icon.png"));
            popupStage.setScene(scene);
            popupStage.setTitle("Display Flights");
            
            popupStage.show();
            
            } catch (IOException e) {
                e.printStackTrace();
        }    
    }

    @FXML
    public void handleViewFlightsByCountry(ActionEvent event) {
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Flights/DisplayFilteredFlightsView.fxml"));
            
            // Load scene 
            Scene scene = new Scene(loader.load());
            
            Stage popupStage = new Stage();
            popupStage.getIcons().add(new Image("/image/flights_icon.png"));
            popupStage.setScene(scene);
            popupStage.setTitle("Display Flights Filtered");
            popupStage.show();
            
            } catch (IOException e) {
                e.printStackTrace();
        }    
    }

    @FXML
    public void handleAddFlight(ActionEvent event) {
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Flights/AddFlightView.fxml"));
            
            // Load scene 
            Scene scene = new Scene(loader.load());
            
            Stage popupStage = new Stage();
            popupStage.getIcons().add(new Image("/image/flights_icon.png"));
            popupStage.setScene(scene);
            popupStage.setTitle("Add Flight");
            popupStage.show();
            
            } catch (IOException e) {
                e.printStackTrace();
        }    
    }

    @FXML
    public void handleRemoveFlight(ActionEvent event) {
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Flights/RemoveFlightView.fxml"));
            
            // Load scene 
            Scene scene = new Scene(loader.load());
            
            Stage popupStage = new Stage();
            popupStage.getIcons().add(new Image("/image/flights_icon.png"));
            popupStage.setScene(scene);
            popupStage.setTitle("Remove Flight");
            popupStage.show();
            
            } catch (IOException e) {
                e.printStackTrace();
        }    
    }

    @FXML
    public void handleCloseMenu(ActionEvent event) {
        // Implement logic for closing the agency menu
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AgencyView.fxml"));
            
            // Load scene 
            Scene scene = new Scene(loader.load());
            
            Stage popupStage = new Stage();
            popupStage.getIcons().add(new Image("/image/agency_icon.png"));
            popupStage.setScene(scene);
            popupStage.setTitle("Prog2 Travel Agency");
            popupStage.show();
            
            } catch (IOException e) {
                e.printStackTrace();
        }      
    }
}

