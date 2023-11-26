package facture.Modele;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Prix")
public class Prix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int prix_id;
    @ManyToOne
    @JoinColumn(name = "prix_article")
    Article prix_article;
    @ManyToOne
    @JoinColumn(name = "prix_fournisseur")
    Fournisseur prix_fournisseur;
    Double prix_valeur;
    Date prix_date;

    public Prix() {
    }

    public int getPrix_id() {
        return prix_id;
    }

    public void setPrix_id(int prix_id) {
        this.prix_id = prix_id;
    }

    public Article getPrix_article() {
        return prix_article;
    }

    public void setPrix_article(Article prix_article) {
        this.prix_article = prix_article;
    }

    public Fournisseur getPrix_fournisseur() {
        return prix_fournisseur;
    }

    public void setPrix_fournisseur(Fournisseur prix_fournisseur) {
        this.prix_fournisseur = prix_fournisseur;
    }

    public Double getPrix_valeur() {
        return prix_valeur;
    }

    public void setPrix_valeur(Double prix_valeur) {
        this.prix_valeur = prix_valeur;
    }

    public Date getPrix_date() {
        return prix_date;
    }

    public void setPrix_date(Date prix_date) {
        this.prix_date = prix_date;
    }
}
