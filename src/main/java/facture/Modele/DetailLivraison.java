package facture.Modele;

import jakarta.persistence.*;

@Entity
@Table(name = "DetailLivraison")
public class DetailLivraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int det_livraison_id;
    @ManyToOne
    @JoinColumn(name = "commande_id")
    Commande commande;
    @ManyToOne
    @JoinColumn(name = "article_id")
    Article article;
    double prix_unitaire;
    double quantite;

    public DetailLivraison() {
    }

    public DetailLivraison(DetailCommande detailCommande) {
        setCommande(detailCommande.getCommande());
        setArticle(detailCommande.getArticle());
        setPrix_unitaire(detailCommande.getPrix_unitaire());
        setQuantite(detailCommande.getQuantite());
    }

    public int getDet_livraison_id() {
        return det_livraison_id;
    }

    public void setDet_livraison_id(int det_livraison_id) {
        this.det_livraison_id = det_livraison_id;
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
