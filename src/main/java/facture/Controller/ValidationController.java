package facture.Controller;

import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import facture.Modele.Validation;
import facture.Repos.DemandeRepository;
import facture.Service.DemandeService;
import facture.Service.ValidationService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/Validation")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class ValidationController {
    private final ValidationService validationService;
    private final DemandeService demandeService;

    private final DemandeRepository demande_rep;
    @PostMapping
    public Validation create(@RequestBody Validation validation){
        Validation v = validationService.validationByChefDep(validation);
        v.setDemande_id(demande_rep.findById(v.getDemande_id().getDemande_id()).get());
        return v;
    }

    @PostMapping("validation")
    public Validation validation(@RequestBody Validation validation){
        Validation v = validationService.validation(validation);
        v.setDemande_id(demande_rep.findById(v.getDemande_id().getDemande_id()).get());
        return v;
    }

    @GetMapping("/{etat}")
    public java.util.List<Validation> getValidationParValidation(@PathVariable("etat") int etat){
        return demandeService.listDemande(etat);
    }
}
