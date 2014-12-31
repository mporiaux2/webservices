package magasin.modele;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * classe métier de gestion d'un produit
 * @author Michel Poriaux
 * @version 1.0
 * @see Comporte
 */
@XmlRootElement(name="produit")
public class Produit {
    /**
     * identifiant unique du produit
     */
	protected String numprod;
    /**
     *  description du produit
     */
	protected String description;
     /**
      * prix hors tva
      */
	protected float phtva;
      /**
       * stock en cours
       */
	protected int stock;

  /**
 * constructeur par défaut
 */
    public Produit() {
    }
/**
 * constructeur paramétré
 * @param numprod identifiant unique du produit
 * @param description description du produit
 * @param phtva prix hors tva du produit
 * @param stock stock en cours du produit
  */
        
    public Produit(String numprod, String description, float phtva, int stock)  {
        this.numprod = numprod;
        this.description = description;
        this.phtva = phtva;
        this.stock = stock;

    }
 /**
    * getter phtva
    * @return prix hors tva du produit
    */
    public float getPhtva() {
        return phtva;
    }
 /**
     * setter phtva
     * @param phtva prix hors tva du produit
     */
    public void setPhtva(float phtva) {
        this.phtva = phtva;
    }

    /**
     * getter stock
     * @return stock en cours
     */
    
    public int getStock() {
        return stock;
    }

     /**
     * setter stock
     * @param stock nouveau stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    /**
     * getter description
     * @return description du produit
     */
    public String getDescription() {
        return description;
    }

    
     /**
     * setter description
     * @param description nouvelle description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * getter numéro de produit
     * @return numéro de produit
     */
     public String getNumprod() {
        return numprod;
    }
     
       /**
     * setter numprod utilisé par la sérialisation xml
     * @param numprod numéro de produit 
     */
    public void setNumprod(String numprod) {
        this.numprod = numprod;
    }


    /**
     * affichage des infos du produit
     * @return description complète du produit
    */
    @Override
    public String toString() {
        return "Produit{" + "numprod=" + numprod + ", description=" + description + ", phtva=" + phtva + ", stock=" + stock + '}';
    }
    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.numprod != null ? this.numprod.hashCode() : 0);
        return hash;
    }

    
    /**
     * méthode de test d'égalité basée sur le numéro de produit
     * @param obj un autre produit
     * @return true ou false selon la comparaison
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        if ((this.numprod == null) ? (other.numprod != null) : !this.numprod.equals(other.numprod)) {
            return false;
        }
        return true;
    }
    
    
}


    