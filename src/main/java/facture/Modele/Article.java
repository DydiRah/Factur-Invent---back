package facture.Modele;

import jakarta.persistence.*;
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int art_id;

    private String art_designation;

    private String art_category;

    private int art_fournisseur;

    private double art_prix_unitaire;

    private String art_unite;

}
