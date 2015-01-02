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
public class TestServiceProduits {
    public static void main(String[] args) {
        

            ClientConfig config=new DefaultClientConfig();
            Client client = Client.create();
            URI uri= UriBuilder.fromUri("http://localhost:9090/magasinwebservice").build();
            WebResource service= client.resource(uri);
            
            
            System.out.println("test des produits");
            System.out.println("création d'un produit");         
            Produit p= new Produit("P00023","test23",23,30);
            ClientResponse response =service.path("gestion").path("produits").path("create").accept("application/xml").put(ClientResponse.class,p);
            int status = response.getStatus();
            if(status >=400){
                MultivaluedMap h= response.getHeaders();
                String msg= (String)h.getFirst("erreur");
                System.err.println("erreur-status = "+status+" message = "+msg);
            } 
            else System.out.println("ok");
	    
            System.out.println("lecture d'un produit ");
            p=service.path("gestion").path("produits").path("read-P00023").get(Produit.class);
            if(! p.getNumprod().equals("P00023")) {
                System.err.println("erreur produit reçu =" +p);
            }
            else 
            System.out.println("OK produit reçu ="+p); 
            
            
              
	    System.out.println("mise à jour d'un produit ");    
            
            p= new Produit("P00023","test23b",24,50);
            response =service.path("gestion").path("produits").path("update").accept("application/xml").put(ClientResponse.class,p);
           status = response.getStatus();
            if(status >=400){
                MultivaluedMap h= response.getHeaders();
                String msg= (String)h.getFirst("erreur");
                System.err.println("erreur-status = "+status+" message = "+msg);
                
            } 
            else{
                 p=service.path("gestion").path("produits").path("read-P00023").get(Produit.class);
                 if(p.getStock()!=50)System.err.println("erreur stock non mis à jour ="+p.getStock()); 
                  else
                    System.out.println("ok");
            }
                
            
            System.out.println("recherche de produits");
            ListeProduits lp=service.path("gestion").path("produits").path("search- ").get(ListeProduits.class);
            if(lp.getListe().isEmpty()) System.err.println("liste vide");       
            else System.out.println(lp.getListe());
            
            System.out.println("effacement d'un produit sans achat");
            response=service.path("gestion").path("produits").path("delete-P00023").accept("application/xml").delete(ClientResponse.class);
            status = response.getStatus();
            if(status >=400){
                MultivaluedMap h= response.getHeaders();
                String msg= (String)h.getFirst("erreur");
                System.err.println("erreur-status = "+status+" message = "+msg);
            } 
            else System.out.println("ok");
            
            System.out.println("effacement d'un produit avec achat");
            response=service.path("gestion").path("produits").path("delete-P00001").accept("application/xml").delete(ClientResponse.class);
            status = response.getStatus();
            if(status >=400){
                MultivaluedMap h= response.getHeaders();
                String msg= (String)h.getFirst("erreur");
                System.out.println("ok-status = "+status+" message = "+msg);
            } 
            else System.out.println("erreur effacement accepté");
    } 
}
