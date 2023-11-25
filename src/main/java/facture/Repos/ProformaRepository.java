package facture.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import facture.Modele.Proforma;

public interface ProformaRepository extends JpaRepository<Proforma, Integer>{
    
}
