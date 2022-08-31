/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.vista;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import trabajofinal.modelo.Contenedor;

/**
 *
 * @author Usuario
 */
public class VistaCaracteristicasEspeciales extends Vista {

    public VistaCaracteristicasEspeciales(Contenedor contenedor) {
        super(contenedor);
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.cargarDatosCaracteristicasEspeciales();        
        setVisible(true);
        
    }

    public void cargarDatosCaracteristicasEspeciales(){
        DefaultTableModel modeloCaracteristicasEspeciales = (DefaultTableModel) this.tablaCaracteristicasEspeciales.getModel();
        int filascont = modeloCaracteristicasEspeciales.getRowCount();
        for(int i=filascont-1;i>=0;i--){
            modeloCaracteristicasEspeciales.removeRow(i);
        }
        
        this.contenedor.getCaracteristicasEspeciales().forEach(CaracteristicasEspeciales ->{
            Object[] fila = new Object[2];
            fila[0]=CaracteristicasEspeciales.getNombre();
            fila[1]=CaracteristicasEspeciales.getDescripcion();
            modeloCaracteristicasEspeciales.addRow(fila);
        });
        this.tablaCaracteristicasEspeciales.setModel(modeloCaracteristicasEspeciales);
    }
    @Override
    public void setTableListeners(TableModelListener controlador) {
        this.tablaCaracteristicasEspeciales.getModel().addTableModelListener(controlador);
        //super.setTableListeners(controlador); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setActionListeners(ActionListener controlador) {
        this.botonRegistrarCaracteristicaEspecial.addActionListener(controlador);
        this.botonActualizarCaracteristicaEspecial.addActionListener(controlador);
        this.botonEliminarCaracteristicaEspecial.addActionListener(controlador);
        this.jButtonSalir.addActionListener(controlador);
        this.jButtonGuardarCambios.addActionListener(controlador);
        //super.setActionListeners(controlador); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCaracteristicasEspeciales = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelActualizar = new javax.swing.JPanel();
        jButtonSalir = new javax.swing.JButton();
        botonEliminarCaracteristicaEspecial = new javax.swing.JButton();
        botonActualizarCaracteristicaEspecial = new javax.swing.JButton();
        botonRegistrarCaracteristicaEspecial = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        inputNombreCaracteristicaEspecial = new javax.swing.JTextField();
        labelNombreCaracteristicaEspecial = new javax.swing.JLabel();
        labelDescripcionCaracteristicaEspecial = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputDescripcionCaracteristicaEspecial = new javax.swing.JTextArea();
        jButtonGuardarCambios = new javax.swing.JButton();
        icono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Características Especiales");

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        jLabel1.setText("Caracteristicas Especiales");

        tablaCaracteristicasEspeciales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Caracteristica", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaCaracteristicasEspeciales);

        jButtonSalir.setText("Regresar");
        jButtonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonEliminarCaracteristicaEspecial.setText("Eliminar");
        botonEliminarCaracteristicaEspecial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonActualizarCaracteristicaEspecial.setText("Actualizar");
        botonActualizarCaracteristicaEspecial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonRegistrarCaracteristicaEspecial.setText("Registrar");
        botonRegistrarCaracteristicaEspecial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanelActualizarLayout = new javax.swing.GroupLayout(jPanelActualizar);
        jPanelActualizar.setLayout(jPanelActualizarLayout);
        jPanelActualizarLayout.setHorizontalGroup(
            jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelActualizarLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(botonRegistrarCaracteristicaEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(botonActualizarCaracteristicaEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(botonEliminarCaracteristicaEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelActualizarLayout.setVerticalGroup(
            jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelActualizarLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrarCaracteristicaEspecial)
                    .addComponent(botonActualizarCaracteristicaEspecial)
                    .addComponent(botonEliminarCaracteristicaEspecial)
                    .addComponent(jButtonSalir))
                .addGap(10, 10, 10))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingreso"));

        inputNombreCaracteristicaEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputNombreCaracteristicaEspecialKeyTyped(evt);
            }
        });

        labelNombreCaracteristicaEspecial.setText("Nombre:");

        labelDescripcionCaracteristicaEspecial.setText("Descripcion:");

        inputDescripcionCaracteristicaEspecial.setColumns(20);
        inputDescripcionCaracteristicaEspecial.setRows(5);
        jScrollPane2.setViewportView(inputDescripcionCaracteristicaEspecial);

        jButtonGuardarCambios.setText("Guardar Cambios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonGuardarCambios)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNombreCaracteristicaEspecial)
                            .addComponent(labelDescripcionCaracteristicaEspecial))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputNombreCaracteristicaEspecial)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreCaracteristicaEspecial)
                    .addComponent(inputNombreCaracteristicaEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescripcionCaracteristicaEspecial)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jButtonGuardarCambios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/Caracteristicas.jpg"))); // NOI18N
        icono.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(261, 261, 261)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanelActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jPanelActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(icono)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inputNombreCaracteristicaEspecialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNombreCaracteristicaEspecialKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane,"Ingresar solo Letras");
        }
    }//GEN-LAST:event_inputNombreCaracteristicaEspecialKeyTyped

    public String getInputNombreCaracteristicasEspecial(){
        return inputNombreCaracteristicaEspecial.getText();
    }
    public String getInputDescripcionCaracteristicasEspecial(){
        return inputDescripcionCaracteristicaEspecial.getText();
    }
    
    public void setInputDescriptionText(String text) {
        this.inputDescripcionCaracteristicaEspecial.setText(text);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonActualizarCaracteristicaEspecial;
    public javax.swing.JButton botonEliminarCaracteristicaEspecial;
    public javax.swing.JButton botonRegistrarCaracteristicaEspecial;
    private javax.swing.JLabel icono;
    private javax.swing.JTextArea inputDescripcionCaracteristicaEspecial;
    public javax.swing.JTextField inputNombreCaracteristicaEspecial;
    public javax.swing.JButton jButtonGuardarCambios;
    public javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanelActualizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelDescripcionCaracteristicaEspecial;
    private javax.swing.JLabel labelNombreCaracteristicaEspecial;
    public javax.swing.JTable tablaCaracteristicasEspeciales;
    // End of variables declaration//GEN-END:variables

}
