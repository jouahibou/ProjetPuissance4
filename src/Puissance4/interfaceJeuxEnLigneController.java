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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class interfaceJeuxEnLigneController implements Initializable {

    public void onLineButton5Action (ActionEvent event) throws IOException {
         try{
             
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
             //fxmlLoader.setController(this
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage= (Stage)( (Node) (event.getSource())).getScene().getWindow();
            stage.setScene(new Scene(root1));
            stage.show();  
    
    }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     public void onLineButton6Action (ActionEvent event) throws IOException {
          try{
     
    
    }catch(Exception e){
            e.printStackTrace();
        }
     }
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
