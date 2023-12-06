package facture.Modele;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "achat")
public class Achat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_Stock;
    Date date_Stock;

    int article_id;
    double quantite;
    double prix_Unitaire;
    String type;
    String unite;
    String magasin_id;
    int source;

    public int getId_Stock() {
        return id_Stock;
    }

    public void setId_Stock(int id_Stock) {
        this.id_Stock = id_Stock;
    }

    public Date getDate_Stock() {
        return date_Stock;
    }

    public void setDate_Stock(Date date_Stock) {
        this.date_Stock = date_Stock;
    }

    public int getArticle() {
        return article_id;
    }

    public void setArticle(int article) {
        this.article_id = article;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getPrix_Unitaire() {
        return prix_Unitaire;
    }

    public void setPrix_Unitaire(double prix_Unitaire) {
        this.prix_Unitaire = prix_Unitaire;
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

    public String getMagasin() {
        return magasin_id;
    }

    public void setMagasin(String magasin) {
        this.magasin_id = magasin;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }
}
