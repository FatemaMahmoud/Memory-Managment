
package memorymanagment;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class MemoryPanel extends javax.swing.JPanel {

    private ArrayList <Rectangle> rects;
    
    public MemoryPanel() {
        initComponents();
        rects = new ArrayList();
    }
    
    public void setRectangles(ArrayList<Rectangle> rects){
        this.rects = rects;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
       
        for (int i = 0 ; i < rects.size() ; i++){
            
            g.setColor(rects.get(i).getColor());
            g.fillRect(rects.get(i).getX(), rects.get(i).getY(), rects.get(i).getWidth(), Math.round(rects.get(i).getHeight()));
            g.setColor(Color.blue);
            g.drawString(Integer.toString(((rects.get(i).getY() - 44)*10)/5),10, rects.get(i).getY());
            g.drawString(Integer.toString(((rects.get(i).getY()+Math.round(rects.get(i).getHeight()) - 44)*10)/5),10 , rects.get(i).getY()+Math.round(rects.get(i).getHeight()));
            g.setColor(Color.WHITE);
            g.drawString(rects.get(i).getName(), 140, rects.get(i).getY() + Math.round(0.5f *rects.get(i).getHeight()));
            
        }
        
        
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Memory", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT Condensed", 1, 24), new java.awt.Color(0, 0, 153))); // NOI18N
        setPreferredSize(new java.awt.Dimension(295, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
