package facture.Service;

import facture.Modele.Utilisateur;
import facture.Repos.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository uR){utilisateurRepository=uR;}

    public void create(Utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> retrieve(){
        return (List<Utilisateur>) utilisateurRepository.findAll();
    }
}
