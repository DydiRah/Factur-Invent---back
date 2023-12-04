package facture.Repos;

import facture.Modele.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande,Integer> {
    public List<Commande> getByEtat(int etat);
}
