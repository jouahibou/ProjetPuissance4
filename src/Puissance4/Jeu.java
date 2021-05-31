/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puissance4;
import Puissance4.BouleDuJeux;
import javafx.scene.image.Image;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.When;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 *
 * @author Lenovo
 */
public class Jeu{
    private static int precedent;
    private static int nbTour;
    private BouleDuJeux[][] cases;
   
    

    
      
    
     String joueur1 = interfaceJeuxLocalController.player_name1;
    String joueur2 =  interfaceJeuxLocalController.player_name2;
    
                     
    

    public void start(Stage primaryStage) {
        
        
          
           
            
           
              
              
              
             
                  
                  
		try {
                      
                     
                      
                   
                    
                     
                         
                        

			int N = 4;
			//colonnes et lignes :
			int C = 7;
			int L = 6;

			
			
			//couleur de fond:
			Color couleurFond = Color.WHITE;
			
			
			Group root = new Group();
			Scene scene = new Scene(root,550,300 + 250);
			scene.setFill(couleurFond);
			
			//utile layouts:
			When w = Bindings.when((scene.widthProperty().divide(scene.heightProperty())).greaterThan(7.0/6.0));
			//grille:
			Rectangle r = new Rectangle(0, 0, 100, 100);
			LinearGradient lg = new LinearGradient(2,2,2,2, true, CycleMethod.NO_CYCLE, new Stop(0, Color.BLUE), new Stop(0.5, Color.rgb(0, 0, 100)), new Stop(1, Color.BLUE));
			r.setFill(lg);
			root.getChildren().addAll(r);
			
			r.heightProperty().bind(w.then(scene.heightProperty().subtract(100)).otherwise(r.widthProperty().multiply(6.0/7.0)));
			r.widthProperty().bind(w.then(r.heightProperty().multiply(7.0/6.0)).otherwise(scene.widthProperty()));
			
			for(int i = 0 ; i < L ; i++){
				for (int j = 0 ; j < C ; j++){
					Circle c = new Circle(5 +45 + 100*j, 5+45 + 100*i, 45);
					c.setFill(couleurFond);
					c.radiusProperty().bind(r.heightProperty().divide(12).subtract(5));
					c.centerXProperty().bind(r.widthProperty().divide(7).multiply(j+0.5));
					c.centerYProperty().bind(r.heightProperty().divide(6).multiply(i+0.5));
					root.getChildren().add(c);
				}
			}
                        
			
			
			//creation des cases:
			cases = new BouleDuJeux[7][6];
			
			
			for(int i = 0 ; i < L ; i++){
				for (int j = 0 ; j < C ; j++){
					cases[j][i] = new BouleDuJeux();
					cases[j][i].layoutXProperty().bind(r.widthProperty().divide(7).multiply(j));
					cases[j][i].layoutYProperty().bind(r.heightProperty().divide(6).multiply(i));
					cases[j][i].fitHeightProperty().bind(r.heightProperty().divide(6));
					cases[j][i].fitWidthProperty().bind(r.widthProperty().divide(7));


					root.getChildren().add(cases[j][i]);
				}
			}



			//textes:
			Label tour = new Label("Tour 1");
			tour.setTextFill(Color.BLACK);
			tour.setFont(Font.font("Cambria", scene.getHeight() / 20));
			tour.setLayoutX(0);
			tour.layoutYProperty().bind(r.heightProperty());
			
                        
                       
			
			Label joueur = new Label(joueur1+" à toi de jouer ");
			joueur.setTextFill(Color.BLACK);
			joueur.setFont(Font.font("Cambria", scene.getHeight() / 20));
			joueur.setLayoutX(150);
			joueur.layoutYProperty().bind(r.heightProperty());
			
			Label victoire = new Label("");
			victoire.setTextFill(Color.BLUE);
			victoire.setFont(Font.font("Cambria", scene.getHeight() / 20));
			victoire.setLayoutX(150);

			victoire.layoutYProperty().bind(r.heightProperty());
			victoire.setVisible(false);
                        
                        Button b1 = new Button("  ACCEUIL ");
                        b1.setOnAction(event -> {
//				Platform.exit();
                                Stage secondStage= (Stage)( (Node) (event.getSource())).getScene().getWindow();
                                    secondStage.close();
                                
                                 try{
           
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                                Parent root1 = (Parent) fxmlLoader.load();
                                Stage stage =  new Stage();
                                stage.setScene(new Scene(root1));
                                stage.show();
                                stage.getIcons().add(new Image("Ucad.jpg"));
                            }catch(Exception ex){
                                ex.printStackTrace();
                            }
                                //.start(primaryStage);

				//this.restart(primaryStage);
			});
                      // PrimaryStage.hide();
                       
			b1.setLayoutY(510);
			b1.setLayoutX(80);
			
	                b1.setVisible(true);
			root.getChildren().add(b1);

			Button b2 = new Button(" NOUVELLE PARTIE ");
			b2.setLayoutY(510);
			b2.setLayoutX(300);
			
			b2.setVisible(true);
			root.getChildren().add(b2);
                        b2.setOnAction(event -> {
  				this.start(primaryStage);

				
			});
                       
			
			scene.heightProperty().addListener(e->{
				tour.setFont(Font.font("Cambria", scene.getHeight() / 20));
				joueur.setFont(Font.font("Cambria", scene.getHeight() / 20));
				victoire.setFont(Font.font("Cambria", scene.getHeight() / 20));
			});
                        primaryStage.getIcons().add(new Image("Ucad.jpg"));
			
			
			
			root.getChildren().addAll(tour, joueur, victoire);
			
			
			//cadres de selections:
			Rectangle[] rects = new Rectangle[C];
			for(int i = 0 ; i < C ; i++){
				rects[i] = new Rectangle(0, 0, 100, 100);
				rects[i].layoutXProperty().bind(r.widthProperty().divide(C).multiply(i));
				rects[i].heightProperty().bind(r.heightProperty());
				rects[i].widthProperty().bind(r.widthProperty().divide(C));
				rects[i].setFill(Color.TRANSPARENT);
				rects[i].setStroke(Color.BLUE);
				rects[i].setStrokeType(StrokeType.INSIDE);
				rects[i].setStrokeWidth(7);
				rects[i].setVisible(false);
				
				root.getChildren().addAll(rects[i]);
			}
                        
			
			
			//selections:
			
			Rectangle r2 = new Rectangle(0,0,10,10);
			r2.heightProperty().bind(r.heightProperty());
			r2.widthProperty().bind(r.widthProperty());
			r2.setFill(Color.TRANSPARENT);
			root.getChildren().addAll(r2);
			
			precedent = -1;
			r2.setOnMouseMoved(e -> {
				
					int val = (int)(e.getX() / (r.getWidth() / C));
					if(val != precedent){
						rects[val].setVisible(true);
						if(precedent > -1)
							rects[precedent].setVisible(false);
					}
					precedent= val;
				
			});
			
			
			
			nbTour = 1;
			
			//clique:
			r2.setOnMouseClicked(e -> {
				
				
				int colonne = (int)(e.getX() / (r.getWidth() / C));
				
				//placement du jeton:
				if(cases[colonne][0].getStatut() == 0 && !victoire.isVisible()){

					int rang = L-1;
					while(cases[colonne][rang].getStatut() != 0){
						rang--;
					}
					cases[colonne][rang].set(nbTour%2==1 ? 1 : 2);

					
					//condiiton de victoire:


					//couleur en cours:
					int couleur = (nbTour%2==1 ? 1 : 2);
					//nombre alignes maximal: 
					int max = 0;
					int x; int y;
					int somme;

					//-->  diagonale HG-BD
					x = colonne; y = rang; somme=-1;
					while(y >= 0 && x >= 0 && cases[x][y].getStatut() == couleur){ y--; x--; somme++;}
					x = colonne; y = rang;
					while(y < L && x < C && cases[x][y].getStatut() == couleur){ y++; x++; somme++;}
					if(somme > max) max= somme;

					//-->  diagonale HD-BG
					x = colonne; y = rang; somme=-1;
					while(y >= 0 && x < C && cases[x][y].getStatut() == couleur){ y--; x++; somme++;}
					x = colonne; y = rang;
					while(y < L && x >= 0 && cases[x][y].getStatut() == couleur){ y++; x--; somme++;}
					if(somme > max) max= somme;

					//-->  verticale:
					x = colonne; y = rang; somme=-1;
					while(y >= 0 && cases[x][y].getStatut() == couleur){ y--; somme++;}
					y = rang;
					while(y < L && cases[x][y].getStatut() == couleur){ y++; somme++;}
					if(somme > max) max= somme;

					//-->  horizontale:
					x = colonne; y = rang; somme=-1;
					while(x >= 0 && cases[x][y].getStatut() == couleur){ x--; somme++;}
					x = colonne;
					while(x < C && cases[x][y].getStatut() == couleur){ x++; somme++;}
					if(somme > max) max= somme;
					
					
					if(max >= N){
						joueur.setVisible(false);
						victoire.setVisible(true);
						victoire.setTextFill(couleur == 1 ? Color.BLACK : Color.BLUE);
						victoire.setText( (couleur == 1 ? joueur1 : joueur2)+ " a gagné félicitation");
						nbTour--;
					}
					
					
					
					
					
					
					
					nbTour++;
					
					
					
					if(nbTour > C*L && max < N){
						joueur.setVisible(false);
						victoire.setVisible(true);
						victoire.setText(" MATCH NUL !");
						nbTour--;
					}
					
					
					tour.setText("Tour " + nbTour);
					joueur.setText((nbTour%2 == 1 ? joueur1 : joueur2) + " à toi de jouer");
					 //System.out.print(cc.jeu12);
				}
                               
                                
				
				
			});



			
			
			
			
			
			
			primaryStage.setTitle("Puissance 4 PROJET FIN ANNEE");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

    
	
        
        
}
