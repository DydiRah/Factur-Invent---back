package facture.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import facture.Modele.Utilisateur;
import facture.Repos.UserRepository;

import java.util.List;

@Service
public class TodoService {
    private final UserRepository urp;


    @Autowired
    public TodoService(UserRepository urp) {
        this.urp = urp;
    }

    public List<Utilisateur> getAllUtilisateur(){
        return (List<Utilisateur>) urp.findAll();
    }

    @Transactional
    public Utilisateur insert(Utilisateur utilisateur){
        return urp.save(utilisateur);
    }

}
