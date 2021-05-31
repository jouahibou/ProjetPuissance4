/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puissance4;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BouleDuJeux extends ImageView {
    private static Image noir = new Image("seydi.png");
    private static Image bleu = new Image("jou.png");
        
        
        private int statut;
	
	public BouleDuJeux(){
		this.statut = 0;
	}
	
	public void set(int j){
		this.setImage(j == 1 ? noir : bleu);
		this.statut = j;
	}
	
	
	public int getStatut(){
		return statut;
	}
	
}

