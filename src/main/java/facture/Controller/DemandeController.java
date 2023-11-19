package facture.Controller;

import facture.Modele.Demande;
import facture.Service.DemandeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demandes")
@CrossOrigin(origins = "http://localhost:4200/")
public class DemandeController {

    private final DemandeService demandeService;

    public DemandeController(DemandeService dS){demandeService = dS;}

    @PostMapping
    public void create(@RequestBody Demande demande){
        demandeService.create(demande);
    }
}
