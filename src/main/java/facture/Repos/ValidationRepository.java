package facture.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import facture.Modele.Validation;

public interface ValidationRepository extends JpaRepository<Validation,Integer>{
    
}
