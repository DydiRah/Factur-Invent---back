package facture.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import facture.Modele.Facture;
import facture.Repos.FactureRepository;
import jakarta.transaction.Transactional;

@Service
public class FactureService {

    public FactureService(){}
    @Autowired
    private FactureRepository fact_rep;
    
    @Transactional
    public Facture creerFacture(Facture facture) {
        return fact_rep.save(facture);
    }

    @Transactional
    public List<Facture> getAllFacture() {
        return fact_rep.findAll();
    }


    public Facture updateFacture(int id,Facture facture ) {
        Facture val = fact_rep.findById(id).map(
            fact -> {
                fact.setFact_utilisateur(facture.getFact_utilisateur());
                fact.setFact_tva(facture.getFact_tva());
                fact.setFact_detail_facture(facture.getFact_detail_facture());
                fact.setFact_prix_total_hors_taxe(facture.getFact_prix_total_hors_taxe());
                return fact;
            }
        ).orElseThrow(() -> new RuntimeException("Impossible de trouver le kilométrage avec l'ID : " + id));
       return fact_rep.save(val);
    }

}
