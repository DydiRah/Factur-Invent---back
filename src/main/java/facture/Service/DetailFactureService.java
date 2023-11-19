package facture.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import facture.Modele.DetailFacture;
import facture.Modele.Facture;
import facture.Repos.DetailFactureRepository;
import jakarta.transaction.Transactional;

@Service
public class DetailFactureService {

    public DetailFactureService(){}
    @Autowired
    private DetailFactureRepository detail_fact_rep;
    
    @Transactional
    public DetailFacture creerDetailFacture(DetailFacture det_fact) {
        return detail_fact_rep.save(det_fact);
    }

    public List<DetailFacture> getAllDetailFacture() {
        return detail_fact_rep.findAll();
    }

    
    public List<DetailFacture> getAllDetailFacture(Facture facture) {
        return detail_fact_rep.findByDetFactureFacture(facture);
    }
}
