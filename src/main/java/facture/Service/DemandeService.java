package facture.Service;

import facture.Modele.Demande;
import facture.Modele.ProformatFacture;
import facture.Repos.DemandeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeService {
    private final DemandeRepository demandeRepository;
    private final ArticleService articleService;


    @Autowired
    public DemandeService(DemandeRepository dR,ArticleService aS){
        demandeRepository = dR;
        articleService = aS;
    }

    @Transactional
    public void create(Demande demande){
        demandeRepository.save(demande);
    }

    public List<ProformatFacture> getAllProformatFacture(Demande demande){
        return null;
    }

}
