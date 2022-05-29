/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.conexion;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jairo de León
 */
public class CrearusuarioController implements Initializable {
    

    @FXML
    private TextField txtcode;
    @FXML
    private TextField txtnombreusuario;
    @FXML
    private PasswordField txtcontrasena;
    @FXML
    private TextField txtnombre;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txttelefono;
    @FXML
    private TextField txtdireccion;
    @FXML
    private TextField txtstatus;
    @FXML
    private Button btnagregar;
    @FXML
    private Button btncancelar;
    @FXML
    private TextField txtusuario;
    
    String user;
    
    public CrearusuarioController(){
    user = LoginController.user;
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void agregar(ActionEvent event) {
        
        int validacion= 0;
        String codigouser, tipouser, username, contrasena, name, email, tel, direccion, status;
        
        codigouser = txtcode.getText().trim();
        tipouser = txtusuario.getText().trim();
        username = txtnombreusuario.getText().trim();
        contrasena = txtcontrasena.getText().trim();
        name = txtnombre.getText().trim();
        email = txtemail.getText().trim();
        tel = txttelefono.getText().trim();
        direccion = txtdireccion.getText().trim();
        status = txtstatus.getText().trim();
    
        if(codigouser.equals("")){ 
           validacion++;
        }
        if(tipouser.equals("")){ 
           validacion++;
        }
        if(username.equals("")){ 
           validacion++;
        }
        if(contrasena.equals("")){ 
           validacion++;
        }
        if(email.equals("")){ 
           validacion++;
        }
        if(tel.equals("")){ 
           validacion++;
        }
        if(direccion.equals("")){ 
           validacion++;
        }
        if(status.equals("")){ 
           validacion++;
        }
    
        try {
        Connection cn = conexion.conectar();
        PreparedStatement pst = cn.prepareStatement(
            "select idpersona from usuario where idpersona ='" + codigouser + "'");
        ResultSet rs = pst.executeQuery();
        
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Codigo de usuario no disponible!!");
                txtcode.setEditable(true);
                txtcode.setText("");
                txtusuario.setText("");
                txtnombreusuario.setText("");
                txtcontrasena.setText("");
                txtemail.setText("");
                txtemail.setText("");
                txtnombre.setText("");
                txttelefono.setText("");
                txtdireccion.setText("");
                txtstatus.setText("");
                
                cn.close();
            } else {
                if (validacion == 0) {
                    try {
                        Connection cn2 = conexion.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement(
                            "insert into usuario values (?,?,?,?,?,?,?,?,?)");
                        pst2.setInt(1, 0);
                        pst2.setString(2, tipouser);
                        pst2.setString(3, username);
                        pst2.setString(4, contrasena);
                        pst2.setString(5, name);
                        pst2.setString(6, email);
                        pst2.setString(7, tel);
                        pst2.setString(8, direccion);
                        pst2.setString(9, "Activo");
                        
                        pst2.executeUpdate();
                        cn2.close();
                        
                        limpiar();
                        JOptionPane.showMessageDialog(null, "Registro Exitoso!!");
                        Stage myStage = (Stage) this.btnagregar.getScene().getWindow();
                        myStage.close();
                
                        
                    } catch (Exception e) {
                        System.err.println("Error en registrar usuario "+e);
                        JOptionPane.showMessageDialog(null, "Error, comuniquese con su programador");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos.");
                }
            }
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error, contacte a su administrador");
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
            txtusuario.setText("");
            txtnombreusuario.setText("");
            txtcontrasena.setText("");
            txtnombre.setText("");
            txtemail.setText("");
            txttelefono.setText("");
            txtdireccion.setText("");
            txtstatus.setText("");
    }
}
    

 