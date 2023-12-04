package facture.Repos;

import facture.Modele.Commande;
import facture.Modele.DetailCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DetailCommandeRepository extends JpaRepository<DetailCommande,Integer> {
    public List<DetailCommande> getByCommande(Commande commande);
}
