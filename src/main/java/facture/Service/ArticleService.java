package facture.Service;

import facture.Modele.Article;
import facture.Modele.DetailFacture;
import facture.Repos.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository aR){articleRepository=aR;}

    public Article create(Article article){
        return articleRepository.save(article);
    }

    public List<Article> retrieve(){
        return (List<Article>) articleRepository.findAll();
    }

    public List<Article> getAllArticleByName(String article_demander){
        return articleRepository.getArtileByDesignation(article_demander);
    }

    public List<DetailFacture> getArticleInfo(List<DetailFacture> dfs){
        for (DetailFacture detailFacture : dfs) {
            Article formee = articleRepository.findById(detailFacture.getArticle().getArticle_id()).get();
            detailFacture.setArticle(formee);
        }
        return dfs;
    }
}
