package facture.Repos;

import facture.Modele.Achat;
import facture.Modele.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AchatRepository extends JpaRepository<Achat,Integer> {
    @Query("SELECT a FROM Achat a " +
            "WHERE a.date_Stock = (SELECT MIN(a1.date_Stock) FROM Achat a1 WHERE a1.article_id = :article_id) AND a.article_id = :article_id")
    public Achat getFirstAchat(@Param("article_id")int article_id);
}
