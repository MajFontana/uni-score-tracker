package models;


import static java.lang.Math.ceil;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;


@XmlAccessorType(XmlAccessType.NONE)
public class Course {
    
    @XmlElement(name = "code")
    private String code;
    
    @XmlElement(name = "title")
    private String title;
    
    @XmlElement(name = "convenor")
    private String convenor;
    
    @XmlElement(name = "year")
    private int year;
    
    @XmlElement(name = "semester")
    private int semester;
    
    @XmlElement(name = "ects")
    private int ects;
    
    @XmlElement(name = "grade")
    private int grade;
    
    @XmlElementWrapper
    @XmlElement(name = "assignments")
    private ArrayList<Assignment> assignments;
    
    
    
    public Course(){
        code = "";
        title = "";
        convenor = "";
        year = 2021;
        semester = 1;
        ects = 0;
        assignments = new ArrayList<Assignment>();
        recalculateGrade();
    }
    
    
    
    public String getCode(){
        return code;
    }
    
    public void setCode(String code){
        this.code = code;
    }
    
    
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    
    
    public String getConvenor(){
        return convenor;
    }
    
    public void setConvenor(String convenor){
        this.convenor = convenor;
    }
    
    
    
    public int getYear(){
        return year;
    }
    
    public void setYear(int year){
        this.year = year;
    }
    
    
    
    public int getSemester(){
        return semester;
    }
    
    public void setSemester(int semester){
        if ( (semester < 1) || (semester > 2) ){
            throw new IllegalArgumentException();
        }
        this.semester = semester;
    }
    
    
    
    public int getEcts(){
        return ects;
    }
    
    public void setEcts(int ects){
        if (ects < 0){
            throw new IllegalArgumentException();
        }
        this.ects = ects;
    }
    
    
    
    public int getGrade(){
        return grade;
    }
    
    public void recalculateGrade(){
        int sum = 0;
        sum = assignments.stream().map(assignment -> assignment.getScore() * assignment.getWeight()).reduce(sum, Integer::sum);
        grade = (int) ceil(sum / 1000);
        if (grade == 0){
            grade = 1;
        }
    }
    
    
    
    public List<Assignment> getAssignments(){
        return (ArrayList<Assignment>) assignments.clone();
    }
    
    public void setAssignments(List<Assignment> assignments){
        this.assignments = (ArrayList<Assignment>) assignments;
    }
    
    public Assignment addAssignment(){
        Assignment assignment = new Assignment();
        assignments.add(assignment);
        return assignment;
    }
    
    public void removeAssignment(Assignment assignment){
        assignments.remove(assignment);
    }
    
    
    
    public void set(Course course){
        title = course.getTitle();
        convenor = course.getConvenor();
        code = course.getCode();
        year = course.getYear();
        semester = course.getSemester();
        ects = course.getEcts();
        assignments = (ArrayList<Assignment>) course.getAssignments();
    }
    
}
