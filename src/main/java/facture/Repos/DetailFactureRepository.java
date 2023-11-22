package facture.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import facture.Modele.DetailFacture;
import facture.Modele.Facture;
@Repository
public interface DetailFactureRepository extends JpaRepository<DetailFacture,Integer> {
    List<DetailFacture> findByDetFactureFacture(Facture facture);

}
