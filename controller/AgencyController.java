package controller;

import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import controller.Destinations.ExploreDestinationsController;
import controller.Destinations.ModifyDestinationsController;
import controller.Flights.ExploreFlightsController;
import controller.Trip.DisplayTripController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Destinations;
import model.Flights;

public class AgencyController extends Controller {

    @FXML
    private Label NameLabel; 
    private String name;

    public void setName(String name) {
        this.name = name;
        NameLabel.setText(this.name); 
    }

    private Destinations destinationsModel;
    private Flights flightsModel;

    public void setDestinationsModel(Destinations destinations) {
        this.destinationsModel = destinations;
    }
    public void setFlightsModel(Flights flights) {
        this.flightsModel = flights;
    }

    @FXML
    public void ExploreFlight(ActionEvent event) {
    try {
        // Load FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Flights/ExploreFlightsView.fxml"));
        
        // Load scene 
        Scene scene = new Scene(loader.load());
        ExploreFlightsController controller = loader.getController();
        controller.setFlights(flightsModel);
        controller.setName(name);
        Stage popupStage = new Stage();
        popupStage.getIcons().add(new Image("/image/flights_icon.png"));
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
            ExploreDestinationsController controller = loader.getController();
            controller.setDestinations(destinationsModel);
            controller.setName(name);
            Stage popupStage = new Stage();
            popupStage.getIcons().add(new Image("/image/destinations_icon.png"));
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
        DisplayTripController controller = loader.getController();
        controller.setName(name);        
        Stage popupStage = new Stage();
        popupStage.getIcons().add(new Image("/image/trip_icon.png"));
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

}
