
package trabajofinal.vista;

import java.awt.event.ActionListener;
import trabajofinal.modelo.Contenedor;

public class VistaPrincipal extends Vista {
    
    private Contenedor contenedor;
    
    public VistaPrincipal(Contenedor contenedor) {
        super(contenedor);
        initComponents();
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonCiudades = new javax.swing.JButton();
        botonProductos = new javax.swing.JButton();
        botonClientes = new javax.swing.JButton();
        botonCaracteristicas = new javax.swing.JButton();
        botonEmpresas = new javax.swing.JButton();
        botonVehiculos = new javax.swing.JButton();
        botonConductores = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonTransaccion = new javax.swing.JButton();
        jButtonReportes = new javax.swing.JButton();
        jButtonCobertura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setMaximumSize(new java.awt.Dimension(800, 600));

        botonCiudades.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        botonCiudades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/cityscape.png"))); // NOI18N
        botonCiudades.setText("Ciudades");
        botonCiudades.setAlignmentY(0.0F);
        botonCiudades.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonProductos.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        botonProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/gift.png"))); // NOI18N
        botonProductos.setText("Productos");
        botonProductos.setAlignmentY(0.0F);
        botonProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonProductos.setMaximumSize(new java.awt.Dimension(99, 33));
        botonProductos.setMinimumSize(new java.awt.Dimension(99, 33));
        botonProductos.setPreferredSize(new java.awt.Dimension(135, 41));

        botonClientes.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        botonClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/target.png"))); // NOI18N
        botonClientes.setText("Clientes");
        botonClientes.setAlignmentY(0.0F);
        botonClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonClientes.setPreferredSize(new java.awt.Dimension(135, 41));

        botonCaracteristicas.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        botonCaracteristicas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/settings.png"))); // NOI18N
        botonCaracteristicas.setText("Caracteristicas");
        botonCaracteristicas.setAlignmentY(0.0F);
        botonCaracteristicas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonCaracteristicas.setPreferredSize(new java.awt.Dimension(135, 41));

        botonEmpresas.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        botonEmpresas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/enterprise.png"))); // NOI18N
        botonEmpresas.setText("Empresa");
        botonEmpresas.setAlignmentY(0.0F);
        botonEmpresas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonEmpresas.setPreferredSize(new java.awt.Dimension(135, 41));

        botonVehiculos.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        botonVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/truck.png"))); // NOI18N
        botonVehiculos.setText("Vehiculos");
        botonVehiculos.setAlignmentY(0.0F);
        botonVehiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonVehiculos.setPreferredSize(new java.awt.Dimension(135, 41));

        botonConductores.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        botonConductores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/driver-license.png"))); // NOI18N
        botonConductores.setText("Conductores");
        botonConductores.setAlignmentY(0.0F);
        botonConductores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonConductores.setPreferredSize(new java.awt.Dimension(135, 41));

        botonSalir.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/logout.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.setAlignmentY(0.0F);
        botonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonSalir.setPreferredSize(new java.awt.Dimension(135, 41));
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 0, 102));
        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("SISTEMA DE REPARTO DE PRODUCTOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButtonTransaccion.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jButtonTransaccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/work-tools.png"))); // NOI18N
        jButtonTransaccion.setText("Transacciones");
        jButtonTransaccion.setPreferredSize(new java.awt.Dimension(135, 41));

        jButtonReportes.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jButtonReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/dashboard.png"))); // NOI18N
        jButtonReportes.setText("Reportes");
        jButtonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportesActionPerformed(evt);
            }
        });

        jButtonCobertura.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jButtonCobertura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/way.png"))); // NOI18N
        jButtonCobertura.setText("Cobertura");
        jButtonCobertura.setPreferredSize(new java.awt.Dimension(135, 41));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonConductores, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonCaracteristicas, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonTransaccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonReportes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonCobertura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCobertura, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(botonCaracteristicas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonConductores, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void jButtonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReportesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCaracteristicas;
    private javax.swing.JButton botonCiudades;
    private javax.swing.JButton botonClientes;
    private javax.swing.JButton botonConductores;
    private javax.swing.JButton botonEmpresas;
    private javax.swing.JButton botonProductos;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonVehiculos;
    private javax.swing.JButton jButtonCobertura;
    public javax.swing.JButton jButtonReportes;
    public javax.swing.JButton jButtonTransaccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setActionListeners(ActionListener controlador) {
        botonCiudades.addActionListener(controlador);
        botonProductos.addActionListener(controlador);
        botonClientes.addActionListener(controlador);
        botonCaracteristicas.addActionListener(controlador);
        botonEmpresas.addActionListener(controlador);
        botonVehiculos.addActionListener(controlador);
        botonConductores.addActionListener(controlador);
        botonSalir.addActionListener(controlador);
        jButtonTransaccion.addActionListener(controlador);
        jButtonReportes.addActionListener(controlador);
        jButtonCobertura.addActionListener(controlador);
    }

}
