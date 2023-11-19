package facture.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import facture.Modele.Facture;
import facture.Service.FactureService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/Facture")
public class FactureController {
    private final FactureService fact_sv;

    @GetMapping
    public List<Facture> getAllFacture() {
        return fact_sv.getAllFacture();
    }

}
