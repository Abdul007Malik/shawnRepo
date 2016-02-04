package home;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectList {
    Map<String,String> projectList = new HashMap<>();

    public ProjectList(int a){
        for(int i=1;i<20;i++){
            projectList.put("project"+i,"Location"+i);
        }

    }


    public void saveProject(String projectName , String location){

       projectList.put(projectName , location);

    }

   public String getProjectLocation(String key) {

       return projectList.get(key);
   }
    public ProjectList(){}


   public List<String> getProjectNameList() {

       return new ArrayList<>(projectList.keySet());

   }



}
