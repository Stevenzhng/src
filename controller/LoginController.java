package controller;

import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import model.Administrator;
import model.Agency;
import model.Exceptions.InvalidCredentialsException;

public class LoginController extends Controller<Agency> {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorMessage;

    @FXML
    public String name;
    
    @FXML
    private Label NameLabel;
    
    @FXML
    private void LoginButton(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            if (model.getAdministrators().hasAdministrator(username, password)) {
                Administrator administrator = model.getAdministrators().getAdministrator(username, password);
                name = administrator.getName();

                // Load Agency
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AgencyView.fxml"));
                Parent root = loader.load();

                // name
                AgencyController controller = loader.getController();
                controller.setName(name);

                // stage
                Stage agencyStage = new Stage();
                agencyStage.getIcons().add(new Image("/image/agency_icon.png"));
                Scene scene = new Scene(root);
                agencyStage.setScene(scene);
                agencyStage.setTitle("Prog2 Travel Agency");
                agencyStage.show();

                Stage currentStage = (Stage) usernameField.getScene().getWindow();
                currentStage.close();
            }
        } catch (InvalidCredentialsException e) {
            e.printStackTrace();
            InvalidCredentialsException.show("Error", "InvalidCredentialsException", "Invalid credentials provided.");
        }
    }
    //set name 
    public void setNameLabel(String name) {
        NameLabel.setText(name);
    }

    @FXML
    private void ExitButton(ActionEvent event) {
        System.exit(0); //exit 
    }
}
