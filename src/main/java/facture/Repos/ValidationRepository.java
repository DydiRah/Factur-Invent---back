package facture.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import facture.Modele.Demande;
import facture.Modele.Validation;

public interface ValidationRepository extends JpaRepository<Validation,Integer>{
    Validation findByDemande(Demande d);
}
