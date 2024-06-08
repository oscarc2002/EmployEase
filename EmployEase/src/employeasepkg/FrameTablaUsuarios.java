package employeasepkg;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrameTablaUsuarios extends javax.swing.JFrame {
    ConexionSQL connection = new ConexionSQL();
    int idUser, idEmpleado, isAdmin;
    String user;
    
    public FrameTablaUsuarios() {
        initComponents();
    }

    public FrameTablaUsuarios(int idUser) {
        initComponents();
        getContentPane().setBackground(new Color(0x6cb4d4));
        this.idUser = idUser;
        loadData();
    }
    
    private void loadData(){
        PreparedStatement st;
        ResultSet rs;

        try {
            DefaultTableModel tblModel = (DefaultTableModel) tableData.getModel();
            tblModel.setRowCount(0);
            String query = "select * from `empleados`";

            st = connection.getConectarDB().prepareStatement(query);
            rs = st.executeQuery(query);

            while (rs.next()) {
                //Recolectar datos
                user = rs.getString("user");
                int isAdmin = rs.getInt("esAdmin");
                int id = rs.getInt("id_user");
                String permission = (isAdmin == 1) ? "Si" : "No";
                
                //Datos
                tblModel.addRow(new Object[]{String.valueOf(id), user, permission});
            }

        } catch (Exception e) {
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        chbIsAdmin = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        btnDeleteUser = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemRegresar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID de empleado", "Usuario", "Es administrador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableData);

        jLabel1.setText("Nombre de usuario");

        lblUserName.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblUserName.setText("No seleccionado");

        chbIsAdmin.setText("Es administrador");
        chbIsAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbIsAdminActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setText("Lista de Usuarios");

        btnDeleteUser.setText("Eliminar usuario");
        btnDeleteUser.setEnabled(false);
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        itemRegresar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LEFT, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return.png"))); // NOI18N
        itemRegresar.setText("Regresar");
        itemRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegresarActionPerformed(evt);
            }
        });
        jMenu1.add(itemRegresar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbIsAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeleteUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUserName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(chbIsAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUserName)
                .addGap(112, 112, 112))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegresarActionPerformed
        FrameTablaEmpleados frame = new FrameTablaEmpleados(idUser);
        frame.show();
        this.dispose();
    }//GEN-LAST:event_itemRegresarActionPerformed

    private void tableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataMouseClicked
        btnDeleteUser.setEnabled(true);
        chbIsAdmin.setEnabled(true);
        
        int index = tableData.getSelectedRow();
        DefaultTableModel tblModel = (DefaultTableModel) tableData.getModel();
        idEmpleado = Integer.parseInt(tblModel.getValueAt(index, 0).toString());
        user = tblModel.getValueAt(index, 1).toString();
        lblUserName.setText(user);
        
        String permission = tblModel.getValueAt(index, 2).toString();
        isAdmin = (permission.trim().equals("Si")) ? 1 : 0;
        
        if(isAdmin == 1){
            chbIsAdmin.setSelected(true);
        }
        else{
            chbIsAdmin.setSelected(false);
        }
    }//GEN-LAST:event_tableDataMouseClicked
   
    private void chbIsAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbIsAdminActionPerformed
        int opc = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres cambiar el estado de este empleado?",
                "Opciones", JOptionPane.YES_NO_OPTION);
        if (opc == JOptionPane.YES_OPTION) {
            PreparedStatement st;
            ResultSet rs;
            
            isAdmin = (chbIsAdmin.isSelected()) ? 1 : 0;
            
            try{
                String query = "SELECT COUNT(esAdmin) FROM `empleados` WHERE `esAdmin` = 1";
                st = connection.getConectarDB().prepareStatement(query);
                rs = st.executeQuery();
                int cont = 0;
                
                if(rs.next())
                {
                    cont = rs.getInt(1);
                }
                
                if(cont == 1 && isAdmin == 0){
                    JOptionPane.showMessageDialog(rootPane, "Debe haber al menos 1 administrador", "Error", JOptionPane.ERROR_MESSAGE);
                    chbIsAdmin.setSelected(true);
                }
                else{
                    query = "UPDATE `empleados` SET `esAdmin`= ? WHERE `id_user` = " + idEmpleado;
                    st = connection.getConectarDB().prepareStatement(query);
                    
                    st.setInt(1, isAdmin);

                    if (st.executeUpdate() != 0) {
                        JOptionPane.showMessageDialog(rootPane, "Se modificó al usuario con éxito");

                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Error al modificar al usuario");
                    }
                }
            }catch(HeadlessException | NumberFormatException | SQLException e){
                System.out.println(e.toString());
            }
            
            loadData();
        }
        else{
            if (chbIsAdmin.isSelected())
                chbIsAdmin.setSelected(false);
            else
                chbIsAdmin.setSelected(true);
        }
    }//GEN-LAST:event_chbIsAdminActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        int opc = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar a " + user + " con id: " + idEmpleado + "?",
                "Opciones", JOptionPane.YES_NO_OPTION);
        if (opc == JOptionPane.YES_OPTION) {
            if(idUser == idEmpleado){
                JOptionPane.showMessageDialog(rootPane, "No puedes borrarte a ti mismo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            PreparedStatement st;
            ResultSet rs;
            
            try{
                String query = "SELECT COUNT(esAdmin) FROM `empleados` WHERE `esAdmin` = 1";
                st = connection.getConectarDB().prepareStatement(query);
                rs = st.executeQuery();
                int cont = 0;
                
                if(rs.next())
                {
                    cont = rs.getInt(1);
                }
                
                if(cont == 1 && isAdmin == 1){
                    JOptionPane.showMessageDialog(rootPane, "Debe haber al menos 1 administrador", "Error", JOptionPane.ERROR_MESSAGE);
                    chbIsAdmin.setSelected(true);
                }
                else{
                    deleteRegister();
                }
            }catch(HeadlessException | NumberFormatException | SQLException e){
                System.out.println(e.toString());
            }
            
        }
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void deleteRegister() {
        PreparedStatement st;
        ResultSet rs;

        try {
            String query = "delete from `empleados` where `id_user` = ?";

            st = connection.getConectarDB().prepareStatement(query);
            st.setInt(1, idEmpleado);

            if (st.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(rootPane, "Registro eliminado");
            }

            loadData();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameTablaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameTablaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameTablaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameTablaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JCheckBox chbIsAdmin;
    private javax.swing.JMenuItem itemRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTable tableData;
    // End of variables declaration//GEN-END:variables
}
