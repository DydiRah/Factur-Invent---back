package facture.Modele;

import facture.Repos.MagasinRepository;
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

    public List<ResteQuantiteMontant> get_Reste_Quantite_Montant(MagasinRepository magasinRepository, Date date, int idArticle){
        List<Object[]> all_Quantite_Montant = magasinRepository.get_Quantites_Montants_For_Date(date,idArticle,getMagasin_id());
        List<ResteQuantiteMontant> resteQuantiteMontants = new ArrayList<>();
        for (Object[] objects:all_Quantite_Montant) {
            ResteQuantiteMontant rqm = new ResteQuantiteMontant(objects);
            resteQuantiteMontants.add(rqm);
        }
        return resteQuantiteMontants;
    }

    public double get_Reste_For_Date(MagasinRepository magasinRepository,Date date,int idArticle){
        List<ResteQuantiteMontant> rqms = get_Reste_Quantite_Montant(magasinRepository,date,idArticle);
        double qEntree = 0;
        double qSortie = 0;
        for (ResteQuantiteMontant rqm:rqms) {
            if (rqm.getType().equals("Entree")){
                qEntree += rqm.getNombre();
            }else {
                qSortie += rqm.getNombre();
            }
        }
        return qEntree - qSortie;
    }

    public double get_Montant_For_Date(MagasinRepository magasinRepository,Date date,int idArticle){
        List<ResteQuantiteMontant> rqms = get_Reste_Quantite_Montant(magasinRepository,date,idArticle);
        double mEntree = 0;
        double mSortie = 0;
        for (ResteQuantiteMontant rqm:rqms) {
            if (rqm.getType().equals("Entree")){
                mEntree += rqm.getMontant();
            }else {
                mSortie += rqm.getMontant();
            }
        }
        return mEntree - mSortie;
    }
}
