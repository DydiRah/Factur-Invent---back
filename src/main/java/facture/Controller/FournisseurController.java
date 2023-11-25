package facture.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import facture.Modele.Fournisseur;
import facture.Modele.Utilisateur;
import facture.Repos.FournisseurRepository;
import facture.Service.FournisseurService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/Fournisseurs")
@CrossOrigin(origins = "http://localhost:4200/")
public class FournisseurController {
    private final FournisseurService fournisseur_serice;
    private final FournisseurRepository fournisseur_rep;

    @GetMapping
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseur_serice.retrieve();
    }

    @PostMapping
    public Fournisseur insert(@RequestBody Fournisseur f){
        return fournisseur_serice.create(f);
    }

    @PostMapping("/login")
    public HashMap<String,Object> login(@RequestBody Fournisseur fournisseur){
        HashMap<String,Object> resp = new HashMap<>();
        List<Fournisseur> listFournisseur  = fournisseur_rep.findByEmail(fournisseur.getEmail());
        if (listFournisseur.size() == 0) {
            resp.put("message", "emailerreur");
            return resp;
        }
        for (Fournisseur f : listFournisseur) {
            if (f.getMot_passe().equals(fournisseur.getMot_passe()  )) {
                resp.put("message", listFournisseur);
                return resp;
            }
        }
        resp.put("message", "mdperreur");
        return resp;
    } 
}
