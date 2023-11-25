package facture.Repos;

import facture.Modele.Fournisseur;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FournisseurRepository extends CrudRepository<Fournisseur,Integer> {

    public List<Fournisseur> findByEmail(String email);
}
