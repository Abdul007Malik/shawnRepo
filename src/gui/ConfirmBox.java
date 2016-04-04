package gui;

    import javafx.scene.paint.Color;
    import javafx.scene.text.Font;
    import javafx.scene.text.FontPosture;
    import javafx.stage.*;
    import javafx.scene.*;
    import javafx.scene.layout.*;
    import javafx.scene.control.*;
    import javafx.geometry.*;

/*
* This Class generates a confirm box. */
public class ConfirmBox {


        static int answer;

    /*
    * This method takes arguments for setting details such as title of the generated window,
      message and any no. of note*/
        public static int display(String title, String message,String... note) {
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(title);
            window.setMinWidth(250);
            Label label = new Label(message);
            Label label2 = new Label("Note :"+note[0]);
            label2.setFont(Font.font("Verdana" , FontPosture.ITALIC,11.0));
            label2.setTextFill(Color.RED);

            Button yesButton = new Button("Yes");
            Button noButton = new Button("No");

            yesButton.setOnAction(e -> {
                answer = 1;
                window.close();

            });
            noButton.setOnAction(e -> {
                answer = 2;
                window.close();
            });


            VBox layout = new VBox(10);

            layout.getChildren().addAll(label, yesButton, noButton);
            if(note[0]!=null) layout.getChildren().add(label2);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout);
            window.setScene(scene);
            window.showAndWait();

            return answer;
        }


}
