package displayclock;

/*
 * CSC-225 - Advanced JAVA Programming
 * Project 3 - Animated Clock Lab Assignment
 * Class Description : This is the driver class for the loan calculator program
 * Author            : Original Author Unknown - Code supplied in class
 * Modified by       : Jacob Johncox, Benjamin Kleynhans, and Jake Neels
 * Date              : October 20, 2017
 * Filename          : AnimatedClock.java
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * <h1>
 *      CSC-225 - Advanced JAVA Programming - Animated Clock Lab Assignment
 * </h1>
 * <p>
 *      This is the driver class for the Animated Clock program
 * </p>
 *
 * @author Jacob Johncox (M00864758)
 * @author Benjamin Kleynhans (M00858194)
 * @author Jake Neels (M00696306)
 * 
 * @version 1.0
 * @since October 20, 2017
 */

public class AnimatedClock extends Application {
    
    private final Button      btStopClock     = new Button("Stop Clock");       // Define stop clock button
    private final Button      btStartClock    = new Button("Start Clock");      // Define start clock button
    private final ClockPane   clock           = new ClockPane();                // Define a clock object
    
    @Override                                                                   // Override the start method in the Application class
    public void start(Stage primaryStage) {
        
        BorderPane borderPane   = new BorderPane();                             // Create a borderpane to assist with element placement
        VBox vBox               = new VBox(8);                                  // Create a vertical box for the borderpane
        GridPane gridPane       = new GridPane();                               // Create a gridpane
        
        vBox.setPadding(new Insets(15, 12, 15, 12));                            // Define space formatting for vertical box
        
        borderPane.setRight(vBox);                                              // Place the vertical box in the right side of the borderpane
        borderPane.setCenter(gridPane);                                         // Place the gridpane in the center of the borderpane
     
        gridPane.getChildren().add(clock);                                      // Add the clock element to the gridpane
        vBox.getChildren().add(btStopClock);                                    // Add the stop clock button to the vertical box
        vBox.getChildren().add(btStartClock);                                   // Add the start clock button to the vertical box
        
        EventHandler<ActionEvent> updateClock = e -> {                          // Create event handler to update clock time
            clock.setCurrentTime();                                             // Set a new clock time
        };       

        Timeline animation = new Timeline(                                      // Create an animation to animate the clock
                new KeyFrame(Duration.millis(1000), updateClock));
        animation.setCycleCount(Timeline.INDEFINITE);                           // Set the animation to run indefinately
        animation.play();                                                       // Start clock animation
        
        btStopClock.setOnAction(e -> stopClock(animation));                     // Add an action listener to the Stop Clock button
        btStartClock.setOnAction(e -> startClock(animation));                   // Add an action listener to the Start Clock button

        Scene scene = new Scene(borderPane, 400, 250);                          // Create a scene containing a border pane with specified dimensions
        
        primaryStage.setTitle("ClockAnimation");                                // Set the stage title
        primaryStage.setScene(scene);                                           // Place the scene in the stage
        primaryStage.show();                                                    // Display the stage
    }
    
    /**
     * Calls the stop method from the Timeline class to stop the clock
     * 
     * @param animation Timeline object that manages the animation of the clock
     */
    
    private void stopClock(Timeline animation) {
    
        animation.stop();                                                       // Stop clock animation
    
    }
    
    /**
     * Calls the play method from the Timeline class to start the clock
     * 
     * @param animation Timeline object that manages the animation of the clock
     */
    
    private void startClock(Timeline animation) {
    
        animation.play();                                                       // Start clock animation
    
    }
}
