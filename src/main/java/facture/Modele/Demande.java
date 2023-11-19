package facture.Modele;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Demande")
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int demande_id;
	Date demande_date;
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	Utilisateur utilisateur_id;
	String article;
	double quantite;
	String motif;
    String service;

	public int getDemande_id() {
		return demande_id;
	}

	public void setDemande_id(int demande_id) {
		this.demande_id = demande_id;
	}

	public Date getDemande_date() {
		return demande_date;
	}

	public void setDemande_date(Date demande_date) {
		this.demande_date = demande_date;
	}

	public Utilisateur getUtilisateur_id() {
		return utilisateur_id;
	}

	public void setUtilisateur_id(Utilisateur utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

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
}
