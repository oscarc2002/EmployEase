package employeasepkg;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrameAgregarUsuario extends javax.swing.JFrame {
    ConexionSQL connection = new ConexionSQL();
    int idUser, idEmpleado;
    
    public FrameAgregarUsuario() {
        initComponents();
        loadData();
        adjustSize();
    }
    
    public FrameAgregarUsuario(int idUser) {
        initComponents();
        getContentPane().setBackground(new Color(0x6cb4d4));
        
        loadData();
        adjustSize();
        this.idUser = idUser;
    }
    
    private void adjustSize() {
        tableEmployees.getColumnModel().getColumn(0).setPreferredWidth(100);
        for (int i = 0; i < 6; i++) {
            tableEmployees.getColumnModel().getColumn(i).setPreferredWidth(130);
        }
    }
    
    private void loadData(){
        PreparedStatement st;
        ResultSet rs;

        try {
            DefaultTableModel tblModel = (DefaultTableModel) tableEmployees.getModel();
            tblModel.setRowCount(0);
            String query = "select * from `employease` where estatus = 'ACTIVO'";

            st = connection.getConectarDB().prepareStatement(query);
            rs = st.executeQuery(query);

            while (rs.next()) {
                //Recolectar datos
                String nombre = rs.getString("nombre");
                int id = rs.getInt("id_empleado");
                String apellido = rs.getString("apellido");
                String unidad = rs.getString("unidad");
                String puesto = rs.getString("puesto");
                String departamento = rs.getString("departamento");
                
                //Datos
                tblModel.addRow(new Object[]{String.valueOf(id), nombre, apellido,
                    unidad, puesto, departamento});
            }

        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmployees = new javax.swing.JTable();
        btnCreateUser = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemReturn = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setText("id de empleado:");

        tableEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID de Empleado", "Nombre", "Apellido", "Unidad", "Puesto", "Departamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmployeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEmployees);

        btnCreateUser.setText("Crear usuario");
        btnCreateUser.setEnabled(false);
        btnCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUserActionPerformed(evt);
            }
        });

        lblID.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblID.setText("0");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Nombre del empleado:");

        lblNombre.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreateUser))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblID)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateUser)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmployeesMouseClicked
        int index = tableEmployees.getSelectedRow();
        DefaultTableModel tblModel = (DefaultTableModel) tableEmployees.getModel();
        idEmpleado = Integer.parseInt(tblModel.getValueAt(index, 0).toString());
        lblID.setText(String.valueOf(idEmpleado));
        lblNombre.setText(tblModel.getValueAt(index, 1).toString());
        btnCreateUser.setEnabled(true);
    }//GEN-LAST:event_tableEmployeesMouseClicked

    private void btnCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUserActionPerformed
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT * FROM `empleados` WHERE `id_user` = ?";
        try {
            st = connection.getConectarDB().prepareStatement(query);

            st.setInt(1, idEmpleado);
            rs = st.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(rootPane, "El empleado ya tiene usuario", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                FrameCrearUsuario frame = new FrameCrearUsuario(idUser, idEmpleado);
                frame.show();
                this.dispose();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnCreateUserActionPerformed

    private void itemReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReturnActionPerformed
        
        
        FrameTablaEmpleados frame = new FrameTablaEmpleados(idUser);
        frame.show();
        this.dispose();
    }//GEN-LAST:event_itemReturnActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrameAgregarUsuario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateUser;
    private javax.swing.JMenuItem itemReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tableEmployees;
    // End of variables declaration//GEN-END:variables
}
