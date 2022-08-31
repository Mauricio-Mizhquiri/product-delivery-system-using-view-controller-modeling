package trabajofinal.vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import trabajofinal.modelo.CaracteristicaEspecial;
import trabajofinal.modelo.Contenedor;

public class VistaProductos extends Vista {

    public VistaProductos(Contenedor contenedor) {
        super(contenedor);
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.cargarDatosProductos();
        this.setVisible(true);
        llenarCombobox();

    }

    public void cargarDatosProductos() {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaDatosProductos.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        this.contenedor.getProductos().forEach(producto -> {
            Object[] fila = new Object[5];
            fila[0] = producto.getNombre();
            fila[1] = producto.getTipoUnidad();
            fila[2] = producto.getPeso();
            fila[3] = producto.getVolumen();
            String caracteristicasEspeciales = "Sin definir";
            ArrayList<CaracteristicaEspecial> caracteristicas = producto.getCaracteristicasEspeciales();
            if (caracteristicas != null && !caracteristicas.isEmpty()) {
                caracteristicasEspeciales = "";
                for (CaracteristicaEspecial caracteristica : caracteristicas) {
                    caracteristicasEspeciales += caracteristica.getNombre() + " - >";
                }
            }
            fila[4] = caracteristicasEspeciales;
            modelo.addRow(fila);
        });
        this.tablaDatosProductos.setModel(modelo);
    }

    public void llenarCombobox() {
        for (CaracteristicaEspecial carac : contenedor.getCaracteristicasEspeciales()) {
            jComboBox1.addItem(carac.getNombre());
        }
    }

    @Override
    public void setTableListeners(TableModelListener controlador) {
        //super.setTableListeners(controlador); //To change body of generated methods, choose Tools | Templates.
        this.tablaDatosProductos.getModel().addTableModelListener(controlador);
    }

    @Override
    public void setActionListeners(ActionListener controlador) {
        this.jButtonAgregar.addActionListener(controlador);
        this.botonRegistrarProducto.addActionListener(controlador);
        this.botonActualizar.addActionListener(controlador);
        this.botonEliminar.addActionListener(controlador);

        this.jButtonSalir.addActionListener(controlador);
        this.jButtonGuardarCambios.addActionListener(controlador);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNombreProducto = new javax.swing.JLabel();
        inputNombreProducto = new javax.swing.JTextField();
        labelCaracteristicasEspeciales = new javax.swing.JLabel();
        labelTipoUnidad = new javax.swing.JLabel();
        labelPeso = new javax.swing.JLabel();
        labelVolumen = new javax.swing.JLabel();
        inputPeso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inputVolumen = new javax.swing.JTextField();
        inputTipoUnidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatosProductos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        icono = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonAgregar = new javax.swing.JButton();
        jPanelActualizar = new javax.swing.JPanel();
        jButtonSalir = new javax.swing.JButton();
        botonRegistrarProducto = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jButtonGuardarCambios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Productos");

        labelNombreProducto.setText("Nombre del producto:");
        labelNombreProducto.setToolTipText("");

        inputNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputNombreProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputNombreProductoKeyTyped(evt);
            }
        });

        labelCaracteristicasEspeciales.setText("Caracteristicas especiales: ");

        labelTipoUnidad.setText("Tipo de unidad:");

        labelPeso.setText("Peso por unidad:");

        labelVolumen.setText("Volumen:");

        inputPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputPesoKeyTyped(evt);
            }
        });

        jLabel6.setText("Kg");

        inputVolumen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputVolumenKeyTyped(evt);
            }
        });

        inputTipoUnidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputTipoUnidadKeyTyped(evt);
            }
        });

        tablaDatosProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo De Unidad", "Peso", "Volumen", "Visualizar"
            }
        ));
        jScrollPane1.setViewportView(tablaDatosProductos);

        jLabel8.setText("m^3");

        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/producto1.png"))); // NOI18N

        labelTitulo.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        labelTitulo.setText("Registro De Productos");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButtonAgregar.setText("Agregar");

        jButtonSalir.setText("Salir");
        jButtonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        botonRegistrarProducto.setText("Registrar");
        botonRegistrarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonActualizar.setText("Actualizar");
        botonActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonEliminar.setText("Eliminar");
        botonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanelActualizarLayout = new javax.swing.GroupLayout(jPanelActualizar);
        jPanelActualizar.setLayout(jPanelActualizarLayout);
        jPanelActualizarLayout.setHorizontalGroup(
            jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelActualizarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonRegistrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154)
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanelActualizarLayout.setVerticalGroup(
            jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActualizarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrarProducto)
                    .addComponent(botonActualizar)
                    .addComponent(botonEliminar)
                    .addComponent(jButtonSalir))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jButtonGuardarCambios.setText("Guardar Cambios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(labelTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanelActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCaracteristicasEspeciales)
                                    .addComponent(labelNombreProducto)
                                    .addComponent(labelTipoUnidad)
                                    .addComponent(labelPeso)
                                    .addComponent(labelVolumen))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(inputVolumen)
                                            .addComponent(inputPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(inputTipoUnidad, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputNombreProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonAgregar)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(271, 271, 271)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(338, 338, 338)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNombreProducto)
                            .addComponent(inputNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCaracteristicasEspeciales)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAgregar))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTipoUnidad)
                            .addComponent(inputTipoUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelPeso)
                                    .addComponent(inputPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(labelVolumen))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(inputVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jButtonGuardarCambios))))
                    .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed

    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void inputNombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNombreProductoKeyReleased

    }//GEN-LAST:event_inputNombreProductoKeyReleased

    private void inputNombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNombreProductoKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo Letras");
        }
    }//GEN-LAST:event_inputNombreProductoKeyTyped

    private void inputPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputPesoKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Numeros");
        }
    }//GEN-LAST:event_inputPesoKeyTyped

    private void inputVolumenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputVolumenKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Numeros");
        }
    }//GEN-LAST:event_inputVolumenKeyTyped

    private void inputTipoUnidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTipoUnidadKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo Letras");
        }
    }//GEN-LAST:event_inputTipoUnidadKeyTyped

    public String getInputNombreProducto() {
        return inputNombreProducto.getText();
    }

    public String getInputTipoUnidad() {
        return inputTipoUnidad.getText();
    }

    public String getInputPeso() {
        return inputPeso.getText();
    }

    public String getInputVolumen() {
        return inputVolumen.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonActualizar;
    public javax.swing.JButton botonEliminar;
    public javax.swing.JButton botonRegistrarProducto;
    private javax.swing.JLabel icono;
    public javax.swing.JTextField inputNombreProducto;
    public javax.swing.JTextField inputPeso;
    public javax.swing.JTextField inputTipoUnidad;
    public javax.swing.JTextField inputVolumen;
    public javax.swing.JButton jButtonAgregar;
    public javax.swing.JButton jButtonGuardarCambios;
    public javax.swing.JButton jButtonSalir;
    public javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JPanel jPanelActualizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel labelCaracteristicasEspeciales;
    private javax.swing.JLabel labelNombreProducto;
    private javax.swing.JLabel labelPeso;
    private javax.swing.JLabel labelTipoUnidad;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelVolumen;
    public javax.swing.JTable tablaDatosProductos;
    // End of variables declaration//GEN-END:variables

}
