package facture.Repos;

import facture.Modele.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Integer> {
    @Query("SELECT s.article,s.unite,s.magasin " +
            "FROM Stock s " +
            "WHERE s.date_Stock <= :date " +
            "GROUP BY s.article,s.unite,s.magasin")
    List<Object[]> get_Article_In_Stock(@Param("date") Date date);

}
