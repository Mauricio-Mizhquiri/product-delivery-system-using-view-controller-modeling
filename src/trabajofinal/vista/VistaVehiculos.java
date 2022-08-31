package trabajofinal.vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import trabajofinal.modelo.CaracteristicaEspecial;
import trabajofinal.modelo.Ciudad;
import trabajofinal.modelo.Contenedor;
import trabajofinal.modelo.Vehiculo;

public class VistaVehiculos extends Vista {

    public VistaVehiculos(Contenedor contenedor) {
        super(contenedor);
        initComponents();
        llenarCombobox();
    }

    @Override
    public void setTableListeners(TableModelListener controlador) {
        super.setTableListeners(controlador);
    }

    @Override
    public void setActionListeners(ActionListener controlador) {
        super.setActionListeners(controlador);
        this.botonRegistrar.addActionListener(controlador);
        this.jButtonAgregar.addActionListener(controlador);
        this.Regresar.addActionListener(controlador);
    }

    public void cargarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaDatos.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        this.contenedor.getVehiculos().forEach((Vehiculo vehiculo) -> {
            Object[] fila = new Object[7];
            fila[0] = vehiculo.getPlaca();
            fila[1] = vehiculo.getMarca();
            fila[2] = vehiculo.getCiudad().getNombre();
            fila[3] = vehiculo.getModelo();
            fila[4] = vehiculo.getPesoMaximo();
            fila[5] = vehiculo.getVolumenMaximo();
            String dato = "N/D";
            ArrayList<CaracteristicaEspecial> caracteristicas = vehiculo.getCaracteristicasEspeciales();
            if (caracteristicas != null && !caracteristicas.isEmpty()) {
                dato = "";
                for (CaracteristicaEspecial caracteristica : caracteristicas) {
                    dato += caracteristica.getNombre() + "->";
                }
            }
            fila[6] = dato;
            modelo.addRow(fila);
        });
        this.tablaDatos.setModel(modelo);
    }

    public void llenarCombobox() {
        for (Ciudad ciudad : contenedor.getCiudades()) {
            this.jComboBoxCiudad.addItem(ciudad.getNombre());
        }
        for (CaracteristicaEspecial caracte : contenedor.getCaracteristicasEspeciales()) {
            this.jComboBoxCaracteristica.addItem(caracte.getNombre());
        }
    }

    public String getPlaca() {
        return this.inputPlaca.getText();
    }

    public String getMarca() {
        return this.inputMarca.getText();
    }

    public String getModelo() {
        return this.inputModelo.getText();
    }

    public String getPesoMaximo() {
        return this.inputPesoMaximo.getText();
    }

    public String getVolumenMaximo() {
        return this.inputVolumenMaximo.getText();
    }

    public void setIncorrecto() {

    }

    public void setCorrecto() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPlaca = new javax.swing.JLabel();
        labelMarca = new javax.swing.JLabel();
        labelModelo = new javax.swing.JLabel();
        labelCiudad = new javax.swing.JLabel();
        labelPeso = new javax.swing.JLabel();
        labelVolumen = new javax.swing.JLabel();
        labelCaracteristicas = new javax.swing.JLabel();
        botonRegistrar = new javax.swing.JButton();
        inputPlaca = new javax.swing.JTextField();
        inputMarca = new javax.swing.JTextField();
        inputPesoMaximo = new javax.swing.JTextField();
        inputVolumenMaximo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        Regresar = new javax.swing.JButton();
        icono = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBoxCaracteristica = new javax.swing.JComboBox<>();
        jComboBoxCiudad = new javax.swing.JComboBox<>();
        jButtonAgregar = new javax.swing.JButton();
        inputModelo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Vehículos");

        labelPlaca.setText("Placa:");

        labelMarca.setText("Marca:");

        labelModelo.setText("Modelo:");

        labelCiudad.setText("Ciudad:");

        labelPeso.setText("Peso máximo:");

        labelVolumen.setText("Volumen máximo:");

        labelCaracteristicas.setText("Caracteristicas especiales:");

        botonRegistrar.setText("Registrar");
        botonRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        inputPlaca.setToolTipText("");
        inputPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPlacaActionPerformed(evt);
            }
        });
        inputPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputPlacaKeyTyped(evt);
            }
        });

        inputMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputMarcaKeyTyped(evt);
            }
        });

        inputPesoMaximo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputPesoMaximoKeyTyped(evt);
            }
        });

        inputVolumenMaximo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputVolumenMaximoKeyTyped(evt);
            }
        });

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Marca", "Ciudad", "Modelo", "Peso Maximo", "Volumen Maximo", "Caracteristicas"
            }
        ));
        jScrollPane2.setViewportView(tablaDatos);

        Regresar.setText("Regresar");
        Regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/Camion.png"))); // NOI18N

        labelTitulo.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        labelTitulo.setText("Registro De Vehiculos");

        jComboBoxCaracteristica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar:" }));

        jComboBoxCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar:" }));

        jButtonAgregar.setText("Agregar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(labelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMarca)
                    .addComponent(labelPlaca)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCiudad)
                        .addGap(198, 198, 198)
                        .addComponent(jComboBoxCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelVolumen)
                            .addComponent(labelPeso)
                            .addComponent(labelCaracteristicas)
                            .addComponent(labelModelo))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxCaracteristica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jButtonAgregar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(inputModelo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputVolumenMaximo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(inputPesoMaximo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(inputMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(inputPlaca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 453, Short.MAX_VALUE)
                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonRegistrar)
                        .addGap(296, 296, 296))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPlaca)
                            .addComponent(inputPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMarca)
                            .addComponent(inputMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelModelo)
                            .addComponent(inputModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCiudad)
                            .addComponent(jComboBoxCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputPesoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPeso))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputVolumenMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelVolumen))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCaracteristicas)
                            .addComponent(jComboBoxCaracteristica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAgregar))))
                .addGap(12, 12, 12)
                .addComponent(botonRegistrar)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Regresar)
                .addGap(8, 8, 8))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inputPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPlacaActionPerformed

    private void inputPlacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputPlacaKeyTyped

    }//GEN-LAST:event_inputPlacaKeyTyped

    private void inputMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputMarcaKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo Letras");
        }
    }//GEN-LAST:event_inputMarcaKeyTyped

    private void inputPesoMaximoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputPesoMaximoKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Numeros");
        }
    }//GEN-LAST:event_inputPesoMaximoKeyTyped

    private void inputVolumenMaximoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputVolumenMaximoKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Numeros");
        }
    }//GEN-LAST:event_inputVolumenMaximoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Regresar;
    public javax.swing.JButton botonRegistrar;
    private javax.swing.JLabel icono;
    public javax.swing.JTextField inputMarca;
    public javax.swing.JTextField inputModelo;
    public javax.swing.JTextField inputPesoMaximo;
    public javax.swing.JTextField inputPlaca;
    public javax.swing.JTextField inputVolumenMaximo;
    public javax.swing.JButton jButtonAgregar;
    public javax.swing.JComboBox<String> jComboBoxCaracteristica;
    public javax.swing.JComboBox<String> jComboBoxCiudad;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCaracteristicas;
    private javax.swing.JLabel labelCiudad;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelModelo;
    private javax.swing.JLabel labelPeso;
    private javax.swing.JLabel labelPlaca;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelVolumen;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables

}
