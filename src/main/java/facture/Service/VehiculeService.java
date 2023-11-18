package facture.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import facture.Modele.Vehicule;
import facture.Repos.VehiculeRepos;

import java.util.List;

@Service
public class VehiculeService {
    private final VehiculeRepos vrp;


    @Autowired
    public VehiculeService(VehiculeRepos vrp) {
        this.vrp = vrp;
    }


    //C
    @Transactional
    public Vehicule create(Vehicule vehicule){
        return vrp.save(vehicule);
    }

    //R
    public List<Vehicule> retrieve(){
        return (List<Vehicule>) vrp.findAll();
    }

    //U
    public Vehicule update(Vehicule vehicule){
        if(existByIdString(vehicule)){
            return vrp.save(vehicule);
        }
        return null;
    }

    public boolean existByIdString(Vehicule vehicule){
        List<Vehicule> lv = retrieve();
        for (Vehicule v: lv) {
            if(v.getMatricule().equals(vehicule.getMatricule())){
                return true;
            }
        }
        return false;
    }


    //D
    @Transactional
    public void delete(Vehicule vehicule){
        vrp.delete(vehicule);
    }


}
