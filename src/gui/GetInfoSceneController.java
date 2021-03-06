package gui;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/*
* This class is the controller of the GetInfoScene fxml file and extends the Organizer class in the same package.
 */


public class GetInfoSceneController extends Organizer {

    //All @FXML are either controls or the handler of this controller class's Scene.
    @FXML ComboBox<String> fileType ,level;
    @FXML TextField newURL;
    @FXML TextField newLocation;
    @FXML private Button back, next, close;
    ObservableList<String> typeList = FXCollections.observableArrayList("HTML only","Images only","Audio only",
            "Video only","WebPages, Stylesheet and Scripts ","complete site");
    ObservableList<String> levelList = FXCollections.observableArrayList("Level 0","Level 1","Level 2", "Level 3",
            "Level 4");



    @FXML private void buttonControl(){

        if(close.isArmed()) {

            if(ConfirmBox.display("Confirm","Do you want Save the project","If you click 'No' all the downloaded Information"
                    + "\n will be deleted")==1){
                super.saveProject();
            }
            else if(ConfirmBox.answer == 2) {
               System.out.print("File is deleted");
                super.closeProgram();
            }
        }

        if(next.isArmed()) {

            if (newURL.getText().isEmpty() || newLocation.getText().isEmpty()){
                alert("Please fill all the Details");
            }
            else {
                //location = newLocation.getText();
                setScene(": Active" ,"GrabStartScene.fxml",700,500);

            }

        }
        if (back.isArmed()){
            setScene(": OutSet","StartScene.fxml",600,400);

        }

    }

    @FXML
    void getLocation(){
        newLocation.setText(setChooser());
    }

    @FXML
    private void initialize() {

        fileType.setItems(typeList);
        fileType.setValue("HTML only");
        level.setItems(levelList);
        level.setValue("Level 0");
    }
}
