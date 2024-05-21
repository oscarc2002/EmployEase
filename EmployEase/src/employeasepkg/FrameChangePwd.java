package employeasepkg;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class FrameChangePwd extends javax.swing.JFrame {
    ConexionSQL connection = new ConexionSQL();
    int idUser;
    String pwd, pwdConfirm, pwdOld;
    
    public FrameChangePwd() {
        initComponents();
    }
    
    public FrameChangePwd(int idUser) {
        initComponents();
        this.idUser = idUser;
        lblResponse.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWelcome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        lblResponse = new javax.swing.JLabel();
        txtpwd = new javax.swing.JPasswordField();
        txtpwdconfirm = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemReturn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblWelcome.setFont(lblWelcome.getFont().deriveFont(lblWelcome.getFont().getStyle() | java.awt.Font.BOLD, lblWelcome.getFont().getSize()+10));
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Cambiar contraseña");

        jLabel2.setText("Nueva contraseña:");

        jLabel3.setText("Confirmar contraseña");

        btnSave.setText("Guardar cambios");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblResponse.setText("0");

        txtpwd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpwdKeyReleased(evt);
            }
        });

        txtpwdconfirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpwdconfirmKeyReleased(evt);
            }
        });

        jMenu1.setText("Archivo");

        itemReturn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LEFT, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemReturn.setText("Regresar");
        itemReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReturnActionPerformed(evt);
            }
        });
        jMenu1.add(itemReturn);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWelcome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpwd)
                    .addComponent(txtpwdconfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblResponse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtpwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnSave)))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResponse)
                    .addComponent(txtpwdconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReturnActionPerformed
        FrameTablaEmpleados frame = new FrameTablaEmpleados(idUser);
        frame.show();
        this.dispose();
    }//GEN-LAST:event_itemReturnActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(verifyFields()){
            pwdOld = JOptionPane.showInputDialog("Ingresa tu contraseña anterior");
            PreparedStatement st;
            ResultSet rs;

            String query = "SELECT * FROM `empleados` WHERE `id_user` = ? AND `password` = ?";
            try {
                st = connection.getConectarDB().prepareStatement(query);

                st.setInt(1, idUser);
                st.setString(2, pwdOld);
                rs = st.executeQuery();

                if (rs.next()) {
                    query = "UPDATE `empleados` SET `password`= ? WHERE `id_user` = " + idUser;
                    st = connection.getConectarDB().prepareStatement(query);
                    st.setString(1, pwd);

                    if (st.executeUpdate() != 0) {
                        JOptionPane.showMessageDialog(rootPane, "Se modificó tu contraseña con éxito");
                        //Cerrar pestaña
                        FrameTablaEmpleados info = new FrameTablaEmpleados(idUser);
                        info.show();
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Error al modificar tu usuario");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "La contraseña es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtpwdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpwdKeyReleased
        pwd = String.valueOf( txtpwd.getPassword());
        verifyPassword();
    }//GEN-LAST:event_txtpwdKeyReleased

    private void txtpwdconfirmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpwdconfirmKeyReleased
        pwdConfirm = String.valueOf(txtpwdconfirm.getPassword());
        verifyPassword();
    }//GEN-LAST:event_txtpwdconfirmKeyReleased

    private boolean verifyFields(){
        if(txtpwd.getText().isBlank() || txtpwdconfirm.getText().isBlank()){
            return false;
        }
        else{
            return true;
        }
    }
    
    private void verifyPassword(){
        lblResponse.setVisible(true);
        if(pwd.trim().equals(pwdConfirm) && !(pwd.trim().isBlank())){
            btnSave.setEnabled(true);
            lblResponse.setText("Ambas contraseñas coinciden");
            lblResponse.setForeground(Color.green);
        }
        else{
            btnSave.setEnabled(false);
            lblResponse.setText("Las contraseñas no coinciden");
            lblResponse.setForeground(Color.red);
        }
    }
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
            java.util.logging.Logger.getLogger(FrameChangePwd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameChangePwd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameChangePwd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameChangePwd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameChangePwd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JMenuItem itemReturn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblResponse;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPasswordField txtpwd;
    private javax.swing.JPasswordField txtpwdconfirm;
    // End of variables declaration//GEN-END:variables
}
