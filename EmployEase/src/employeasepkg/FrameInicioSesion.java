package employeasepkg;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FrameInicioSesion extends javax.swing.JFrame {

    ConexionSQL connection = new ConexionSQL();

    public FrameInicioSesion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        lblCampoObligatorio = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuClaro = new javax.swing.JMenuItem();
        jMenuOscuro = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+6));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Inicio de Sesión");

        txtUserName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtUserName.setName("txtUserName"); // NOI18N
        txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserNameFocusLost(evt);
            }
        });
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserNameKeyPressed(evt);
            }
        });

        jButton2.setText("Iniciar Sesión");
        jButton2.setName("btnStartSesion"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartSesionActionPerformed(evt);
            }
        });

        txtPassword.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtPassword.setName("txtPassword"); // NOI18N
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        jLabel2.setText("Contraseña");

        jLabel3.setText("Nombre de usuario");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("He olvidado mi contraseña");
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setName("btnStartSesion"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3btnStartSesionActionPerformed(evt);
            }
        });

        lblCampoObligatorio.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        lblCampoObligatorio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setBorderPainted(false);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Apariencia");

        jMenuClaro.setText("Modo claro");
        jMenuClaro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuClaroActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuClaro);

        jMenuOscuro.setText("Modo oscuro");
        jMenuOscuro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOscuroActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuOscuro);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCampoObligatorio))
                            .addComponent(jLabel2)
                            .addComponent(txtUserName)
                            .addComponent(txtPassword)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCampoObligatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton3)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int opc = JOptionPane.showConfirmDialog(null, "Seguro que quieres salir?", "Opciones", JOptionPane.YES_NO_OPTION);
        if (opc == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnStartSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartSesionActionPerformed
        startSesion();
    }//GEN-LAST:event_btnStartSesionActionPerformed

    private void startSesion() {
        PreparedStatement st;
        ResultSet rs;

        String username = txtUserName.getText();
        String password = String.valueOf(txtPassword.getPassword());

        String query = "SELECT * FROM `empleados` WHERE `user` = ? AND `password` = ?";
        try {
            st = connection.getConectarDB().prepareStatement(query);

            st.setString(1, username);
            st.setString(2, password);
            rs = st.executeQuery();

            if (rs.next()) {
                FrameTablaEmpleados info = new FrameTablaEmpleados(rs.getInt("id_user"));
                info.show();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "La contraseña o el usuario son incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void jButton3btnStartSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3btnStartSesionActionPerformed
        FrameClaveOlvidada fpwd = new FrameClaveOlvidada();
        fpwd.show();
        this.dispose();
    }//GEN-LAST:event_jButton3btnStartSesionActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            startSesion();
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void jMenuClaroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuClaroActionPerformed
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatIntelliJLaf());
            java.awt.EventQueue.invokeLater(() -> {
                new FrameInicioSesion().setVisible(true);
            });
            this.dispose();
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error al inicializar tema claro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuClaroActionPerformed

    private void jMenuOscuroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOscuroActionPerformed
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarculaLaf());
            java.awt.EventQueue.invokeLater(() -> {
                new FrameInicioSesion().setVisible(true);
            });
            this.dispose();
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error al inicializar tema oscuro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuOscuroActionPerformed

    private void txtUserNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusLost
        if (((JTextField) evt.getSource()).getText().equals("")) {
            lblCampoObligatorio.setText("* Campo obligatorio");
        } else {
            lblCampoObligatorio.setText("");
        }
    }//GEN-LAST:event_txtUserNameFocusLost

    private void txtUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            startSesion();
    }//GEN-LAST:event_txtUserNameKeyPressed

    public static void main(String args[]) {
        /* Create and display the form */
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ez) {
                java.util.logging.Logger.getLogger(FrameAgregarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ez);
            }
        }
        java.awt.EventQueue.invokeLater(() -> {

            new FrameInicioSesion().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuClaro;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuOscuro;
    private javax.swing.JLabel lblCampoObligatorio;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
