package model.Exceptions;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.ImageView;

public class InvalidCredentialsException extends Exception {

    public static void show(String... messages) {
        // Create stage 
        Stage errorStage = new Stage();
        Image image = new Image("/image/error.png"); 
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(380);  
        imageView.setFitHeight(450); 
        imageView.setPreserveRatio(true);  
        
        BorderPane root = new BorderPane();

        // Create scene 
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(imageView);

        for (String message : messages) {
            Label messageLabel = new Label(message);

            if ("InvalidCredentialsException".equals(message)) {
                messageLabel.getStyleClass().add("errorLabel");
            } else {
                messageLabel.getStyleClass().add("label");
            }

            layout.getChildren().add(messageLabel);
        }

        Button closeButton = new Button("Close");
        closeButton.setMaxWidth(Double.MAX_VALUE);  
        closeButton.setPadding(new Insets(5, 10, 5, 10));  
        closeButton.setOnAction((ActionEvent event) -> errorStage.close());

        root.setCenter(layout);

        root.setBottom(closeButton);
        BorderPane.setMargin(closeButton, new Insets(0, 10, 10, 10)); 

        Scene errorScene = new Scene(root, 400, 300); 
        errorScene.getStylesheets().add("view/style.css");

        errorStage.setScene(errorScene);
        errorStage.show();
    }
}
