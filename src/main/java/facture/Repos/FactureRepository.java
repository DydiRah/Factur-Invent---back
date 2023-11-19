package facture.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import facture.Modele.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer>{
    
}
