
package memorymanagment;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class MemoryFrame extends javax.swing.JFrame {

    private ArrayList<JTextField[]> processes ;
    private ArrayList<JCheckBox> deallocation;
    private int textFieldHeight;
    private int textFieldWidth;
    private int  checkBoxHeight;
    private int checkBoxWidth;
    private MemoryPanel drawingPanel;
    private ArrayList<Rectangle> rects;
    private Color[] clrs;
    private int color;
    
    
    public MemoryFrame() {
        initComponents();
        scndInitComps();
    }
    
    private void scndInitComps(){
        this.setTitle("Memory Managment");
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        
        processes = new ArrayList();
        processes.add(new JTextField[2]);
        processes.get(0)[0] = jTextField2;
        processes.get(0)[1] = jTextField1;
        deallocation = new ArrayList();
        deallocation.add(jCheckBox1);
        textFieldHeight  = jTextField1.getHeight();
        textFieldWidth = jTextField1.getWidth();
        checkBoxHeight = jCheckBox1.getHeight();
        checkBoxWidth = jCheckBox1.getWidth();
        drawingPanel = new MemoryPanel();
        drawingPanel.setBounds(367, 130, 295, 588);
        this.add(drawingPanel);
        rects = new ArrayList<Rectangle>();
        clrs = new Color[7];
        clrs[0] = Color.MAGENTA;
        clrs[1] = Color.BLUE;
        clrs[2] = Color.gray;
        clrs[3] = Color.pink;
        clrs[4] = Color.RED;
        clrs[5] = Color.GREEN;
        clrs[6] = Color.LIGHT_GRAY;
        
    }
    
    private void firstFit(){
        
        float height = (Integer.parseInt(processes.get(processes.size()-2)[1].getText()) * 5f) / 10;
        int sum = 0;
        for (int i = 0; i < rects.size() ; i++){
            sum+= rects.get(i).getHeight();
        }
        if (500 - sum < height)
            JOptionPane.showMessageDialog(null, "There is no enough place in the memory.");
        else{
        String name = processes.get(processes.size()-2)[0].getText();
        if (rects.isEmpty()){
            rects.add(new Rectangle(44,height,clrs[0],name));
        }
        
        else{    
            for (int i = rects.size() - 1 ; i >= 0 ; i--){ //sorting 
                for (int j = 1 ; j <= i ; j++){
                    if (rects.get(j-1).getY() > rects.get(j).getY())
                        Collections.swap(rects, j-1, j);
                }
            }
            int j;
            for (int i = 0 ; i < rects.size() ; i++){
                if (i == 0 && rects.get(0).getY() > 44){
                    if (rects.get(i).getY() - 44 >= height){ //first after deallocation 
                        rects.add(i,new Rectangle(44,height,clrs[i%7],name));
                        break;
                    }
                }
                else
                {
                    if (i+1 == rects.size())
                        j = 544;
                    else 
                        j = rects.get(i+1).getY();
                    if (j - (rects.get(i).getY() +rects.get(i).getHeight()) >= height){ //first 
                        rects.add(i,new Rectangle(rects.get(i).getY()+Math.round(rects.get(i).getHeight()),height,clrs[color%7],name));
                        break;
                    }
                }
            }
        }
        drawingPanel.setRectangles(rects);
        drawingPanel.repaint();
        }
    }
    
    public void bestFit(){
        float height = (Integer.parseInt(processes.get(processes.size()-2)[1].getText()) * 5f) / 10;
        int sum = 0;
        for (int i = 0; i < rects.size() ; i++){
            sum+= rects.get(i).getHeight();
        }
        if (500 - sum < height)
            JOptionPane.showMessageDialog(null, "There is no enough place in the memory.");
        else{
        String name = processes.get(processes.size()-2)[0].getText();
        if (rects.size() == 0){
            rects.add(new Rectangle(44,height,clrs[0],name));
        }
        
        else{
            for (int i = rects.size() - 1 ; i >= 0 ; i--){ //sorting 
                for (int j = 1 ; j <= i ; j++){
                    if (rects.get(j-1).getY() > rects.get(j).getY())
                        Collections.swap(rects, j-1, j);
                }
            }
            int j;
            float best = 5000;
            int index = 0;
            for (int i = 0 ; i < rects.size() ; i++){
                
                if (i+1 == rects.size())
                    j = 544;
                else 
                    j = rects.get(i+1).getY();
                if (i == 0 && rects.get(i).getY() > 44)
                    if (rects.get(i).getY() - 44 >= height && rects.get(i).getY() - 44 < best){
                    best = rects.get(i).getY() - 44;
                    index = 44;
                }
                    
                if (j - (rects.get(i).getY()+rects.get(i).getHeight()) >= height &&  j - (rects.get(i).getY()+rects.get(i).getHeight()) < best){
                    best = j - (rects.get(i).getY()+rects.get(i).getHeight());
                    index = rects.get(i).getY()+Math.round(rects.get(i).getHeight());
                }
            }
            rects.add(new Rectangle(index,height,clrs[color%7],name));
            
        }
        drawingPanel.setRectangles(rects);
        drawingPanel.repaint();
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Processes' Table", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT Condensed", 1, 24), new java.awt.Color(0, 0, 153))); // NOI18N
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 153));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Size");
        jLabel1.setAlignmentX(0.5F);

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Name");
        jLabel3.setAlignmentX(0.5F);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Deallocation");
        jLabel2.setAlignmentX(0.5F);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1)
                        .addGap(57, 57, 57))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(213, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(437, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(486, Short.MAX_VALUE)))
        );

        jScrollPane1.setViewportView(jPanel1);

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Allocate Process");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 153));
        jButton2.setText("Deallocate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Algorithm Type:");

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(102, 102, 102));
        jCheckBox2.setText("First Fit");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(102, 102, 102));
        jCheckBox3.setText("Best Fit");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addGap(42, 42, 42)
                        .addComponent(jCheckBox3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(385, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        color++;      
        int xName = processes.get(processes.size()-1)[0].getX();
        int yName =  processes.get(processes.size()-1)[0].getY() + textFieldHeight + 10;
        int xSize = processes.get(processes.size()-1)[1].getX();
        int ySize =  processes.get(processes.size()-1)[1].getY() + textFieldHeight + 10;
        int deallocX = deallocation.get(deallocation.size()-1).getX();
        int deallocY = deallocation.get(deallocation.size()-1).getY() + checkBoxHeight + 10;
        processes.add(new JTextField[2]);
        processes.get(processes.size() -1)[0] = new JTextField();
        processes.get(processes.size()-1)[0].setBounds(xName, yName, textFieldWidth, textFieldHeight);
        jPanel1.add( processes.get(processes.size()-1)[0]);
        processes.get(processes.size() -1)[1] = new JTextField();
        processes.get(processes.size()-1)[1].setBounds(xSize, ySize, textFieldWidth, textFieldHeight);
        jPanel1.add( processes.get(processes.size()-1)[1]);
        deallocation.add(new JCheckBox());
        deallocation.get(deallocation.size()-1).setBounds(deallocX, deallocY, checkBoxWidth, checkBoxHeight);
        deallocation.get(deallocation.size()-1).setBackground(Color.white);
        jPanel1.add(deallocation.get(deallocation.size()-1));
        jPanel1.repaint();
        if (jCheckBox2.isSelected())
            firstFit();
        else
            bestFit();
        
        if (processes.size() >= 11)
            jPanel1.setPreferredSize(new Dimension(jPanel1.getSize().width,jPanel1.getSize().height+30));
        jPanel1.setSize(new Dimension(jPanel1.getSize().width,jPanel1.getSize().height+50));
        
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for (int i = 0 ; i < deallocation.size() ; i++){
            if (deallocation.get(i).isSelected()){
                processes.get(i)[0].setEditable(false);
                processes.get(i)[1].setEditable(false);
                deallocation.get(i).setEnabled(false);
                for (int j = 0 ; j < rects.size() ; j++){
                    if (processes.get(i)[0].getText().equals(rects.get(j).getName())){
                        rects.remove(j);
                        drawingPanel.repaint();
                    }
                }
            }
          
        }
        
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        jCheckBox3.setSelected(false);
        jCheckBox2.setSelected(true);
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(true);
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MemoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemoryFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
