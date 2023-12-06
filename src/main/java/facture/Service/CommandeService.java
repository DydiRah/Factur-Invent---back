package facture.Service;

import facture.Modele.*;
import facture.Repos.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import  java.util.List;

@AllArgsConstructor
@Service
public class CommandeService {
    private final CommandeRepository commandeRepository;
    private final DetailCommandeRepository detailCommandeRepository;
    private final DetailLivraisonRepository detailLivraisonRepository;
    private final DetailReceptionRepository detailReceptionRepository;
    private final StockRepository stockRepository;
    private final StockViewRepository stockViewRepository;
    private final ResteViewRepository resteViewRepository;
    private final AchatRepository achatRepository;

    @Transactional
    public void commander(Commande commande){
        commande.setEtat(0);
        Commande commande1 = commandeRepository.save(commande);
        for (DetailCommande detailCommande: commande.getDetailCommandeList()) {
            detailCommande.setCommande(commande1);
            System.out.println(detailCommande.getArticle());
            detailCommandeRepository.save(detailCommande);
        }
    }

    @Transactional
    public void changerEtat(Commande commande,int etat){
        commande.setEtat(etat);
        commandeRepository.save(commande);
    }

    @Transactional
    public void insertLivraison(List<DetailCommande> detailCommandes){
        for (DetailCommande detailCommande:detailCommandes) {
            DetailLivraison detailLivraison = new DetailLivraison(detailCommande);
            detailLivraisonRepository.save(detailLivraison);
        }
    }

    @Transactional
    public void insertReception(List<DetailLivraison> detailLivraisons){
        for (DetailLivraison detailLivraison : detailLivraisons) {
            DetailReception detailReception = new DetailReception(detailLivraison);
            detailReceptionRepository.save(detailReception);
        }
    }

    @Transactional
    public void insertStock(List<DetailReception> detailReceptions){
        for (DetailReception detailReception:detailReceptions) {
            Stock stock = new Stock(detailReception);
            stockRepository.save(stock);
        }
    }


    @Transactional
    public void sortirStock(List<DetailCommande> detailCommandes) throws Exception {
        for (DetailCommande detailCommande : detailCommandes) {
            Stock stock = new Stock(detailCommande,stockViewRepository);
            StockView stockView = stockViewRepository.getById(stock.getArticle().getArticle_id());
            List<Stock> composants = stock.decomposer(achatRepository,resteViewRepository,stockView);
            for (Stock composant : composants) {
                stockRepository.save(composant);
            }
        }
    }

    public List<Commande> byState(int etat){
        return commandeRepository.getByEtat(etat);
    }

    public List<DetailCommande> detailsByCommande(int id){
        Commande commande = new Commande();
        commande.setCommande_id(id);
        return detailCommandeRepository.getByCommande(commande);
    }

    public List<DetailLivraison> detailsLivraisonByCommande(int id){
        Commande commande = new Commande();
        commande.setCommande_id(id);
        return detailLivraisonRepository.getByCommande(commande);
    }

    public List<DetailReception> detailsReceptionByCommande(int id){
        Commande commande = new Commande();
        commande.setCommande_id(id);
        return detailReceptionRepository.getByCommande(commande);
    }

    public List<StockView> getEtatStocks(){
        return stockViewRepository.findAll();
    }


}
