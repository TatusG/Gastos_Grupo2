/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CapaPresentacion;

import CapaEntidades.Departamento;
import CapaEntidades.Distrito;
import CapaEntidades.Estado;
import CapaEntidades.Proveedor;
import CapaEntidades.Provincia;
import CapaNegocio.ProveedorBL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class FrmProveedor extends javax.swing.JFrame {

    private String perfilUsuario;

    public FrmProveedor(String perfil) {
        initComponents();
        this.perfilUsuario = perfil;
        setLocationRelativeTo(null);
        setResizable(false);
        cargarDepartamento();
        cargarEstado();
        listar();
        personalizarTabla();
        txtId.setVisible(false);
    }

    public FrmProveedor() {
        this("Operador");
    }

    ProveedorBL oProveedorBL = new ProveedorBL();

    void listar() {
        DefaultTableModel p_tabla = new DefaultTableModel();
        String[] titulos = {"Código", "RUC", "Razon Social", "Dirección", "Departamento", "Provincia", "Distrito", "Teléfono", "Celular", "E-mail", "Estado"};
        p_tabla.setColumnIdentifiers(titulos);

        List<Proveedor> lista = oProveedorBL.listarProveedor();
        System.out.println("Cantidad de proveedores: " + lista.size());

        for (Proveedor oproveedor : lista) {
            Object data[] = {
                oproveedor.getIdproveedor(),
                oproveedor.getRuc(),
                oproveedor.getRazonsocial(),
                oproveedor.getDireccion(),
                oproveedor.getDepartamento(),
                oproveedor.getProvincia(),
                oproveedor.getDistrito(),
                oproveedor.getTelefono(),
                oproveedor.getCelular(),
                oproveedor.getEmail(),
                oproveedor.getEstado()
            };
            p_tabla.addRow(data);
        }
        tblLista.setModel(p_tabla);
    }

    void limpiar() {
        txtRUC.setText("");
        txtRSocial.setText("");
        txtDir.setText("");
        txtTelef.setText("");
        txtCel.setText("");
        txtEmail.setText("");
        txtId.setText("");
        cboDepartamento.removeAllItems();
        cboProvincia.removeAllItems();
        cboDistrito.removeAllItems();
        cboEstado.removeAllItems();
        cargarDepartamento();
        cargarEstado();
    }

    void cargarDepartamento() {
        cboDepartamento.removeAllItems();
        List<Departamento> departamento = new ArrayList();
        departamento = oProveedorBL.listarDepartamento();

        for (Departamento oDepartamento : departamento) {
            cboDepartamento.addItem(oDepartamento.getDepartamento());
        }
        cargarProvincias(departamento.get(0).getDepartamento());
    }

    void cargarProvincias(String departamento) {
        cboProvincia.removeAllItems();
        List<Provincia> provincias = oProveedorBL.listarProvincia(departamento);
        for (Provincia oProvincia : provincias) {
            cboProvincia.addItem(oProvincia.getProvincia());
        }
        cargarDistritos(provincias.get(0).getProvincia());
    }

    void cargarDistritos(String provincia) {
        cboDistrito.removeAllItems();
        List<Distrito> distritos = oProveedorBL.listarDistrito(provincia);
        for (Distrito oDistrito : distritos) {
            cboDistrito.addItem(oDistrito.getDistrito());
        }
    }

    void cargarEstado() {
        cboEstado.removeAllItems();
        List<Estado> estado = new ArrayList();
        estado = oProveedorBL.listarEstado();
        for (Estado oestado : estado) {
            cboEstado.addItem(oestado.getNombre());
        }
    }

    void activarbotones(boolean botonGuardar, boolean botonBuscar, boolean botonEliminar) {
        btnGuardar.setEnabled(botonGuardar);
        btnBuscar.setEnabled(botonBuscar);
        btnEliminar.setEnabled(botonEliminar);
    }

    private void personalizarTabla() {
        tblLista.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblLista.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblLista.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblLista.getColumnModel().getColumn(3).setPreferredWidth(250);
        tblLista.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblLista.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblLista.getColumnModel().getColumn(6).setPreferredWidth(100);
        tblLista.getColumnModel().getColumn(7).setPreferredWidth(100);
        tblLista.getColumnModel().getColumn(8).setPreferredWidth(100);
        tblLista.getColumnModel().getColumn(9).setPreferredWidth(200);
        tblLista.getColumnModel().getColumn(10).setPreferredWidth(100);
    }

    void mensaje(String men) {
        JOptionPane.showMessageDialog(this, men, "Aviso", 1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboDepartamento = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboProvincia = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboDistrito = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtRUC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRSocial = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDir = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTelef = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cboEstado = new javax.swing.JComboBox<>();
        txtId = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cboDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboDepartamentoMouseClicked(evt);
            }
        });
        cboDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDepartamentoActionPerformed(evt);
            }
        });

        jLabel1.setText("Departamento");

        jLabel2.setText("Provincia");

        cboProvincia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboProvinciaMouseClicked(evt);
            }
        });
        cboProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProvinciaActionPerformed(evt);
            }
        });

        jLabel3.setText("Distrito");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("REGISTRO DE PROVEEDORES");

        jLabel5.setText("RUC");

        jLabel6.setText("Razon Social");

        jLabel7.setText("Dirección");

        jLabel8.setText("Teléfono");

        jLabel9.setText("Celular");

        jLabel10.setText("E-mail");

        jLabel11.setText("Estado");

        jScrollPane1.setEnabled(false);

        tblLista.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblLista);

        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Añadir.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtId.setEnabled(false);

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Actualizar.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelef, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRUC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRSocial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboDepartamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboProvincia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboDistrito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(296, 296, 296)
                                .addComponent(jLabel4)))
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(cboDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(txtTelef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(256, 256, 256)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(6, 6, 6)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboDepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboDepartamentoMouseClicked
        // TODO add your handling code here:        


    }//GEN-LAST:event_cboDepartamentoMouseClicked

    private void cboProvinciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboProvinciaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cboProvinciaMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:       

        if (btnNuevo.getText().equalsIgnoreCase("Nuevo")) {
            btnNuevo.setText("Cancelar");
            activarbotones(true, false, false);
            txtRUC.requestFocus();
            cargarDepartamento();
            cargarEstado();
            limpiar();
        } else {
            btnNuevo.setText("Nuevo");
            limpiar();
            activarbotones(false, true, false);
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtRUC.getText().isEmpty() || txtRSocial.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "RUC y Razón Social son obligatorios");
            return;
        }
        ProveedorBL oProveedorBL = new ProveedorBL();
        int prov;
        String usuarioActual = FrmLogin.usuarioActual;
        Date fechaActual = new Date(System.currentTimeMillis());
        //System.out.println("Iniciando el proceso de guardado...");

        try {
            if (txtId.getText().length() == 0) {
                if (oProveedorBL.validarRUC(txtRUC.getText())) {
                    JOptionPane.showMessageDialog(this, "El RUC ya existe");
                    return;
                } else {
                    if (oProveedorBL.validarRazonSocial(txtRSocial.getText())) {
                        JOptionPane.showMessageDialog(this, "La razón Social ya existe");
                        return;
                    } else {
                        if (!txtRUC.getText().matches("\\d{11}")) {
                            JOptionPane.showMessageDialog(this, "El RUC debe tener 11 digitos numéricos");
                            return;
                        } else {
                            prov = oProveedorBL.agregarProveedor(new Proveedor(
                                    txtRUC.getText(),
                                    txtRSocial.getText(),
                                    txtDir.getText(),
                                    cboDepartamento.getSelectedItem().toString(),
                                    cboProvincia.getSelectedItem().toString(),
                                    cboDistrito.getSelectedItem().toString(),
                                    txtTelef.getText(),
                                    txtCel.getText(),
                                    txtEmail.getText(),
                                    cboEstado.getSelectedItem().toString(),
                                    fechaActual,
                                    usuarioActual
                            ));
                            JOptionPane.showMessageDialog(this, "Registro Guardado");
                        }
                    }
                }
            } else {
                int idProveedor = Integer.parseInt(txtId.getText());

                if (oProveedorBL.validarRUCExcluyendoId(txtRUC.getText(), idProveedor)) {
                    JOptionPane.showMessageDialog(this, "EL RUC ya existe");
                    return;
                } else {
                    if (oProveedorBL.validarRazonSocialExcluyendoId(txtRSocial.getText(), idProveedor)) {
                        JOptionPane.showMessageDialog(this, "La razón social ya existe");
                        return;
                    } else {

                        if (!txtRUC.getText().matches("\\d{11}")) {
                            JOptionPane.showMessageDialog(this, "El RUC debe tener 11 digitos numéricos");
                            return;
                        } else {

                            prov = oProveedorBL.actualizarProveedor(new Proveedor(
                                    Integer.parseInt(txtId.getText()),
                                    txtRUC.getText(),
                                    txtRSocial.getText(),
                                    txtDir.getText(),
                                    cboDepartamento.getSelectedItem().toString(),
                                    cboProvincia.getSelectedItem().toString(),
                                    cboDistrito.getSelectedItem().toString(),
                                    txtTelef.getText(),
                                    txtCel.getText(),
                                    txtEmail.getText(),
                                    cboEstado.getSelectedItem().toString(),
                                    fechaActual,
                                    usuarioActual));
                            //System.out.println("Proveedor actualizado, resultado: " + prov);
                            JOptionPane.showMessageDialog(this, "Proveedor Modificado");
                        }
                    }
                }
            }
        } catch (Exception e) {
            mensaje(e.getMessage());
        }

        activarbotones(false, true, false);
        btnNuevo.setText("NUEVO");
        listar();
        limpiar();
        personalizarTabla();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

        txtRUC.setText(JOptionPane.showInputDialog("Ingrese el RUC a buscar"));

        if (!txtRUC.getText().matches("\\d{11}")) {
            JOptionPane.showMessageDialog(this, "El RUC debe tener 11 digitos numéricos");
            limpiar();
            return;
        } else {
            Proveedor oproveedor = oProveedorBL.buscarProveedor(txtRUC.getText());
            if (oproveedor == null) {
                JOptionPane.showMessageDialog(this, "RUC no existe");
            } else {
                txtId.setText(String.valueOf(oproveedor.getIdproveedor()));
                txtRUC.setText(oproveedor.getRuc());
                txtRSocial.setText(oproveedor.getRazonsocial());
                txtDir.setText(oproveedor.getDireccion());
                cboDepartamento.setSelectedItem(oproveedor.getDepartamento());
                cboProvincia.setSelectedItem(oproveedor.getProvincia());
                cboDistrito.setSelectedItem(oproveedor.getDistrito());
                txtTelef.setText(oproveedor.getTelefono());
                txtCel.setText(oproveedor.getCelular());
                txtEmail.setText(oproveedor.getEmail());
                cboEstado.setSelectedItem(oproveedor.getEstado());
            }
        }        
        activarbotones(true, true, true);        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cboDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDepartamentoActionPerformed
        // TODO add your handling code here:        
        if (cboDepartamento.getSelectedItem() != null) {
            cargarProvincias(cboDepartamento.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cboDepartamentoActionPerformed

    private void cboProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProvinciaActionPerformed
        // TODO add your handling code here:
        if (cboProvincia.getSelectedItem() != null) {
            cargarDistritos(cboProvincia.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cboProvinciaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        String men = "";
        if (oProveedorBL.eliminarProveedor(txtRUC.getText()) == 1) {
            men = "Registro Eliminado";
        } else {
            men = "No se puede eliminar";
        }
        JOptionPane.showMessageDialog(this, men);
        listar();
        activarbotones(false, true, false);
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        FrmPrincipal frmPrincipal = new FrmPrincipal(perfilUsuario);
        frmPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmProveedor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProveedor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProveedor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProveedor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cboDepartamento;
    private javax.swing.JComboBox<String> cboDistrito;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLista;
    private javax.swing.JTextField txtCel;
    private javax.swing.JTextField txtDir;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtRSocial;
    private javax.swing.JTextField txtRUC;
    private javax.swing.JTextField txtTelef;
    // End of variables declaration//GEN-END:variables
}
