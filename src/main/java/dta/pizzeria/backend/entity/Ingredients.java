/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dta.pizzeria.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



/**
 *
 * @author MHayet
 */
@Entity
public class Ingredients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String Nom;
    
    @ManyToMany(mappedBy = "ingredients")
    @JsonIgnore
    private List<Produits> pizzas = new ArrayList<>();

    public Ingredients() {
    }

    public Ingredients(String Nom) {
        this.Nom = Nom;
    }

    public Ingredients(Long id, String Nom) {
        this.id = id;
        this.Nom = Nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public List<Produits> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Produits> pizzas) {
        this.pizzas = pizzas;
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
        if (!(object instanceof Ingredients)) {
            return false;
        }
        Ingredients other = (Ingredients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dta.pizzeria.backend.entity.Ingredients[ id=" + id + " ]";
    }

}
