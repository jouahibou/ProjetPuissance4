/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puissance4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



/**
 *
 * @author Lenovo
 */
public class projetPuissance4Controller implements Initializable {
    @FXML AnchorPane apMain;
   
    

    
     public void handleButtonAction(ActionEvent event) throws IOException {
        try{
           
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfaceJeuxEnLocal.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage= (Stage)( (Node) (event.getSource())).getScene().getWindow();
            stage.setScene(new Scene(root1));
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
     } 
     public void onLineButton1Action(ActionEvent event) throws IOException {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfaceJeuxEnLigne.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage= (Stage)( (Node) (event.getSource())).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
     } 
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
