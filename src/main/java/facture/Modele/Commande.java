package facture.Modele;

import jakarta.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int commande_id;
    Date commande_date;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    Utilisateur utilisateur;
    int etat;
    double montants;
    @Transient
    List<DetailCommande> detailCommandeList;


    public List<DetailCommande> getDetailCommandeList() {
        return detailCommandeList;
    }

    public void setDetailCommandeList(List<DetailCommande> detailCommandeList) {
        this.detailCommandeList = detailCommandeList;
    }


    public double getMontants() {
        return montants;
    }

    public void setMontants(double montants) {
        this.montants = montants;
    }

    public int getCommande_id() {
        return commande_id;
    }

    public void setCommande_id(int commande_id) {
        this.commande_id = commande_id;
    }

    public Date getCommande_date() {
        return commande_date;
    }

    public void setCommande_date(Date commande_date) {
        this.commande_date = commande_date;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
