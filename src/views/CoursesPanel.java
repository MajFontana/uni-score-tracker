package views;


import controllers.AssignmentsController;
import controllers.CoursesController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.Course;


public class CoursesPanel extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private CoursesController controller;
    private String query;
    
    
    
    public CoursesPanel() {
        initComponents();
        tableModel = (DefaultTableModel) jTableCourses.getModel();
        
        jTableCourses.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            controller.select();
        });
        
        jTableCourses.getModel().addTableModelListener((TableModelEvent evt) -> {
            controller.modify();
        });
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCourses = new javax.swing.JTable();
        jButtonRemoveCourse = new javax.swing.JButton();
        jButtonAddCourse = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();

        jTableCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Koda", "Naziv", "Nosilec", "Letnik", "Semester", "ECTS", "Ocena"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCourses.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTableCoursesPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCourses);

        jButtonRemoveCourse.setText("Odstrani");
        jButtonRemoveCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRemoveCourseMouseClicked(evt);
            }
        });

        jButtonAddCourse.setText("Dodaj");
        jButtonAddCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddCourseMouseClicked(evt);
            }
        });

        jTextFieldSearch.setText("Iskalni niz");
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyTyped(evt);
            }
        });

        jButtonSearch.setText("Išči");
        jButtonSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonRemoveCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAddCourse)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSearch)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemoveCourse)
                    .addComponent(jButtonAddCourse))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddCourseMouseClicked
        controller.addNew();
    }//GEN-LAST:event_jButtonAddCourseMouseClicked

    private void jButtonRemoveCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRemoveCourseMouseClicked
        controller.remove();
    }//GEN-LAST:event_jButtonRemoveCourseMouseClicked

    private void jTableCoursesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTableCoursesPropertyChange

    }//GEN-LAST:event_jTableCoursesPropertyChange

    private void jTextFieldSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyTyped
        //nič
        
    }//GEN-LAST:event_jTextFieldSearchKeyTyped

    private void jButtonSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSearchMouseClicked
        controller.search();
    }//GEN-LAST:event_jButtonSearchMouseClicked

    
    
    public void setCourseList(List<Course> courses){
        tableModel.setRowCount(0);
        if (courses != null){
            courses.forEach(course -> {
                tableModel.addRow(new Object[] {course.getCode(), course.getTitle(), course.getConvenor(), course.getYear(), course.getSemester(), course.getEcts(), course.getGrade()});
            });
        }
    }
    
    public void setSelected(int index){
        if (index == -1){
            jTableCourses.clearSelection();
        }
        else{
            jTableCourses.setRowSelectionInterval(index, index);
        }
    }
    
    public int getSelected(){
        return jTableCourses.getSelectedRow();
    }
    
    public void setController(CoursesController controller){
        this.controller = controller;
    }
    
    public String getQuery(){
        return jTextFieldSearch.getText();
    }
    
    public ArrayList<Course> getData(){
        try {
            ArrayList<Course> data = new ArrayList<Course>();
            for (int i = 0; i < jTableCourses.getRowCount(); i++){ // ohhhhhh, I'm an idiot. But why does it do it for every course?
                DefaultTableModel m = (DefaultTableModel) jTableCourses.getModel();
                Course c = new Course();
                c.setCode((String) m.getValueAt(i, 0));
                c.setTitle((String) m.getValueAt(i, 1));
                c.setConvenor((String) m.getValueAt(i, 2));
                c.setYear((int) m.getValueAt(i, 3));
                c.setSemester((int) m.getValueAt(i, 4));
                c.setEcts((int) m.getValueAt(i, 5));
                data.add(c); 
            }
            return data;
        }
        catch (IllegalArgumentException e){
            return null;
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddCourse;
    private javax.swing.JButton jButtonRemoveCourse;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCourses;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}