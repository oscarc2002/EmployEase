package employeasepkg;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class FrameEditarEmpleado extends javax.swing.JFrame {

    int idEmpleado, idUser;
    ConexionSQL connection = new ConexionSQL();

    public FrameEditarEmpleado() {
        initComponents();
        loadData();
    }

    public FrameEditarEmpleado(int idUser, int id) {
        this.idEmpleado = id;
        initComponents();
        getContentPane().setBackground(new Color(0x6cb4d4));
        loadData();
        this.idUser = idUser;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        jTextField35 = new javax.swing.JTextField();
        btnGroupSexos = new javax.swing.ButtonGroup();
        btnGroupEstatus = new javax.swing.ButtonGroup();
        btnGroupTipo = new javax.swing.ButtonGroup();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCurrentDate = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        panelEmpleado = new employeasepkg.PanelEditarEmpleado();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemRegresar = new javax.swing.JMenuItem();

        jLabel9.setText("Nombre(s):");

        jTextField5.setText("jTextField1");

        jLabel10.setText("Apellido(s):");

        jTextField6.setText("jTextField1");

        jLabel14.setText("jLabel5");

        jTextField10.setText("jTextField1");

        jTextField14.setText("jTextField1");

        jLabel18.setText("jLabel5");

        jLabel20.setText("jLabel20");

        label1.setText("label1");

        jTextField35.setText("jTextField1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modificación de empleado");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("N° de empleado:");

        lblCurrentDate.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblCurrentDate.setText("0");

        jLabel30.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel30.setText("Fecha de registro:");

        lblID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblID.setText("0");

        btnActualizar.setText("Actualizar empleado");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Campos con * son obligatorios");

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
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar)
                        .addGap(33, 33, 33)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblCurrentDate)
                    .addComponent(jLabel30)
                    .addComponent(lblID)
                    .addComponent(btnActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegresarActionPerformed
        FrameTablaEmpleados info = new FrameTablaEmpleados(idUser);
        info.show();
        this.dispose();
    }//GEN-LAST:event_itemRegresarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        askUser();
        //modifyRegister();
    }//GEN-LAST:event_btnActualizarActionPerformed

    public boolean verifyFields() {
        String nombre = panelEmpleado.getTxtName();
        String apellido = panelEmpleado.getTxtLastName();
        String unidad = panelEmpleado.getTxtUnit();
        String puesto = panelEmpleado.getTxtPosition();
        String departamento = panelEmpleado.getTxtDepartment();

        if (nombre.trim().equals("") || apellido.trim().equals("") || unidad.trim().equals("") || puesto.trim().equals("")
                || departamento.trim().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Faltan datos por llenar", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    private void askUser(){
        PreparedStatement st;
        ResultSet rs;
                
        String query = "SELECT * FROM `empleados` WHERE `id_user` = ?";
        try {
            st = connection.getConectarDB().prepareStatement(query);

            st.setInt(1, idEmpleado);
            rs = st.executeQuery();

            if (rs.next() && panelEmpleado.isRbtnInactiveSelected()) {
                JOptionPane.showMessageDialog(rootPane, "Debes borrar el usuario antes de poner al empleado inactivo",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                modifyRegister();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void modifyRegister() {
        PreparedStatement st;
        ResultSet rs;
        if (verifyFields()) {
            String consultaActualizar = "UPDATE employease SET "
                    + "fecha_ingreso = ?, "
                    + "nombre = ?, "
                    + "apellido = ?, "
                    + "unidad = ?, "
                    + "telefono = ?, "
                    + "correo = ?, "
                    + "nss = ?, "
                    + "curp = ?, "
                    + "rfc = ?, "
                    + "broxel = ?, " //10
                    + "banco = ?, "
                    + "clave_interbancaria = ?, "
                    + "direccion = ?, "
                    + "fecha_nacimiento = ?, "
                    + "lugar_nacimiento = ?, " //15
                    + "sexo = ?, "
                    + "estado_civil = ?, "
                    + "no_cedula = ?, "
                    + "vacuna_covid = ?, "
                    + "puesto = ?, " //20
                    + "departamento = ?, "
                    + "credito_infonavit = ?, "
                    + "nombre_beneficiario = ?, "
                    + "telefono_beneficiario = ?, "
                    + "parentesco_beneficiario = ?, " //25
                    + "estatus = ?, "
                    + "motivo_baja = ?, "
                    + "recomendable = ?, "
                    + "motivo = ?, "
                    + "tipo = ?, " //30
                    + "fecha_alta_imss = ?, "
                    + "fecha_inicio = ?, "
                    + "fecha_baja = ?, "
                    + "sueldo = ?"
                    + "WHERE id_empleado = ?";

            try {
                st = connection.getConectarDB().prepareStatement(consultaActualizar);
                st.setDate(1, Date.valueOf(lblCurrentDate.getText()));
                st.setString(2, panelEmpleado.getTxtName());
                st.setString(3, panelEmpleado.getTxtLastName());
                st.setString(4, panelEmpleado.getTxtUnit());
                st.setString(5, panelEmpleado.getTxtPhone());
                st.setString(6, panelEmpleado.getTxtEmail());
                st.setString(7, panelEmpleado.getTxtNSS());
                st.setString(8, panelEmpleado.getTxtCurp());
                st.setString(9, panelEmpleado.getTxtRFC());
                st.setString(10, panelEmpleado.getTxtBroxel());
                st.setString(11, panelEmpleado.getTxtBank());
                if (panelEmpleado.getTxtClaveInter().trim().equals("")) {
                    st.setString(12, "0");
                } else {
                    st.setString(12, panelEmpleado.getTxtClaveInter());
                }
                st.setString(13, panelEmpleado.getTxtDirection());
                st.setDate(14, new java.sql.Date(panelEmpleado.getCalBirthdayDate().getTime()));
                st.setString(15, panelEmpleado.getTxtBornPlace());
                st.setString(16, panelEmpleado.getCboxSexSelectedItem());
                st.setString(17, panelEmpleado.getCboxCivilStateSelectedItem());
                st.setString(18, panelEmpleado.getTxtCedula());
                if (panelEmpleado.isChkVaccinatedChecked()) {
                    st.setString(19, "VACUNADO");
                } else {
                    st.setString(19, "REGISTRADO");
                }
                st.setString(20, panelEmpleado.getTxtPosition());
                st.setString(21, panelEmpleado.getTxtDepartment());
                st.setString(22, panelEmpleado.getTxtCreditI());
                st.setString(23, panelEmpleado.getTxtBeneficiaryName());
                st.setString(24, panelEmpleado.getTxtBeneficiaryPhone());
                st.setString(25, panelEmpleado.getTxtBeneficiaryRelation());
                if (panelEmpleado.isRbtnActiveSelected()) {
                    st.setString(26, "ACTIVO");
                } else {
                    st.setString(26, "INACTIVO");
                }
                st.setString(27, panelEmpleado.getTxtReasons());
                st.setInt(28, panelEmpleado.getSliderRecommended());
                st.setString(29, panelEmpleado.getTxtComentaries());
                if (panelEmpleado.isRbtnEntrySelected()) {
                    st.setString(30, "ALTA");
                } else {
                    st.setString(30, "REINGRESO");
                }
                st.setDate(31, new java.sql.Date(panelEmpleado.getCalRegisterIMSSDate().getTime()));
                st.setDate(32, new java.sql.Date(panelEmpleado.getCaldStartDate().getTime()));
                st.setDate(33, new java.sql.Date(panelEmpleado.getCaldFinishDate().getTime()));
                st.setDouble(34, panelEmpleado.getTxtSalary());
                st.setInt(35, idEmpleado);

                if (st.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(rootPane, "Se actualizó el empleado con éxito");
                    //Cerrar pestaña
                    FrameTablaEmpleados info = new FrameTablaEmpleados(idUser);
                    info.show();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se actualizó el empleado");
                }
            } catch (HeadlessException | NumberFormatException | SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    private void loadData() {
        PreparedStatement st;
        ResultSet rs;
        String consultaSeleccionar = "SELECT * FROM employease where id_empleado = " + this.idEmpleado;
        lblCurrentDate.setText(LocalDate.now().toString()); //Current date
        try {
            st = connection.getConectarDB().prepareStatement(consultaSeleccionar);
            rs = st.executeQuery();
            rs.next();
            int id = rs.getInt("id_empleado");
            panelEmpleado.setTxtBank(rs.getString("banco"));
            panelEmpleado.setTxtBeneficiaryName(rs.getString("nombre_beneficiario"));
            panelEmpleado.setTxtBeneficiaryPhone(rs.getString("telefono_beneficiario"));
            panelEmpleado.setTxtBeneficiaryRelation(rs.getString("parentesco_beneficiario"));
            panelEmpleado.setTxtBornPlace(rs.getString("lugar_nacimiento"));
            panelEmpleado.setTxtBroxel(rs.getString("broxel"));
            panelEmpleado.setTxtCedula(rs.getString("no_cedula"));
            panelEmpleado.setTxtClaveInter(rs.getString("clave_interbancaria"));
            panelEmpleado.setTxtCreditI(rs.getString("credito_infonavit"));
            panelEmpleado.setTxtCurp(rs.getString("curp"));
            panelEmpleado.setTxtDepartment(rs.getString("departamento"));
            panelEmpleado.setTxtDirection(rs.getString("direccion"));
            panelEmpleado.setTxtEmail(rs.getString("correo"));
            panelEmpleado.setTxtLastName(rs.getString("apellido"));
            panelEmpleado.setTxtNSS(rs.getString("nss"));
            panelEmpleado.setTxtName(rs.getString("nombre"));
            panelEmpleado.setTxtPhone(rs.getString("telefono"));
            panelEmpleado.setTxtPosition(rs.getString("puesto"));
            panelEmpleado.setTxtRFC(rs.getString("rfc"));
            panelEmpleado.setTxtReasons(rs.getString("motivo_baja"));
            panelEmpleado.setTxtUnit(rs.getString("unidad"));
            panelEmpleado.setTxtComentaries(rs.getString("motivo"));
            panelEmpleado.setSliderRecommended(rs.getInt("recomendable"));
            panelEmpleado.setRbtnActiveSelected(rs.getString("estatus").equals("ACTIVO"));
            panelEmpleado.setRbtnInactiveSelected(rs.getString("estatus").equals("INACTIVO"));
            panelEmpleado.setCboxSexSelectedItem(rs.getString("sexo"));
            panelEmpleado.setRbtnEntrySelected(rs.getString("tipo").equals("ALTA"));
            panelEmpleado.setRbtnReinstatedSelected(rs.getString("tipo").equals("REINGRESO"));
            panelEmpleado.setCboxCivilStateSelectedItem(rs.getString("estado_civil"));
            panelEmpleado.setChkVaccinatedChecked(rs.getString("vacuna_covid").equals("VACUNADO"));
            panelEmpleado.setCalBirthdayDate(rs.getDate("fecha_nacimiento"));
            panelEmpleado.setCalRegisterIMSSDate(rs.getDate("fecha_alta_imss"));
            panelEmpleado.setCaldFinishDate(rs.getDate("fecha_baja"));
            panelEmpleado.setCaldStartDate(rs.getDate("fecha_inicio"));
            panelEmpleado.setTxtSalary(rs.getDouble("sueldo"));
            lblID.setText(String.valueOf(id));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrameEditarEmpleado().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.ButtonGroup btnGroupEstatus;
    private javax.swing.ButtonGroup btnGroupSexos;
    private javax.swing.ButtonGroup btnGroupTipo;
    private javax.swing.JMenuItem itemRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private java.awt.Label label1;
    private javax.swing.JLabel lblCurrentDate;
    private javax.swing.JLabel lblID;
    private employeasepkg.PanelEditarEmpleado panelEmpleado;
    // End of variables declaration//GEN-END:variables
}
