package facture.Modele;

import jakarta.persistence.*;

@Entity
@Table
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int fournisseur_id;
    String fournisseur_nom;
    String adresse;
    String contact;
    String email;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category_id;

    public int getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(int fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }

    public String getFournisseur_nom() {
        return fournisseur_nom;
    }

    public void setFournisseur_nom(String fournisseur_nom) {
        this.fournisseur_nom = fournisseur_nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }
}
