package home;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ProjectListController{

    private VBox vBox;
    HBox buttonBox;
    HBox listBox;
    ListView<String> listView;
    Button oKButton, cancelButton;
    ProjectList projectList;
    ObservableList<String> list , projectName;
    private Boolean answer;


    /*
      This class only Constructor:
    *  that initialises the member of the class
    *  And responsible for constructing member of the Scene         */


    public ProjectListController(){
        projectList = new ProjectList();
        vBox = new VBox();
        oKButton = new Button("OK");
        oKButton.setDisable(Boolean.TRUE);
        cancelButton = new Button("Cancel");
        buttonBox = new HBox(15);
        buttonBox.setPadding(new Insets(4.0,4.0,4.0,4.0));
        listBox = new HBox();
        listView = new ListView<>();
        listBox.getChildren().add(listView);
        vBox.getChildren().addAll(listBox , buttonBox);


    }
    /*
    This method:
    * populate the list via ObservableList class into ListView
    * control the buttons of the generated Scene using buttonControl
    * it returns the String which is used as a key for Map */

    public String getProjectList(Stage listStage){

        String temp = null;
        buttonBox.getChildren().addAll(oKButton, cancelButton);
        list = FXCollections.observableArrayList(projectList.getProjectNameList());
        listView.setItems(list);
        buttonControl(listStage);
        listStage.setTitle("Load Project");
        listStage.setScene(new Scene(vBox,200,250));
        listStage.showAndWait();
        if(answer) {
           temp = projectName.toString();
        }
        return temp;
    }

    /*
    This method :
    * Controls the oK and Cancel buttton of the Constructed Scene*/
    protected void buttonControl(Stage stage){

        if(listView.getItems().size() > 1){
            oKButton.setDisable(Boolean.FALSE);
        }
        oKButton.setOnAction(e -> {
            answer = true;
            projectName = listView.getSelectionModel().getSelectedItems();
            stage.close();
        } );
        cancelButton.setOnAction(e -> {
            answer = false;
            stage.close();
        } );
        stage.setOnCloseRequest(e -> {
            answer = false;
            stage.close();
        } );




    }



}