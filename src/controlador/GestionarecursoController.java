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
public class GestionarecursoController implements Initializable {

    @FXML
    private TextField txtcodere;
    @FXML
    private TextField txtnombrere;
    @FXML
    private TextField txtreca;
    @FXML
    private TextField txtreco;
    @FXML
    private TextField txttmaxuso;
    @FXML
    private TextField txtcosto;
    @FXML
    private Button btnagregar;
    @FXML
    private Button btncancelar;

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
        String nombre, nombrere, recaprobacion, reconfirmacion, tmaxuso, costo;
        
        nombre = txtcodere.getText().trim();
        nombrere = txtnombrere.getText().trim();
        recaprobacion = txtreca.getText().trim();
        reconfirmacion = txtreco.getText().trim();
        tmaxuso = txttmaxuso.getText().trim();
        costo = txtcosto.getText().trim();
        
        
        if(nombre.equals("")){ 
           validacion++;
        }
        if(nombrere.equals("")){ 
           validacion++;
        }
        if(recaprobacion.equals("")){ 
           validacion++;
        }
        if(reconfirmacion.equals("")){ 
           validacion++;
        }
        if(tmaxuso.equals("")){ 
           validacion++;
        }
        if(costo.equals("")){ 
           validacion++;
        }
        
        try {
        Connection cn = conexion.conectar();
        PreparedStatement pst = cn.prepareStatement(
            "select idrecurso from recurso where idrecurso ='" + nombre + "'");
        ResultSet rs = pst.executeQuery();
        
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Codigo de usuario no disponible!!");
                txtcodere.setEditable(true);
                txtcodere.setText("");
                txtnombrere.setText("");
                txtreca.setText("");
                txtreco.setText("");
                txttmaxuso.setText("");
                txtcosto.setText("");
                
                cn.close();
            } else {
                if (validacion == 0) {
                    try {
                        Connection cn2 = conexion.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement(
                            "insert into recurso values (?,?,?,?,?,?)");
                        pst2.setInt(1, 0);
                        pst2.setString(2, nombrere);
                        pst2.setString(3, recaprobacion);
                        pst2.setString(4, reconfirmacion);
                        pst2.setString(5, tmaxuso);
                        pst2.setString(6, costo);                       
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
        txtcodere.setText("");
        txtnombrere.setText("");
        txtreca.setText("");
        txtreco.setText("");
        txttmaxuso.setText("");
        txtcosto.setText("");
    }
    
}
