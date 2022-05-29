/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import util.conexion;

/**
 * FXML Controller class
 *
 * @author Jairo de León
 */
public class CrearorganizacionController implements Initializable {

    @FXML
    private TextField txtcode;
    @FXML
    private TextField txtdireccion;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtstatus;
    @FXML
    private Button btnagregar;
    @FXML
    private Button btncancelar;
    @FXML
    private TextField txtorganizacion;
    @FXML
    private TextField txttelefono;

    /**
     * Initializes the controller class.
     */
    
    String user;
    public CrearorganizacionController(){
    user = LoginController.user;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void agregar(ActionEvent event) {
        
        int validacion= 0;
        String codeorganzacion, organizacion, direccion, email, status;
        
        
        codeorganzacion = txtcode.getText().trim();
        organizacion = txtorganizacion.getText().trim();
        direccion = txtdireccion.getText().trim();
        email = txtemail.getText().trim();
        status = txtstatus.getText().trim();
    
        if(codeorganzacion.equals("")){ 
           validacion++;
        }
        if(organizacion.equals("")){ 
           validacion++;
           
        }if(direccion.equals("")){ 
           validacion++;
        }
        if(email.equals("")){ 
           validacion++;
        }
        if(status.equals("")){ 
           validacion++;
        }
        try {
        Connection cn = conexion.conectar();
        PreparedStatement pst = cn.prepareStatement(
            "select idorganizacion from organizacion where idorganizacion ='" + codeorganzacion + "'");
        ResultSet rs = pst.executeQuery();
        
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Codigo de usuario no disponible!!");
                txtcode.setEditable(true);
                txtcode.setText("");
                txtorganizacion.setText("");
                txtdireccion.setText("");
                txttelefono.setText("");
                txtemail.setText("");
                txtstatus.setText("");
                cn.close();
            } else {
                if (validacion == 0) {
                    try {
                        Connection cn2 = conexion.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement(
                            "insert into organizacion values (?,?,?,?,?,?)");
                        pst2.setInt(1, 0);
                        pst2.setString(2, organizacion);
                        pst2.setString(3, direccion);
                        pst2.setString(4, email);
                        pst2.setString(5, email);
                        pst2.setString(6, "Activo");
                        
                        pst2.executeUpdate();
                        cn2.close();
                        
                        limpiar();
                        JOptionPane.showMessageDialog(null, "Registro Exitoso!!");
                        Stage myStage = (Stage) this.btnagregar.getScene().getWindow();
                        myStage.close();
                
                        
                    } catch (Exception e) {
                        System.err.println("Error en registrar usuario "+e);
                        JOptionPane.showMessageDialog(null, "Error, comuniquese con su programador"+e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos.");
                }
            }
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error, contacte a su administrador"+e);
        }   
    }

    @FXML
    private void cancelar(ActionEvent event) {
        
             
         // Cierro la ventana
        Stage myStage = (Stage) this.btncancelar.getScene().getWindow();
        myStage.close();
   
    }
 
    
     public void limpiar(){
            txtcode.setText("");
            txtorganizacion.setText("");
            txtemail.setText("");
            txttelefono.setText("");
            txtdireccion.setText("");
            txtstatus.setText("");
    }
}
