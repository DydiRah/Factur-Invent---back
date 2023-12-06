package facture.Modele;

import facture.Repos.MagasinRepository;
import facture.Repos.ResteViewRepository;
import facture.Repos.StockViewRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Magasin")
public class Magasin {
    @Id
    String magasin_id;

    public String getMagasin_id() {
        return magasin_id;
    }

    public Magasin() {
    }

    public Magasin(String magasin_id) {
        setMagasin_id(magasin_id);
    }

    public void setMagasin_id(String magasin_id) {
        this.magasin_id = magasin_id;
    }

    public double getReste(int article_id, StockViewRepository stockViewRepository){
        StockView stockView = stockViewRepository.findById(article_id).get();
        return stockView.getReste();
    }

    public List<ResteView> getResteByEntree(int article_id, ResteViewRepository resteViewRepository,StockView stockView){
        String ordre = (stockView.getNature().equals("LIFO"))?"DESC":"ASC";
        List<ResteView> resteViews = resteViewRepository.getEntrees(article_id,ordre);
        return resteViews;
    }
}
