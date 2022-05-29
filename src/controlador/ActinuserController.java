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
public class ActinuserController implements Initializable {

    @FXML
    private TextField txtcode;
    @FXML
    private TextField txtuser;
    @FXML
    private Button btncancel;
    @FXML
    private Button btnnewconsulta;
    @FXML
    private Button btnmodify;
    @FXML
    private TextField txtstatus;
    @FXML
    private Button btnnew;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public static String idpersona;    
    @FXML
    private void cancelar(ActionEvent event) {
        // Cierro la ventana
        Stage myStage = (Stage) this.btncancel.getScene().getWindow();
        myStage.close();
    }

    @FXML
    private void consulta(ActionEvent event) {
        idpersona = txtcode.getText().trim();
        try {
            txtcode.setEditable(false);
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select nombreusuario, status FROM usuario where idpersona ='"+idpersona +"'");
            ResultSet rs = pst.executeQuery(); 
            if(rs.next()){
                txtuser.setText(rs.getString(1));
                txtstatus.setText(rs.getString(2));
                txtuser.setEditable(false);
            }else{
                JOptionPane.showMessageDialog(null, "El registro no existe, intente de nuevo");
                txtuser.setText("");
                txtcode.setText("");
                txtcode.setEditable(true);
                txtstatus.setEditable(true);
                txtuser.setEditable(true);
            }
        } catch (SQLException e) {
            Logger.getLogger(ModificaruserController.class.getName()).log(Level.SEVERE, null, e);
             JOptionPane.showMessageDialog(null, "No existe el registro en la tabla. Intente de nuevo");
             txtcode.setText("");
             txtcode.setEditable(true);
        }
    
    }

    @FXML
    private void modify(ActionEvent event) {
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "update usuario SET status= ? where idpersona ='"+idpersona +"'"); 
                        pst.setString(1, txtstatus.getText());
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Registros guardados");
                        txtstatus.setEditable(false);
                        
                        
        } catch (SQLException e) {
            Logger.getLogger(ModificaruserController.class.getName()).log(Level.SEVERE, null, e);
             JOptionPane.showMessageDialog(null, "No se pudo modificar el registro"+e);
        }
    }

    @FXML
    private void actnew(ActionEvent event) {
        
        txtcode.setEditable(true);
        txtcode.setText("");
        txtuser.setEditable(true);
        txtuser.setText("");
        txtuser.setEditable(true);
        txtstatus.setEditable(true);
        txtstatus.setText("");
    }
    
}
