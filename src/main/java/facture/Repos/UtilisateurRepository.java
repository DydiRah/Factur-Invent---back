package facture.Repos;

import facture.Modele.Utilisateur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    List<Utilisateur> findByEmail(String email);
}
