/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package magasin.modele;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class ListeComFacts {
    
    
    private ArrayList<ComFact> liste= new ArrayList<ComFact>();
    
    public ListeComFacts(){
        
    }

    public ArrayList<ComFact> getListe() {
        return liste;
    }

    public void setListe(ArrayList<ComFact> liste) {
        this.liste = liste;
    }
    
    
    
}
