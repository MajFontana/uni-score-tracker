package models;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.NONE)
public class Assignment {
    
    @XmlElement(name = "type")
    private String type;
    
    @XmlElement(name = "weight")
    private int weight;
    
    @XmlElement(name = "score")
    private int score;
    
    
    
    public Assignment(){
        type = "";
        weight = 0;
        score = 0;
    }
    
    
    
    public String getType(){
        return type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    
    
    public int getWeight(){
        return weight;
    }
    
    public void setWeight(int weight){
        if ((weight < 0) || (weight > 100)){
            throw new IllegalArgumentException();
        }
        this.weight = weight;
    }
    
    
    
    public int getScore(){
        return score;
    }
    
    public void setScore(int score){
        if ((score < 0) || (score > 100)){
            throw new IllegalArgumentException();
        }
        this.score = score;
    }
    
    
    public void set(Assignment assignment){
        type = assignment.getType();
        weight = assignment.getWeight();
        score = assignment.getScore();
    }
    
    
}
