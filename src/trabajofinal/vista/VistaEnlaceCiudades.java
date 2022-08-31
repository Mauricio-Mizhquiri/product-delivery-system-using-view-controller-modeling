
package trabajofinal.vista;

import java.awt.event.ActionListener;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.TableModelListener;
import trabajofinal.modelo.Ciudad;
import trabajofinal.modelo.Contenedor;

public class VistaEnlaceCiudades extends Vista {
    public VistaEnlaceCiudades(Contenedor contenedor) {
        super(contenedor);
        //validacion
        
        initComponents();
        SpinnerNumberModel model = new SpinnerNumberModel();
        model.setMaximum(10000);
        model.setMinimum(0);
        jSpinnerTiempoViaje.setModel(model);
        llenarCombobox();
        setLocationRelativeTo(null);
        jTextArea1.append("Ciudad: \tCiudad Enlazada"+"\tTiempo\n");
        
    }
    public void llenarCombobox(){
        for(Ciudad ciudad: contenedor.getCiudades()){
            jComboBoxCiudades.addItem(ciudad.getNombre());
            jComboBox.addItem(ciudad.getNombre());
        }
    }
    @Override
    public void setTableListeners(TableModelListener controlador) {
        super.setTableListeners(controlador); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setActionListeners(ActionListener controlador) {
        super.setActionListeners(controlador); //To change body of generated methods, choose Tools | Templates.
        this.jButtonAgregarEnlace.addActionListener(controlador);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBoxCiudades = new javax.swing.JComboBox<>();
        jSpinnerTiempoViaje = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jButtonAgregarEnlace = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ciudades Disponibles");
        setMinimumSize(new java.awt.Dimension(600, 310));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        jLabel1.setText("Enlace De Ciudades");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jButton1.setText("Aceptar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, -1, -1));

        jComboBoxCiudades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar:" }));
        jComboBoxCiudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCiudadesActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxCiudades, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 100, -1));
        getContentPane().add(jSpinnerTiempoViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 60, 20));

        jLabel3.setText("Tiempo de Viaje:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 20));

        jButtonAgregarEnlace.setText("Agregar");
        jButtonAgregarEnlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarEnlaceActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregarEnlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 380, 150));

        jLabel4.setText("Ciudades Enlazadas:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar:" }));
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 110, -1));

        jLabel2.setText("Ciudades:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel5.setText("Ciudades a Enlazar:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxCiudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCiudadesActionPerformed
        
    }//GEN-LAST:event_jComboBoxCiudadesActionPerformed

    private void jButtonAgregarEnlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarEnlaceActionPerformed
        jSpinnerTiempoViaje.setValue(((SpinnerNumberModel)jSpinnerTiempoViaje.getModel()).getMinimum());
        jComboBoxCiudades.setSelectedIndex(0);
        
    }//GEN-LAST:event_jButtonAgregarEnlaceActionPerformed

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButtonAgregarEnlace;
    public javax.swing.JComboBox<String> jComboBox;
    public javax.swing.JComboBox<String> jComboBoxCiudades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JSpinner jSpinnerTiempoViaje;
    public javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
