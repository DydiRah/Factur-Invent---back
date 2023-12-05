package facture.Controller;

import facture.Modele.*;
import facture.Service.CommandeService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


@RestController
@AllArgsConstructor
@RequestMapping("/Commande")
@CrossOrigin(origins = "http://localhost:4200/")
public class CommandeController {
    private final CommandeService commandeService;
    @PostMapping
    public void commander(@RequestBody Commande commande){
        commandeService.commander(commande);
    }

    @GetMapping
    public List<Commande> byState(@PathParam("etat") int etat){
        return commandeService.byState(etat);
    }

    @GetMapping("/details")
    public List<DetailCommande> details(@PathParam("id") int id){
        return commandeService.detailsByCommande(id);
    }

    @GetMapping("/detailsLivraison")
    public List<DetailLivraison> detailsLivraison(@PathParam("id") int id){
        return commandeService.detailsLivraisonByCommande(id);
    }

    @GetMapping("/detailsReception")
    public List<DetailReception> detailsReception(@PathParam("id") int id){
        return commandeService.detailsReceptionByCommande(id);
    }

    @PostMapping("/demandeLivraison")
    public void demandeLivraison(@RequestBody List<DetailCommande> detailCommandes){
        commandeService.changerEtat(detailCommandes.getFirst().getCommande(), 5);
    }

    @PostMapping("/livrer")
    public void livrer(@RequestBody List<DetailCommande> detailCommandes){
        commandeService.changerEtat(detailCommandes.getFirst().getCommande(), 10);
        commandeService.insertLivraison(detailCommandes);
    }

    @PostMapping("/recevoir")
    public void recevoir(@RequestBody List<DetailLivraison> detailLivraisons){
        commandeService.changerEtat(detailLivraisons.getFirst().getCommande(), 20);
        commandeService.insertReception(detailLivraisons);
    }

    @PostMapping("/stocker")
    public void stocker(@RequestBody List<DetailReception> detailReceptions){
        commandeService.changerEtat(detailReceptions.getFirst().getCommande(), 30);
        commandeService.insertStock(detailReceptions);
    }
}
