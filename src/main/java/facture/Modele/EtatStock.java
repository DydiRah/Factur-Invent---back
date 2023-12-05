package facture.Modele;

import facture.Repos.MagasinRepository;
import facture.Repos.StockRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EtatStock {
    Article article;
    double qInitiale;
    double qFinale;
    double prixUnitaire;
    String unite;
    Magasin magasin;
    double montant;

    public EtatStock(Stock stock, Date date1, Date date2, MagasinRepository magasinRepository){
        Article article = stock.getArticle();
        Magasin magasin = stock.getMagasin();
        double qInitiale = magasin.get_Reste_For_Date(magasinRepository,date1,article.getArticle_id());
        double qFinale = magasin.get_Reste_For_Date(magasinRepository,date2,article.getArticle_id());
        double montant = magasin.get_Montant_For_Date(magasinRepository,date2,article.getArticle_id());
        setArticle(article);
        setqInitiale(qInitiale);
        setqFinale(qFinale);
        setPrixUnitaire(montant / qFinale);
        setUnite(stock.getUnite());
        setMagasin(magasin);
        setMontant(montant);
    }

    public EtatStock() {
    }


    public double getqInitiale() {
        return qInitiale;
    }

    public void setqInitiale(double qInitiale) {
        this.qInitiale = qInitiale;
    }

    public double getqFinale() {
        return qFinale;
    }

    public void setqFinale(double qFinale) {
        this.qFinale = qFinale;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public static List<EtatStock> get_Etat_By_date(Date date1, Date date2, MagasinRepository magasinRepository, StockRepository stockRepository) throws Exception{
        List<Stock> stocks = Stock.get_Article_In_Stock(stockRepository,date2);
        List<EtatStock> etatStocks = new ArrayList<>();
        for (Stock stock:stocks) {
            EtatStock etatStock = new EtatStock(stock,date1,date2,magasinRepository);
            etatStocks.add(etatStock);
        }
        return etatStocks;
    }
}
