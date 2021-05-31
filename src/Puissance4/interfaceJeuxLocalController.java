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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * jouahibou 
 */
public class interfaceJeuxLocalController implements Initializable {
    
   
    @FXML
    private TextField joueur1;
    @FXML
    private TextField joueur2;
    
    public static  String player_name1 ;
    public static String player_name2;
    

    public void onLineButton2Action (ActionEvent event) throws IOException { 
        
      
 
        
    
     try{
         String gamer1 =joueur1.getText();
        String gamer2   =joueur2.getText();
        
        
       Jeu jeu = new Jeu();
         
         Stage primaryStage = new Stage();
         
        
        jeu.joueur1=gamer1;
        jeu.joueur2= gamer2;
        
         player_name1=gamer1;
           player_name2 = gamer2;
         
          jeu.start(primaryStage);
          
          Stage secondStage= (Stage)( (Node) (event.getSource())).getScene().getWindow();
           secondStage.close();
          
          
            
           
            
           
            
        }catch(Exception e){
            e.printStackTrace();
        }
      
    }
     
    
     
    
    
    
     public void onLineButton3Action (ActionEvent event) throws IOException { 
    
    
     try{
           
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("interfaceAcceuil.fxml"));
            
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage= (Stage)( (Node) (event.getSource())).getScene().getWindow();
            stage.setScene(new Scene(root1));
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
