package facture.Service;

import facture.Modele.*;
import facture.Repos.DemandeRepository;
import facture.Repos.UtilisateurRepository;
import facture.Repos.ValidationRepository;
import jakarta.persistence.EntityManager;
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
    private final ValidationRepository valid_rep;
    @Autowired
    private EntityManager em;


    @Autowired
    public DemandeService(DemandeRepository dR,ArticleService aS,UtilisateurRepository uR,ValidationRepository val_rep){
        demandeRepository = dR;
        articleService = aS;
        utilisateurRepository = uR;
        valid_rep = val_rep;
    }

    @Transactional
    public void create(Demande demande){
        Validation v=  new Validation();
        v.setDemande(demande);
        v.setValidation_etat(0);
        v.setValidation_date(demande.getDemande_date());
        valid_rep.save(v);
        demandeRepository.save(demande);
    }

    public List<Validation> listDemande(int etat){
        List<Validation> list = em.createNativeQuery("SELECT  d.*,  COALESCE(valid.validation_etat, 0) AS validation_etat, valid.validation_date, COALESCE(valid.validation_id, 0) AS validation_id FROM demande d LEFT JOIN  validation valid ON d.demande_id = valid.demande_id WHERE COALESCE(valid.validation_etat, 0) = :etat",Validation.class)
                    .setParameter("etat", etat)
                    .getResultList();
        return list;
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
