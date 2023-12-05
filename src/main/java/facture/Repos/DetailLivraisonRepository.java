package facture.Repos;

import facture.Modele.Commande;
import facture.Modele.DetailCommande;
import facture.Modele.DetailLivraison;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailLivraisonRepository extends JpaRepository<DetailLivraison,Integer> {
    public List<DetailLivraison> getByCommande(Commande commande);
}
