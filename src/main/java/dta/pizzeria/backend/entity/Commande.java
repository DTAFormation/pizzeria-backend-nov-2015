package dta.pizzeria.backend.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commande implements Serializable {
    public enum Type{
        SUR_PLACE, A_EMPORTER, LIVRAISON;
    }
    
    public enum Paiement{
        EN_LIGNE, CARTE, LIQUIDE;
    }
    
    public enum Etat{
        EN_COURS, PREPARE, LIVRAISON, TERMINE;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float total;
    private boolean paye;
    
    @Enumerated
    private Type type;
    
    @Enumerated
    private Paiement paiement;
    
    @Enumerated
    private Etat etat;
    
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;
    
    @ManyToMany
    @JoinTable(name = "commandes_produits")
    private List<Produits> produits = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(name = "commandes_menus")
    private List<Menu> menus = new ArrayList<>();

    public Commande() {
        
    }

    public Commande(Long id, float total, boolean paye, Type type, Paiement paiement, Etat etat) {
        this.id = id;
        this.total = total;
        this.paye = paye;
        this.type = type;
        this.paiement = paiement;
        this.etat = etat;
    }

    public Commande(float total, boolean paye, Type type, Paiement paiement, Etat etat) {
        this.total = total;
        this.paye = paye;
        this.type = type;
        this.paiement = paiement;
        this.etat = etat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean isPaye() {
        return paye;
    }

    public void setPaye(boolean paye) {
        this.paye = paye;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Produits> getProduits() {
        return produits;
    }

    public void setProduits(List<Produits> produits) {
        this.produits = produits;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
    
    
}
