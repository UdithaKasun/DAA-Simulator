
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Uditha Kasun
 */
public class SelectionGUI extends javax.swing.JFrame {

    int top_limit = 200;
    int bottom_limit = 346;
    int current_position = 273;
    
    Map<Integer,Point> coordinates;
    Map<Integer,JTextField> elements;
    int[] original_Array;
    public SelectionGUI() {
        initComponents();
        loadCoordinates();
        loadElements();

    }
    
    public void loadCoordinates(){
        coordinates = new HashMap<>();
        coordinates.put(0, new Point(20,273));
        coordinates.put(1, new Point(92,273));
        coordinates.put(2, new Point(164,273));
        coordinates.put(3, new Point(234,273));
        coordinates.put(4, new Point(306,273));
        coordinates.put(5, new Point(378,273));
        coordinates.put(6, new Point(450,273));
    }
    
    public void loadElements(){
        elements = new HashMap<>();
        elements.put(0, element0);
        elements.put(1, element1);
        elements.put(2, element2);
        elements.put(3, element3);
        elements.put(4, element4);
        elements.put(5, element5);
        elements.put(6, element6);
    }
    
    public void loadArray(){
        original_Array = new int[7];
        original_Array[0] = Integer.parseInt(txtInput0.getText());
        original_Array[1] = Integer.parseInt(txtInput1.getText());
        original_Array[2] = Integer.parseInt(txtInput2.getText());
        original_Array[3] = Integer.parseInt(txtInput3.getText());
        original_Array[4] = Integer.parseInt(txtInput4.getText());
        original_Array[5] = Integer.parseInt(txtInput5.getText());
        original_Array[6] = Integer.parseInt(txtInput6.getText());
        
        for(int i=0;i<7;i++){
            elements.get(i).setText(String.valueOf(original_Array[i]));
        }
    }
    
    
     public void moveFirst(JTextField src, Point destination) {
        MoveUp_First(src, destination);
        MoveRight_First(src, destination);
        MoveDown_First(src, destination);
      }
     
