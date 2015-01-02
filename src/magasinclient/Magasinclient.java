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
            
            
            System.out.println("test des produits");
           // Produit p=service.path("gestion").path("produits").path("oneproduct").get(Produit.class);
           // System.out.println("produit reçu ="+p);
            
            Produit p= new Produit("P00023","test23",23,30);
            ClientResponse response =service.path("gestion").path("produits").path("create").accept("application/xml").put(ClientResponse.class,p);
            System.out.println("reponse status= "+response.getStatus());
              
	    MultivaluedMap h= response.getHeaders();
            String msg= (String)h.getFirst("erreur");
            System.out.println("erreur: "+msg);
            
            p=service.path("gestion").path("produits").path("read-P00001").get(Produit.class);
            System.out.println("produit reçu ="+p); 
            response=service.path("gestion").path("produits").path("delete-P00001").accept("application/xml").delete(ClientResponse.class);
            System.out.println("reponse status= "+response.getStatus());
              
	    h= response.getHeaders();
            msg= (String)h.getFirst("erreur");
            System.out.println("erreur: "+msg);     
            
            
            p= new Produit("P00023","test23b",24,30);
            response =service.path("gestion").path("produits").path("update").accept("application/xml").put(ClientResponse.class,p);
            System.out.println("reponse status= "+response.getStatus());
            h= response.getHeaders();
            msg= (String)h.getFirst("erreur");
            System.out.println("erreur: "+msg);
                    
            ListeProduits lp=service.path("gestion").path("produits").path("search- ").get(ListeProduits.class);
                    
            System.out.println(lp.getListe());
            
            
            System.out.println("test des clients");
            
            System.out.println("creation");        
            magasin.modele.Client cl= new magasin.modele.Client(0,"Dupont","Nadine",6000,"Charleroi","des pierres","2A","0456789555");
            response =service.path("gestion").path("clients").path("create").accept("application/xml").put(ClientResponse.class,cl);
            System.out.println("reponse status= "+response.getStatus());
              
	    h= response.getHeaders();
            
            
            msg= (String)h.getFirst("erreur");
            System.out.println("erreur: "+msg);
            int idclient= Integer.parseInt((String) h.getFirst("numcli"));
            System.out.println("idclient = "+idclient);
            cl.setIdclient(idclient);
        
            
            
            cl=service.path("gestion").path("clients").path("read-"+idclient).get(magasin.modele.Client.class);
            System.out.println("client reçu ="+cl); 
            
            System.out.println("modification");
            cl.setTel("0477777777");
            response =service.path("gestion").path("clients").path("update").accept("application/xml").put(ClientResponse.class,cl);
            System.out.println("reponse status= "+response.getStatus());
            
            cl=service.path("gestion").path("clients").path("read-"+idclient).get(magasin.modele.Client.class);
            System.out.println("client reçu ="+cl);
            h= response.getHeaders();
            msg= (String)h.getFirst("erreur");
            System.out.println("erreur: "+msg);
            
            System.out.println("recherche");
                    
            ListeClients lc=service.path("gestion").path("clients").path("search-Dupont").get(ListeClients.class);
            System.out.println(lc.getListe());
          
            System.out.println("effacement");
            response=service.path("gestion").path("clients").path("delete-"+idclient).accept("application/xml").delete(ClientResponse.class);
            System.out.println("reponse status= "+response.getStatus());
              
	    h= response.getHeaders();
            msg= (String)h.getFirst("erreur");
            System.out.println("erreur: "+msg);     
            
            
             System.out.println("test des commandes");
            
            System.out.println("creation");        
            ComFact cm= new ComFact(0,0,null,'c',0,41);
            response =service.path("gestion").path("commandes").path("create").accept("application/xml").put(ClientResponse.class,cm);
            System.out.println("reponse status= "+response.getStatus());
              
	    h= response.getHeaders();
            
            
            msg= (String)h.getFirst("erreur");
            System.out.println("erreur: "+msg);
            int numcommande= Integer.parseInt((String) h.getFirst("numcommande"));
            System.out.println("numcommande = "+numcommande);
                  
                     
            cm=service.path("gestion").path("commandes").path("read-"+numcommande).get(ComFact.class);
            System.out.println("commande reçue ="+cm); 
            
            System.out.println("modification");
            response =service.path("gestion").path("commandes").path("update").accept("application/xml").put(ClientResponse.class,cm);
            System.out.println("reponse status= "+response.getStatus());
            
            cm=service.path("gestion").path("commandes").path("read-"+numcommande).get(ComFact.class);
            System.out.println("commande reçue ="+cm);
            h= response.getHeaders();
            msg= (String)h.getFirst("erreur");
            System.out.println("erreur: "+msg);
            
            System.out.println("recherche par numfacture");
            cm=service.path("gestion").path("commandes").path("readfact-"+cm.getNumfact()).get(ComFact.class);
            System.out.println("commande reçue ="+cm);
            h= response.getHeaders();
            msg= (String)h.getFirst("erreur");
            System.out.println("erreur: "+msg);
            
            System.out.println("recherche par idclient");
                    
            ListeComFacts lcm=service.path("gestion").path("commandes").path("search-41").get(ListeComFacts.class);
            System.out.println(lcm.getListe());
          
           System.out.println("effacement");
           System.out.println("effacement de "+cm.getNumcommande());
            response=service.path("gestion").path("commandes").path("delete-"+cm.getNumcommande()).accept("application/xml").delete(ClientResponse.class);
            System.out.println("reponse status= "+response.getStatus());
              
	    h= response.getHeaders();
            msg= (String)h.getFirst("erreur");
            System.out.println("erreur: "+msg);     
                    
            System.out.println("test detail de commande");
            ListeComporte lcp=service.path("gestion").path("commandes").path("detail-21").get(ListeComporte.class);
            System.out.println(lcp.getListe());
          
	  }

	}


        

