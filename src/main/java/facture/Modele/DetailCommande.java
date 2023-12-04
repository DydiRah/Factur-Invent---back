package facture.Modele;

import jakarta.persistence.*;

@Entity
@Table(name = "DetailCommande")
public class DetailCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int det_commande_id;
    @ManyToOne
    @JoinColumn(name = "commande_id")
    Commande commande;
    @ManyToOne
    @JoinColumn(name = "article_id")
    Article article;
    double prix_unitaire;
    double quantite;

    public int getDet_commande_id() {
        return det_commande_id;
    }

    public void setDet_commande_id(int det_commande_id) {
        this.det_commande_id = det_commande_id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
}
