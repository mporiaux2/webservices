/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package magasin.modele;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class ListeComporte {
    
    //@XmlElement(name = "produit")
    private ArrayList<Comporte> liste= new ArrayList<Comporte>();
    
    public ListeComporte(){
        
    }

    public ArrayList<Comporte> getListe() {
        return liste;
    }

    public void setListe(ArrayList<Comporte> liste) {
        this.liste = liste;
    }
    
    
    
}
