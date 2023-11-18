package facture.Service;

import facture.Modele.Demande;
import facture.Repos.DemandeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandeService {
    private final DemandeRepository demandeRepository;

    @Autowired
    public DemandeService(DemandeRepository dR){demandeRepository = dR;}

    @Transactional
    public void create(Demande demande){
        demandeRepository.save(demande);
    }

}
