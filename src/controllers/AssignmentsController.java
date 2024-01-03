package controllers;


import java.util.ArrayList;
import models.Assignment;
import models.Course;
import views.AssignmentsPanel;

// Double click is messing something up
public class AssignmentsController{
    
    Course course;
    Assignment selected;
    boolean update;
    
    MainController mainController;
    
    AssignmentsPanel panel;
    
    
    
    public AssignmentsController(AssignmentsPanel panel, MainController mainController){
        this.panel = panel;
        this.mainController = mainController;
        update = false;
        panel.setController(this);
    }
    
    
    
    public void addNew(){
        Assignment assignment = course.addAssignment();
        selected = assignment;
        mainController.setModified();
        mainController.update();
    }
    
    public void update(){
        update = true;
        if (course != null){
            panel.setAssignmentList(course.getAssignments());
            if (!course.getAssignments().contains(selected)){
                selected = null;
            }
            panel.setSelected(course.getAssignments().indexOf(selected));
        }
        else{
            panel.setAssignmentList(null);
        }
        update = false;
    }
    
    public void select(){
        if (!update){
            int index = panel.getSelected();
            if (index != -1){
                selected = course.getAssignments().get(index);
            }
            else{
                selected = null;
            }
            mainController.update();
        }
    }
    
    public void setCourse(Course course){
        if (course != this.course){
            selected = null;
            this.course = course;
        }
    }
    
    public void remove(int index){
        if (selected != null){
            course.removeAssignment(course.getAssignments().get(index));
            selected = null;
            mainController.setModified();
            mainController.update();
        }
    }
    
    public Assignment getSelected(){
        return selected;
    }
    
    
    public void modify(){
        if (! update){
            ArrayList<Assignment> data = panel.getData();
            if (data != null){
                for (int i = 0; i < course.getAssignments().size(); i++){
                    course.getAssignments().get(i).set(data.get(i));
                }
            }
            mainController.update();
        }
    }
    
}
