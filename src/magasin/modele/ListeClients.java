/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package magasin.modele;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class ListeClients {
    
    //@XmlElement(name = "produit")
    private ArrayList<Client> liste= new ArrayList<Client>();
    
    public ListeClients(){
        
    }

    public ArrayList<Client> getListe() {
        return liste;
    }

    public void setListe(ArrayList<Client> liste) {
        this.liste = liste;
    }
    
    
    
}
