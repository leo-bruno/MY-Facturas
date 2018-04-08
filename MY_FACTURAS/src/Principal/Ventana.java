/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;


import com.toedter.calendar.JDateChooser;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Angel
 */

public class Ventana extends javax.swing.JFrame {
    Conexion con;
    String numFactura;
    String serie;
    String fecha;
    JDateChooser jFecha;
    int cont=0,x,y;
   
    public Ventana() {
        
        initComponents();
       
        this.setLocationRelativeTo(null);
        //AWTUtilities.setWindowOpaque(this, rootPaneCheckingEnabled);
        con=new Conexion();
        con.cargarSerie();
        
        
        try{
        while(con.series.get(cont)!=null){
            cbSerieN.addItem(con.series.get(cont));
            cbSerie.addItem(con.series.get(cont));
            cont++;
        }
        }catch(Exception e){
            
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbSerie = new javax.swing.JComboBox<>();
        lbNumero = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        lbReserva = new javax.swing.JLabel();
        tfReserva = new javax.swing.JTextField();
        lbFecha = new javax.swing.JLabel();
        tfFecha = new javax.swing.JTextField();
        lbFactura = new javax.swing.JLabel();
        tfFactura = new javax.swing.JTextField();
        rbFactura = new javax.swing.JRadioButton();
        lbSerieNew = new javax.swing.JLabel();
        cbSerieN = new javax.swing.JComboBox<>();
        rbSerie = new javax.swing.JRadioButton();
        lbFechaNueva = new javax.swing.JLabel();
        dcCalendario = new com.toedter.calendar.JDateChooser();
        rbFecha = new javax.swing.JRadioButton();
        btCancelar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        jbReset = new javax.swing.JButton();
        btBorrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Datos Factura");
        setBounds(new java.awt.Rectangle(0, 0, 480, 3));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(481, 450));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(481, 450));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(null);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Serie");
        jLabel2.setToolTipText("");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 40, 120, 10);

        cbSerie.setBorder(null);
        cbSerie.setOpaque(false);
        cbSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSerieActionPerformed(evt);
            }
        });
        jPanel1.add(cbSerie);
        cbSerie.setBounds(50, 60, 120, 20);

        lbNumero.setForeground(new java.awt.Color(255, 255, 255));
        lbNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNumero.setText("Factura");
        jPanel1.add(lbNumero);
        lbNumero.setBounds(190, 40, 120, 14);

        tfNumero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfNumero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfNumero.setBorder(null);
        tfNumero.setOpaque(false);
        tfNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumeroActionPerformed(evt);
            }
        });
        jPanel1.add(tfNumero);
        tfNumero.setBounds(200, 60, 100, 20);

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_ch_hov.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.setToolTipText("");
        jbBuscar.setBorder(null);
        jbBuscar.setBorderPainted(false);
        jbBuscar.setContentAreaFilled(false);
        jbBuscar.setFocusable(false);
        jbBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbBuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_ch.png"))); // NOI18N
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jbBuscar);
        jbBuscar.setBounds(360, 50, 90, 40);

        lbReserva.setForeground(new java.awt.Color(255, 255, 255));
        lbReserva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReserva.setText("Nº Reserva");
        jPanel1.add(lbReserva);
        lbReserva.setBounds(55, 110, 110, 14);

        tfReserva.setEditable(false);
        tfReserva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfReserva.setBorder(null);
        tfReserva.setOpaque(false);
        jPanel1.add(tfReserva);
        tfReserva.setBounds(60, 130, 100, 20);

        lbFecha.setForeground(new java.awt.Color(255, 255, 255));
        lbFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFecha.setText("Fecha");
        jPanel1.add(lbFecha);
        lbFecha.setBounds(190, 110, 120, 14);

        tfFecha.setEditable(false);
        tfFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tfFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfFecha.setBorder(null);
        tfFecha.setEnabled(false);
        tfFecha.setOpaque(false);
        jPanel1.add(tfFecha);
        tfFecha.setBounds(200, 130, 100, 20);

        lbFactura.setForeground(new java.awt.Color(255, 255, 255));
        lbFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFactura.setText("Nº Factura Nuevo");
        jPanel1.add(lbFactura);
        lbFactura.setBounds(50, 180, 110, 14);

        tfFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfFactura.setBorder(null);
        tfFactura.setOpaque(false);
        jPanel1.add(tfFactura);
        tfFactura.setBounds(60, 200, 100, 20);

        rbFactura.setBorder(null);
        rbFactura.setBorderPainted(true);
        rbFactura.setOpaque(false);
        rbFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFacturaActionPerformed(evt);
            }
        });
        jPanel1.add(rbFactura);
        rbFactura.setBounds(30, 200, 13, 13);

        lbSerieNew.setForeground(new java.awt.Color(255, 255, 255));
        lbSerieNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSerieNew.setText("Serie Nueva");
        jPanel1.add(lbSerieNew);
        lbSerieNew.setBounds(50, 240, 120, 14);

        jPanel1.add(cbSerieN);
        cbSerieN.setBounds(50, 260, 120, 20);

        rbSerie.setOpaque(false);
        rbSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSerieActionPerformed(evt);
            }
        });
        jPanel1.add(rbSerie);
        rbSerie.setBounds(20, 260, 21, 21);

        lbFechaNueva.setForeground(new java.awt.Color(255, 255, 255));
        lbFechaNueva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFechaNueva.setText("Fecha Nueva");
        jPanel1.add(lbFechaNueva);
        lbFechaNueva.setBounds(50, 300, 120, 14);

        dcCalendario.setDateFormatString("MM-dd-yyyy");
        dcCalendario.setOpaque(false);
        jPanel1.add(dcCalendario);
        dcCalendario.setBounds(50, 320, 120, 20);

        rbFecha.setOpaque(false);
        rbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFechaActionPerformed(evt);
            }
        });
        jPanel1.add(rbFecha);
        rbFecha.setBounds(20, 320, 21, 21);

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_ch_hov.png"))); // NOI18N
        btCancelar.setText("Cerrar");
        btCancelar.setBorder(null);
        btCancelar.setBorderPainted(false);
        btCancelar.setContentAreaFilled(false);
        btCancelar.setFocusable(false);
        btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_ch.png"))); // NOI18N
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar);
        btCancelar.setBounds(280, 310, 79, 27);

        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_ch_hov.png"))); // NOI18N
        btModificar.setText("Modificar");
        btModificar.setBorder(null);
        btModificar.setBorderPainted(false);
        btModificar.setContentAreaFilled(false);
        btModificar.setEnabled(false);
        btModificar.setFocusable(false);
        btModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btModificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_ch.png"))); // NOI18N
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btModificar);
        btModificar.setBounds(280, 190, 79, 30);

        jbReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_ch_hov.png"))); // NOI18N
        jbReset.setText("Reset");
        jbReset.setBorder(null);
        jbReset.setBorderPainted(false);
        jbReset.setContentAreaFilled(false);
        jbReset.setFocusable(false);
        jbReset.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbReset.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_ch.png"))); // NOI18N
        jbReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbResetActionPerformed(evt);
            }
        });
        jPanel1.add(jbReset);
        jbReset.setBounds(280, 270, 80, 30);

        btBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_ch_hov.png"))); // NOI18N
        btBorrar.setBorder(null);
        btBorrar.setBorderPainted(false);
        btBorrar.setContentAreaFilled(false);
        btBorrar.setFocusable(false);
        btBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btBorrar.setLabel("Eliminar");
        btBorrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_ch.png"))); // NOI18N
        btBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(btBorrar);
        btBorrar.setBounds(280, 230, 80, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/txt_med.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(190, 50, 120, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/txt_med.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(190, 130, 120, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/txt_med.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 130, 120, 20);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/txt_med.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 200, 119, 20);

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoAzulN.png"))); // NOI18N
        jPanel1.add(Fondo);
        Fondo.setBounds(0, 0, 481, 450);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFechaActionPerformed
        // TODO add your handling code here:
        if(rbFecha.isSelected()) btModificar.setEnabled(true);
        else btModificar.setEnabled(false);
    }//GEN-LAST:event_rbFechaActionPerformed

    private void rbSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSerieActionPerformed
        // TODO add your handling code here:
        if(rbSerie.isSelected()==true) btModificar.setEnabled(true);
        else btModificar.setEnabled(false);
    }//GEN-LAST:event_rbSerieActionPerformed

    private void rbFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFacturaActionPerformed
        // TODO add your handling code here:
        if(rbFactura.isSelected())btModificar.setEnabled(true);
        else btModificar.setEnabled(false);
    }//GEN-LAST:event_rbFacturaActionPerformed

    private void btBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBorrarActionPerformed
        // TODO add your handling code here:
        if(tfNumero.getText().isEmpty()==false){
            int nSerie=con.numSeriePasandoleLetra(String.valueOf(cbSerie.getSelectedItem()));
            if(cbSerie.getItemCount()==0)con.eliminarFacturaSinSerie(Integer.parseInt(tfNumero.getText()));
            else con.eliminarFactura(Integer.parseInt(tfNumero.getText()), nSerie);
        }else JOptionPane.showMessageDialog(null, "Faltan datos de la factura");
        
        limpiarCampos();
    }//GEN-LAST:event_btBorrarActionPerformed

    private void jbResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbResetActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_jbResetActionPerformed

    private void cbSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSerieActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        // TODO add your handling code here:
        
        if(tfNumero.getText().isEmpty()==false){
            
            if(rbFactura.isSelected()==true){
                int serie=con.numSeriePasandoleLetra(String.valueOf(cbSerie.getSelectedItem()));
                if(cbSerie.getItemCount()==0){
                    con.modificarFacturaNuevoSinSerie(Integer.parseInt(tfNumero.getText()), Integer.parseInt(tfFactura.getText()));
                }
                else con.modificarFacturaNuevo(Integer.parseInt(tfNumero.getText()), Integer.parseInt(tfFactura.getText()), serie);
                btModificar.setEnabled(false);
            }
            if(rbSerie.isSelected()==true){
                int serieOld=con.numSeriePasandoleLetra(String.valueOf(cbSerie.getSelectedItem()));
                System.out.println(serieOld);
                int serieNueva=con.numSeriePasandoleLetra(String.valueOf(cbSerieN.getSelectedItem()));
                con.modificarSerieNuevo(Integer.parseInt(tfNumero.getText()), serieNueva,serieOld);
                btModificar.setEnabled(false);
            }
            if(rbFecha.isSelected()==true){
                String formato=dcCalendario.getDateFormatString();
               
                System.out.println(formato);
                Date date=dcCalendario.getDate();
                SimpleDateFormat sdf=new SimpleDateFormat(formato);
                
                
                String fechaNueva=String.valueOf(sdf.format(date));
                
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date dateN;
                try {
                    dateN = (Date)formatter.parse(fechaNueva);
                } catch (ParseException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
                SimpleDateFormat newFormat = new SimpleDateFormat("MM-dd-yyyy");
                fecha = newFormat.format(date);
            
                int nSerie=con.numSeriePasandoleLetra(String.valueOf(cbSerie.getSelectedItem()));
                
                String fechaAntigua=tfFecha.getText();
                System.out.println(tfNumero.getText());
                System.out.println(fecha);
                System.out.println(fechaAntigua);
                System.out.println(nSerie);
                if(cbSerie.getItemCount()==0)con.modificarFechaNuevoSinSerie(Integer.parseInt(tfNumero.getText()),fecha, fechaAntigua);
                else con.modificarFechaNuevo(Integer.parseInt(tfNumero.getText()),fecha, fechaAntigua, nSerie);
                
               btModificar.setEnabled(false);
            }
            JOptionPane.showMessageDialog(null, "La facura ha sido modificada");
            limpiarCampos();
        }else JOptionPane.showMessageDialog(null, "Faltan datos de la factura");
        
        
    }//GEN-LAST:event_btModificarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
        numFactura=tfNumero.getText();
        serie=(String)cbSerie.getSelectedItem();
        System.out.println(cbSerie.getItemCount());
        System.out.println(numFactura);
        if(cbSerie.getItemCount()==0) con.consultaFacturaSinSerie(numFactura);   
        else con.consultaFac(numFactura,serie);

        tfReserva.setText(con.bookingno);

        
        try {
            
            
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date=(Date)formatter.parse(con.date);
            SimpleDateFormat newFormat = new SimpleDateFormat("MM-dd-yyyy");
            fecha = newFormat.format(date);

            System.out.println(fecha);
            
        } catch (ParseException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tfFecha.setText(fecha);

        tfFactura.setText(con.invoiceno);
        
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void tfNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNumeroActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_formMouseDragged

    public void limpiarCampos(){
        tfReserva.setText("");
        tfFactura.setText("");
        tfFecha.setText("");
        tfNumero.setText("");
        rbFactura.setSelected(false);
        rbFecha.setSelected(false);
        rbSerie.setSelected(false);
        cbSerie.setSelectedIndex(0);
        cbSerieN.setSelectedIndex(0);
        
        con.desconectar();
    }
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btBorrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btModificar;
    private javax.swing.JComboBox<String> cbSerie;
    private javax.swing.JComboBox<String> cbSerieN;
    private com.toedter.calendar.JDateChooser dcCalendario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbReset;
    private javax.swing.JLabel lbFactura;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbFechaNueva;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbReserva;
    private javax.swing.JLabel lbSerieNew;
    private javax.swing.JRadioButton rbFactura;
    private javax.swing.JRadioButton rbFecha;
    private javax.swing.JRadioButton rbSerie;
    private javax.swing.JTextField tfFactura;
    private javax.swing.JTextField tfFecha;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfReserva;
    // End of variables declaration//GEN-END:variables
}
