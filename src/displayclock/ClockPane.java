package displayclock;

/*
 * CSC-225 - Advanced JAVA Programming
 * Project 3 - Animated Clock Lab Assignment
 * Class Description : This is the driver class for the Animated Clock program
 * Author            : Original Author Unknown - Code supplied in class
 * Modified by       : Jacob Johncox, Benjamin Kleynhans, and Jake Neels
 * Date              : October 20, 2017
 * Filename          : ClockPane.java
 */

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

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

public final class ClockPane extends Pane {

    private int hour;                                                           // Define a hour variable
    private int minute;                                                         // Define a minute variable
    private int second;                                                         // Define a second variable

    private double width = 250, height = 250;                                   // Define the dimensions of the object

    /**
     * Constructs a default clock with the current time
     */
    
    public ClockPane() {
        
        setCurrentTime();
        
    }

    /**
     * Construct a clock with specified hour, minute, and second
     * 
     * @param hour Variable containing hour of current time
     * @param minute Variable containing minute of current time
     * @param second Variable containing second of current time
     */
    
    public ClockPane(int hour, int minute, int second) {
        
        this.hour = hour;                                                       // Set hour object variable to current hour
        this.minute = minute;                                                   // Set minute object variable to current minute
        this.second = second;                                                   // Set second object variable to current second
        
        paintClock();                                                           // Update the clock face with the new time information
        
    }

    /**
     * Return hour
     * 
     * @return Return current object variable hour value
     */
    
    public int getHour() {
        
        return hour;
        
    }

    /**
     * Set a new hour
     * 
     * @param hour Hour from current time
     */
    
    public void setHour(int hour) {
        
        this.hour = hour;
        
        paintClock();                                                           // Update the clock face with the new time information
        
    }

    /**
     * Return minute
     * 
     * @return Return current object variable minute value
     */
    
    public int getMinute() {
        
        return minute;
        
    }

    /**
     * Set a new minute
     * 
     * @param minute Minute from current time
     */
    
    public void setMinute(int minute) {
        
        this.minute = minute;
        
        paintClock();                                                           // Update the clock face with the new time information
        
    }

    /**
     * Return second
     * 
     * @return Return current object variable second value
     */
    
    public int getSecond() {
        
        return second;
        
    }

    /**
     * Set a new second
     * 
     * @param second Second from current time
     */
    
    public void setSecond(int second) {
        
        this.second = second;
        
        paintClock();                                                           // Update the clock face with the new time information
        
    }

    /**
     * Return clock pane's width
     * 
     * @return width Current object variable preferred width value
     */
    
    public double getW() {
        
        return width;
        
    }

    /**
     * Set clock pane's width
     * 
     * @param width Set the required width of the clock object
     */
    
    public void setW(double width) {
        
        this.width = width;                                                     // Set width of clock object variable
        
        paintClock();                                                           // Update the clock face with the new time information
        
    }

    /**
     * Return clock pane's height
     * 
     * @return height Current object variable preferred height value
     */
    
    public double getH() {
        
        return height;
        
    }

    /**
     * Set clock pane's height
     * 
     * @param height Set the required height of the clock object
     */
    
    public void setH(double height) {
        
        this.height = height;
        
        paintClock();                                                           // Update the clock face with the new time information
        
    }

    /* Set the current time for the clock */
    public void setCurrentTime() {
        
        // Construct a calendar for the current date and time
        Calendar calendar = new GregorianCalendar();

        // Set current hour, minute and second
        this.hour   = calendar.get(Calendar.HOUR_OF_DAY);                       // Get current hour from Calendar object and set variable
        this.minute = calendar.get(Calendar.MINUTE);                            // Get current minute from Calendar object and set variable
        this.second = calendar.get(Calendar.SECOND);                            // Get current second from Calendar object and set variable

        paintClock();                                                           // Update the clock face with the new time information
        
    }

    /**
     * Paint the clock
     */
    
    protected void paintClock() {
        
        // Initialize clock parameters
        double clockRadius = Math.min(width, height) * 0.8 * 0.5;               // Define clock radius
        double centerX = width / 2;                                             // Define x-coordinate of clock center
        double centerY = height / 2;                                            // Define y-coordinate of clock center

        // Draw circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);                                            // Set fill color of clock
        circle.setStroke(Color.BLACK);                                          // Set circle color of clock
        Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");      // Add numbers to clock display
        Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

        // Draw second hand
        double sLength = clockRadius * 0.8;                                     // Set length of second hand
        double secondX = centerX + sLength                                      // Define x-coordinate of second hand end point
                * Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength                                      // Define y-coordinate of second hand end point
                * Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);              // Create second line object
        sLine.setStroke(Color.RED);                                             // Draw second hand

        // Draw minute hand
        double mLength = clockRadius * 0.65;                                    // Set length of minute hand
        double xMinute = centerX + mLength                                      // Define x-coordinate of minute hand end point
                * Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength                                      // Define y-coordinate of minute hand end point
                * Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, xMinute, minuteY);              // Create minute line object
        mLine.setStroke(Color.BLUE);                                            // Draw minute hand

        // Draw hour hand
        double hLength = clockRadius * 0.5;                                     // Set length of hour hand
        double hourX = centerX + hLength                                        // Define x-coordinate of hour hand end point
                * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength                                        // Define y-coordinate of hour hand end point
                * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));        
        Line hLine = new Line(centerX, centerY, hourX, hourY);                  // Create hour line object
        hLine.setStroke(Color.GREEN);                                           // Draw hour hand

        getChildren().clear();                                                  // Remove all elements from the clock face
        getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);      // Add all updated elements to the clock face
        
    }
}
