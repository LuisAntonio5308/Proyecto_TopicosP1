/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author lo397
 */
public class jfrmSalidas extends javax.swing.JFrame {
    ControladorSalidas controlador;
    Salidas salida1 = new Salidas();
    Socio socio1 = new Socio();
    Barco barco1 = new Barco();
    int IdSalida;

    /**
     * Creates new form jfrmSalidas
     */
    public jfrmSalidas() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controlador = new ControladorSalidas();
        TableSalidas.setModel(this.controlador.salidas());
        seleccionarSalida();
        fillBarco();
        fillSocio();
    }
    
    public void fillBarco(){
        ConexionBarco b = new ConexionBarco();
        Barco barco = new Barco();
        barco = null;
        Barco[] a = b.ConsultarBarco(barco);
        if (a != null) {
            for (Barco alu : a) {
               cmbBarco.addItem(alu.getNombre());
            }
        }
    }
    
    public void fillSocio(){
        Conexion b = new Conexion();
        Socio socio = new Socio();
        socio = null;
        Socio[] a = b.ConsultarSocio(socio);
        if (a != null) {
            for (Socio alu : a) {
               cmbSocio.addItem(alu.getNombre());
            }
        }
    }
    public void seleccionarSalida(){
    TableSalidas.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent Mouse_evt) {
            //To change body of generated methods, choose Tools | Templates.
            if (Mouse_evt.getClickCount() == 1) {
                txtIdSalida.setText(TableSalidas.getValueAt(TableSalidas.getSelectedRow(), 0).toString());
                txtFecha.setText(TableSalidas.getValueAt(TableSalidas.getSelectedRow(), 1).toString());
                txtHoraSalida.setText(TableSalidas.getValueAt(TableSalidas.getSelectedRow(), 2).toString());
                txtDestino.setText(TableSalidas.getValueAt(TableSalidas.getSelectedRow(), 3).toString());
                TableSalidas.getValueAt(TableSalidas.getSelectedRow(), 4).toString();
                TableSalidas.getValueAt(TableSalidas.getSelectedRow(), 5).toString();
                
            }
        
        }
        
    });
}
    
    //Conocer el Ultimo ID del Ultimo Registro
    public int idSalida(){
    return IdSalida = this.controlador.IdSalida(salida1);
    }
        
private void insertarSalida(){

    try {
        
        String fecha = txtFecha.getText();
        String horaSalida = txtHoraSalida.getText();
        String destino = txtDestino.getText();
        String nomSocio = cmbSocio.getSelectedItem().toString();
        String nomBarco = cmbBarco.getSelectedItem().toString();
        
        IdSalida = this.idSalida();
        
        boolean insertado = this.controlador.insertarSalida(IdSalida++, fecha, horaSalida, destino, nomSocio, nomBarco);
        
        if (insertado == true) {
            JOptionPane.showMessageDialog(null, "Datos Guardados");
            this.cancelar();
            TableSalidas.setModel(this.controlador.salidas());
        }else{
            JOptionPane.showMessageDialog(null, "Algo fallo al Insertar");
        }
        
    } catch (NumberFormatException | HeadlessException e) {
        JOptionPane.showMessageDialog(null, "Falla");
        
    }
        }


private void actualizarSalida(){
    String fecha = txtFecha.getText();
        String horaSalida = txtHoraSalida.getText();
        String destino = txtDestino.getText();
        String nomSocio = cmbSocio.getSelectedItem().toString();
        String nomBarco = cmbBarco.getSelectedItem().toString();
        
        int id = Integer.parseInt(txtIdSalida.getText());
    
    boolean actualizar = this.controlador.actualizarSalida(id, fecha, horaSalida, destino, nomSocio, nomBarco);
    
    if (actualizar == true) {
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            this.cancelar();
            TableSalidas.setModel(this.controlador.salidas());
        }else{
            JOptionPane.showMessageDialog(null, "Algo fallo al Actualizar");
        }
    
    
}

private void eliminarSalida(){
    try {
        
        String fecha = txtFecha.getText();
        String horaSalida = txtHoraSalida.getText();
        String destino = txtDestino.getText();
        //String nomSocio = cmbSocio.getSelectedItem().toString();
        //String nomBarco = cmbBarco.getSelectedItem().toString();
        
        int id = Integer.parseInt(txtIdSalida.getText());
        
    boolean eliminado = this.controlador.eliminarSalida(id, fecha, horaSalida, destino, null, null);
    
        if (eliminado==true) {
            JOptionPane.showMessageDialog(null, "Datos Eliminados");
            this.cancelar();
            TableSalidas.setModel(this.controlador.salidas());
        }else{
        JOptionPane.showMessageDialog(null, "Algo fallo al eliminar");
        }
        
    } catch (NumberFormatException | HeadlessException e) {
        JOptionPane.showMessageDialog(null, "El valor introducido no es un numero");
        
    }
}

private void cancelar(){
    txtFecha.setText("");
    txtHoraSalida.setText("");
    txtDestino.setText("");
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableSalidas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtIdSalida = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHoraSalida = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();
        cmbSocio = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbBarco = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnSocio = new javax.swing.JButton();
        btnBarco = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TableSalidas);

        jLabel1.setText("SALIDAS");

        txtIdSalida.setEditable(false);

        jLabel2.setText("Id_Salida");

        jLabel3.setText("Fecha:");

        jLabel4.setText("HoraSalida:");

        jLabel5.setText("Destino:");

        jLabel6.setText("Nombre Socio:");

        jLabel7.setText("Nombre Barco:");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnSocio.setText("Socios");
        btnSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSocioActionPerformed(evt);
            }
        });

        btnBarco.setText("Barcos");
        btnBarco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarcoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFecha)
                                .addComponent(txtHoraSalida)
                                .addComponent(txtDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                            .addComponent(jButton1))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jButton2))
                        .addGap(2, 2, 2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbSocio, 0, 69, Short.MAX_VALUE)
                            .addComponent(cmbBarco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBarco, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(btnSocio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbBarco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btnSocio)
                        .addGap(18, 18, 18)
                        .addComponent(btnBarco)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.insertarSalida();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.actualizarSalida();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.eliminarSalida();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSocioActionPerformed
        // TODO add your handling code here:
        NewJFrame v = new NewJFrame();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSocioActionPerformed

    private void btnBarcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarcoActionPerformed
        // TODO add your handling code here:
        Barcos v = new Barcos();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBarcoActionPerformed

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
            java.util.logging.Logger.getLogger(jfrmSalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmSalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmSalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmSalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrmSalidas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableSalidas;
    private javax.swing.JButton btnBarco;
    private javax.swing.JButton btnSocio;
    private javax.swing.JComboBox<String> cmbBarco;
    private javax.swing.JComboBox<String> cmbSocio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHoraSalida;
    private javax.swing.JTextField txtIdSalida;
    // End of variables declaration//GEN-END:variables
}
