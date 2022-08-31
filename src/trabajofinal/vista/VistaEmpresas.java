
package trabajofinal.vista;

import java.awt.event.ActionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import trabajofinal.modelo.Ciudad;
import trabajofinal.modelo.Contenedor;


public class VistaEmpresas extends Vista {
    
    private Contenedor contenedor;

    public VistaEmpresas(Contenedor contenedor) {
        super(contenedor);
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        for(Ciudad ci: contenedor.getCiudades())
            jComboBox.addItem(ci.getNombre());
    }

    public void cargarDatos(){
        String titulo[] = {"Oficinas","Direccion","Telefono"};
        String registro[] = new String[3];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = new DefaultTableModel(null,titulo);
        String ciudades = "";
        //ciudades = contenedor.getEmpresas().stream().map((ciu) -> ciu.getNombre()).reduce(ciudades, String::concat);
        registro[0] = ciudades;
        registro[1] = this.getInputDireccionEmpresa().toUpperCase();
        registro[2] = this.getInputTelefonoEmpresa().toUpperCase();
        modelo.addRow(registro);
        this.tablaDatonEmpresa.setModel(modelo);
    }


    @Override
    public void setTableListeners(TableModelListener controlador) {
        this.tablaDatonEmpresa.getModel().addTableModelListener(controlador);
        //super.setTableListeners(controlador); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setActionListeners(ActionListener controlador) {
        this.botonRegistrarEmpresa.addActionListener(controlador);
        this.botonActualizarEmpresa.addActionListener(controlador);
        this.botonEliminarEmpresa.addActionListener(controlador);
        this.jButtonAgregar.addActionListener(controlador);
        this.jButtonAgregar.addActionListener(controlador);
        this.jButtonGuardarCambios.addActionListener(controlador);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatonEmpresa = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        icono = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelOficinas = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        jButtonAgregar = new javax.swing.JButton();
        labelDireccionEmpresa = new javax.swing.JLabel();
        labelTelefonoEmpresa = new javax.swing.JLabel();
        inputDireccionEmpresa = new javax.swing.JTextField();
        inputTelefonoEmpresa = new javax.swing.JTextField();
        jButtonGuardarCambios = new javax.swing.JButton();
        jPanelActualizar = new javax.swing.JPanel();
        botonRegistrarEmpresa = new javax.swing.JButton();
        botonActualizarEmpresa = new javax.swing.JButton();
        botonEliminarEmpresa = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Empresas");

        tablaDatonEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Oficinas", "Direccion", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(tablaDatonEmpresa);

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        jLabel4.setText("Registro De Empresa");

        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/empresa.jpg"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingreso"));

        labelOficinas.setText("Oficinas:");

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar:" }));

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.setPreferredSize(new java.awt.Dimension(83, 20));
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        labelDireccionEmpresa.setText("Dirección:");

        labelTelefonoEmpresa.setText("Teléfono:");

        jButtonGuardarCambios.setText("Guardar Cambios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonGuardarCambios)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDireccionEmpresa)
                                    .addComponent(labelOficinas))
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(labelTelefonoEmpresa)
                                .addGap(52, 52, 52)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(inputTelefonoEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(inputDireccionEmpresa))
                        .addGap(77, 77, 77))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelOficinas)
                    .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDireccionEmpresa)
                    .addComponent(inputDireccionEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefonoEmpresa)
                    .addComponent(inputTelefonoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButtonGuardarCambios)
                .addGap(21, 21, 21))
        );

        jPanelActualizar.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        botonRegistrarEmpresa.setText("Registrar");
        botonRegistrarEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonActualizarEmpresa.setText("Actualizar");
        botonActualizarEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonEliminarEmpresa.setText("Eliminar");
        botonEliminarEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButtonRegresar.setText("Regresar");
        jButtonRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelActualizarLayout = new javax.swing.GroupLayout(jPanelActualizar);
        jPanelActualizar.setLayout(jPanelActualizarLayout);
        jPanelActualizarLayout.setHorizontalGroup(
            jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActualizarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonRegistrarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonActualizarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonEliminarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelActualizarLayout.setVerticalGroup(
            jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActualizarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrarEmpresa)
                    .addComponent(botonActualizarEmpresa)
                    .addComponent(botonEliminarEmpresa)
                    .addComponent(jButtonRegresar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jPanelActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(235, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 29, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(icono, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    public String getInputDireccionEmpresa(){
        return inputDireccionEmpresa.getText();
    }
    
    public String getInputTelefonoEmpresa(){
        return inputTelefonoEmpresa.getText();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarEmpresa;
    private javax.swing.JButton botonEliminarEmpresa;
    private javax.swing.JButton botonRegistrarEmpresa;
    private javax.swing.JLabel icono;
    public javax.swing.JTextField inputDireccionEmpresa;
    public javax.swing.JTextField inputTelefonoEmpresa;
    public javax.swing.JButton jButtonAgregar;
    public javax.swing.JButton jButtonGuardarCambios;
    public javax.swing.JButton jButtonRegresar;
    public javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanelActualizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDireccionEmpresa;
    private javax.swing.JLabel labelOficinas;
    private javax.swing.JLabel labelTelefonoEmpresa;
    public javax.swing.JTable tablaDatonEmpresa;
    // End of variables declaration//GEN-END:variables

}
