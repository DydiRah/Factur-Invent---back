package facture.Modele;

import java.util.Date;

public class ProformatFacture {
    Fournisseur fournisseur;
    Utilisateur utilisateur;
    Date facture_date;
    Article article;
    double quantite;
    String photo_url_facture;
    String motif;
    String service;

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Date getFacture_date() {
        return facture_date;
    }

    public void setFacture_date(Date facture_date) {
        this.facture_date = facture_date;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public String getPhoto_url_facture() {
        return photo_url_facture;
    }

    public void setPhoto_url_facture(String photo_url_facture) {
        this.photo_url_facture = photo_url_facture;
    }
}
