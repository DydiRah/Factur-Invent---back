package facture.Controller;

import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import facture.Modele.Demande;
import facture.Modele.Utilisateur;
import facture.Modele.Validation;
import facture.Repos.DemandeRepository;
import facture.Service.DemandeService;
import facture.Service.UtilisateurService;
import facture.Service.ValidationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/Validation")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class ValidationController {
    private final ValidationService validationService;
    private final DemandeRepository demande_rep;
    @PostMapping
    public Validation create(@RequestBody Validation validation){
        Validation v = validationService.validationByChefDep(validation);
        v.setDemande_id(demande_rep.findById(v.getDemande_id().getDemande_id()).get());
        return v;
    }
}
