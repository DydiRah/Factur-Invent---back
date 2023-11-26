package facture.Repos;

import facture.Modele.Prix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrixRepository extends JpaRepository<Prix, Integer> {
    @Query(value = "SELECT 1 as prix_id, '2023-03-01' as prix_date, prix_article, prix_fournisseur, prix_valeur, MAX(prix_date) FROM Prix GROUP BY prix_fournisseur, prix_article, prix_valeur, prix_id, prix_date", nativeQuery = true)
    List<Prix> getAllLastDate();
}
