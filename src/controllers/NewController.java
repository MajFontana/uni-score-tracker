package controllers;

import models.Course;
import models.CourseList;
import views.NewPanel;



public class NewController {

    MainController mainController;
    
    NewPanel panel;
    int year;
    
    CourseList filtered;
    CourseList courses;
    
    
    
    public NewController(NewPanel panel, MainController mainController){
        this.panel = panel;
        year = 1;
        this.mainController = mainController;
        panel.setController(this);
    }
    
    public void update(){
        panel.setAllCourses(courses);
        panel.setPosCourses(filtered);
    }
    
    public void setData(CourseList courses){
        System.out.println(year);
        CourseList yearf = new CourseList();
        for (Course course : courses.getCourses()){
            if (course.getYear() == year){
                yearf.addCourse().set(course);
            }
        }
        
        filtered = new CourseList();
        for (Course course : yearf.getCourses()){
            if (course.getGrade() >= 5){
                filtered.addCourse().set(course);
            }
        }
        this.courses = yearf;
        
    }

    
    public void yearControl(Object obj){
        String choice = (String)obj;
        System.out.println(choice);
        if (choice.equals("1. letnik")){
            year = 1;
        }
        else{
            year = 2;
        }
        mainController.update();
    }
}
