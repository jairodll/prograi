/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import util.conexion;
/**
 * FXML Controller class
 *
 * @author Jairo de León
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtuser;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private Button btnlogin;

    
    public static String user = "";
    String pass = ""; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ingresar(ActionEvent event) throws IOException {
   
    user = txtuser.getText().trim();
    pass = txtpassword.getText().trim();
    
    if(!user.equals("") || !pass.equals("")){
        
        try{
            
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
              "select tipousuario, status from usuario where nombreusuario ='"+user
                      +"' and contrasena = '"+pass +"'");
                      
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
            
                String tipousuario = rs.getString("tipousuario");
                String status = rs.getString("status");
                
                if(tipousuario.equalsIgnoreCase("Administrador") && status.equalsIgnoreCase("Activo")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Exito");
                alert.setContentText("Login correcto");
                alert.showAndWait();

                // carga la vista
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/administrador.fxml"));

                // Cargo el padre
                Parent root = loader.load();

                // Creo la scene
                Scene scene = new Scene(root);
                
                // Creo la stage
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Administrador");
                stage.show();
                
                // Cierro la ventana
                Stage myStage = (Stage) this.btnlogin.getScene().getWindow();
                myStage.close();
                
                
                }else if(tipousuario.equalsIgnoreCase("Usuario Sistema") && status.equalsIgnoreCase("Activo")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Exito");
                alert.setContentText("Login correcto");
                alert.showAndWait();

                // carga la vista
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/usersistema.fxml"));

                // Cargo el padre
                Parent root = loader.load();

                // Creo la scene
                Scene scene = new Scene(root);
                
                // Creo la stage
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Usuario Sistema");
                stage.show();
                
                // Cierro la ventana
                Stage myStage = (Stage) this.btnlogin.getScene().getWindow();
                myStage.close();
                }
                
            }else{
            JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos");
            txtuser.setText("");
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en el botón acceder. "+e);
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión, comuniquese con su programador");
        }
        
    }else{
        JOptionPane.showMessageDialog(null, "Debes llenar todos los datos!!");

}
    
}
    
}
