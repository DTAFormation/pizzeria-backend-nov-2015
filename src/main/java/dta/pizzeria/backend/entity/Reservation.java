package dta.pizzeria.backend.entity;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @DateTimeFormat
    private Date date;
    
    @DateTimeFormat
    private Date heure;
    
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;
    

    public Reservation() {
        
    }

    public Reservation(Long id, Date date, Date heure) {
        this.id = id;
        this.date = date;
        this.heure = heure;
    }

    public Reservation(Date date, Date heure) {
        this.date = date;
        this.heure = heure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
