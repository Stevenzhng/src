package controller.Flights;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Flights;


public class DisplayFlightsController extends Controller<Flights>  {
    @FXML
    private TextField Airline;    
    @FXML
    private TextField FlightNumber; 
    @FXML
    private TextField TakeoffCountry;     
    @FXML
    private TextField LandingCountry; 
    @FXML
    private TextField Cost;     
}
