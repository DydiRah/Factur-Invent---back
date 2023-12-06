package facture.Repos;

import facture.Modele.StockView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StockViewRepository extends JpaRepository<StockView,Integer> {
}
