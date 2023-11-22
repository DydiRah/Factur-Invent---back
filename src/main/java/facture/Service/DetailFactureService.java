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

    private final DetailFactureRepository detail_fact_rep;

    @Autowired
    public DetailFactureService(DetailFactureRepository detailFactureRepository) {
        this.detail_fact_rep = detailFactureRepository;
    }
    
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

    public DetailFacture updateDetailFacture(int facture_facture_id,DetailFacture detail){
        DetailFacture val = detail_fact_rep.findById(facture_facture_id).map(
            fact -> {
                fact.setDetFactureFacture(detail.getDetFactureFacture());
                fact.setArticle(detail.getArticle());
                fact.setQuantite(detail.getQuantite());
                return fact;
            }
        ).orElseThrow(() -> new RuntimeException("Impossible de trouver les details de la facture avec l'ID : " + facture_facture_id));
       return detail_fact_rep.save(val);
    }
}
