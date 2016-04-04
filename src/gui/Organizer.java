package gui;


import core.FilesList;
import core.TreeList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Organizer {
    ProjectList projectList;
    static Stage mainStage;
    Stage stage;
    Scene scene;
    Parent root;
    static String key, projectName, location;
    Alert alert;
    DirectoryChooser chooser;
    FilesList filesList;
    TreeList treeList;

    public void setStage(Stage stage){
        Organizer.mainStage = stage;
    }



    protected void setScene(String title, String fileName,int height, int width){
        try {
            root = FXMLLoader.load(getClass().getResource(fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        mainStage.setTitle("WebPageGrabber "+title);
        scene = new Scene(root,height, width);
        mainStage.setScene(scene);
        mainStage.setResizable(false);
        mainStage.show();
    }


    void alert(String msg){
        alert = new Alert(Alert.AlertType.ERROR, msg , ButtonType.CLOSE);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("Web Grabber");
        alert.showAndWait();
    }


    /*
    This method:
    * is used to validate the key and get the location of the Project
    */

    private Boolean validate(String key){

        Boolean exist = null;
        location = projectList.getProjectLocation(key);
        if(location != null ) {
            exist = true;
        }

        return exist;
    }



    public void saveProject(){
        if(SaveBox.display("Save","Do you want to save project with the above name","Further changing the Project Name " +
                "will be treated\n as a different project"))
            projectList.saveProject(projectName,location);

    }

 /*
    This method :
    * open the saved Project from the ProjectList class on User choice
    * validate the key returned by the ProjectList class method getProjectList
      using validate key method validate(key) if it returns true than it start Grabber\
    */

    public void openProject(){
        stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        ProjectListController pc = new ProjectListController();
        key = pc.getProjectList(stage);
        if(key !=null ){
            setScene(" :Fill Details","GetInfoScene.fxml",600,400);

        }

    }


    String setChooser(){
        stage = new Stage();
        chooser = new DirectoryChooser();
        chooser.setTitle("Save Project ");
        File defaultDirectory = new File("c:/");
        chooser.setInitialDirectory(defaultDirectory);
        return chooser.showDialog(stage).toString();

    }




    protected void closeProgram(){
        mainStage.close();
    }
}
