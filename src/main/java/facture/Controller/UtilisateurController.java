package facture.Controller;

import facture.Modele.Utilisateur;
import facture.Service.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
@CrossOrigin(origins = "http://localhost:4200/")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService uS){utilisateurService = uS;}

    @PostMapping
    public void create(@RequestBody Utilisateur utilisateur){
        utilisateurService.create(utilisateur);
    }


    @GetMapping
    public List<Utilisateur> retrieve(){
        return utilisateurService.retrieve();
    }
}
