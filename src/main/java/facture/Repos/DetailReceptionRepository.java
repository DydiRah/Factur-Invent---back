package facture.Repos;

import facture.Modele.Commande;
import facture.Modele.DetailCommande;
import facture.Modele.DetailReception;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailReceptionRepository extends JpaRepository<DetailReception,Integer> {
    public List<DetailReception> getByCommande(Commande commande);
}
