package facture.Service;

import facture.Modele.Commande;
import facture.Modele.DetailCommande;
import facture.Repos.CommandeRepository;
import facture.Repos.DetailCommandeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import  java.util.List;

@AllArgsConstructor
@Service
public class CommandeService {
    private final CommandeRepository commandeRepository;
    private final DetailCommandeRepository detailCommandeRepository;

    @Transactional
    public void commander(Commande commande){
        commande.setEtat(0);
        Commande commande1 = commandeRepository.save(commande);
        for (DetailCommande detailCommande: commande.getDetailCommandeList()) {
            detailCommande.setCommande(commande1);
            detailCommandeRepository.save(detailCommande);
        }
    }

    public List<Commande> byState(int etat){
        return commandeRepository.getByEtat(etat);
    }

    public List<DetailCommande> detailsByCommande(int id){
        Commande commande = new Commande();
        commande.setCommande_id(id);
        return detailCommandeRepository.getByCommande(commande);
    }

}
