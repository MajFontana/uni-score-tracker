package models;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "courseList")
public class CourseList {
    
    @XmlElement(name = "courses")
    private ArrayList<Course> courses;
    
    
    
    public CourseList(){
        courses = new ArrayList<Course>();
    }
    
    
    
    public List<Course> getCourses(){
        return (ArrayList<Course>) courses.clone();
    }
    
    public void setCourses(List<Course> courses){
        this.courses = (ArrayList<Course>) courses;
    }
    
    public Course addCourse(){
        Course course = new Course();
        courses.add(course);
        return course;
    }
    
    public void removeCourse(Course course){
        courses.remove(course);
    }
    
}
