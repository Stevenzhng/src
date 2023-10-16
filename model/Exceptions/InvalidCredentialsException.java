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
        // Create a new stage for the error window
        Stage errorStage = new Stage();
        Image image = new Image("/image/error.png"); // Make sure the path to your image is correct
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(380);  // set desired width
        imageView.setFitHeight(450); // set desired height
        imageView.setPreserveRatio(true);  // keep the original aspect ratio
        
        // Create the BorderPane
        BorderPane root = new BorderPane();

        // Create a scene for the error window
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
        closeButton.setMaxWidth(Double.MAX_VALUE);  // Make the button take up full width
        closeButton.setPadding(new Insets(5, 10, 5, 10));  // Padding to the button (top, right, bottom, left)        
        closeButton.setOnAction((ActionEvent event) -> errorStage.close());

        // Add the VBox to the center of the BorderPane
        root.setCenter(layout);

        // Add the button to the bottom of the BorderPane
        root.setBottom(closeButton);
        BorderPane.setMargin(closeButton, new Insets(0, 10, 10, 10)); // top, right, bottom, left

        Scene errorScene = new Scene(root, 400, 300); // width, height
        errorScene.getStylesheets().add("view/style.css");

        // Show the error window
        errorStage.setScene(errorScene);
        errorStage.show();
    }
}
