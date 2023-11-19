package facture.Service;

import facture.Modele.Article;
import facture.Modele.Fournisseur;
import facture.Repos.ArticleRepository;
import facture.Repos.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository aR){articleRepository=aR;}

    public void create(Article article){
        articleRepository.save(article);
    }

    public List<Article> retrieve(){
        return (List<Article>) articleRepository.findAll();
    }

    public List<Article> getAllArticleByName(String article){
        return null;
    }
}
