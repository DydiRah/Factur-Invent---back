package facture.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.pattern.Util;
import facture.Modele.Facture;
import facture.Modele.Utilisateur;
import facture.Repos.DetailFactureRepository;
import facture.Repos.FactureRepository;
import facture.Repos.UtilisateurRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class FactureService {

    public FactureService(){}
    @Autowired
    private FactureRepository fact_rep;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private DetailFactureRepository det_fact_rep;
    
    @Transactional
    public Facture creerFacture(Facture facture) {
        if (facture.getFact_utilisateur() == null) {
            throw new IllegalArgumentException("Impossible de trouver la personne associer à cette facture.");
        }
        Utilisateur utilisateur = utilisateurRepository.findById(
            facture.getFact_utilisateur().getUtilisateur_id()
        ).orElseThrow(() -> new EntityNotFoundException("Utilisateur invalide for ID: " + facture.getFact_utilisateur().getUtilisateur_id()));
        facture.setFact_utilisateur(utilisateur);
        return fact_rep.save(facture);
    }

    @Transactional
    public List<Facture> getAllFacture() {
        List<Facture> list = fact_rep.findAll();
        for (Facture facture : list) {
            facture.setFact_detail_facture(det_fact_rep.findByDetFactureFacture(facture));
        }
        return list;
    }
    @Transactional
    public Facture updateFacture(int id,Facture facture ) {
        Facture val = fact_rep.findById(id).map(
            fact -> {
                fact.setFact_utilisateur(facture.getFact_utilisateur());
                fact.setFact_tva(facture.getFact_tva());
                fact.setFact_detail_facture(facture.getFact_detail_facture());
                fact.setFact_prix_total_hors_taxe(facture.getFact_prix_total_hors_taxe());
                return fact;
            }
        ).orElseThrow(() -> new RuntimeException("Impossible de trouver la Facture avec l'ID : " + id));
       return fact_rep.save(val);
    }

    @Transactional
    public Facture updateFacture(int id,double prix_total_hors_taxe ) {
        Facture val = fact_rep.findById(id).map(
            fact -> {
                fact.setFact_prix_total_hors_taxe(prix_total_hors_taxe);
                return fact;
            }
        ).orElseThrow(() -> new RuntimeException("Impossible de trouver la Facture avec l'ID : " + id));
       return fact_rep.save(val);
    }

}
