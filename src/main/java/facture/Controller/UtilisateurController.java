package facture.Controller;

import facture.Modele.Utilisateur;
import facture.Repos.UtilisateurRepository;
import facture.Service.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import ch.qos.logback.classic.pattern.Util;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
@CrossOrigin(origins = "http://localhost:4200/")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private final UtilisateurRepository user_rep;


    public UtilisateurController(UtilisateurService uS,UtilisateurRepository userRep){
        utilisateurService = uS;
        user_rep = userRep;
    }


    @PostMapping
    public Utilisateur create(@RequestBody Utilisateur utilisateur){
        return utilisateurService.create(utilisateur);
    }


    @GetMapping
    public List<Utilisateur> retrieve(){
        return utilisateurService.retrieve();
    }

    @PostMapping("/login")
    public HashMap<String,Object> login(@RequestBody Utilisateur user){
        HashMap<String,Object> resp = new HashMap<>();
        List<Utilisateur> listUtilisateurs  = user_rep.findByEmail(user.getEmail());
        if (listUtilisateurs.size() == 0) {
            resp.put("message", "Il n y a pas d'utilisateur avec cet Email");
            return resp;
        }
        for (Utilisateur utilisateur : listUtilisateurs) {
            if (utilisateur.getMot_passe() == user.getMot_passe()  ) {
                resp.put("message", listUtilisateurs);
                return resp;
            }
        }
        resp.put("message", "Votre mot de passe est incorecte");
        return resp;
    } 

}
