/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ModificaruserController implements Initializable {

    @FXML
    private TextField txtcode;
    @FXML
    private TextField txtuser;
    @FXML
    private TextField txtusername;
    @FXML
    private TextField txtpassword;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txttel;
    @FXML
    private TextField txtaddress;
    @FXML
    private Button btnmodify;
    @FXML
    private Button btncancel;
    @FXML
    private Button btnconslt;
    @FXML
    private Button btnnewconsulta;
    /**
     * Initializes the controller class.
     */
          
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public static String idpersona; 
    @FXML
    
    private void btnconslt(ActionEvent event) throws IOException, SQLException {
    idpersona = txtcode.getText().trim();
        try {
            txtcode.setEditable(false);
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select tipousuario, nombreusuario, contrasena, nombrecompleto, "
            + "correoelectronico, telefono, direccion FROM usuario where idpersona ='"+idpersona +"'");
            ResultSet rs = pst.executeQuery(); 
            if(rs.next()){
                txtuser.setText(rs.getString(1));
                txtusername.setText(rs.getString(2));
                txtpassword.setText(rs.getString(3));
                txtname.setText(rs.getString(4));
                txtemail.setText(rs.getString(5));
                txttel.setText(rs.getString(6));
                txtaddress.setText(rs.getString(7));
            }else{
                JOptionPane.showMessageDialog(null, "El registro no existe, intente de nuevo");
                txtcode.setText("");
                txtcode.setEditable(true);
            }
        } catch (SQLException e) {
            Logger.getLogger(ModificaruserController.class.getName()).log(Level.SEVERE, null, e);
             JOptionPane.showMessageDialog(null, "No existe el registro en la tabla. Intente de nuevo");
             txtcode.setText("");
             txtcode.setEditable(true);
        }
    }

              
    @FXML
    private void cancelar(ActionEvent event){
        // Cierro la ventana
        Stage myStage = (Stage) this.btncancel.getScene().getWindow();
        myStage.close(); 
    }  

    @FXML
    private void consulta(ActionEvent event) {
        txtcode.setEditable(true);
        txtcode.setText("");
        txtuser.setText("");
        txtusername.setText("");
        txtpassword.setText("");
        txtname.setText("");
        txtemail.setText("");
        txttel.setText("");
        txtaddress.setText("");
        
        txtcode.setEditable(true);
        txtuser.setEditable(true);
        txtusername.setEditable(true);
        txtpassword.setEditable(true);
        txtname.setEditable(true);
        txttel.setEditable(true);
        txtaddress.setEditable(true);
  
    }

    @FXML
    private void modify(ActionEvent event) throws SQLException {
        
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "update usuario SET tipousuario= ?, nombreusuario= ?, "
                    + "contrasena= ?, nombrecompleto = ?, correoelectronico = ?, "
                    + "telefono = ?, direccion = ? where idpersona ='"+idpersona +"'"); 
                        pst.setString(1, txtuser.getText());
                        pst.setString(2, txtusername.getText());
                        pst.setString(3, txtpassword.getText());
                        pst.setString(4, txtname.getText());
                        pst.setString(5, txtemail.getText());
                        pst.setString(6, txttel.getText());
                        pst.setString(7, txtaddress.getText());
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Registros guardados");
                        txtcode.setEditable(false);
                        txtuser.setEditable(false);
                        txtusername.setEditable(false);
                        txtpassword.setEditable(false);
                        txtname.setEditable(false);
                        txttel.setEditable(false);
                        txtemail.setEditable(false);
                        txtaddress.setEditable(false);
                        
                        
        } catch (SQLException e) {
            Logger.getLogger(ModificaruserController.class.getName()).log(Level.SEVERE, null, e);
             JOptionPane.showMessageDialog(null, "No se pudo modificar el registro"+e);
        }
    }        
}

