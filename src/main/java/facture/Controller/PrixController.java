package facture.Controller;

import facture.Modele.Prix;
import facture.Repos.PrixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prix")
@CrossOrigin("*")
public class PrixController {
    @Autowired
    PrixRepository prix_repo;

    @GetMapping
    public List<Prix> getLastPrix(){
        return prix_repo.getAllLastDate();
    }

    @PostMapping
    public Prix insert(@RequestBody Prix p){
        return prix_repo.save(p);
    }
}
