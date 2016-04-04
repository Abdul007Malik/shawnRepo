package gui;


import core.FilesList;
import core.TreeList;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class GrabStartSceneController extends Organizer{

    @FXML private ToggleButton start, stop, statistics;
    @FXML private Button refresh, back, finish, close;
    @FXML private CheckBox selectAll;
    @FXML private TableView<FilesList> tableView;
    @FXML private TableColumn<FilesList,String> fileName, size, status, fileType, url;
    @FXML private TreeView<TreeList> treeView;


    @FXML private void buttonControl(){
        if(start.isArmed()){
super.closeProgram();
        }
        if(stop.isArmed()){
            super.closeProgram();
        }
        if(refresh.isArmed()){
            super.closeProgram();
        }
        if(statistics.isArmed()){
            super.closeProgram();
        }
        if(selectAll.isArmed()){
            super.closeProgram();
        }
        if(back.isArmed()){
            setScene(": Fill Details","GetInfoScene.fxml",600,400);
        }

        if(finish.isArmed()){
         super.closeProgram();
        }
        if(close.isArmed()){

            if(ConfirmBox.display("Confirm","Do you want Save the project","If you click 'No' all the downloaded Information"
                    + "\n will be deleted")==1){
                super.saveProject();
            }
            else if(ConfirmBox.answer == 2) {
                System.out.print("File is deleted");
                super.closeProgram();
            }
        }





    }

}
