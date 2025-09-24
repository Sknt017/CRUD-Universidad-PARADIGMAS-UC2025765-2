package Crud.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author dasan
 */
public class conexionDB {
    Connection conectar = null;
    //(1) crear cadena de conexion
    String cadena = "jdbc:sqlite:Estudiantes.db";
    //(2) crear metodo de conexion
    public Connection conectar(){
        try{
            Class.forName("org.sqlite.JDBC");//establecer conexion con la libreria sqlite-jdbc
            //Abrir la conexion
            conectar = DriverManager.getConnection(cadena);
            JOptionPane.showMessageDialog(null, "¡Conexion exitosa!");
            System.out.println("conexion abierta");
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, "Error!! La conexion no fue exitosa: "+e.getMessage());
            System.out.println("Error!! La conexion no fue exitosa: "+e);
        };
        return conectar;
    }
    public void desconectar(){
        try{
            if(conectar != null){
                conectar.close();
                //JOptionPane.showMessageDialog(null, "conexion cerrada");
                System.out.println("se cerro la conexion");
            }
        }catch (Exception e){
            //JOptionPane.showMessageDialog(null, "la conexion no se cerro: " + e.getMessage());
            System.out.println("error en la conexion"+e.getMessage());
        }
    }
}