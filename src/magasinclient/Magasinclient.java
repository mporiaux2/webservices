/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package magasinclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.net.URI;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;
       
import magasin.modele.*;

/**
 *
 * @author Michel
 */
public class Magasinclient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

            ClientConfig config=new DefaultClientConfig();
            Client client = Client.create();
            URI uri= UriBuilder.fromUri("http://localhost:9090/magasinwebservice").build();
            WebResource service= client.resource(uri);
            
            Produit p=service.path("gestionproduit").path("oneproduct").get(Produit.class);
            System.out.println("produit reçu ="+p);
            
            p= new Produit("P00023","test23",23,30);
            ClientResponse response =service.path("gestionproduit").path("create").accept("application/xml").put(ClientResponse.class,p);
            System.out.println("reponse status= "+response.getStatus());
              
	    MultivaluedMap h= response.getHeaders();
            String msg= (String)h.getFirst("erreur");
            System.out.println("erreur: "+msg);
            
            p=service.path("gestionproduit").path("read-P00001").get(Produit.class);
            System.out.println("produit reçu ="+p); 
            response=service.path("gestionproduit").path("delete-P00001").accept("application/xml").delete(ClientResponse.class);
            System.out.println("reponse status= "+response.getStatus());
              
	    h= response.getHeaders();
            msg= (String)h.getFirst("erreur");
            System.out.println("erreur: "+msg);     
            
            
            p= new Produit("P00023","test23b",24,30);
            response =service.path("gestionproduit").path("update").accept("application/xml").put(ClientResponse.class,p);
            System.out.println("reponse status= "+response.getStatus());
            h= response.getHeaders();
            msg= (String)h.getFirst("erreur");
            System.out.println("erreur: "+msg);
                    
            ListeProduits lp=service.path("gestionproduit").path("search- ").get(ListeProduits.class);
                    
            System.out.println(lp.getListe());
          /*  Pizza pz= new Pizza("Maquereau",3);
            ClientResponse response =service.path("rest").path("gestion").path("newpizza").accept(MediaType.APPLICATION_XML).put(ClientResponse.class,pz);
            System.out.println("reponse = "+response.getStatus());
            pz=service.path("rest").path("gestion").path("onepizza").get(Pizza.class);
            System.out.println("pizza reçue ="+pz);
         
            ListePizzas lpz=service.path("rest").path("gestion").path("listepizzas").get(ListePizzas.class);
            
            System.out.println(lpz.getLpz());*/
	  }

	}


        

