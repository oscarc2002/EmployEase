import com.mysql.cj.x.protobuf.MysqlxResultset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrameInfoEmpleado extends javax.swing.JFrame {

    SQLConnection connection = new SQLConnection();
    int id = 0;
    String nombre = "";
    
    public FrameInfoEmpleado() {
        initComponents();
        loadData("where `estatus` = 'ACTIVO'");
        adjustSize();
    }
    
    private void adjustSize(){
        tableData.getColumnModel().getColumn(0).setPreferredWidth(100);
        for(int i = 1; i < 34; i++)
            tableData.getColumnModel().getColumn(i).setPreferredWidth(130);
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
        jPanel1 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUnidad = new javax.swing.JTextField();
        txtPuesto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        chkMostrarActivos = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemDocumentation = new javax.swing.JMenuItem();
        itemQA = new javax.swing.JMenuItem();
        itemCloseSession = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setText("Tabla de empleados");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("ID:");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setText("Unidad:");

        txtUnidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUnidadKeyReleased(evt);
            }
        });

        txtPuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPuestoKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel5.setText("Puesto:");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setText("Departamento:");

        txtDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDepartamentoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(34, 34, 34)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGenerar.setText("Generar contrato");
        btnGenerar.setEnabled(false);

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID del empleado", "Fecha de ingreso", "Nombre", "Apellido", "Unidad", "Puesto", "Departamento", "Teléfono", "Correo", "NSS", "Curp", "RFC", "Broxel", "Banco", "Clave interbancaria", "Dirección", "Fecha de nacimiento", "Lugar de nacimiento", "Sexo", "Estado civil", "Número de cédula", "Vacuna Covid-19", "Crédito infonavit", "Nombre del beneficiario", "Teléfono del beneficiario", "Parentesco con el beneficiario", "Estatus", "Motivo de baja", "Motivo/Comentario", "% Recomendable", "Tipo", "Fecha alta del IMSS", "Fecha de inicio", "Fecha de baja"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableData.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableData.setShowGrid(true);
        tableData.getTableHeader().setReorderingAllowed(false);
        tableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableData);

        chkMostrarActivos.setSelected(true);
        chkMostrarActivos.setText("Mostrar solo activos");
        chkMostrarActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrarActivosActionPerformed(evt);
            }
        });

        jLabel7.setText("Empleado seleccionado:");

        lblNombre.setText("Ninguno");

        jMenu1.setText("Archivo");

        itemDocumentation.setText("Documentación");
        itemDocumentation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDocumentationActionPerformed(evt);
            }
        });
        jMenu1.add(itemDocumentation);

        itemQA.setText("Preguntas frecuentas");
        itemQA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemQAActionPerformed(evt);
            }
        });
        jMenu1.add(itemQA);

        itemCloseSession.setText("Cerrar sesión");
        itemCloseSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCloseSessionActionPerformed(evt);
            }
        });
        jMenu1.add(itemCloseSession);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGenerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chkMostrarActivos)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGenerar)
                        .addGap(18, 18, 18)
                        .addComponent(chkMostrarActivos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombre)
                        .addGap(93, 93, 93))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteRegister(){
        PreparedStatement st;
        ResultSet rs;
        
        try {
            String query = "delete from `employease` where `id_empleado` = ?" ;
            
            st = connection.getConectarDB().prepareStatement(query);
            st.setInt(1, id);
            
            if(st.executeUpdate() > 0){
                JOptionPane.showMessageDialog(rootPane, "Registro eliminado");
            }
            
            loadData("");
        } catch (Exception e) {
        }
    }
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int opc = JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar a "+ nombre + " con id: " + id + "?",
                "Opciones",JOptionPane.YES_NO_OPTION);
        if(opc==JOptionPane.YES_OPTION)
        {
            deleteRegister();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        FrameAñadirEmpleado add = new FrameAñadirEmpleado();
        add.show();
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void itemCloseSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCloseSessionActionPerformed
        int opc = JOptionPane.showConfirmDialog(null, "Seguro que quieres cerrar sesión?","Opciones",JOptionPane.YES_NO_OPTION);
        if(opc==0)
        {
            FrameInicioSesion st = new FrameInicioSesion();
            st.show();
            this.dispose();
        }
        
    }//GEN-LAST:event_itemCloseSessionActionPerformed

    private void itemDocumentationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDocumentationActionPerformed
        FrameDocumentacion df = new FrameDocumentacion();
        df.show();
        this.dispose();
    }//GEN-LAST:event_itemDocumentationActionPerformed

    private void itemQAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemQAActionPerformed
        FramePreguntas qa = new FramePreguntas();
        qa.show();
        this.dispose();
    }//GEN-LAST:event_itemQAActionPerformed

    private void loadData(String where){
        PreparedStatement st;
        ResultSet rs;
        
        try {
            DefaultTableModel tblModel = (DefaultTableModel) tableData.getModel();
            tblModel.setRowCount(0);
            String query = "select * from `employease` " + where;
            
            st = connection.getConectarDB().prepareStatement(query);
            rs = st.executeQuery(query);
            
            while(rs.next()){
                //Recolectar datos
                
                Date fecha_r = rs.getDate("fecha_ingreso");
                int id = rs.getInt("id_empleado");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String unidad = rs.getString("unidad");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String nss = rs.getString("nss");
                String curp = rs.getString("curp");
                String rfc = rs.getString("rfc");
                String broxel = rs.getString("broxel");
                String banco = rs.getString("banco");
                int clave_i = rs.getInt(13);
                String direccion = rs.getString("direccion");
                Date fecha_n = rs.getDate(15);
                String lugar_nacimiento = rs.getString("lugar_nacimiento");
                String sexo = rs.getString("sexo");
                String estado_civil = rs.getString("estado_civil");
                String no_cedula = rs.getString("no_cedula");
                String vacuna_covid = rs.getString("vacuna_covid");
                String puesto = rs.getString("puesto");
                String departamento = rs.getString("departamento");
                String credito_infonavit = rs.getString("credito_infonavit");
                String nombre_beneficiario = rs.getString("nombre_beneficiario");
                String telefono_beneficiario = rs.getString("telefono_beneficiario");
                String parentesco_beneficiario = rs.getString("parentesco_beneficiario");
                String estatus = rs.getString("estatus");
                String motivo_baja = rs.getString("motivo_baja");
                String recomendable = rs.getString("recomendable");
                String motivo = rs.getString("motivo");
                String tipo = rs.getString("tipo");
                Date fecha_a = rs.getDate(32);
                Date fecha_i = rs.getDate(33);
                Date fecha_b = rs.getDate(34);
                
                //Datos                
                tblModel.addRow(new Object[]{String.valueOf(id), String.valueOf(fecha_r),nombre, apellido,
                unidad,puesto,departamento,telefono,correo,nss,curp,rfc,broxel,banco, String.valueOf(clave_i),direccion,
                String.valueOf(fecha_n),lugar_nacimiento,sexo,estado_civil,no_cedula,vacuna_covid,credito_infonavit,nombre_beneficiario,
                telefono_beneficiario,parentesco_beneficiario, estatus,motivo_baja,motivo,recomendable,tipo, String.valueOf(fecha_a),
                String.valueOf(fecha_i), String.valueOf(fecha_b)});
            }
            
        } catch (Exception e) {
        }
    }
    
    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
        if(txtID.getText().trim().equals(""))
            loadData("");
        else
            loadData("where `id_empleado` = " + txtID.getText().trim());
        chkMostrarActivos.setSelected(false);
    }//GEN-LAST:event_txtIDKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        String text = "'%" + txtNombre.getText().trim() + "%'";
        if(txtNombre.getText().trim().equals(""))
            loadData("");
        else
            loadData("where `nombre` like " + text);
        chkMostrarActivos.setSelected(false);
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtUnidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnidadKeyReleased
        String text = "'%" + txtUnidad.getText().trim() + "%'";
        if(txtUnidad.getText().trim().equals(""))
            loadData("");
        else
            loadData("where `unidad` like " + text);
        chkMostrarActivos.setSelected(false);
    }//GEN-LAST:event_txtUnidadKeyReleased

    private void txtPuestoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPuestoKeyReleased
        String text = "'%" + txtPuesto.getText().trim() + "%'";
        if(txtPuesto.getText().trim().equals(""))
            loadData("");
        else
            loadData("where `puesto` like " + text);
        chkMostrarActivos.setSelected(false);
    }//GEN-LAST:event_txtPuestoKeyReleased

    private void txtDepartamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDepartamentoKeyReleased
        String text = "'%" + txtDepartamento.getText().trim() + "%'";
        if(txtDepartamento.getText().trim().equals(""))
            loadData("");
        else
            loadData("where `departamento` like " + text);
        chkMostrarActivos.setSelected(false);
    }//GEN-LAST:event_txtDepartamentoKeyReleased

    private void chkMostrarActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarActivosActionPerformed
        if(chkMostrarActivos.isSelected())
            loadData("where `estatus` = 'ACTIVO'");
        else
            loadData("");
    }//GEN-LAST:event_chkMostrarActivosActionPerformed

    private void setButtons(boolean condition){
        btnActualizar.setEnabled(condition);
        btnEliminar.setEnabled(condition);
        btnGenerar.setEnabled(condition);
    }
    
    private void tableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataMouseClicked
        setButtons(true); //Activate bottons
        
        int index = tableData.getSelectedRow();
        DefaultTableModel tblModel = (DefaultTableModel) tableData.getModel();
        id = Integer.parseInt(tblModel.getValueAt(index, 0).toString());
        nombre = tblModel.getValueAt(index, 2).toString();
        lblNombre.setText(nombre);
    }//GEN-LAST:event_tableDataMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(FrameInfoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameInfoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameInfoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameInfoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrameInfoEmpleado().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JCheckBox chkMostrarActivos;
    private javax.swing.JMenuItem itemCloseSession;
    private javax.swing.JMenuItem itemDocumentation;
    private javax.swing.JMenuItem itemQA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPuesto;
    private javax.swing.JTextField txtUnidad;
    // End of variables declaration//GEN-END:variables
}