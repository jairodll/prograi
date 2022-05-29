/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Jairo de León
 */
public class main extends Application {
    
   @Override
    public void start(Stage primaryStage) {

        try {
            // Cargo la ventana inicial
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(main.class.getResource("/vista/login.fxml"));

            // Ventana a cargar
            Pane ventana = (Pane) loader.load();

            // Creo la escena
            Scene scene = new Scene(ventana);

            // Modifico el stage
            primaryStage.setScene(scene);
            primaryStage.setTitle("Login");
            
            // Muestro la ventana
            primaryStage.show();

        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
