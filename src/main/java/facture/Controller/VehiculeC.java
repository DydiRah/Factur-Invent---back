package facture.Controller;

import org.springframework.web.bind.annotation.*;
import facture.Modele.Vehicule;
import facture.Service.VehiculeService;

import java.util.List;

@RestController
@RequestMapping("/vehicules")
public class VehiculeC {

    private final VehiculeService vs;

    public VehiculeC(VehiculeService vs) {
        this.vs = vs;
    }
    @GetMapping
    public List<Vehicule> getAllVehicules() {
        return vs.retrieve();
    }

    @PostMapping
    public Vehicule addVehicule(@RequestBody Vehicule vehicule){
        return vs.create(vehicule);
    }

    @DeleteMapping
    public void deleteVehicule(@RequestBody Vehicule vehicule){
        vs.delete(vehicule);
    }

    @PutMapping
    public Vehicule updateVehicule(@RequestBody Vehicule vehicule){
        return vs.update(vehicule);
    }

}
