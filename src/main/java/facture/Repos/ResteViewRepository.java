package facture.Repos;

import facture.Modele.ResteView;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface ResteViewRepository extends JpaRepository<ResteView,Integer> {
    @Query("SELECT rv FROM ResteView rv WHERE rv.article_id = :article_id ORDER BY " +
            "CASE WHEN :ordre = 'ASC' THEN rv.date_stock END ASC," +
            "CASE WHEN :ordre = 'DESC' THEN rv.date_stock END DESC")
    public List<ResteView> getEntrees(@Param("article_id") int article_id,@Param("ordre") String ordre);
}
