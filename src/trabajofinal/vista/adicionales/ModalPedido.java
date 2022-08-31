/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.vista.adicionales;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import trabajofinal.modelo.Pedido;
import trabajofinal.modelo.Producto;
import trabajofinal.utils.Dialogo;
import trabajofinal.vista.Vista;

/**
 *
 * @author paulc
 */
public class ModalPedido extends javax.swing.JDialog {

    private ArrayList<Producto> productos;
    private Pedido pedido;

    public ModalPedido(Vista parent, boolean modal, ArrayList<Producto> productos) {
        super(parent, modal);
        initComponents();
        this.productos = productos;
        this.cargarDatos();
        this.setVisible(true);
    }

    private void cargarDatos() {
        DefaultTableModel modeloProductos = (DefaultTableModel) this.tablaDatos.getModel();
        for (int i = 0; i < modeloProductos.getRowCount(); i++) {
            modeloProductos.removeRow(i);
        }
        this.productos.forEach(producto -> {
            Object[] fila = new Object[4];
            fila[0] = producto.getNombre();
            fila[1] = producto.getTipoUnidad();
            fila[2] = producto.getPeso();
            fila[3] = producto.getVolumen();
            modeloProductos.addRow(fila);
        });
        this.tablaDatos.setModel(modeloProductos);
    }

    public Pedido getPedido() {
        return pedido;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        botonSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Elegir producto"));

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo", "Peso", "Volumen"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaDatos);
        if (tablaDatos.getColumnModel().getColumnCount() > 0) {
            tablaDatos.getColumnModel().getColumn(0).setResizable(false);
            tablaDatos.getColumnModel().getColumn(1).setResizable(false);
            tablaDatos.getColumnModel().getColumn(2).setResizable(false);
            tablaDatos.getColumnModel().getColumn(3).setResizable(false);
        }

        botonSeleccionar.setText("Seleccionar");
        botonSeleccionar.setPreferredSize(new java.awt.Dimension(120, 40));
        botonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarActionPerformed
        int seleccion = this.tablaDatos.getSelectedRow();
        if (seleccion != -1) {
            System.out.println("Seleccionado: " + this.productos.get(seleccion));
            int cantidad = Dialogo.numero(null, "Ingresa una cantidad", 1, 100);
            if (cantidad != -1) {
                this.pedido = new Pedido(this.productos.get(seleccion), cantidad);
                this.dispose();
                return;
            }
            Dialogo.mostrar(null, "Error, el número ingresado es incorrecto");
            return;
        }
        Dialogo.mostrar(null, "Selecciona un producto para agregarlo");
    }//GEN-LAST:event_botonSeleccionarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSeleccionar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
