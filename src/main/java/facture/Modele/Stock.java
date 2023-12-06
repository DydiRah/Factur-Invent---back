package facture.Modele;

import facture.Repos.AchatRepository;
import facture.Repos.ResteViewRepository;
import facture.Repos.StockRepository;
import facture.Repos.StockViewRepository;
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

    public Stock(DetailCommande detailCommande,StockViewRepository stockViewRepository) throws Exception {
        Magasin magasin = new Magasin("M1");
        setDate_Stock(new Date());
        setArticle(detailCommande.getArticle());
        setQuantite(detailCommande.getQuantite(),magasin,stockViewRepository);
        setPrix_Unitaire(detailCommande.getPrix_unitaire());
        setType("Sortie");
        setUnite(detailCommande.getArticle().getUnite());
        setMagasin(magasin);
        setSource(0);
    }

    //composant
    public Stock(Stock general, ResteView entree, Achat firstAchat){
        setDate_Stock(general.getDate_Stock());
        setArticle(general.getArticle());
        //1.4*1er prix d'achat
        setPrix_Unitaire(1.4 * firstAchat.getPrix_Unitaire());
        setType("Sortie");
        setUnite(entree.getUnite());
        setMagasin(new Magasin("M1"));
        setSource(entree.getId_stock());
    }

    public void setQuantite(double quantite, Magasin magasin, StockViewRepository stockViewRepository) throws Exception{
        if(quantite > magasin.getReste(getArticle().getArticle_id(),stockViewRepository)){
            throw new Exception("Quantite insuffisant .");
        }
        setQuantite(quantite);
    }



    public List<Stock> decomposer(AchatRepository achatRepository,ResteViewRepository resteViewRepository,StockView stockView){
        List<ResteView> entrees = getMagasin().getResteByEntree(getArticle().getArticle_id(),resteViewRepository,stockView);
        List<Stock> sorties = new ArrayList<>();
        Achat firstAchat = achatRepository.getFirstAchat(getArticle().getArticle_id());
        double sortie = getQuantite();
        int idSE = 0;
        while(sortie != 0){
            ResteView entree = entrees.get(idSE);
            Stock composant = new Stock(this,entree,firstAchat);
            double reste = entree.getReste();
            if (reste >= sortie){
                composant.setQuantite(sortie);
                sortie = 0;
            }else {
                sortie = sortie - reste;
                composant.setQuantite(reste);
            }
            sorties.add(composant);
            idSE++;
        }
        return sorties;
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



}
