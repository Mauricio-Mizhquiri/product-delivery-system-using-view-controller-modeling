package trabajofinal.vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import trabajofinal.modelo.Ciudad;
import trabajofinal.modelo.Cliente;
import trabajofinal.modelo.Contenedor;
import trabajofinal.modelo.Pedido;
import trabajofinal.modelo.Transaccion;

public class VistaTransacciones extends Vista {

    private String diaTransaccion;
    private String mesTransaccion;
    private String anioTransaccion;

    public VistaTransacciones(Contenedor contenedor) {
        super(contenedor);
        initComponents();
        SpinnerNumberModel modelo = new SpinnerNumberModel();
        modelo.setMaximum(100);
        modelo.setMinimum(0);
        llenarCombobox();
    }

    public void cargarTransacciones() {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaTransacciones.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        ArrayList<Transaccion> transacciones = this.contenedor.getTransacciones();
        if (transacciones != null && !transacciones.isEmpty()) {
            transacciones.forEach(transaccion -> {
                Object[] fila = new Object[5];
                fila[0] = transaccion.getCliente().getNombre();
                fila[1] = transaccion.getOrigen().getNombre();
                fila[2] = transaccion.getDestino().getNombre();
                fila[3] = transaccion.getFecha();
                fila[4] = transaccion.getEstado();
                modelo.addRow(fila);
            });
            this.tablaTransacciones.setModel(modelo);
        }
    }
    
    public void setPeso(String peso) {
        this.inputPeso.setText(peso);
    }
    
    public void setVolumen(String volumen) {
        this.inputVolumen.setText(volumen);
    }
    
    public String getPeso() {
        return this.inputPeso.getText();
    }
    
    public String getVolumen() {
        return this.inputVolumen.getText();
    }

    @Override
    public void setActionListeners(ActionListener controlador) {
        this.jButtonIngresar.addActionListener(controlador);
        this.jButtonRegresar.addActionListener(controlador);
        this.botonAgregarProducto.addActionListener(controlador);
        this.botonEliminarProducto.addActionListener(controlador);
        this.botonCompletado.addActionListener(controlador);
        this.botonPendiente.addActionListener(controlador);
        this.botonCancelado.addActionListener(controlador);
    }

    public void llenarCombobox() {
        for (Cliente cliente : contenedor.getClientes()) {
            this.jComboBoxClientes.addItem(cliente.getNombre());
        }
        for (Ciudad ciu : contenedor.getCiudades()) {
            this.jComboBoxOrigen.addItem(ciu.getNombre());
            this.jComboBoxDestino.addItem(ciu.getNombre());
        }
        this.configurarDatePicker();
    }
    
    public int getIndiceTablaTransacciones() {
        return this.tablaTransacciones.getSelectedRow();
    }
    
    public void borrarCampos() {
        this.jComboBoxClientes.setSelectedIndex(0);
        this.jComboBoxOrigen.setSelectedIndex(0);
        this.jComboBoxDestino.setSelectedIndex(0);
        this.inputPeso.setText("");
        this.inputVolumen.setText("");
        this.cargarPedidos(new ArrayList<>());
    }

    public void cargarPedidos(ArrayList<Pedido> pedidos) {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaPedidos.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        pedidos.forEach(pedido -> {
            Object[] fila = new Object[4];
            fila[0] = pedido.getProducto().getNombre();
            fila[1] = pedido.getProducto().getPeso();
            fila[2] = pedido.getProducto().getVolumen();
            fila[3] = pedido.getCantidad();
            modelo.addRow(fila);
        });
        this.tablaPedidos.setModel(modelo);
        this.tablaPedidos.repaint();
    }

    public int filaPedidoSeleccionada() {
        return this.tablaPedidos.getSelectedRow();
    }
    
    public int filaTransaccionSeleccionada() {
        return this.tablaTransacciones.getSelectedRow();
    }

    private void configurarDatePicker() {
        this.jComboBoxDia.addActionListener(e -> {
            diaTransaccion = jComboBoxDia.getSelectedItem().toString();
        });
        this.jComboBoxMes.addActionListener(e -> {
            mesTransaccion = jComboBoxMes.getSelectedItem().toString();
        });
        this.jComboBoxAnio.addActionListener(e -> {
            anioTransaccion = jComboBoxAnio.getSelectedItem().toString();
        });
    }

    private void setDias(int cantidad) {
        this.jComboBoxDia.removeAllItems();
        for (int i = 1; i < cantidad + 1; i++) {
            String dia = (i > 10) ? "0" + String.valueOf(i) : String.valueOf(i);
            this.jComboBoxDia.addItem(dia);
        }
    }

    public String getFecha() {
        this.diaTransaccion = this.diaTransaccion != null ? this.diaTransaccion : "01";
        this.mesTransaccion = this.mesTransaccion != null ? this.mesTransaccion : "01";
        this.anioTransaccion = this.anioTransaccion != null ? this.anioTransaccion : "2020";
        return this.diaTransaccion + "/" + this.mesTransaccion + "/" + this.anioTransaccion;
    }

