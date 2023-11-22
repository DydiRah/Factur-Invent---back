package facture.Modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "Detail_facture")
public class DetailFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int det_facture_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facture_id")
    private Facture detFactureFacture;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    private int quantite;

}

