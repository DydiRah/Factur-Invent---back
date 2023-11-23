package facture.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import facture.Modele.Article;
import facture.Service.ArticleService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/Articles")
@CrossOrigin(origins = "http://localhost:4200/")
public class ArticleController {
    private final ArticleService art_serice;

    @GetMapping
    public List<Article> getAllArticle() {
        return art_serice.retrieve();
    }

    @PostMapping
    public Article insert(@RequestBody Article a){
        return art_serice.create(a);
    }
}