     public void moveSecond(JTextField src, Point destination) {
        MoveDown_Second(src, destination);
        MoveLeft_Second(src, destination);
        MoveUp_Second(src, destination);
      }
    public void MoveUp_First(JTextField source, Point destination) {

        int source_x = source.getBounds().x;
        int source_y = source.getBounds().y;

        int destination_x = destination.x;
        int destination_y = destination.y;
        source.setBackground(Color.YELLOW);
        while (source_y != top_limit && source_x != destination_x) {
            source_y--;
            source.setBounds(source_x, source_y, source.getBounds().width, source.getBounds().height);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(SelectionGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public void MoveRight_First(JTextField source, Point destination) {

        int source_x = source.getBounds().x;
        int source_y = source.getBounds().y;

        int destination_x = destination.x;
        int destination_y = destination.y;

        while (source_x != destination_x && source_y == top_limit) {
            source_x++;
            source.setBounds(source_x, source_y, source.getBounds().width, source.getBounds().height);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(SelectionGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public void MoveDown_First(JTextField source, Point destination) {

        int source_x = source.getBounds().x;
        int source_y = source.getBounds().y;

        int destination_x = destination.x;
        int destination_y = destination.y;
        while (source_y != current_position && source_x == destination_x) {
            source_y++;
            source.setBounds(source_x, source_y, source.getBounds().width, source.getBounds().height);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(SelectionGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        source.setBackground(Color.WHITE);

    }
    
    public void MoveDown_Second(JTextField source, Point destination) {
        int source_x = source.getBounds().x;
        int source_y = source.getBounds().y;

        int destination_x = destination.x;
        int destination_y = destination.y;
        source.setBackground(Color.GREEN);
        while (source_y != bottom_limit && source_x != destination_x) {
            source_y++;
            source.setBounds(source_x, source_y, source.getBounds().width, source.getBounds().height);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(SelectionGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
    
    public void MoveLeft_Second(JTextField source, Point destination) {
        int source_x = source.getBounds().x;
        int source_y = source.getBounds().y;

        int destination_x = destination.x;
        int destination_y = destination.y;

        while (source_x != destination_x && source_y == bottom_limit) {
            source_x--;
            source.setBounds(source_x, source_y, source.getBounds().width, source.getBounds().height);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(SelectionGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void MoveUp_Second(JTextField source, Point destination) {
        int source_x = source.getBounds().x;
        int source_y = source.getBounds().y;

        int destination_x = destination.x;
        int destination_y = destination.y;

        while (source_y != current_position && source_x == destination_x) {
            source_y--;
            source.setBounds(source_x, source_y, source.getBounds().width, source.getBounds().height);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(SelectionGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void performSelection(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < list.length; j++) {
                elements.get(i).setBackground(Color.PINK);
                try {
                    resetElements(j);
                    Thread.sleep(500);
                    elements.get(j).setBackground(Color.ORANGE);
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SelectionGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (list[j] > list[minPos]) {
                    minPos = j;
                }
                 
            }
            elements.get(minPos).setBackground(Color.RED);
            swap(list, minPos, i);
        }
        
        elements.get(6).setBackground(Color.GREEN);
    }
    
    public void resetElements(int start){
        for(int i=start+1;i<7;i++){
            elements.get(i).setBackground(Color.WHITE);
        }
    }
    
    private void swap(int[] a, int i, int j) {
        JTextField jTemp = elements.get(j);
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        if(i!=j){
            moveFirst(elements.get(j), coordinates.get(i));
            moveSecond(elements.get(i), coordinates.get(j));
        }
        else {
                elements.get(j).setBackground(Color.GREEN);
        }
        
        elements.put(j, elements.get(i));
        elements.put(i, jTemp);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtInput0 = new javax.swing.JTextField();
        txtInput1 = new javax.swing.JTextField();
        txtInput2 = new javax.swing.JTextField();
        txtInput3 = new javax.swing.JTextField();
        txtInput4 = new javax.swing.JTextField();
        txtInput5 = new javax.swing.JTextField();
        txtInput6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        element3 = new javax.swing.JTextField();
        element0 = new javax.swing.JTextField();
        element2 = new javax.swing.JTextField();
        element5 = new javax.swing.JTextField();
        element4 = new javax.swing.JTextField();
        element6 = new javax.swing.JTextField();
        element1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Selection Sort");

        jButton1.setText("Move");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtInput0.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        txtInput0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInput0.setToolTipText("");

        txtInput1.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        txtInput1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInput1.setToolTipText("");

        txtInput2.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        txtInput2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInput2.setToolTipText("");

        txtInput3.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        txtInput3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInput3.setToolTipText("");

        txtInput4.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        txtInput4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInput4.setToolTipText("");

        txtInput5.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        txtInput5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInput5.setToolTipText("");

        txtInput6.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        txtInput6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInput6.setToolTipText("");

        jButton3.setText("Selection Sort");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtInput0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtInput4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtInput5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtInput6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInput0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        element3.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        element3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        element3.setToolTipText("");

        element0.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        element0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        element0.setToolTipText("");

        element2.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        element2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        element2.setToolTipText("");
        element2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                element2ActionPerformed(evt);
            }
        });

        element5.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        element5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        element5.setToolTipText("");

        element4.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        element4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        element4.setToolTipText("");

        element6.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        element6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        element6.setToolTipText("");

        element1.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        element1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        element1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(element0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(element1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(element2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(element3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(element4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(element5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(element6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(element1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(element3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(element4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(element5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(element6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(element0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(element2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        int x_position = jTextField1.getBounds().x;
//        x_position++;
//        jTextField1.setBounds(x_position, jTextField1.getBounds().y, jTextField1.getWidth(), jTextField1.getHeight());
//        
            
//        
//        
//        jTextField1.setText("Hello");
          loadArray();
          Thread t = new Thread(()->{
              performSelection(original_Array);
          });
          
          t.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void element2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_element2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_element2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        InsertionSort s2 = new InsertionSort();
        s2.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(SelectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectionGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField element0;
    public javax.swing.JTextField element1;
    private javax.swing.JTextField element2;
    private javax.swing.JTextField element3;
    private javax.swing.JTextField element4;
    private javax.swing.JTextField element5;
    private javax.swing.JTextField element6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtInput0;
    private javax.swing.JTextField txtInput1;
    private javax.swing.JTextField txtInput2;
    private javax.swing.JTextField txtInput3;
    private javax.swing.JTextField txtInput4;
    private javax.swing.JTextField txtInput5;
    private javax.swing.JTextField txtInput6;
    // End of variables declaration//GEN-END:variables
}
