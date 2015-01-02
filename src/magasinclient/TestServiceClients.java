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
public class TestServiceClients {
    public static void main(String[] args) {
        

            ClientConfig config=new DefaultClientConfig();
            Client client = Client.create();
            URI uri= UriBuilder.fromUri("http://localhost:9090/magasinwebservice").build();
            WebResource service= client.resource(uri);
            
            
            
            System.out.println("creation");        
            magasin.modele.Client cl= new magasin.modele.Client(0,"Dupont","Nadine",6000,"Charleroi","des pierres","2A","0456789555");
            ClientResponse response =service.path("gestion").path("clients").path("create").accept("application/xml").put(ClientResponse.class,cl);
            int status = response.getStatus();
            MultivaluedMap h=response.getHeaders();
            if(status >=400){
                String msg= (String)h.getFirst("erreur");
                System.err.println("erreur-status = "+status+" message = "+msg);
            } 
            else {
                System.out.println("ok");
                int idclient= Integer.parseInt((String) h.getFirst("numcli"));
                System.out.println("idclient = "+idclient);
                cl.setIdclient(idclient);
            }   
        
            System.out.println("lecture");
            
            cl=service.path("gestion").path("clients").path("read-"+cl.getIdclient()).get(magasin.modele.Client.class);
            if(cl.getNom().equals("Dupont"))System.out.println("ok");
            else System.err.println("erreur client reçu ="+cl); 
            
            System.out.println("modification");
            cl.setTel("0477777777");
            response =service.path("gestion").path("clients").path("update").accept("application/xml").put(ClientResponse.class,cl);
            status = response.getStatus();
           if(status >=400){
                h= response.getHeaders();
                String msg= (String)h.getFirst("erreur");
                System.err.println("erreur-status = "+status+" message = "+msg);
            } 
            else {
                 cl=service.path("gestion").path("clients").path("read-"+cl.getIdclient()).get(magasin.modele.Client.class);
                 if(cl.getTel().equals("0477777777"))System.out.println("ok");
                 else System.err.println("erreur client reçu ="+cl); 
            }   
        
                       
            System.out.println("recherche");
                    
            ListeClients lc=service.path("gestion").path("clients").path("search-Dupont").get(ListeClients.class);
            if(lc.getListe().isEmpty()) System.err.println("liste vide");       
            else System.out.println(lc.getListe());
          
          
         System.out.println("effacement d'un client sans achat");
         response=service.path("gestion").path("clients").path("delete-"+cl.getIdclient()).accept("application/xml").delete(ClientResponse.class);
         if(status >=400){
                h= response.getHeaders();
                String msg= (String)h.getFirst("erreur");
                System.err.println("erreur-status = "+status+" message = "+msg);
            } 
            else System.out.println("ok");
            
            System.out.println("effacement d'un produit avec achat");
            response=service.path("gestion").path("clients").path("delete-41").accept("application/xml").delete(ClientResponse.class);
            status = response.getStatus();
            if(status >=400){
                h= response.getHeaders();
                String msg= (String)h.getFirst("erreur");
                System.out.println("ok-status = "+status+" message = "+msg);
            } 
            else  System.err.println("erreur effacement accepté");   
                     
    } 
}
