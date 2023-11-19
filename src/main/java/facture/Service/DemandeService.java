package facture.Service;

import facture.Modele.*;
import facture.Repos.DemandeRepository;
import facture.Repos.UtilisateurRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DemandeService {
    private final DemandeRepository demandeRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final ArticleService articleService;


    @Autowired
    public DemandeService(DemandeRepository dR,ArticleService aS,UtilisateurRepository uR){
        demandeRepository = dR;
        articleService = aS;
        utilisateurRepository = uR;
    }

    @Transactional
    public void create(Demande demande){
        demandeRepository.save(demande);
    }

    public List<ProformatFacture> getAllProformatFacture(Demande demande)throws Exception{
        List<ProformatFacture> pfs = new ArrayList<ProformatFacture>();
        List<Article> articles = articleService.getAllArticleByName(demande.getArticle());
        if(articles.isEmpty()){
            throw new Exception("Aucun fournisseur a cet article.");
        }
        for (Article article:articles) {
            ProformatFacture pf = new ProformatFacture();
            int demandeur_id = demande.getUtilisateur_id().getUtilisateur_id();
            Utilisateur demandeur = utilisateurRepository.findById(demandeur_id).get();
            pf.setFournisseur(article.getFournisseur_id());
            pf.setUtilisateur(demandeur);
            pf.setFacture_date(new Date());
            pf.setArticle(article);
            pf.setQuantite(demande.getQuantite());
            pf.setPhoto_url_facture("./Any e");
            pf.setMotif(demande.getMotif());
            pf.setService(demande.getService());
            pfs.add(pf);
        }
        return pfs;
    }

}
