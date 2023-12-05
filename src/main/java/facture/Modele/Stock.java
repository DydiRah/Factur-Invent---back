package facture.Modele;

import facture.Repos.StockRepository;
import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.*;

//Mouvement
@Entity
@Table(name="stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_Stock;
    Date date_Stock;
    @ManyToOne
    @JoinColumn(name = "article_id")
    Article article;
    double quantite;
    double prix_Unitaire;
    String type;
    String unite;
    @ManyToOne
    @JoinColumn(name = "magasin_id")
    Magasin magasin;
    int source;

    public Stock(){
    }

    public Stock(DetailReception detailReception){
        setDate_Stock(new Date());
        setArticle(detailReception.getArticle());
        setQuantite(detailReception.getQuantite());
        setPrix_Unitaire(detailReception.getPrix_unitaire());
        setType("Entree");
        setUnite(detailReception.getArticle().getUnite());
        setMagasin(new Magasin("M1"));
        setSource(0);
    }

    public int getId_Stock() {
        return id_Stock;
    }

    public void setId_Stock(int id_Stock) {
        this.id_Stock = id_Stock;
    }

    public Date getDate_Stock() {
        return date_Stock;
    }

    public void setDate_Stock(Date date_Stock) {
        this.date_Stock = date_Stock;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getPrix_Unitaire() {
        return prix_Unitaire;
    }

    public void setPrix_Unitaire(double prix_Unitaire) {
        this.prix_Unitaire = prix_Unitaire;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public static List<Stock> get_Article_In_Stock(StockRepository stockRepository, Date date) throws Exception{
        List<Object[]> article_in_stock = stockRepository.get_Article_In_Stock(date);
        List<Stock> stocks = new ArrayList<Stock>();
        for (Object[] as: article_in_stock) {
            Stock stock = new Stock();
            stock.setArticle(new Article((int)as[0]));
            stock.setUnite((String)as[1]);
            stock.setMagasin(new Magasin((String)as[2]));
            stocks.add(stock);
        }
        return stocks;
    }
}
