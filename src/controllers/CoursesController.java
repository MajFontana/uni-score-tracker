package controllers;

import java.util.ArrayList;
import models.Course;
import models.CourseList;
import views.CoursesPanel;


public class CoursesController {
    CourseList courseList; // Displayed courses
    Course selected; // Selected course
    boolean update; // We're updating
    
    String query;
    
    MainController mainController;
    
    CoursesPanel panel;
    
    CourseList filtered;
    
    
    
    public CoursesController(CoursesPanel panel, MainController mainController){
        query = "";
        this.panel = panel;
        this.mainController = mainController;
        update = false;
        panel.setController(this);
    }
    
    
    // add new empty Course to CourseList
    public void addNew(){
        Course course = courseList.addCourse();
        selected = course;
        
        // Update everything
        mainController.setModified();
        
        mainController.update();
    }
    

    public void update(){
        update = true;
        if (courseList != null){ // if list is not empty
            filtered = new CourseList();
            for (Course course : courseList.getCourses()){
                if (course.getTitle().contains(query) || course.getConvenor().contains(query) || course.getCode().contains(query)){
                    Course newc = filtered.addCourse();
                    newc.set(course);
                }
            }
            
            /*
            panel.setCourseList(filtered.getCourses()); // give a copy of the list to the ui
            if (!filtered.getCourses().contains(selected)){
                selected = null; // unselect if new list doesn't contain the selected object
            }
            panel.setSelected(filtered.getCourses().indexOf(selected)); // selected the object again
            */
            
            panel.setCourseList(courseList.getCourses()); // give a copy of the list to the ui
            if (!courseList.getCourses().contains(selected)){
                selected = null; // unselect if new list doesn't contain the selected object
            }
            panel.setSelected(courseList.getCourses().indexOf(selected)); // selected the object again
        }
        else{
            panel.setCourseList(null);
        }
        update = false;
    }
    
    // Make selection, called from UI
    public void select(){
        if (!update){ // check that the changes aren't due to updates
            int index = panel.getSelected(); // read selected index
            if (index != -1){
                selected = courseList.getCourses().get(index);
            }
            else{
                selected = null;
            }
            mainController.update();
        }
    }
    
    // This doesn't really do much once the whole thing is loaded in at the start
    public void setCourseList(CourseList courseList){
        if (courseList != this.courseList){ // We're actually checking to see if the list changed, but I don't think it can ever be different than the one we have
            selected = null;
            this.courseList = courseList;
        }
    }
    
    // Remove selected course
    public void remove(){
        if (selected != null){ // Check that there is a selected course
            courseList.removeCourse(selected);
            selected = null; // unselect
            
            // update everything
            mainController.setModified();
            mainController.update();
        }
    }
    
    public void search(){
        query = panel.getQuery();
        mainController.update();
    }
    
    public Course getSelected(){
        return selected;
    }
    
    // entry was modified
    public void modify(){
        
        if (! update){
            ArrayList<Course> data = panel.getData(); // get data from UI
            if (data != null){
                for (int i = 0; i < courseList.getCourses().size(); i++){ // we're erasing assingment data for some reason, what's going on
                    Course c = data.get(i); // All good NOW!
                    c.setAssignments(courseList.getCourses().get(i).getAssignments());
                    courseList.getCourses().get(i).set(c);
                }
            }
            System.out.println("Updating cause course modified");
            mainController.update();
        }
        
        
        /*
        if (! update){
            ArrayList<Course> data = panel.getData(); // get data from UI
            if (data != null){
                for (int i = 0; i < filtered.getCourses().size(); i++){ // we're erasing assingment data for some reason, what's going on
                    Course c = data.get(i); // All good NOW!
                    c.setAssignments(filtered.getCourses().get(i).getAssignments());
                    Course orig = courseList.getCourses().get(courseList.getCourses().indexOf(filtered.getCourses().get(i)));
                    orig.set(c);
                    //filtered.getCourses().get(i).set(c);
                }
            }
            mainController.update();
        }
        */
    }
}
