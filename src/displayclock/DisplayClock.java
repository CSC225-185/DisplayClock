package displayclock;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class DisplayClock extends Application {
    
    private Button btStopClock              = new Button("Stop Clock");         // Define stop clock button
    private Button btStartClock               = new Button("Start Clock");        // Define start clock button
    private ClockPane clock = new ClockPane();
    
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a clock and a label
        BorderPane borderPane   = new BorderPane();
        //HBox hBox               = new HBox(8);
        VBox vBox               = new VBox(8);
        GridPane gridPane       = new GridPane();
        
        //hBox.setPadding(new Insets(15, 12, 15, 12));
        vBox.setPadding(new Insets(15, 12, 15, 12));
        
        //borderPane.setTop(hBox);
        borderPane.setRight(vBox);
        borderPane.setCenter(gridPane);
     
        gridPane.getChildren().add(clock);
        vBox.getChildren().add(btStopClock);
        vBox.getChildren().add(btStartClock);
        
        // Create a handler for animation
        EventHandler<ActionEvent> eventHandler = e -> {
            clock.setCurrentTime(); // Set a new clock time
        };       

        // Create an animation for a running clock
        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation
        
        // Process events
        btStopClock.setOnAction(e -> stopClock(animation));		// Add an action listener to the calculate button
        btStartClock.setOnAction(e -> startClock(animation));

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 400, 250);
        primaryStage.setTitle("ClockAnimation"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    
    private void stopClock(Timeline animation) {
    
        animation.stop();
    
    }
    
    private void startClock(Timeline animation) {
    
        animation.play();
    
    }
}
