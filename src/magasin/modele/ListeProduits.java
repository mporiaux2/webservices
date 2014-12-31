/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package magasin.modele;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Michel
 */
@XmlRootElement
public class ListeProduits {
    
    //@XmlElement(name = "produit")
    private ArrayList<Produit> liste= new ArrayList<Produit>();
    
    public ListeProduits(){
        
    }

    public ArrayList<Produit> getListe() {
        return liste;
    }

    public void setListe(ArrayList<Produit> liste) {
        this.liste = liste;
    }
    
    
    
}
