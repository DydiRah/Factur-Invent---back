package facture.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import facture.Modele.DetailFacture;
import facture.Modele.Facture;
import facture.Service.DetailFactureService;
import facture.Service.FactureService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/Facture")
@CrossOrigin(origins = "http://localhost:4200/")
public class FactureController {
    private final FactureService fact_sv;
    private final DetailFactureService detail_fact_sv;

    @GetMapping
    public List<Facture> getAllFacture() {
        return fact_sv.getAllFacture();
    }

    @PostMapping
    public Facture ajoutFacture(@RequestBody Facture facture){
        List<DetailFacture> list = facture.getFact_detail_facture();
        for (DetailFacture detailFacture : list) {
            detail_fact_sv.creerDetailFacture(detailFacture);
        }
        return fact_sv.creerFacture(facture);
    }

    @PutMapping("/{facture_id}")
    public Facture modifierFacture(@PathVariable Integer facture_id,@RequestBody Facture facture){
        return fact_sv.updateFacture(facture_id, facture);
    }

}
