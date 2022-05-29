/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Jairo de León
 */
public class RecursoController implements Initializable {

    @FXML
    private ComboBox<String> combobx;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> options = 
    FXCollections.observableArrayList(
        "Administrador",
        "Usuario Sistema",
        "Option 3"
    );
    combobx = new ComboBox(options);
    }    

    @FXML
    private void listadoadmins(ActionEvent event) {
    }
    
}
