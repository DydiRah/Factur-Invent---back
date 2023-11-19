package facture.Repos;

import facture.Modele.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
    List<Article> getArtileByDesignation(String designation);
}
