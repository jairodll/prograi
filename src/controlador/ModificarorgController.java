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
public class ModificarorgController implements Initializable {

    @FXML
    private Button btnconsltorg;
    @FXML
    private Button btncancelorg;
    @FXML
    private Button btnnewconsultaorg;
    @FXML
    private Button btnmodifyorg;
    @FXML
    private TextField txtorg;
    @FXML
    private TextField txtorganizacion;
    @FXML
    private TextField txtdireccion;
    @FXML
    private TextField txttelefono;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtstatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public static String idorganizacion;
    @FXML
    private void btnconsltorg(ActionEvent event) {
    idorganizacion = txtorg.getText().trim();
        try {
            txtorg.setEditable(false);
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select nombreorganizacion, direccion, telefono, email, "
            + "estado FROM organizacion where idorganizacion ='"+idorganizacion +"'");
            ResultSet rs = pst.executeQuery(); 
            if(rs.next()){
                txtorganizacion.setText(rs.getString(1));
                txtdireccion.setText(rs.getString(2));
                txttelefono.setText(rs.getString(3));
                txtemail.setText(rs.getString(4));
                txtstatus.setText(rs.getString(5));
            }else{
                JOptionPane.showMessageDialog(null, "El registro no existe, intente de nuevo");
                txtorg.setText("");
                txtorg.setEditable(true);
            }
        } catch (SQLException e) {
            Logger.getLogger(ModificaruserController.class.getName()).log(Level.SEVERE, null, e);
             JOptionPane.showMessageDialog(null, "No existe el registro en la tabla. Intente de nuevo"+e);
             txtorg.setText("");
             txtorg.setText("");
                txtorg.setEditable(true);
        }
    }

    @FXML
    private void cancelarorg(ActionEvent event) {
        
         // Cierro la ventana
        Stage myStage = (Stage) this.btncancelorg.getScene().getWindow();
        myStage.close();
    }

    @FXML
    private void consultaorg(ActionEvent event) {
        txtorg.setText("");
        txtorganizacion.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
        txtemail.setText("");
        txtstatus.setText("");
        
        txtorg.setEditable(true);
        txtorganizacion.setEditable(true);
        txtdireccion.setEditable(true);
        txttelefono.setEditable(true);
        txtemail.setEditable(true);
        txtstatus.setEditable(true);
        }
    
     
    @FXML
    private void modifyorg(ActionEvent event) {
        
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "update organizacion SET nombreorganizacion= ?, direccion= ?, telefono= ?"
                    + ",email= ?, estado= ? where idorganizacion ='"+idorganizacion +"'"); 
                        pst.setString(1, txtorganizacion.getText());
                        pst.setString(2, txtdireccion.getText());
                        pst.setString(3, txttelefono.getText());
                        pst.setString(4, txtemail.getText());
                        pst.setString(5, txtstatus.getText());
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Registros guardados");
                        txtorg.setEditable(false);
                        txtorganizacion.setEditable(false);
                        txtdireccion.setEditable(false);
                        txttelefono.setEditable(false);
                        txtemail.setEditable(false);
                        txtstatus.setEditable(false);                        
                        
        } catch (SQLException e) {
            Logger.getLogger(ModificaruserController.class.getName()).log(Level.SEVERE, null, e);
             JOptionPane.showMessageDialog(null, "No se pudo modificar el registro"+e);
        }
    }  
    
    
}
