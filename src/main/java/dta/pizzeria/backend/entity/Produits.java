/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dta.pizzeria.backend.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author MHayet
 */
@Entity
public class Produits implements Serializable {
    
    public enum Type_Produit{
        PIZZA, BOISSON, DESSERT
    }
    
    public enum Taille{
        MOYEN, LARGE, XLARGE
    }
    
    public enum Format{
        NORMAL, XL
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private Float prix;
    @Enumerated(EnumType.STRING)
    private Type_Produit type;
    @Enumerated(EnumType.STRING)
    private Taille taille;
    @Enumerated(EnumType.STRING)
    private Format format;
    
    @ManyToMany(mappedBy = "produits", cascade = CascadeType.ALL)
    private List<Commande> commandes = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(name = "pizzas_ingredients")
    private List<Ingredients> ingredients = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(name = "produits_menu")
    private List<Menu> menus = new ArrayList<>();

    public Produits() {
    }

    public Produits(String nom, Float prix, Type_Produit type, Taille taille, Format format) {
        this.nom = nom;
        this.prix = prix;
        this.type = type;
        this.taille = taille;
        this.format = format;
    }

    public Produits(Long id, String nom, Float prix, Type_Produit type, Taille taille, Format format) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.type = type;
        this.taille = taille;
        this.format = format;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Type_Produit getType() {
        return type;
    }

    public void setType(Type_Produit type) {
        this.type = type;
    }

    public Taille getTaille() {
        return taille;
    }

    public void setTaille(Taille taille) {
        this.taille = taille;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produits)) {
            return false;
        }
        Produits other = (Produits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dta.pizzeria.backend.entity.Produits[ id=" + id + " ]";
    }

}
