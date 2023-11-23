package facture.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import facture.Modele.Fournisseur;
import facture.Service.FournisseurService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/Fournisseurs")
@CrossOrigin(origins = "http://localhost:4200/")
public class FournisseurController {
    private final FournisseurService fournisseur_serice;

    @GetMapping
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseur_serice.retrieve();
    }

    @PostMapping
    public Fournisseur insert(@RequestBody Fournisseur f){
        return fournisseur_serice.create(f);
    }
}
