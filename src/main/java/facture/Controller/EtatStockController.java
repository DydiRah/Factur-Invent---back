package facture.Controller;

import facture.Service.CommandeService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/EtatStock")
@CrossOrigin(origins = "http://localhost:4200")
public class EtatStockController {
    private final CommandeService commandeService;
    @GetMapping
    public HashMap<String,Object> get_Stock_Info(@PathParam("date1")String date1, @PathParam("date2")String date2){
        HashMap<String,Object> reponse = new HashMap<>();
        try {
            reponse.put("Message","Success.");
            reponse.put("Data",commandeService.getEtatStocks());
        } catch (Exception e) {
            reponse.put("Message","Error: " + e.getMessage() + " .");
            reponse.put("Data",null);
        }
        return reponse;
    }



}
