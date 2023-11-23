package facture.Controller;

import facture.Modele.Article;
import facture.Modele.Demande;
import facture.Modele.ProformatFacture;
import facture.Service.ArticleService;
import facture.Service.DemandeService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/demandes")
@CrossOrigin(origins = "http://localhost:4200/")
public class DemandeController {

    private final DemandeService demandeService;
    private final ArticleService articleService;

    public DemandeController(DemandeService dS,ArticleService aS){
        demandeService = dS;
        articleService = aS;
    }

    @PostMapping
    public HashMap<String,Object> create(@RequestBody Demande demande){
        HashMap<String,Object> reponse = new HashMap<>();
        try {
            reponse.put("Message","Success: Telles sont nos suggestions.");
            reponse.put("Data",demandeService.getAllProformatFacture(demande));
            demandeService.create(demande);
        }catch (Exception ex){
            reponse.put("Message","Error: "+ex.getMessage());
            reponse.put("Data",null);
        }
        return reponse;
    }

}