    public Cliente getCliente() {
        int index = this.jComboBoxClientes.getSelectedIndex() - 1;
        return this.contenedor.getClientes().get(index);
    }

    public Ciudad getCiudadOrigen() {
        int index = this.jComboBoxOrigen.getSelectedIndex() - 1;
        return this.contenedor.getCiudades().get(index);
    }

    public Ciudad getCiudadDestino() {
        int index = this.jComboBoxDestino.getSelectedIndex() - 1;
        return this.contenedor.getCiudades().get(index);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonIngresar = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        botonAgregarProducto = new javax.swing.JButton();
        botonEliminarProducto = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        inputPeso = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        inputVolumen = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxClientes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxOrigen = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxDestino = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxDia = new javax.swing.JComboBox<>();
        jComboBoxAnio = new javax.swing.JComboBox<>();
        jComboBoxMes = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTransacciones = new javax.swing.JTable();
        botonPendiente = new javax.swing.JButton();
        botonCompletado = new javax.swing.JButton();
        botonCancelado = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transacciones");

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        jLabel1.setText("Transacciones");

        jButtonIngresar.setText("Ingresar");
        jButtonIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButtonRegresar.setText("Regresar");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedidos"));

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Peso", "Volumen", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPedidos);
        if (tablaPedidos.getColumnModel().getColumnCount() > 0) {
            tablaPedidos.getColumnModel().getColumn(0).setResizable(false);
            tablaPedidos.getColumnModel().getColumn(1).setResizable(false);
            tablaPedidos.getColumnModel().getColumn(2).setResizable(false);
            tablaPedidos.getColumnModel().getColumn(3).setResizable(false);
        }

        botonAgregarProducto.setText("Agregar");

        botonEliminarProducto.setText("Eliminar");

        jLabel6.setText("Peso Total:");

        inputPeso.setText("0");
        inputPeso.setToolTipText("");
        inputPeso.setEnabled(false);

        jLabel7.setText("Volumen Total:");

        inputVolumen.setText("0");
        inputVolumen.setToolTipText("");
        inputVolumen.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonAgregarProducto)
                        .addGap(18, 18, 18)
                        .addComponent(botonEliminarProducto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(inputPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(inputVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inputPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(inputVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonEliminarProducto)
                    .addComponent(botonAgregarProducto))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingreso"));

        jLabel2.setText("Clientes:");

        jComboBoxClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar:" }));

        jLabel3.setText("Ciudad Origen:");

        jComboBoxOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar:" }));

        jLabel4.setText("Ciudad Destino:");

        jComboBoxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar:" }));

        jLabel5.setText("Fecha:");

        jComboBoxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        jComboBoxDia.setMinimumSize(new java.awt.Dimension(90, 27));
        jComboBoxDia.setPreferredSize(new java.awt.Dimension(75, 27));

        jComboBoxAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029" }));
        jComboBoxAnio.setPreferredSize(new java.awt.Dimension(90, 27));

        jComboBoxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        jComboBoxMes.setPreferredSize(new java.awt.Dimension(75, 27));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(45, 45, 45)
                        .addComponent(jComboBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Transacciones"));

        tablaTransacciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Origen", "Destino", "Fecha", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaTransacciones);
        if (tablaTransacciones.getColumnModel().getColumnCount() > 0) {
            tablaTransacciones.getColumnModel().getColumn(0).setResizable(false);
            tablaTransacciones.getColumnModel().getColumn(1).setResizable(false);
            tablaTransacciones.getColumnModel().getColumn(2).setResizable(false);
            tablaTransacciones.getColumnModel().getColumn(3).setResizable(false);
            tablaTransacciones.getColumnModel().getColumn(4).setResizable(false);
        }

        botonPendiente.setText("Pendiente");

        botonCompletado.setText("Completado");

        botonCancelado.setText("Cancelado");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonCompletado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonPendiente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonCancelado)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonPendiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonCompletado)
                    .addComponent(botonCancelado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Vehículo Seleccionado"));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonRegresar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonIngresar)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonRegresar)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarProducto;
    private javax.swing.JButton botonCancelado;
    private javax.swing.JButton botonCompletado;
    private javax.swing.JButton botonEliminarProducto;
    private javax.swing.JButton botonPendiente;
    private javax.swing.JTextField inputPeso;
    private javax.swing.JTextField inputVolumen;
    public javax.swing.JButton jButtonIngresar;
    public javax.swing.JButton jButtonRegresar;
    private javax.swing.JComboBox<String> jComboBoxAnio;
    public javax.swing.JComboBox<String> jComboBoxClientes;
    public javax.swing.JComboBox<String> jComboBoxDestino;
    private javax.swing.JComboBox<String> jComboBoxDia;
    private javax.swing.JComboBox<String> jComboBoxMes;
    public javax.swing.JComboBox<String> jComboBoxOrigen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JTable tablaTransacciones;
    // End of variables declaration//GEN-END:variables

}
