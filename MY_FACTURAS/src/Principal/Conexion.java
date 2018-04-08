/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import static java.awt.SystemColor.text;
import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexion {
    
    private Connection conector=null;
    //private String BD="C:/Users/Miguel Angel/Desktop/Clientes/Escondite/MASTERYIELD.FDB";
    //private String BD="C:/ProgramData/MasterYield/Data/MASTERYIELD.FDB"; // Ap. Temporales
    private String BD="F:/Base de datos Masteryield/Data/MASTERYIELD.FDB";
    private String user="SYSDBA";
    private String pass="masterkey";
    private PreparedStatement pst;
    private ResultSet rs;
    ArrayList <String> series;
    
    String bookingno, invoiceno, invoiceserie, amount, date;
    String sentencia;
    String estado;
    
    FileWriter file;
    
    
    public Conexion(){
        try{
            Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();
            conectar();
            estado="Conectado ";
        }catch(Exception e){
            
        }
    } 
    
    public void consultaFac(String numero, String serie){
        sentencia="SELECT inv.BOOKINGNO, inv.INVOICENO, inv.INVOICESERIE, inv.AMOUNT, invn.identification, inv.INVOICEDATE FROM INVOICES inv\n" +
                    "left join invoices_num invn\n" +
                    "on inv.invoiceserie=invn.serialno\n" +
                    "WHERE INVOICENO="+numero+" and IDENTIFICATION='"+serie+"'";
        try{
            
            pst=conector.prepareStatement(sentencia);
            rs=pst.executeQuery();
            
            if(rs.next()==false){
                JOptionPane.showMessageDialog(null,"ESTA FACTURA NO EXISTE\n ");
                bookingno="";
                invoiceno="";
                invoiceserie="";
                amount="";
                date="";
            }else{
                rs=pst.executeQuery();
                while(rs.next()){
                    bookingno=rs.getString("BOOKINGNO");
                    invoiceno=rs.getString("INVOICENO");
                    invoiceserie=rs.getString("INVOICESERIE");
                    amount=rs.getString("AMOUNT");
                    date=rs.getString("INVOICEDATE");
                }
                modificarLog(Integer.parseInt(numero),0,"",serie,"","", "buscar","","");
            }
            
            desconectar();
        }catch(Exception e){estado="Error en colsulta";     
        }
   
    }
    
    public void consultaFacturaSinSerie(String numero){
        sentencia="SELECT inv.BOOKINGNO, inv.INVOICENO, inv.INVOICESERIE, inv.AMOUNT, invn.identification, inv.INVOICEDATE FROM INVOICES inv\n" +
                    "left join invoices_num invn\n" +
                    "on inv.invoiceserie=invn.serialno\n" +
                    "WHERE INVOICENO="+numero;
        try{
            
            pst=conector.prepareStatement(sentencia);
            rs=pst.executeQuery();
            
            if(rs.next()==false){
                JOptionPane.showMessageDialog(null,"ESTA FACTURA NO EXISTE\n ");
                bookingno="";
                invoiceno="";
                invoiceserie="";
                amount="";
                date="";
            }else{
                rs=pst.executeQuery();
                while(rs.next()){
                    bookingno=rs.getString("BOOKINGNO");
                    invoiceno=rs.getString("INVOICENO");
                    invoiceserie=rs.getString("INVOICESERIE");
                    amount=rs.getString("AMOUNT");
                    date=rs.getString("INVOICEDATE");
                }
                modificarLog(Integer.parseInt(numero),0,"","","","", "buscar","","");
            }
            
            desconectar();
        }catch(Exception e){estado="Error en colsulta";     
        }
   
    }
    
    public void cargarSerie() {
        sentencia="SELECT IDENTIFICATION FROM INVOICES_NUM";
        series=new ArrayList<String>();
        
        try{
            pst=conector.prepareStatement(sentencia);
            rs=pst.executeQuery();
            while(rs.next()){ 
                String n=rs.getString("IDENTIFICATION");
                
                System.out.println(n);
                if(n!=null){series.add(n.trim());};     
            }
            desconectar();
        }catch(SQLException e){
            estado=e.getMessage();
        }
        
    }
    public void desconectar(){
        try{
            rs.close();
            pst.close();
    
        }catch(SQLException e){
            
        }
    }
      
    public void modificarFacturaNuevo(int numFactura, int numFacturaNuevo, int serie){
        sentencia="UPDATE INVOICES SET INVOICENO="+numFacturaNuevo+" WHERE INVOICENO="+numFactura+" AND INVOICESERIE="+serie;
        
        try{
            pst=conector.prepareStatement(sentencia);    
            int count=pst.executeUpdate();
            
            System.out.println("Update count: "+count);
            System.out.println(sentencia);
            estado="Factura modificada  ";
            modificarLog(numFacturaNuevo, numFactura, String.valueOf(serie), String.valueOf(serie),"","", "modificar numero","OLD", "NEW");
            desconectar();
        }catch(Exception e){
            
        }
    }
    
    public void modificarFacturaNuevoSinSerie(int numFactura, int numFacturaNuevo){
        sentencia="UPDATE INVOICES SET INVOICENO="+numFacturaNuevo+" WHERE INVOICENO="+numFactura;
        
        try{
            pst=conector.prepareStatement(sentencia);    
            int count=pst.executeUpdate();
            
            System.out.println("Update count: "+count);
            System.out.println(sentencia);
            estado="Factura modificada  ";
            modificarLog(numFacturaNuevo, numFactura, "", "","","", "modificar numero","OLD", "NEW");
            desconectar();
        }catch(Exception e){
            
        }
    }
    
    public void modificarSerieNuevo(int numFactura, int SerieN, int serie){
        sentencia="UPDATE INVOICES SET INVOICESERIE="+SerieN+" WHERE INVOICENO="+numFactura+" AND INVOICESERIE="+serie;
        
        try{
            pst=conector.prepareStatement(sentencia);
            int count=pst.executeUpdate();
            System.out.println("Registros actualizados: "+count);
            modificarLog(numFactura,numFactura,String.valueOf(serie),String.valueOf(SerieN),"","", "modificar serie","OLD","NEW");
            desconectar();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public void modificarFechaNuevo(int numFactura, String fechaNueva,String fechaAntigua, int serie){
        sentencia="UPDATE INVOICES SET INVOICEDATE='"+fechaNueva+"' WHERE INVOICENO="+numFactura+" AND INVOICESERIE="+serie;
        System.out.println(sentencia);
        try{
            pst=conector.prepareStatement(sentencia);
            
            int count=pst.executeUpdate();
            
            System.out.println("Registros actualizados: "+count);
            modificarLog(numFactura,0,String.valueOf(serie),"",fechaAntigua, fechaNueva,"modificar fecha","OLD","NEW");
            desconectar();
        }catch(Exception e){
            
        }
    }
    
    public void modificarFechaNuevoSinSerie(int numFactura, String fechaNueva,String fechaAntigua){
        sentencia="UPDATE INVOICES SET INVOICEDATE='"+fechaNueva+"' WHERE INVOICENO="+numFactura;
        System.out.println(sentencia);
        try{
            pst=conector.prepareStatement(sentencia);
            
            int count=pst.executeUpdate();
            
            System.out.println("Registros actualizados: "+count);
            modificarLog(numFactura,0,"","",fechaAntigua, fechaNueva,"modificar fecha","OLD","NEW");
            desconectar();
        }catch(Exception e){
            
        }
    }
    
    
    public int numSeriePasandoleLetra(String letra){
        sentencia="select serialno from invoices_num where identification='"+letra+"'";
        
        try{
            pst=conector.prepareStatement(sentencia);
            rs=pst.executeQuery();
            while(rs.next()){
                return rs.getInt("serialno");  
            }
            
            desconectar();
        }catch(Exception e){
            System.out.println(e);
        }
        return -1;
    }
    
    public void conectar() {
        try {
            conector=DriverManager.getConnection("jdbc:firebirdsql://localhost/" + BD,this.user,this.pass);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"EXISTE UN ERROR CON LA CONEXION");
        }
    }
    
    public void eliminarFactura(int numFactura, int serie){
       
        sentencia="update invoices set invoiceno=null, invoiceserie=null where invoiceno="+numFactura+" and invoiceserie="+serie;
        try{
            pst=conector.prepareStatement(sentencia);
            pst.executeUpdate();
            modificarLog(numFactura, 0,"","","","","","", "eliminar");
            desconectar();
            JOptionPane.showMessageDialog(null, "La facura ha sido eliminada");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar la factura");
        }
    }
    
    public void eliminarFacturaSinSerie(int numFactura){
       
        sentencia="update invoices set invoiceno=null, invoiceserie=null where invoiceno="+numFactura;
        try{
            pst=conector.prepareStatement(sentencia);
            pst.executeUpdate();
            modificarLog(numFactura, 0,"","","","","","", "eliminar");
            desconectar();
            JOptionPane.showMessageDialog(null, "La facura ha sido eliminada");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar la factura");
        }
    }
   
    public void modificarLog(int facturaVieja, int facturaNueva, String serieVieja, String serieNueva, String fechaVieja, String fechaNueva, String operacion, String old, String nuevo){
        try{
            if(new File("dist/log.txt").exists()==false)file=new FileWriter(new File("dist/log.txt"),false);
            file=new FileWriter(new File("dist/log.txt"),true);
            Calendar fechaActual=Calendar.getInstance();
            
            file.write((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
                  +"/"+String.valueOf(fechaActual.get(Calendar.MONTH)+1)
                  +"/"+String.valueOf(fechaActual.get(Calendar.YEAR))
                  +";"+String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
                  +":"+String.valueOf(fechaActual.get(Calendar.MINUTE))
                  +":"+String.valueOf(fechaActual.get(Calendar.SECOND)))+";"+operacion+";"+old+";"+serieVieja+";"+facturaVieja+";"+fechaVieja+";"
                  +nuevo+";"+serieNueva+";"+facturaNueva+";"+fechaNueva+"\r\n");
            
            file.close();
        }catch(Exception e){
            
        }
        
    }
    
   
    
    
}
