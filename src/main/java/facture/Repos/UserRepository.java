package facture.Repos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import facture.Modele.Utilisateur;

@Repository
public interface UserRepository extends CrudRepository<Utilisateur, Long> {
}
