/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jairo de León
 */
public class AdministradorController implements Initializable {

    @FXML
    private MenuBar menu;
    @FXML
    private Menu usuarios;
    @FXML
    private MenuItem crearusuario;
    @FXML
    private MenuItem modificaruser;
    @FXML
    private MenuItem inrecurso;
    @FXML
    private MenuItem inactivaruser;
    @FXML
    private MenuItem crearorg;
    @FXML
    private MenuItem modificarorg;
    @FXML
    private MenuItem btncrearecurso;
    @FXML
    private MenuItem btnactrecursos;
    @FXML
    private MenuItem inact;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void crearu(ActionEvent event) {
          
    try {
            // carga la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/crearusuario.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Creo la scene
            Scene scene = new Scene(root);

            // Creo la stage
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Crear usuario");
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    @FXML
    private void modificaru(ActionEvent event) {
        try {
            // carga la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/modificaruser.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Creo la scene
            Scene scene = new Scene(root);

            // Creo la stage
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Modificar Usuario");
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en el botón acceder. "+ex);
        }
        
    }

    @FXML
    private void recurso(ActionEvent event) {
        try {
            // carga la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/actinrecurso.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Creo la scene
            Scene scene = new Scene(root);

            // Creo la stage
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Modificar Usuario");
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en el botón acceder. "+ex);
        }
    }

    @FXML
    private void inact(ActionEvent event) {
        try {
            // carga la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Actinuser.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Creo la scene
            Scene scene = new Scene(root);

            // Creo la stage
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Activar/Inactivar Usuario");
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en el botón acceder. "+ex);
        }
    }

    @FXML
    private void orgcrea(ActionEvent event) {
        try {
            // carga la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/crearorganizacion.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Creo la scene
            Scene scene = new Scene(root);

            // Creo la stage
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Crear Organizacion");
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void orgmodify(ActionEvent event) {
        try {
            // carga la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/modificarorg.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Creo la scene
            Scene scene = new Scene(root);

            // Creo la stage
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Modificar Usuario");
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void crearec(ActionEvent event) {
        try {
            // carga la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/gestionarecurso.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Creo la scene
            Scene scene = new Scene(root);

            // Creo la stage
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Gestionar Recurso");
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void actrecursos(ActionEvent event){
        try {
            // carga la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/modificarrecurso.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Creo la scene
            Scene scene = new Scene(root);

            // Creo la stage
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Modificar Recurso");
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @FXML
    private void inactorg(ActionEvent event) {
        try {
            // carga la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/actinorg.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Creo la scene
            Scene scene = new Scene(root);

            // Creo la stage
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Activar/Inactivar Organizacion");
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
