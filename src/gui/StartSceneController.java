package gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.List;


public class StartSceneController extends Organizer{
    ProjectList projectList;
    private List list;
    @FXML private Button next , close;
    @FXML TextField projectName;

    public StartSceneController(){
        projectList = new ProjectList();
        list = new ArrayList<String>();
        list = projectList.getProjectNameList();
    }

    /*
    This Method :
    * Controls all the button except the Menu Bar*/

    @FXML private void buttonControl(){


        if(close.isArmed()){
            super.closeProgram();    }

        if(next.isArmed()){

            if (projectName.getText().isEmpty()){
                alert("Please Enter the Project Name");

            }
            else if(projectName.getText().length()>40){
                alert("Project Name is too long...");

            }
            else if(list !=null && list.contains(projectName.getText()) ){
                alert("Project Name is Already Exist");

            }
            else {
                Organizer.projectName = projectName.getText();
                setScene(" :Fill Details","GetInfoScene.fxml",600,400);
            }

        }

    }

    @FXML
    private void initialize() {
        if(Organizer.projectName!=null)
        projectName.setText(Organizer.projectName);
    }
}
