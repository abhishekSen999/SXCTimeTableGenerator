package GUI;


public class JFrameMenu extends javax.swing.JFrame 
{
   
    public JFrameMenu() 
    {
       
        initComponents();
        jLabel1.setVisible(false);
    }
    
    public void println(String s)
    {
        jLabel1.setText(s);
        System.out.println(s);
                
        //System.out.println(s);
        
        //jTextArea1.revalidate();
        //while (true);
    }
    

   /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_dept_details = new javax.swing.JButton();
        JButton_classroom_details = new javax.swing.JButton();
        jButton_labroom_details = new javax.swing.JButton();
        jButton_logout = new javax.swing.JButton();
        jButton_generate_timetable = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_dept_details.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton_dept_details.setText("Enter Department Details");
        jButton_dept_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dept_detailsActionPerformed(evt);
            }
        });

        JButton_classroom_details.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        JButton_classroom_details.setText("Enter Classroom Details");
        JButton_classroom_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton_classroom_detailsActionPerformed(evt);
            }
        });

        jButton_labroom_details.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton_labroom_details.setText("Enter Labroom Details");
        jButton_labroom_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_labroom_detailsActionPerformed(evt);
            }
        });

        jButton_logout.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton_logout.setText("Logout");
        jButton_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_logoutActionPerformed(evt);
            }
        });

        jButton_generate_timetable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton_generate_timetable.setText("Generate Timetable");
        jButton_generate_timetable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_generate_timetableActionPerformed(evt);
            }
        });

        jLabel1.setText("Please Wait while we Generate the result...");
        jLabel1.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton_logout)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(JButton_classroom_details, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_dept_details, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_labroom_details, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_generate_timetable, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_dept_details)
                .addGap(18, 18, 18)
                .addComponent(JButton_classroom_details)
                .addGap(18, 18, 18)
                .addComponent(jButton_labroom_details)
                .addGap(18, 18, 18)
                .addComponent(jButton_generate_timetable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_logoutActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton_logoutActionPerformed

    private void showLabel()
    {
        jLabel1.setVisible(true);
    }
    private void jButton_generate_timetableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_generate_timetableActionPerformed
           
         showLabel();
         for(int i=0;i<10000;i++)
            System.out.println("hello");
        
                try{
                    
                 //  new TimeTable.TimeTable(this);
                    
                }       
                catch(Exception e){}
         
        
    }//GEN-LAST:event_jButton_generate_timetableActionPerformed

    private void jButton_labroom_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_labroom_detailsActionPerformed
        GUI.JFrameLabroom ob= new JFrameLabroom();
        ob.setSize(500,500);
        ob.setVisible(true);
    }//GEN-LAST:event_jButton_labroom_detailsActionPerformed

    private void jButton_dept_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dept_detailsActionPerformed
        GUI.JFrameSelect ob= new JFrameSelect();
        ob.setSize(500,500);
        ob.setVisible(true);
    }//GEN-LAST:event_jButton_dept_detailsActionPerformed

    private void JButton_classroom_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButton_classroom_detailsActionPerformed
        GUI.JFrameClassroom ob= new JFrameClassroom();
        ob.setSize(500,500);
        ob.setVisible(true);
    }//GEN-LAST:event_JButton_classroom_detailsActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButton_classroom_details;
    private javax.swing.JButton jButton_dept_details;
    private javax.swing.JButton jButton_generate_timetable;
    private javax.swing.JButton jButton_labroom_details;
    private javax.swing.JButton jButton_logout;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}