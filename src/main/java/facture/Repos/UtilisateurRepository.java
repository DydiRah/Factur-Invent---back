package facture.Repos;

import facture.Modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
}
