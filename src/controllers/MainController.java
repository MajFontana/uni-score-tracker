package controllers;

import data.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import models.Course;
import models.CourseList;
import views.MainWindow;



public class MainController {
    
    private final String persistencePath = "courses.xml";
    
    MainWindow window;
    
    CoursesController coursesController;
    AssignmentsController assignmentsController;
    NewController newController;
    
    boolean modified;
    CourseList courses; // Root object
    Xml io;
    
    
    
    public MainController(MainWindow window){
        this.window = window;
        coursesController = new CoursesController(window.getCoursesPanel(), this);
        assignmentsController = new AssignmentsController(window.getAssignmentsPanel(), this);
        newController = new NewController(window.getNewPanel(), this);
        
        // Open Xml
        try {
            io = new Xml(persistencePath);
            load();
        }
        catch (FileNotFoundException e) {
            fatal(e);
        }
        catch (JAXBException e) {
            fatal(e);
        }
        
        modified = false;
        update();
    }
    
    
    
    // Load Xml data
    public void load(){
        try {
            courses = io.load();
        }
        catch (JAXBException e) {
            fatal(e);
        }
        catch (IOException e) {
            fatal(e);
        }
    }
    
    // Store data to Xml
    public void save(){
        try {
            io.store(courses);
        }
        catch (IOException e) {
            fatal(e);
        }
        catch (JAXBException e) {
            fatal(e);
        }
        
        modified = false;
    }
    
    public void exit(){
        
    }
    
    // Update everything
    public void update(){
        int sum = 0;
        for (Course course : courses.getCourses()){
            if (course.getAssignments() == null || course.getAssignments().isEmpty()){
                sum++;
            }
        }
        
        // Recalculate grades
        for (Course course : courses.getCourses()){
            course.recalculateGrade();
        }
        
        // Update displayed courses
        coursesController.setCourseList(courses);
        coursesController.update();
        
        // Check if there's a selected course, if yes, enable the assignemnts tab
        Course selcourse = coursesController.getSelected();
        if (selcourse == null){
            window.setEnabledAssignmentsTab(false);
        }
        else{
            window.setEnabledAssignmentsTab(true);
        }
        
        // Update displayed assignment (course)
        assignmentsController.setCourse(selcourse);
        assignmentsController.update();
        
        newController.setData(courses);
        newController.update();
    }
    
    // This doesn't work
    public void fatal(Exception e){
        System.out.println("fatal");
        e.printStackTrace();
        window.error(e.getLocalizedMessage());
        window.dispose();
    }
    
    // Xml modified flag, I'm not sure why I'm storing this
    public void setModified(){
        modified = true;
    }
    
}
