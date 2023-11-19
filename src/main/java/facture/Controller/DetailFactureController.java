package facture.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import facture.Modele.DetailFacture;
import facture.Modele.Facture;
import facture.Service.DetailFactureService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/Detail_facture")
@CrossOrigin(origins = "http://localhost:4200/")
public class DetailFactureController {
    private final DetailFactureService fact_sv;

    @GetMapping
    public List<DetailFacture> getAllDetailFacture() {
        return fact_sv.getAllDetailFacture();
    }

    @GetMapping("/{facture_id}")
    public List<DetailFacture> getDetailFacture(@PathVariable Facture facture_id) {
        return fact_sv.getAllDetailFacture(facture_id);
    }
}
