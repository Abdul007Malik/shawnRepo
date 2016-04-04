package gui;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SaveBox{
    static boolean answer;

    public static boolean display(String title, String message,String... note) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label1 = new Label(message);
        Label label2 = new Label("Note :"+note[0]);
        label2.setFont(Font.font("Verdana" , FontPosture.ITALIC,11.0));
        label2.setTextFill(Color.RED);

        TextField name = new TextField(Organizer.projectName);
        name.setMaxWidth(220);
        name.setDisable(true);

        Button save = new Button("Save");

        save.setOnAction(e -> {
            answer = true;
            window.close();

        });


        VBox layout = new VBox(10);

        layout.getChildren().addAll(label1,name,save);
        if(note[0]!=null) layout.getChildren().add(label2);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
