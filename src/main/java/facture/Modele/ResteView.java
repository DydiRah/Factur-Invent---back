package facture.Modele;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reste_view")
public class ResteView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_stock;
    Date date_stock;
    double prix_unitaire;
    double quantite;
    int source;
    String type;
    String unite;
    int article_id;
    String magasin_id;
    double reste;
    double total_prix;

    public int getId_stock() {
        return id_stock;
    }

    public void setId_stock(int id_stock) {
        this.id_stock = id_stock;
    }

    public Date getDate_stock() {
        return date_stock;
    }

    public void setDate_stock(Date date_stock) {
        this.date_stock = date_stock;
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

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getMagasin_id() {
        return magasin_id;
    }

    public void setMagasin_id(String magasin_id) {
        this.magasin_id = magasin_id;
    }

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }

    public double getTotal_prix() {
        return total_prix;
    }

    public void setTotal_prix(double total_prix) {
        this.total_prix = total_prix;
    }
}
