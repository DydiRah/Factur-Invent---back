package facture.Repos;

import facture.Modele.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Integer> {
}
