
package trabajofinal.vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import trabajofinal.modelo.Ciudad;
import trabajofinal.modelo.Contenedor;

public class VistaClientes extends Vista {
    
    public VistaClientes(Contenedor contenedor) {
        super(contenedor);
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        llenarCombobox();
    }

    public void cargarDatosClientes(){
        DefaultTableModel modelo = (DefaultTableModel) this.tablaDatosClientes.getModel();
        int filasCont = modelo.getRowCount();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        this.contenedor.getClientes().forEach(cliente -> {
            Object[] fila = new Object[5];
            fila[0]=cliente.getNombre();
            fila[1]=cliente.getDireccion();
            fila[2]=cliente.getTelefono();
            fila[3]=cliente.getCorreo();
            
            String ciu = "";
            for(Ciudad ciudad: cliente.getCiudad()){
                ciu+= ciudad.getNombre()+"->";
            }
            fila[4] = ciu;
            modelo.addRow(fila);
        });
        this.tablaDatosClientes.setModel(modelo);
    }
    public void llenarCombobox(){
        for(Ciudad ciu: contenedor.getCiudades()){
            this.jComboBoxNegocios.addItem(ciu.getNombre());
        }
    }
        
    @Override
    public void setTableListeners(TableModelListener controlador) {
        this.tablaDatosClientes.getModel().addTableModelListener(controlador);
        //super.setTableListeners(controlador); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setActionListeners(ActionListener controlador) {
        this.botonRegistrarCliente.addActionListener(controlador);
        this.jButtonAgregar.addActionListener(controlador);
        this.botonActualizarCliente.addActionListener(controlador);
        this.botonEliminarCliente.addActionListener(controlador);
        this.jButtonRegresar.addActionListener(controlador);
        this.jButtonGuardarCambios.addActionListener(controlador);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        labelNombreProducto = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        inputNombreCliente = new javax.swing.JTextField();
        inputDireccionCliente = new javax.swing.JTextField();
        inputTelefonoCliente = new javax.swing.JTextField();
        inputCorreoCliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDatosClientes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jButtonGuardarCambios = new javax.swing.JButton();
        jPanelActualizar = new javax.swing.JPanel();
        jButtonRegresar = new javax.swing.JButton();
        botonRegistrarCliente = new javax.swing.JButton();
        botonActualizarCliente = new javax.swing.JButton();
        botonEliminarCliente = new javax.swing.JButton();
        labelNegocios = new javax.swing.JLabel();
        jComboBoxNegocios = new javax.swing.JComboBox<>();
        jButtonAgregar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Clientes");

        labelNombreProducto.setText("Nombre");

        labelDireccion.setText("Dirección");

        labelTelefono.setText("Teléfono");

        labelCorreo.setText("Correo Eletrónico");

        inputNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputNombreClienteKeyTyped(evt);
            }
        });

        inputTelefonoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputTelefonoClienteKeyTyped(evt);
            }
        });

        inputCorreoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputCorreoClienteKeyTyped(evt);
            }
        });

        tablaDatosClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Direccion", "Telefono", "Correo Eléctronico", "Visualizar"
            }
        ));
        jScrollPane2.setViewportView(tablaDatosClientes);

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        jLabel6.setText("Registro Clientes");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/Clientes.jpg"))); // NOI18N

        jButtonGuardarCambios.setText("Guardar Cambios");

        jButtonRegresar.setText("Regresar");
        jButtonRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonRegistrarCliente.setText("Registrar");
        botonRegistrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonActualizarCliente.setText("Actualizar");
        botonActualizarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonEliminarCliente.setText("Eliminar");
        botonEliminarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        labelNegocios.setText("Negocios");

        jComboBoxNegocios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar:" }));
        jComboBoxNegocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNegociosActionPerformed(evt);
            }
        });

        jButtonAgregar.setText("Agregar");

        javax.swing.GroupLayout jPanelActualizarLayout = new javax.swing.GroupLayout(jPanelActualizar);
        jPanelActualizar.setLayout(jPanelActualizarLayout);
        jPanelActualizarLayout.setHorizontalGroup(
            jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActualizarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelActualizarLayout.createSequentialGroup()
                        .addComponent(botonRegistrarCliente)
                        .addGap(132, 132, 132)
                        .addComponent(botonActualizarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonEliminarCliente)
                        .addGap(119, 119, 119)
                        .addComponent(jButtonRegresar)
                        .addGap(27, 27, 27))
                    .addGroup(jPanelActualizarLayout.createSequentialGroup()
                        .addComponent(labelNegocios)
                        .addGap(85, 85, 85)
                        .addComponent(jComboBoxNegocios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jButtonAgregar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelActualizarLayout.setVerticalGroup(
            jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelActualizarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNegocios)
                    .addComponent(jComboBoxNegocios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrarCliente)
                    .addComponent(botonActualizarCliente)
                    .addComponent(botonEliminarCliente)
                    .addComponent(jButtonRegresar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(288, 288, 288)
                                .addComponent(jLabel6))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelNombreProducto)
                                        .addComponent(labelDireccion)
                                        .addComponent(labelTelefono)
                                        .addComponent(labelCorreo))
                                    .addGap(85, 85, 85)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputNombreCliente)
                                        .addComponent(inputDireccionCliente)
                                        .addComponent(inputTelefonoCliente)
                                        .addComponent(inputCorreoCliente)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(256, 256, 256)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)))
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanelActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(labelNombreProducto)
                                            .addComponent(inputNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(labelDireccion)
                                            .addComponent(inputDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addComponent(labelTelefono))
                                    .addComponent(inputTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(labelCorreo))
                            .addComponent(inputCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonGuardarCambios))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNombreClienteKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane,"Ingresar solo Letras");
        }
    }//GEN-LAST:event_inputNombreClienteKeyTyped

    private void jComboBoxNegociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNegociosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxNegociosActionPerformed

    private void inputCorreoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputCorreoClienteKeyTyped

        
    }//GEN-LAST:event_inputCorreoClienteKeyTyped

    private void inputTelefonoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTelefonoClienteKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane,"Ingresar Solo Numeros");
        }
    }//GEN-LAST:event_inputTelefonoClienteKeyTyped

    public String getInputNombreCliente(){
        return inputNombreCliente.getText();
    }
    public String getInputDireccionCliente(){
        return inputDireccionCliente.getText();
    }
    public String getInputTelefonoCliente(){
        return inputTelefonoCliente.getText();
    }    
    public String getInputCorreoCliente(){
        return inputCorreoCliente.getText();
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonActualizarCliente;
    public javax.swing.JButton botonEliminarCliente;
    private javax.swing.JButton botonRegistrarCliente;
    public javax.swing.JTextField inputCorreoCliente;
    public javax.swing.JTextField inputDireccionCliente;
    public javax.swing.JTextField inputNombreCliente;
    public javax.swing.JTextField inputTelefonoCliente;
    public javax.swing.JButton jButtonAgregar;
    public javax.swing.JButton jButtonGuardarCambios;
    public javax.swing.JButton jButtonRegresar;
    public javax.swing.JComboBox<String> jComboBoxNegocios;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanelActualizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelNegocios;
    private javax.swing.JLabel labelNombreProducto;
    private javax.swing.JLabel labelTelefono;
    public javax.swing.JTable tablaDatosClientes;
    // End of variables declaration//GEN-END:variables
}
