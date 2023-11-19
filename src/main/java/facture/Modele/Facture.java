package facture.Modele;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Setter
@Getter
@Table(name = "Facture")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fact_id;

    @ManyToOne
	@JoinColumn(name = "utilisateur_id")
    private Utilisateur fact_utilisateur;

    private double fact_tva;

    @Transient
    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailFacture> fact_detail_facture ;

    private double fact_prix_total_hors_taxe;

    @Column(columnDefinition = "text")
    private String photo;

}
