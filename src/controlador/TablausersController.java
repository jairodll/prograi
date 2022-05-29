/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.LoginController.user;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import util.conexion;

/**
 * FXML Controller class
 *
 * @author Jairo de León
 */
public class TablausersController implements Initializable {

    @FXML
    private TableColumn<?, ?> coltipouser;
    @FXML
    private TableColumn<?, ?> colusername;
    @FXML
    private TableColumn<?, ?> colpass;
    @FXML
    private TableColumn<?, ?> colname;
    @FXML
    private TableColumn<?, ?> colemail;
    @FXML
    private TableColumn<?, ?> coltel;
    @FXML
    private TableColumn<?, ?> coladdress;
    @FXML
    private TableView<?> tableuserss;
    

        public TablausersController(){
            try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "Select tipousuario, nombreusuario, contrasena, nombrecompleto, correoelectronico, telefono, direccion FROM usuario");
            ResultSet rs = pst.executeQuery();
            tableuserss = new TableView();
        } catch (SQLException e) {
            Logger.getLogger(TablausersController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
