
package funciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionMYSQL {
    String contraseña=null;
    public Connection driver;
    public void Conectar(){
       
  

        
        contraseña=JOptionPane.showInputDialog(this,"Introduzca contraseña de MySQL");
        
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
                    driver=DriverManager.getConnection("jdbc:mysql://localhost:3306/biblosdb","root",contraseña); //Nombre de la base de datos,usuario,contraseña
                    if (driver!=null){
                //JOptionPane.showMessageDialog(null,"Conexión a base de datos lista");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No existe la base de datos"+ e);
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Falta libreria MySQL "+ex);
        }
    } 
    
}
