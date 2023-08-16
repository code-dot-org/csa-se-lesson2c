package com.codedotorg;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HarmonyHelper {

    /** The main window to display the app */
    private Stage window;

    /** The width of the scene in the app */
    private int width;

    /** The height of the scene in the app */
    private int height;

    /** The list of instruments */
    private ArrayList<Instrument> instruments;

    /** The ListView containing the names of instruments */
    private ListView<String> listView;

    /** The text field for the user to enter an instrument */
    private TextField inputField;

    /**
     * Constructs a new HarmonyHelper object with the given window, width, and height.
     * Initializes an empty list of instruments, a ListView for displaying instruments,
     * and a TextField for user input.
     *
     * @param window the Stage object representing the application window
     * @param width the width of the application window
     * @param height the height of the application window
     */
    public HarmonyHelper(Stage window, int width, int height) {
        this.window = window;
        this.width = width;
        this.height = height;

        instruments = new ArrayList<Instrument>();
        listView = new ListView<String>();
        inputField = new TextField();
    }
    
    /**
     * Starts the Harmony Helper application by setting the title of the window to "Harmony Helper",
     * creating the main scene, adding the stylesheets, setting the scene to the main scene, and showing the window.
     */
    public void startApp() {
        window.setTitle("Harmony Helper");
        
        Scene mainScene = createMainScene();
        mainScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        window.setScene(mainScene);
        window.show();
    }

    /**
     * Creates the main scene for the Harmony Helper application.
     * 
     * @return the main scene
     */
    public Scene createMainScene() {
        Label titleLabel = new Label("Harmony Helper");
        Button addButton = createAddButton();

        VBox mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(titleLabel, inputField, addButton, listView);

        Scene mainScene = new Scene(mainLayout, width, height);

        return mainScene;
    }

    /**
     * Adds a new instrument to the list of instruments.
     * It first retrieves the text from the input field, checks if it's not empty,
     * then creates a new Instrument object with the input text and adds it to the instruments list.
     * After adding the new instrument, it sorts the instruments list, refreshes the list view,
     * and finally clears the input field.
     */
    public void addInstrument() {
        String newInstrument = inputField.getText();

        if (!newInstrument.isEmpty()) {
            instruments.add(new Instrument(newInstrument));
            refreshList();
            inputField.clear();
        }
    }

    /**
     * Sorts the instruments in the 'instruments' list based on their names.
     */
    public void sortInstruments() {
        

    }

    /**
     * Refreshes the list of instruments displayed in the listView.
     * It first clears the listView, then iterates over the 'instruments' list,
     * adding each instrument's name to the listView.
     */
    public void refreshList() {
        listView.getItems().clear();

        for (Instrument instrument : instruments) {
            listView.getItems().add(instrument.getName());
        }
    }

    /**
     * Creates a button with the text "Add Instrument" and
     * sets its action to call the addInstrument() method.
     * 
     * @return the created button
     */
    public Button createAddButton() {
        Button tempButton = new Button("Add Instrument");

        tempButton.setOnAction(event -> {
            addInstrument();
        });

        return tempButton;
    }

}
