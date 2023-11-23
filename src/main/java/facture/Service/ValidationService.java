package facture.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import facture.Modele.Demande;
import facture.Modele.Validation;
import facture.Repos.DemandeRepository;
import facture.Repos.ValidationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.val;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ValidationService {
    @Autowired
    private ValidationRepository valide_rep;

    @Autowired
    private DemandeRepository demande_rep;

    @Transactional
    public Validation validationByChefDep(Validation validation){
        Demande demande = demande_rep.findById(validation.getDemande_id().getDemande_id())
        .orElseThrow(() -> new EntityNotFoundException("Demande non valide"));
        validation.setValidation_etat(10);
        return valide_rep.save(validation);
    }
}
