package magasin.modele;
/**
 * classe métier de gestion d'une ligne de commande
 * @author Michel Poriaux
 * @version 1.0
 * @see ComFact
 * @see Produit
 */


public class Comporte {
    /**
     * id automatique de la ligne de commande
     */
        protected int idligne;
     /**
      * quantité achetée
      */
	protected int quantite;
      /**
       * prix du produit lors de l'achat
       */
	protected float prixachat;
        /**
         * référence à la commande
         */
	protected int fkcomfact;
        /**
         * référence au produit acheté
         */
        protected String fkproduit;
  /**
   * constructeur par défaut
   */
    public Comporte() {
    }
        
    /**
     * constructeur paramétré
     * @param idligne identifiant de la ligne
     * @param fkcomfact référence de la commande
     * @param fkproduit référence du produit
     * @param quantite quantité achetée
     * @param prixachat prix du produit lors de l'achat
     */
    public Comporte(int idligne,int fkcomfact,String fkproduit,int quantite, float prixachat){
         this.idligne=idligne;
        this.quantite = quantite;
        this.prixachat = prixachat;
        this.fkcomfact = fkcomfact;
        this.fkproduit = fkproduit;
    }

    /**
     * getter idligne
     * @return identifiant de la ligne de commande
     */
    
    public int getIdligne() {
        return idligne;
    }
    
    
    /**
     * setter idligne
     * @param idligne identifiant de la ligne de commande 
     */
    
    public void setIdligne(int idligne) {
        this.idligne = idligne;
    }

    /**
     * getter quantité
     * @return quantité achetée
     */
    
    public int getQuantite() {
        return quantite;
    }

    /**
     * setter quantité
     * @param quantite quantité achetée 
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    
    /**
     * getter prix d'achat
     * @return prix d'achat
     */
    public float getPrixachat() {
        return prixachat;
    }

    
    /**
     * setter prix d'achat
     * @param prixachat prix d'achat du produit 
     */
    public void setPrixachat(float prixachat) {
        this.prixachat = prixachat;
    }

    /**
     * getter fkcommande
     * @return référence de la commande
     */    
    public int getFkcomfact() {
        return fkcomfact;
    }

    /**
     * setter fkcomfact
     * @param fkcomfact référence de la commande 
     */
    public void setFkcomfact(int fkcomfact) {
        this.fkcomfact = fkcomfact;
    }

    /**
     * getter fkproduit
     * @return référence du produit
     */
    public String getFkproduit() {
        return fkproduit;
    }
    /**
     * setter fkproduit
     * @param fkproduit référence du produit 
     */
    public void setFkproduit(String fkproduit) {
        this.fkproduit = fkproduit;
    }

    /**
     * méthode tostring
     * @return infos complètes de la ligne de commande
     */
    @Override
    public String toString() {
        return "Comporte{" + "idligne=" + idligne + ", quantite=" + quantite + ", prixachat=" + prixachat + ", fkcomfact=" + fkcomfact + ", fkproduit=" + fkproduit + '}';
    }
 }
