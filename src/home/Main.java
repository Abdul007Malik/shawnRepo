package home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Organizer organizer;
    @Override
    public void start(Stage primaryStage) throws Exception{

        organizer = new Organizer();
        organizer.setStage(primaryStage);
        organizer.setScene(": OutSet","StartScene.fxml",400,600);

    }


    public static void main(String[] args) {

        launch(args);

    }
}
