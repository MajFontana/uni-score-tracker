package views;


import controllers.AssignmentsController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import models.Assignment;
import models.Course;


public class AssignmentsPanel extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private AssignmentsController controller;
    
    
    
    public AssignmentsPanel() {
        initComponents();
        tableModel = (DefaultTableModel) jTableAssignments.getModel();
        
        jTableAssignments.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            controller.select();
        });
        
        jTableAssignments.getModel().addTableModelListener((TableModelEvent evt) -> {
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

        jPanel2 = new javax.swing.JPanel();
        jButtonRemoveAssignment = new javax.swing.JButton();
        jButtonAddAssignment = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAssignments = new javax.swing.JTable();

        jButtonRemoveAssignment.setText("Odstrani");
        jButtonRemoveAssignment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRemoveAssignmentMouseClicked(evt);
            }
        });

        jButtonAddAssignment.setText("Dodaj");
        jButtonAddAssignment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddAssignmentMouseClicked(evt);
            }
        });

        jTableAssignments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Način", "Teža", "Ocena"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableAssignments);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonRemoveAssignment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAddAssignment)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemoveAssignment)
                    .addComponent(jButtonAddAssignment))
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jButtonAddAssignmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddAssignmentMouseClicked
        controller.addNew();
    }//GEN-LAST:event_jButtonAddAssignmentMouseClicked

    private void jButtonRemoveAssignmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRemoveAssignmentMouseClicked
        controller.remove(jTableAssignments.getSelectedRow());
    }//GEN-LAST:event_jButtonRemoveAssignmentMouseClicked
    
    
    
    public void setAssignmentList(List<Assignment> assignments){
        tableModel.setRowCount(0);
        if (assignments != null){
            assignments.forEach(assignment -> {
                tableModel.addRow(new Object[] {assignment.getType(), assignment.getWeight(), assignment.getScore()});
            });
        }
    }
    
    public void setSelected(int index){
        if (index == -1){
            jTableAssignments.clearSelection();
        }
        else{
            jTableAssignments.setRowSelectionInterval(index, index);
        }
    }
    
    public void setController(AssignmentsController controller){
        this.controller = controller;
    }
    
    public int getSelected(){
        return jTableAssignments.getSelectedRow();
    }
    
    
    public ArrayList<Assignment> getData(){
        try{
            ArrayList<Assignment> data = new ArrayList<Assignment>();
            for (int i = 0; i < jTableAssignments.getRowCount(); i++){
                DefaultTableModel m = (DefaultTableModel) jTableAssignments.getModel();
                Assignment a = new Assignment();
                a.setType((String) m.getValueAt(i, 0));
                a.setWeight((int) m.getValueAt(i, 1));
                a.setScore((int) m.getValueAt(i, 2));
                data.add(a);
            }
            return data;
        }
        catch (IllegalArgumentException e){
            return null;
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddAssignment;
    private javax.swing.JButton jButtonRemoveAssignment;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAssignments;
    // End of variables declaration//GEN-END:variables
}
