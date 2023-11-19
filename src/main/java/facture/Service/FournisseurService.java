package facture.Service;

import facture.Modele.Fournisseur;
import facture.Modele.Utilisateur;
import facture.Repos.FournisseurRepository;
import facture.Repos.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
