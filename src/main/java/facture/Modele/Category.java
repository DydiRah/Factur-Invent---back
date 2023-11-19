package facture.Modele;

import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int category_id;
    String category_nom;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_nom() {
        return category_nom;
    }

    public void setCategory_nom(String category_nom) {
        this.category_nom = category_nom;
    }
}
