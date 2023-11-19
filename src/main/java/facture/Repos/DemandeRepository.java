package facture.Repos;

import facture.Modele.Demande;
import org.springframework.data.repository.CrudRepository;

public interface DemandeRepository extends CrudRepository<Demande, Integer> {
}
