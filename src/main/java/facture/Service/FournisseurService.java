package facture.Service;

import facture.Modele.Fournisseur;
import facture.Repos.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {
    private final FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurService(FournisseurRepository fR){fournisseurRepository=fR;}

    public void create(Fournisseur fournisseur){
        fournisseurRepository.save(fournisseur);
    }

    public List<Fournisseur> retrieve(){
        return (List<Fournisseur>) fournisseurRepository.findAll();
    }
}
