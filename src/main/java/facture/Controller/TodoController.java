package facture.Controller;
import org.springframework.web.bind.annotation.*;
import facture.Modele.Utilisateur;
import facture.Service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class TodoController {

    private final TodoService ts;

    public TodoController(TodoService ts) {
        this.ts = ts;
    }

    @GetMapping
    public List<Utilisateur> getAllUtilisateur() {
        return ts.getAllUtilisateur();
    }

    @PostMapping
    public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
        return ts.insert(utilisateur);
    }
}
