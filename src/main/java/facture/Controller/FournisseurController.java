package facture.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import facture.Modele.Article;
import facture.Modele.Fournisseur;
import facture.Service.ArticleService;
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
}
