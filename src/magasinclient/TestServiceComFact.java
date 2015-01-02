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
public class TestServiceComFact {
    public static void main(String[] args) {
        

            ClientConfig config=new DefaultClientConfig();
            Client client = Client.create();
            URI uri= UriBuilder.fromUri("http://localhost:9090/magasinwebservice").build();
            WebResource service= client.resource(uri);
                
            System.out.println("creation");        
            ComFact cm= new ComFact(0,0,null,'c',0,41);
            ClientResponse response =service.path("gestion").path("commandes").path("create").accept("application/xml").put(ClientResponse.class,cm);
            int status = response.getStatus();
            MultivaluedMap h=response.getHeaders();
            if(status >=400){
                String msg= (String)h.getFirst("erreur");
                System.err.println("erreur-status = "+status+" message = "+msg);
            } 
            else {
                System.out.println("ok");
                int numcommande= Integer.parseInt((String) h.getFirst("numcommande"));
                System.out.println("numcommande = "+numcommande);
                cm=service.path("gestion").path("commandes").path("read-"+numcommande).get(ComFact.class);
                System.out.println("commande reçue ="+cm); 
            }   
        
            System.out.println("lecture");
                                       
            cm=service.path("gestion").path("commandes").path("read-"+cm.getNumcommande()).get(ComFact.class);
            if(cm.getFkclient()==41) System.out.println("ok"); 
            else System.err.println("erreur commande reçue = "+cm);
            
            System.out.println("modification");
            response =service.path("gestion").path("commandes").path("update").accept("application/xml").put(ClientResponse.class,cm);
            status = response.getStatus();
            h=response.getHeaders();
            if(status >=400){
                String msg= (String)h.getFirst("erreur");
                System.err.println("erreur-status = "+status+" message = "+msg);
            } 
            else {
                cm=service.path("gestion").path("commandes").path("read-"+cm.getNumcommande()).get(ComFact.class);
                if(cm.getEtat()=='f')System.out.println("ok");
                else System.err.println("numcommande reçue = "+cm);
               
            }   
                 
            System.out.println("recherche par numfacture");
            int numcommandeAvant=cm.getNumcommande();
            cm=service.path("gestion").path("commandes").path("readfact-"+cm.getNumfact()).get(ComFact.class);
            if(cm.getNumcommande()==numcommandeAvant)System.out.println("ok");
            else System.err.println("commande reçue ="+cm);
           
            System.out.println("recherche par idclient");
                    
            ListeComFacts lcm=service.path("gestion").path("commandes").path("search-41").get(ListeComFacts.class);
            if(lcm.getListe().isEmpty()) System.err.println("liste vide");       
            else System.out.println(lcm.getListe());
          
           System.out.println("effacement");
           response=service.path("gestion").path("commandes").path("delete-"+cm.getNumcommande()).accept("application/xml").delete(ClientResponse.class);
           status = response.getStatus();
           h=response.getHeaders();           
           if(status >=400){
                String msg= (String)h.getFirst("erreur");
                System.err.println("erreur-status = "+status+" message = "+msg);
            } 
            else {
                System.out.println("ok");
            }
           //pas de test d'effacement avec record liés car l'effacement efface aussi les lignes 
	   
            System.out.println("test detail de commande");
            ListeComporte lcp=service.path("gestion").path("commandes").path("detail-21").get(ListeComporte.class);
            if(lcp.getListe().isEmpty()) System.err.println("liste vide");       
            else System.out.println(lcp.getListe());
                                           
    } 
}
