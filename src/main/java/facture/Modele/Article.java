package facture.Modele;

import jakarta.persistence.*;

@Entity
@Table(name = "Article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int article_id;
    String designation;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category_id;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    Fournisseur fournisseur_id;
    double prix_unitaire;
    String unite;

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    public Fournisseur getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(Fournisseur fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }

    public double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public Article(){}
    public Article(int article_id){
        this.setArticle_id(article_id);
    }
    
}
