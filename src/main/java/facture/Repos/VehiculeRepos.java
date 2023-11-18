package facture.Repos;


import org.springframework.data.repository.CrudRepository;
import facture.Modele.Vehicule;

public interface VehiculeRepos extends CrudRepository<Vehicule, Long> {
}
