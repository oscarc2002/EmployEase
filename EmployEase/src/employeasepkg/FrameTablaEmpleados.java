package employeasepkg;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.temporal.ChronoUnit;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class FrameTablaEmpleados extends javax.swing.JFrame {

    ConexionSQL connection = new ConexionSQL();
    int idEmpleado = 0, idUser = 0, index = 0;
    String nombre_empleado = "", apellido_empleado = "", lugar_n = "", sexo = "", edo_civil = "",
            curp = "", nss = "", rfc = "", direccion = "", correo = "", puesto = "", nombre_beneficiario = "",
            edad = "", fecha_i = "", fecha_b, salario = "";

    public FrameTablaEmpleados(int idUser) {
        initComponents();
        loadData("where `estatus` = 'ACTIVO'");
        adjustSize();
        this.idUser = idUser;
        adminAdjust();
        //Permite ordenar dando clic en el nombre de la columna
        this.tableData.setAutoCreateRowSorter(true); 
    }

    private void adjustSize() {
        tableData.getColumnModel().getColumn(0).setPreferredWidth(100);
        for (int i = 1; i < 34; i++) {
            tableData.getColumnModel().getColumn(i).setPreferredWidth(130);
        }
    }
    
    private void adminAdjust(){
        PreparedStatement st;
        ResultSet rs;

        String query = "SELECT * FROM `empleados` WHERE `id_user` = ?";
        try {
            st = connection.getConectarDB().prepareStatement(query);
            st.setInt(1, idUser);
            rs = st.executeQuery();

            if (rs.next()) {
                if(rs.getInt("esAdmin") == 0){
                    btnAgregar.setVisible(false);
                    btnModificar.setVisible(false);
                    btnEliminar.setVisible(false);
                    menuEdit.setVisible(false);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        chkMostrarActivos = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        itemQA = new javax.swing.JMenuItem();
        itemProfile = new javax.swing.JMenuItem();
        itemCloseSession = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        itemAddUser = new javax.swing.JMenuItem();
        itemReadUser = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setText("Tabla de empleados");

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

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID del empleado", "Fecha de ingreso", "Nombre", "Apellido", "Unidad", "Puesto", "Departamento", "Teléfono", "Correo", "Sueldo", "NSS", "Curp", "RFC", "Broxel", "Banco", "Clave interbancaria", "Dirección", "Fecha de nacimiento", "Lugar de nacimiento", "Sexo", "Estado civil", "Número de cédula", "Vacuna Covid-19", "Crédito infonavit", "Nombre del beneficiario", "Teléfono del beneficiario", "Parentesco con el beneficiario", "Estatus", "Motivo de baja", "Motivo/Comentario", "% Recomendable", "Tipo", "Fecha alta del IMSS", "Fecha de inicio", "Fecha de baja"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableData.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableData.setShowGrid(true);
        tableData.getTableHeader().setReorderingAllowed(false);
        tableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableData);

        jLabel7.setText("Empleado seleccionado:");

        lblNombre.setText("Ninguno");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
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
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        chkMostrarActivos.setSelected(true);
        chkMostrarActivos.setText("Mostrar solo activos");
        chkMostrarActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrarActivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGenerar, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(chkMostrarActivos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkMostrarActivos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuFile.setText("Archivo");

        itemQA.setText("Preguntas frecuentas");
        itemQA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemQAActionPerformed(evt);
            }
        });
        menuFile.add(itemQA);

        itemProfile.setText("Ver mi perfil");
        itemProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProfileActionPerformed(evt);
            }
        });
        menuFile.add(itemProfile);

        itemCloseSession.setText("Cerrar sesión");
        itemCloseSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCloseSessionActionPerformed(evt);
            }
        });
        menuFile.add(itemCloseSession);

        jMenuBar1.add(menuFile);

        menuEdit.setText("Editar");

        itemAddUser.setText("Añadir usuario");
        itemAddUser.setName("itemAddUser"); // NOI18N
        itemAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAddUserActionPerformed(evt);
            }
        });
        menuEdit.add(itemAddUser);

        itemReadUser.setText("Lista de usuarios");
        itemReadUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReadUserActionPerformed(evt);
            }
        });
        menuEdit.add(itemReadUser);

        jMenuBar1.add(menuEdit);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombre)
                        .addGap(93, 93, 93))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteRegister() {
        PreparedStatement st;
        ResultSet rs;

        try {
            String query = "delete from `employease` where `id_empleado` = ?";

            st = connection.getConectarDB().prepareStatement(query);
            st.setInt(1, idEmpleado);

            if (st.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(rootPane, "Registro eliminado");
            }

            loadData("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "¡Debes eliminar la cuenta de usuario primero!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int opc = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar a " + nombre_empleado + " con id: " + idEmpleado + "?",
                "Opciones", JOptionPane.YES_NO_OPTION);
        if (opc == JOptionPane.YES_OPTION) {
            deleteRegister();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        FrameAgregarEmpleado add = new FrameAgregarEmpleado(idUser);
        add.show();
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void itemCloseSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCloseSessionActionPerformed
        int opc = JOptionPane.showConfirmDialog(null, "Seguro que quieres cerrar sesión?", "Opciones", JOptionPane.YES_NO_OPTION);
        if (opc == 0) {
            FrameInicioSesion st = new FrameInicioSesion();
            st.show();
            this.dispose();
        }

    }//GEN-LAST:event_itemCloseSessionActionPerformed

    private void itemQAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemQAActionPerformed
        FramePreguntas qa = new FramePreguntas(idUser);
        qa.show();
        this.dispose();
    }//GEN-LAST:event_itemQAActionPerformed

    private void loadData(String where) {
        PreparedStatement st;
        ResultSet rs;

        try {
            DefaultTableModel tblModel = (DefaultTableModel) tableData.getModel();
            tblModel.setRowCount(0);
            String query = "select * from `employease` " + where;

            st = connection.getConectarDB().prepareStatement(query);
            rs = st.executeQuery(query);

            while (rs.next()) {
                //Recolectar datos
                String nombre = rs.getString("nombre");
                String fecha_ingreso = rs.getDate("fecha_ingreso").toString();
                int id = rs.getInt("id_empleado");
                String apellido = rs.getString("apellido");
                String unidad = rs.getString("unidad");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String nss = rs.getString("nss");
                String curp = rs.getString("curp");
                String rfc = rs.getString("rfc");
                String broxel = rs.getString("broxel");
                String banco = rs.getString("banco");
                String puesto = rs.getString("puesto");
                String departamento = rs.getString("departamento");
                String clave_i = rs.getString(13);
                String direccion = rs.getString("direccion");
                
                Date fecha_n = rs.getDate(15);
                if (fecha_n == null) {
                    fecha_n = java.sql.Date.valueOf(LocalDate.now().minusYears(18));
                }
                String lugar_nacimiento = rs.getString("lugar_nacimiento");
                String sexo = rs.getString("sexo");
                String estado_civil = rs.getString("estado_civil");
                String no_cedula = rs.getString("no_cedula");
                String vacuna_covid = rs.getString("vacuna_covid");

                String credito_infonavit = rs.getString("credito_infonavit");
                String nombre_beneficiario = rs.getString("nombre_beneficiario");
                String telefono_beneficiario = rs.getString("telefono_beneficiario");
                String parentesco_beneficiario = rs.getString("parentesco_beneficiario");
                String estatus = rs.getString("estatus");
                String motivo_baja = rs.getString("motivo_baja");
                String recomendable = rs.getString("recomendable");
                String motivo = rs.getString("motivo");
                String tipo = rs.getString("tipo");
                double sueldo = rs.getDouble("sueldo");

                Date fecha_alta_imss = rs.getDate(32);
                if (fecha_alta_imss == null) {
                    fecha_alta_imss = java.sql.Date.valueOf(LocalDate.now());
                }
                
                Date fecha_inicio = rs.getDate(33);

                Date fecha_baja = rs.getDate(34);
                 
                //Datos
                
                tblModel.addRow(new Object[]{String.valueOf(id), fecha_ingreso, nombre, apellido,
                    unidad, puesto, departamento, telefono, correo, sueldo, nss, curp, rfc, broxel, banco, clave_i, direccion,
                    String.valueOf(fecha_n), lugar_nacimiento, sexo, estado_civil, no_cedula, vacuna_covid, credito_infonavit, nombre_beneficiario,
                    telefono_beneficiario, parentesco_beneficiario, estatus, motivo_baja, motivo, recomendable, tipo, String.valueOf(fecha_alta_imss),
                    String.valueOf(fecha_inicio), String.valueOf(fecha_baja)
                });
            }

        } catch (Exception e) {
        }
    }

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
        if (txtID.getText().trim().equals("")) {
            loadData("");
        } else {
            loadData("where `id_empleado` = " + txtID.getText().trim());
        }
        chkMostrarActivos.setSelected(false);
    }//GEN-LAST:event_txtIDKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        String text = "'%" + txtNombre.getText().trim() + "%'";
        if (txtNombre.getText().trim().equals("")) {
            loadData("");
        } else {
            loadData("where `nombre` like " + text);
        }
        chkMostrarActivos.setSelected(false);
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtUnidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnidadKeyReleased
        String text = "'%" + txtUnidad.getText().trim() + "%'";
        if (txtUnidad.getText().trim().equals("")) {
            loadData("");
        } else {
            loadData("where `unidad` like " + text);
        }
        chkMostrarActivos.setSelected(false);
    }//GEN-LAST:event_txtUnidadKeyReleased

    private void txtPuestoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPuestoKeyReleased
        String text = "'%" + txtPuesto.getText().trim() + "%'";
        if (txtPuesto.getText().trim().equals("")) {
            loadData("");
        } else {
            loadData("where `puesto` like " + text);
        }
        chkMostrarActivos.setSelected(false);
    }//GEN-LAST:event_txtPuestoKeyReleased

    private void txtDepartamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDepartamentoKeyReleased
        String text = "'%" + txtDepartamento.getText().trim() + "%'";
        if (txtDepartamento.getText().trim().equals("")) {
            loadData("");
        } else {
            loadData("where `departamento` like " + text);
        }
        chkMostrarActivos.setSelected(false);
    }//GEN-LAST:event_txtDepartamentoKeyReleased

    private void chkMostrarActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarActivosActionPerformed
        if (chkMostrarActivos.isSelected())
            loadData("where `estatus` = 'ACTIVO'");
        else
            loadData("");
    }//GEN-LAST:event_chkMostrarActivosActionPerformed

    private void setButtons(boolean condition) {
        btnModificar.setEnabled(condition);
        btnEliminar.setEnabled(condition);
        btnGenerar.setEnabled(condition);
    }

    private void tableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataMouseClicked
        setButtons(true); //Activate bottons
        index = tableData.getSelectedRow();
        DefaultTableModel tblModel = (DefaultTableModel) tableData.getModel();
        idEmpleado = Integer.parseInt(tblModel.getValueAt(index, 0).toString());
        nombre_empleado = tblModel.getValueAt(index, 2).toString();
        apellido_empleado = tblModel.getValueAt(index, 3).toString();
        lugar_n = tblModel.getValueAt(index, 18).toString();
        sexo = tblModel.getValueAt(index, 19).toString();
        edo_civil = tblModel.getValueAt(index, 20).toString();
        curp = tblModel.getValueAt(index, 11).toString();
        nss = tblModel.getValueAt(index, 10).toString();
        rfc = tblModel.getValueAt(index, 12).toString();
        direccion = tblModel.getValueAt(index, 16).toString();
        correo = tblModel.getValueAt(index, 8).toString();
        puesto = tblModel.getValueAt(index, 5).toString();
        nombre_beneficiario = tblModel.getValueAt(index, 24).toString();
        
        LocalDate fecha_nac = LocalDate.parse(tblModel.getValueAt(index, 17).toString());
        edad = String.valueOf( ChronoUnit.YEARS.between(fecha_nac, LocalDate.now()));
        fecha_i = tblModel.getValueAt(index, 33).toString();
        
        LocalDate tmpFechaI = LocalDate.parse(fecha_i);
        tmpFechaI = tmpFechaI.plusMonths(1);
        fecha_b = tmpFechaI.toString();
        
        salario = tblModel.getValueAt(index, 9).toString();
        lblNombre.setText(nombre_empleado);
    }//GEN-LAST:event_tableDataMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        FrameEditarEmpleado editarEmpleado = new FrameEditarEmpleado(idUser,idEmpleado);
        editarEmpleado.show();
        this.dispose();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar como...");
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String location = fileToSave.getAbsolutePath() + ".docx";
        
            try {
                // Cargar la plantilla de contrato
                fileChooser.setDialogTitle("Seleccionar plantilla...");
                fileChooser.setCurrentDirectory(new File(".\\src\\plantillas"));
                userSelection = fileChooser.showOpenDialog(null);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToOpen = fileChooser.getSelectedFile();
                    FileInputStream fileInputStream = new FileInputStream(fileToOpen.getAbsolutePath());
                    
                    //FileInputStream fileInputStream = new FileInputStream("C:\\Users\\mario\\Downloads\\plantilla.docx");
                    XWPFDocument document = new XWPFDocument(fileInputStream);
                    fileInputStream.close();


                    // Modificar los valores en la plantilla
                    for (XWPFParagraph paragraph : document.getParagraphs()) {
                        String text = paragraph.getText();

                        if (text != null && text.contains("{{NOMBRE}}")) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String runText = run.getText(run.getTextPosition());
                                if (runText != null && runText.contains("{{NOMBRE}}")) {
                                    run.setText(runText.replace("{{NOMBRE}}", nombre_empleado), 0);
                                }
                            }
                        }

                        if (text != null && text.contains("{{APELLIDO}}")) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String runText = run.getText(run.getTextPosition());
                                if (runText != null && runText.contains("{{APELLIDO}}")) {
                                    run.setText(runText.replace("{{APELLIDO}}", apellido_empleado), 0);
                                }
                            }
                        }
                        if (text != null && text.contains("{{lugar_n}}")) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String runText = run.getText(run.getTextPosition());
                                if (runText != null && runText.contains("{{lugar_n}}")) {
                                    run.setText(runText.replace("{{lugar_n}}", lugar_n), 0);
                                }
                            }
                        }
                        if (text != null && text.contains("{{sexo}}")) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String runText = run.getText(run.getTextPosition());
                                if (runText != null && runText.contains("{{sexo}}")) {
                                    run.setText(runText.replace("{{sexo}}", sexo), 0);
                                }
                            }
                        }
                        if (text != null && text.contains("{{edo_civil}}")) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String runText = run.getText(run.getTextPosition());
                                if (runText != null && runText.contains("{{edo_civil}}")) {
                                    run.setText(runText.replace("{{edo_civil}}", edo_civil), 0);
                                }
                            }
                        }
                        if (text != null && text.contains("{{curp}}")) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String runText = run.getText(run.getTextPosition());
                                if (runText != null && runText.contains("{{curp}}")) {
                                    run.setText(runText.replace("{{curp}}", curp), 0);
                                }
                            }
                        }
                        if (text != null && text.contains("{{nns}}")) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String runText = run.getText(run.getTextPosition());
                                if (runText != null && runText.contains("{{nns}}")) {
                                    run.setText(runText.replace("{{nns}}", nss), 0);
                                }
                            }
                        }
                        if (text != null && text.contains("{{rfc}}")) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String runText = run.getText(run.getTextPosition());
                                if (runText != null && runText.contains("{{rfc}}")) {
                                    run.setText(runText.replace("{{rfc}}", rfc), 0);
                                }
                            }
                        }
                        if (text != null && text.contains("{{direccion}}")) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String runText = run.getText(run.getTextPosition());
                                if (runText != null && runText.contains("{{direccion}}")) {
                                    run.setText(runText.replace("{{direccion}}", direccion), 0);
                                }
                            }
                        }
                        if (text != null && text.contains("{{correo}}")) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String runText = run.getText(run.getTextPosition());
                                if (runText != null && runText.contains("{{correo}}")) {
                                    run.setText(runText.replace("{{correo}}", correo), 0);
                                }
                            }
                        }
                        if (text != null && text.contains("{{puesto}}")) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String runText = run.getText(run.getTextPosition());
                                if (runText != null && runText.contains("{{puesto}}")) {
                                    run.setText(runText.replace("{{puesto}}", puesto), 0);
                                }
                            }
                        }
                        if (text != null && text.contains("{{nombre_beneficiario}}")) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String runText = run.getText(run.getTextPosition());
                                if (runText != null && runText.contains("{{nombre_beneficiario}}")) {
                                    run.setText(runText.replace("{{nombre_beneficiario}}", nombre_beneficiario), 0);
                                }
                            }
                        }
                        if (text != null && text.contains("{{fecha_i}}")) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String runText = run.getText(run.getTextPosition());
                                if (runText != null && runText.contains("{{fecha_i}}")) {
                                    run.setText(runText.replace("{{fecha_i}}", fecha_i), 0);
                                }
                            }
                        }
                        if (text != null && text.contains("{{fecha_b}}")) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String runText = run.getText(run.getTextPosition());
                                if (runText != null && runText.contains("{{fecha_b}}")) {
                                    run.setText(runText.replace("{{fecha_b}}", fecha_b), 0);
                                }
                            }
                        }
                        if (text != null && text.contains("{{salario}}")) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String runText = run.getText(run.getTextPosition());
                                if (runText != null && runText.contains("{{salario}}")) {
                                    run.setText(runText.replace("{{salario}}", salario), 0);
                                }
                            }
                        }
                        if (text != null && text.contains("{{edad}}")) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String runText = run.getText(run.getTextPosition());
                                if (runText != null && runText.contains("{{edad}}")) {
                                    run.setText(runText.replace("{{edad}}", edad), 0);
                                }
                            }
                        }
                    }
                    // Guardar la plantilla modificada
                    FileOutputStream fileOutputStream = new FileOutputStream(location);
                    document.write(fileOutputStream);
                    fileOutputStream.close();
                    document.close();
                    JOptionPane.showMessageDialog(rootPane, "Se ha credo el contrato con éxito");
                    // Agrega más lógica para otros marcadores o placeholders aquí
                }
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnGenerarActionPerformed

    private void itemAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAddUserActionPerformed
        FrameAgregarUsuario frame = new FrameAgregarUsuario(idUser);
        frame.show();
        this.dispose();
    }//GEN-LAST:event_itemAddUserActionPerformed

    private void itemReadUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReadUserActionPerformed
        FrameTablaUsuarios frame = new FrameTablaUsuarios(idUser);
        frame.show();
        this.dispose();
    }//GEN-LAST:event_itemReadUserActionPerformed

    private void itemProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProfileActionPerformed
        FramePerfilUsuario frame = new FramePerfilUsuario(idUser);
        frame.show();
        this.dispose();
    }//GEN-LAST:event_itemProfileActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrameTablaEmpleados(0).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JCheckBox chkMostrarActivos;
    private javax.swing.JMenuItem itemAddUser;
    private javax.swing.JMenuItem itemCloseSession;
    private javax.swing.JMenuItem itemProfile;
    private javax.swing.JMenuItem itemQA;
    private javax.swing.JMenuItem itemReadUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPuesto;
    private javax.swing.JTextField txtUnidad;
    // End of variables declaration//GEN-END:variables
}
