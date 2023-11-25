package facture.Modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "demande_fournisseur")
public class Proforma {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String message;
    private String article;
    private String email;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) throws Exception {
        if(message == null || message == "")
            throw new Exception("Message requis");
        this.message = message;
    }
    public String getArticle() {
        return article;
    }
    public void setArticle(String article) throws Exception {
        if(article == null || article == "")
            throw new Exception("Article requis");
        this.article = article;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) throws Exception {
        if(email == null || email == "")
            throw new Exception("Email requis");
        this.email = email;
    }
}
