package gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    Organizer organizer;
    @Override
    public void start(Stage primaryStage) throws Exception{

        organizer = new Organizer();
        organizer.setStage(primaryStage);
        organizer.setScene(": OutSet","StartScene.fxml",600,400);

    }


    public static void main(String[] args) {

        launch(args);

    }
}
