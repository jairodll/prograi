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
public class ModificarrecursoController implements Initializable {

    @FXML
    private Button btnconsltorg;
    @FXML
    private Button btncancelorg;
    @FXML
    private Button btnnewconsultaorg;
    @FXML
    private Button btnmodifyorg;
    @FXML
    private TextField txtrecurso;
    @FXML
    private TextField txtnamerecurso;
    @FXML
    private TextField txtrecap;
    @FXML
    private TextField txtrecon;
    @FXML
    private TextField txttime;
    @FXML
    private TextField txtcost;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public static String idrecurso;
    @FXML
    private void btnconsltorg(ActionEvent event) {
        idrecurso = txtrecurso.getText().trim();
        try {
            txtrecurso.setEditable(false);
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select nombrerecurso, requierea, requierec, tiempomaxuso, "
            + "costo FROM recurso where idrecurso ='"+idrecurso +"'");
            ResultSet rs = pst.executeQuery(); 
            if(rs.next()){
                txtnamerecurso.setText(rs.getString(1));
                txtrecap.setText(rs.getString(2));
                txtrecon.setText(rs.getString(3));
                txttime.setText(rs.getString(4));
                txtcost.setText(rs.getString(5));
            }else{
                JOptionPane.showMessageDialog(null, "El registro no existe, intente de nuevo");
                txtnamerecurso.setText("");
                txtnamerecurso.setEditable(true);
            }
        } catch (SQLException e) {
            Logger.getLogger(ModificaruserController.class.getName()).log(Level.SEVERE, null, e);
             JOptionPane.showMessageDialog(null, "No existe el registro en la tabla. Intente de nuevo"+e);
             txtnamerecurso.setText("");
             txtrecap.setText("");
             txtrecon.setText("");
             txttime.setText("");
             txtcost.setText("");
             txtrecurso.setEditable(true);
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
        txtrecurso.setText("");
        txtnamerecurso.setText("");
        txtrecap.setText("");
        txtrecon.setText("");
        txttime.setText("");
        txtcost.setText("");
        
        txtrecurso.setEditable(true);
        txtnamerecurso.setEditable(true);
        txtrecap.setEditable(true);
        txtrecon.setEditable(true);
        txttime.setEditable(true);
        txtcost.setEditable(true);
    }

    @FXML
    private void modifyorg(ActionEvent event) {
    try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "update recurso SET nombrerecurso= ?, requierea= ?, requierec= ?"
                    + ",tiempomaxuso= ?, costo= ? where idrecurso ='"+idrecurso +"'"); 
                        pst.setString(1, txtnamerecurso.getText());
                        pst.setString(2, txtrecap.getText());
                        pst.setString(3, txtrecon.getText());
                        pst.setString(4, txttime.getText());
                        pst.setString(5, txtcost.getText());
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Registros guardados");
                        txtnamerecurso.setEditable(false);
                        txtrecap.setEditable(false);
                        txtrecon.setEditable(false);
                        txttime.setEditable(false);
                        txtcost.setEditable(false);                        
                        
        } catch (SQLException e) {
            Logger.getLogger(ModificaruserController.class.getName()).log(Level.SEVERE, null, e);
             JOptionPane.showMessageDialog(null, "No se pudo modificar el registro"+e);
        }
    }
    
}
