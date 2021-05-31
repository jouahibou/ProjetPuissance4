/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puissance4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.scene.image.Image;

/**
 *
 * @author Lenovo
 */
public class ProjetPuissance4 extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("interfaceAcceuil.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.getIcons().add(new Image("Ucad.jpg"));
        
        
        
        
      
       
       
        
     
    }

    /**
     *jouahibou
     */
    public static void main(String[] args) {
        launch(args);
    
        
    }
    
}
