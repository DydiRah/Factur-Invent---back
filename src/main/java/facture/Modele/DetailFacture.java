package facture.Modele;

import jakarta.persistence.*;

@Entity
@Table(name = "Detail_facture")
public class DetailFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int det_facture_id;

    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture det_facture_facture;

    @ManyToOne
    @JoinColumn(name = "art_id")
    private Article article;

    private int quantite;

    // Getters and setters
}

