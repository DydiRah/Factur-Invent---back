package facture.Repos;

import facture.Modele.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
    List<Article> getArtileByDesignation(String designation);

    @Query(value="SELECT * FROM Article WHERE fournisseur_id = :fournisseur", nativeQuery = true)
    public List<Article> getArticleByFournisseur(@Param("fournisseur") int id);
}
