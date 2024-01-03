package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import models.CourseList;


public class Xml {
    
    private final JAXBContext context;
    private final String path;
    
    
    
    public Xml(String path) throws FileNotFoundException, JAXBException{
        context = JAXBContext.newInstance(CourseList.class);
        this.path = path;
    }
    
    
    
    public CourseList load() throws FileNotFoundException, JAXBException, IOException{
        try (FileReader reader = new FileReader(path)) {
            return (CourseList) context.createUnmarshaller().unmarshal(reader);
        }
    }
    
    public void store(CourseList courses) throws IOException, JAXBException{
        try (FileWriter writer = new FileWriter(path)) {
            context.createMarshaller().marshal(courses, writer);
        }
    }
    
}
