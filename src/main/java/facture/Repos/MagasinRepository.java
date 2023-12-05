package facture.Repos;

import facture.Modele.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MagasinRepository extends JpaRepository<Magasin,String> {
    @Query("SELECT s.article,s.type,s.magasin,SUM(s.quantite) AS nombre,SUM(s.quantite * s.prix_Unitaire) AS montant,s.unite " +
            "FROM Stock s " +
            "WHERE s.date_Stock <= :date and s.magasin like %:idMagasin% and s.article = :idArticle " +
            "GROUP BY s.article,s.type,s.magasin,s.unite")
    List<Object[]> get_Quantites_Montants_For_Date(@Param("date") Date date, @Param("idArticle") int idArticle, @Param("idMagasin") String idMagasin);
}

