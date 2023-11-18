package facture.Modele;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Utilisateur")
public class Utilisateur {

    public Utilisateur(String nom, String prenom, Date dateNaissance, String poste, String email, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.poste = poste;
        this.email = email;
        this.motDePasse = motDePasse;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idutilisateur")
    private int idUtilisateur;

    private String nom;
    private String prenom;
    @Column(name = "datenaissance")

    private Date dateNaissance;
    private String poste;
    private String email;
    @Column(name = "motdepasse")

    private String motDePasse;

    public Utilisateur() {
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

}
