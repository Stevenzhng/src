package controller.Trip;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BookTripController {

    @FXML
    public void viewIndividual(ActionEvent event) { 
        
    }

    @FXML
    public void handleCloseMenu(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }     
}
