package facture.Controller;

import facture.Modele.Commande;
import facture.Modele.DetailCommande;
import facture.Modele.InfoCommande;
import facture.Modele.Utilisateur;
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
}
