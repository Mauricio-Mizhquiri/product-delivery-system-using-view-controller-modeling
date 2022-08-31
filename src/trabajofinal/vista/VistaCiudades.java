package trabajofinal.vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import trabajofinal.modelo.Contenedor;
import trabajofinal.modelo.Enlace;

public class VistaCiudades extends Vista {

    public VistaCiudades(Contenedor contenedor) {
        super(contenedor);
        initComponents();
        this.setSpinner();
        //jTextAreaReporte.append("Ciudad: \tCiudad Enlazada"+"\tTiempo\n");
    }
    
    private void setSpinner() {
        //validacion de spinner
        SpinnerNumberModel model1 = new SpinnerNumberModel();
        SpinnerNumberModel model2 = new SpinnerNumberModel();
        //validando el primer modelo
        model1.setMaximum(100);
        model1.setMinimum(0);
        //validando el segundo modelo
        model2.setMaximum(100);
        model2.setMinimum(0);
        //enviando el modelo a cada Spinner
        inputUbicacionX.setModel(model1);
        inputUbicacionY.setModel(model2);
    }

    public void cargarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaDatos.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        this.contenedor.getCiudades().forEach(ciudad -> {
            Object[] fila = new Object[4];
            fila[0] = ciudad.getNombre();
            fila[1] = ciudad.getStringUbicacionX();
            fila[2] = ciudad.getStringUbicacionY();
            fila[3] = "";
            ArrayList<Enlace> enlaces = ciudad.getCiudadesEnlazadas();
            String ciudadesEnlazadas = "Sin definir";
            if (enlaces != null && !enlaces.isEmpty()) {
                ciudadesEnlazadas = "";
                for (Enlace enlace : enlaces) {
                    ciudadesEnlazadas += enlace.getCiudad().getNombre() + " -> ";
                }
            }
            fila[3] = ciudadesEnlazadas;
            modelo.addRow(fila);
        });

        this.tablaDatos.setModel(modelo);
    }

    @Override
    public void setActionListeners(ActionListener controlador) {
        this.botonCrear.addActionListener(controlador);
        this.botonActualizar.addActionListener(controlador);
        this.botonEliminar.addActionListener(controlador);
        this.botonSalir.addActionListener(controlador);
        this.botonEnlazarCiudades.addActionListener(controlador);
        this.jButtonGuardarCambios.addActionListener(controlador);
        this.jButtonGuardar.addActionListener(controlador);
    }

    @Override
    public void setTableListeners(TableModelListener controlador) {
        this.tablaDatos.getModel().addTableModelListener(controlador);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPasswordField1 = new javax.swing.JPasswordField();
        labelTitulo = new javax.swing.JLabel();
        labelNombreCiudad = new javax.swing.JLabel();
        labelUbicacionX = new javax.swing.JLabel();
        labelUbicacionY = new javax.swing.JLabel();
        botonEnlazarCiudades = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        icono = new javax.swing.JLabel();
        inputNombreCiudad = new javax.swing.JTextField();
        inputUbicacionX = new javax.swing.JSpinner();
        inputUbicacionY = new javax.swing.JSpinner();
        jPanelActualizar = new javax.swing.JPanel();
        botonActualizar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonCrear = new javax.swing.JButton();
        jButtonGuardarCambios = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Ciudades");

        labelTitulo.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        labelTitulo.setText("Registro de ciudades");

        labelNombreCiudad.setText("Nombre de la ciudad:");

        labelUbicacionX.setText("Ubicacion X:");

        labelUbicacionY.setText("Ubicacion Y:");

        botonEnlazarCiudades.setText("Enlazar Ciudades");
        botonEnlazarCiudades.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre de la ciudad", "Ubicacion X", "Ubicacion Y", "Visualizar"
            }
        ));
        jScrollPane2.setViewportView(tablaDatos);

        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/ciudades.jpg"))); // NOI18N

        inputNombreCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputNombreCiudadKeyTyped(evt);
            }
        });

        botonActualizar.setText("Modificar");
        botonActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonEliminar.setText("Eliminar");
        botonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonSalir.setText("Salir");
        botonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonCrear.setText("Crear");
        botonCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanelActualizarLayout = new javax.swing.GroupLayout(jPanelActualizar);
        jPanelActualizar.setLayout(jPanelActualizarLayout);
        jPanelActualizarLayout.setHorizontalGroup(
            jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelActualizarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelActualizarLayout.setVerticalGroup(
            jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelActualizarLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonEliminar)
                        .addComponent(botonSalir)
                        .addComponent(botonActualizar))
                    .addComponent(botonCrear, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jButtonGuardarCambios.setText("Guardar Cambios");

        jButtonGuardar.setText("Actualizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelUbicacionX)
                                    .addComponent(labelUbicacionY)
                                    .addComponent(labelNombreCiudad))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputNombreCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(inputUbicacionY, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(inputUbicacionX, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(52, 52, 52)
                                        .addComponent(botonEnlazarCiudades))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonGuardarCambios)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelNombreCiudad)
                                    .addComponent(inputNombreCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(botonEnlazarCiudades)
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(labelUbicacionY)
                                            .addComponent(inputUbicacionY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(labelUbicacionX)
                                            .addComponent(inputUbicacionX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(jButtonGuardarCambios))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonGuardar)))))
                .addGap(18, 18, 18)
                .addComponent(jPanelActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputNombreCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNombreCiudadKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo Letras");
        }
    }//GEN-LAST:event_inputNombreCiudadKeyTyped

    public String getInputNombreCiudad() {
        return inputNombreCiudad.getText();
    }

    public int getInputUbicacionX() {
        return (int) inputUbicacionX.getValue();
    }

    public int getInputUbicacionY() {
        return (int) inputUbicacionY.getValue();
    }

    public void setInputNombreCiudad(JTextField inputNombreCiudad) {
        this.inputNombreCiudad = inputNombreCiudad;
    }

    public void setInputUbicacionX(JSpinner InputUbicacionX) {
        this.inputUbicacionX = InputUbicacionX;
    }

    public void setInputUbicacionY(JSpinner InputUbicacionY) {
        this.inputUbicacionY = InputUbicacionY;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonEnlazarCiudades;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel icono;
    public javax.swing.JTextField inputNombreCiudad;
    public javax.swing.JSpinner inputUbicacionX;
    public javax.swing.JSpinner inputUbicacionY;
    public javax.swing.JButton jButtonGuardar;
    public javax.swing.JButton jButtonGuardarCambios;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanelActualizar;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelNombreCiudad;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUbicacionX;
    private javax.swing.JLabel labelUbicacionY;
    public javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
