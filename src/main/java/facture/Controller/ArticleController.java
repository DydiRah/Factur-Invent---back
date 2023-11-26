package facture.Controller;

import java.util.List;

import facture.Repos.ArticleRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import facture.Modele.Article;
import facture.Service.ArticleService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/Articles")
@CrossOrigin(origins = "http://localhost:4200/")
public class ArticleController {
    private ArticleService art_serice;
    private ArticleRepository art_repo;

    @GetMapping
    public List<Article> getAllArticle() {
        return art_serice.retrieve();
    }

    @PostMapping
    public Article insert(@RequestBody Article a){
        return art_serice.create(a);
    }

    @GetMapping("/fournisseur/{id}")
    public List<Article> getByFournisseur(@PathVariable("id") int idFournisseur){
        return art_repo.getArticleByFournisseur(idFournisseur);
    }
}
