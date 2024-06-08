package employeasepkg;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FrameCrearUsuario extends javax.swing.JFrame {
    ConexionSQL connection = new ConexionSQL();
    int idUser, idEmpleado;
    String pwd, pwdConfirm;
    
    public FrameCrearUsuario() {
        initComponents();
    }
    
    public FrameCrearUsuario(int idUser, int idEmpleado) {
        initComponents();
        getContentPane().setBackground(new Color(0x6cb4d4));
        this.idUser = idUser;
        this.idEmpleado = idEmpleado;
        adjust();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPwdNormal = new javax.swing.JPasswordField();
        txtPwdConfirm = new javax.swing.JPasswordField();
        lblResponse = new javax.swing.JLabel();
        chbIsAdmin = new javax.swing.JCheckBox();
        lblMessage = new javax.swing.JLabel();
        btnCreateUser = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemReturn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setText("ID del Usuario:");

        lblID.setText("0");

        jPanel1.setBackground(new java.awt.Color(25, 108, 170));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Nombre de usuario:");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setText("Contraseña:");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setText("Confirmar contraseña:");

        txtPwdNormal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPwdNormalKeyPressed(evt);
            }
        });

        txtPwdConfirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPwdConfirmKeyPressed(evt);
            }
        });

        chbIsAdmin.setText("Es Administrador");
        chbIsAdmin.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbIsAdminItemStateChanged(evt);
            }
        });

        lblMessage.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        lblMessage.setText("Un gran poder conlleva una gran responsabilidad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserName)
                    .addComponent(txtPwdNormal)
                    .addComponent(txtPwdConfirm)
                    .addComponent(lblResponse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addComponent(chbIsAdmin))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPwdNormal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPwdConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chbIsAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResponse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(lblMessage)
                .addContainerGap())
        );

        btnCreateUser.setText("Crear usuario");
        btnCreateUser.setEnabled(false);
        btnCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUserActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        itemReturn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LEFT, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return.png"))); // NOI18N
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
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreateUser, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnCreateUser)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void adjust(){
        lblID.setText(String.valueOf(idEmpleado));
        lblMessage.setVisible(false);
        lblResponse.setText("");
    }
    
    private boolean verifyFields(){
        return !(txtPwdNormal.getPassword().length == 0 || txtPwdConfirm.getPassword().length == 0
                || txtUserName.getText().isBlank());
    }
    
    private void btnCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUserActionPerformed
        if(verifyFields()){
            PreparedStatement st;
            ResultSet rs;
            try{
                String query = "SELECT * FROM `empleados` WHERE `user` = ?";
                st = connection.getConectarDB().prepareStatement(query);

                st.setString(1, txtUserName.getText());
                rs = st.executeQuery();

                if (rs.next()){
                    JOptionPane.showMessageDialog(rootPane, "No se pueden repetir usuarios");
                }
                else{
                    query = "INSERT INTO `empleados`(`id_user`, `user`, `password`, `esAdmin`) VALUES (?,?,?,?)";
                    st = connection.getConectarDB().prepareStatement(query);
                    st.setInt(1, idEmpleado);
                    st.setString(2, txtUserName.getText());
                    String password = String.valueOf(txtPwdNormal.getPassword());
                    Integer passHs = password.hashCode();
                    st.setString(3,passHs.toString());

                    if(chbIsAdmin.isSelected()){
                        st.setInt(4, 1);
                    }
                    else{
                        st.setInt(4, 0);
                    }

                    if (st.executeUpdate() != 0) {
                        JOptionPane.showMessageDialog(rootPane, "Se añadió el usuario con éxito");
                        //Cerrar pestaña
                        FrameTablaEmpleados info = new FrameTablaEmpleados(idUser);
                        info.show();
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Error al añadir el usuario");
                    }
                }
                
            }catch(HeadlessException | NumberFormatException | SQLException e){
                System.out.println(e.toString());
            }
            
        }
    }//GEN-LAST:event_btnCreateUserActionPerformed

    private void chbIsAdminItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbIsAdminItemStateChanged
        if(chbIsAdmin.isSelected()){
            lblMessage.setVisible(true);
        }
        else{
            lblMessage.setVisible(false);
        }
    }//GEN-LAST:event_chbIsAdminItemStateChanged

    private void txtPwdNormalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPwdNormalKeyPressed
        pwd = String.valueOf(txtPwdNormal.getPassword());
        
        verifyPassword();
    }//GEN-LAST:event_txtPwdNormalKeyPressed

    private void txtPwdConfirmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPwdConfirmKeyPressed
        pwdConfirm = String.valueOf(txtPwdConfirm.getPassword());
        
        verifyPassword();
    }//GEN-LAST:event_txtPwdConfirmKeyPressed

    private void verifyPassword(){
        if(pwd.trim().equals(pwdConfirm) && !(pwd.trim().isBlank())){
            btnCreateUser.setEnabled(true);
            lblResponse.setText("Las contraseñas coinciden");
            lblResponse.setForeground(Color.green);
        }
        else{
            btnCreateUser.setEnabled(false);
            lblResponse.setText("Las contraseñas no coinciden");
            lblResponse.setForeground(Color.red);
        }
    }
    
    private void itemReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReturnActionPerformed
        FrameAgregarUsuario frame = new FrameAgregarUsuario(idUser);
        frame.show();
        this.dispose();
    }//GEN-LAST:event_itemReturnActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrameAgregarUsuario(0).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateUser;
    private javax.swing.JCheckBox chbIsAdmin;
    private javax.swing.JMenuItem itemReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblResponse;
    private javax.swing.JPasswordField txtPwdConfirm;
    private javax.swing.JPasswordField txtPwdNormal;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
