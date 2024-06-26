package employeasepkg;

import java.awt.Color;
import java.awt.HeadlessException;;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JOptionPane;

public class FrameAgregarEmpleado extends javax.swing.JFrame {

    ConexionSQL connection = new ConexionSQL();
    int idUser;
    
    public FrameAgregarEmpleado() {
        initComponents();
        loadData();
    }

    public FrameAgregarEmpleado(int idUser) {
        initComponents();
        getContentPane().setBackground(new Color(0x6cb4d4));
        loadData();
        this.idUser = idUser;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblID = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCurrentDate = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        panelEmpleado = new employeasepkg.PanelEditarEmpleado();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblID.setText("0");

        btnAdd.setText("Agregar registro");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+10));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar nuevo empleado");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Campos con * son obligatorios");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("N° de empleado:");

        lblCurrentDate.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblCurrentDate.setText("0");

        jLabel30.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel30.setText("Fecha de registro:");

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LEFT, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return.png"))); // NOI18N
        jMenuItem1.setText("Regresar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemRegresarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(lblCurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblID)
                    .addComponent(jLabel30)
                    .addComponent(lblCurrentDate)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addRegister();
    }//GEN-LAST:event_btnAddActionPerformed

    private void mItemRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemRegresarActionPerformed
        FrameTablaEmpleados info = new FrameTablaEmpleados(idUser);
        info.show();
        this.dispose();
    }//GEN-LAST:event_mItemRegresarActionPerformed

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

    private void addRegister() {
        PreparedStatement st;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fNacimiento = sdf.format(panelEmpleado.getCalBirthdayDate());
        String fInicio = sdf.format(panelEmpleado.getCalBirthdayDate());
        String fFin = sdf.format(panelEmpleado.getCalBirthdayDate());
        String fAltaIMSS = sdf.format(panelEmpleado.getCalRegisterIMSSDate());
        String fActual = lblCurrentDate.getText();
        String nombre = panelEmpleado.getTxtName();
        String apellido = panelEmpleado.getTxtLastName();
        String unidad = panelEmpleado.getTxtUnit();
        String telefono = panelEmpleado.getTxtPhone();
        String email = panelEmpleado.getTxtEmail();
        String nss = panelEmpleado.getTxtNSS();
        String curp = panelEmpleado.getTxtCurp();
        String rfc = panelEmpleado.getTxtRFC();
        String broxel = panelEmpleado.getTxtBroxel();
        String clave = panelEmpleado.getTxtClaveInter();
        String direccion = panelEmpleado.getTxtDirection();
        String edoCivil = panelEmpleado.getCboxCivilStateSelectedItem();
        String cedula = panelEmpleado.getTxtCedula();
        String puesto = panelEmpleado.getTxtPosition();
        String departamento = panelEmpleado.getTxtDepartment();
        String credito = panelEmpleado.getTxtCreditI();
        String banco = panelEmpleado.getTxtBank();
        String bNombre = panelEmpleado.getTxtBeneficiaryName();
        String bTelefono = panelEmpleado.getTxtBeneficiaryPhone();
        String bParentesco = panelEmpleado.getTxtBeneficiaryRelation();
        String lNacimiento = panelEmpleado.getTxtBornPlace();
        String razones = panelEmpleado.getTxtReasons();
        String comentarios = panelEmpleado.getTxtComentaries();
        String sexo = panelEmpleado.getCboxSexSelectedItem();
        String vacunado = (panelEmpleado.isChkVaccinatedChecked()) ? "VACUNADO" : "REGISTRADO";
        String estatus = (panelEmpleado.isRbtnActiveSelected()) ? "ACTIVO" : "INACTIVO";
        String recomendable = String.valueOf(panelEmpleado.getSliderRecommended());
        String tipo = (panelEmpleado.isRbtnEntrySelected()) ? "ALTA" : "REINGRESO";
        Double sueldo = (panelEmpleado.getTxtSalary());

        if (verifyFields()) {
            String query = "INSERT INTO `employease`(`fecha_ingreso`, `nombre`, `apellido`, `unidad`, "
                    + "`telefono`, `correo`, `nss`, `curp`, `rfc`, `broxel`, `banco`, `clave_interbancaria`, `direccion`, `fecha_nacimiento`, "
                    + "`lugar_nacimiento`, `sexo`, `estado_civil`, `no_cedula`, `vacuna_covid`, `puesto`, `departamento`, `credito_infonavit`, "
                    + "`nombre_beneficiario`, `telefono_beneficiario`, `parentesco_beneficiario`, `estatus`, `motivo_baja`, `recomendable`, "
                    + "`motivo`, `tipo`, `fecha_alta_imss`, `fecha_inicio`, `fecha_baja`, `sueldo` ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            try {
                st = connection.getConectarDB().prepareStatement(query);
                st.setDate(1, Date.valueOf(fActual));
                st.setString(2, nombre);
                st.setString(3, apellido);
                st.setString(4, unidad);
                st.setString(5, telefono);
                st.setString(6, email);
                st.setString(7, nss);
                st.setString(8, curp);
                st.setString(9, rfc);
                st.setString(10, broxel);
                st.setString(11, banco);
                if (clave.trim().equals("")) {
                    st.setString(12, "0");
                } else {
                    st.setString(12, clave);
                }
                st.setString(13, direccion);
                st.setDate(14, Date.valueOf(fNacimiento));
                st.setString(15, lNacimiento);
                st.setString(16, sexo);
                st.setString(17, edoCivil);
                st.setString(18, cedula);
                st.setString(19, vacunado);
                st.setString(20, puesto);
                st.setString(21, departamento);
                st.setString(22, credito);
                st.setString(23, bNombre);
                st.setString(24, bTelefono);
                st.setString(25, bParentesco);
                st.setString(26, estatus);
                st.setString(27, razones);
                st.setString(28, recomendable);
                st.setString(29, comentarios);
                st.setString(30, tipo);
                st.setDate(31, Date.valueOf(fAltaIMSS));
                st.setDate(32, Date.valueOf(fInicio));
                st.setDate(33, Date.valueOf(fFin));
                st.setDouble(34, sueldo);

                if (st.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(rootPane, "Se añadió el empleado con éxito");
                    //Cerrar pestaña
                    FrameTablaEmpleados info = new FrameTablaEmpleados(idUser);
                    info.show();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Error al añadir el empleado");
                }
            } catch (HeadlessException | NumberFormatException | SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    private void loadData() {
        lblCurrentDate.setText(LocalDate.now().toString());
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT MAX(id_empleado) FROM `employease`";
        
        try 
        {
            st = connection.getConectarDB().prepareStatement(query);
            rs = st.executeQuery();
            
            if(rs.next())
            {
                int id = rs.getInt(1);
                lblID.setText(String.valueOf(id + 1)); //Next ID
            }
            
            lblCurrentDate.setText(LocalDate.now().toString()); //Current date
        } 
        catch (Exception e) 
        {
            System.out.println(e.toString());
        }
        
        //NO MOVER
        //not null dates
        panelEmpleado.setCaldStartDate(Date.valueOf(LocalDate.of(0, Month.JANUARY, 1)));
        panelEmpleado.setCaldFinishDate(Date.valueOf(LocalDate.of(0, Month.JANUARY, 1)));
        panelEmpleado.setCalRegisterIMSSDate(Date.valueOf(LocalDate.of(0, Month.JANUARY, 1)));
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameAgregarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrameAgregarEmpleado().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblCurrentDate;
    private javax.swing.JLabel lblID;
    private employeasepkg.PanelEditarEmpleado panelEmpleado;
    // End of variables declaration//GEN-END:variables
}
