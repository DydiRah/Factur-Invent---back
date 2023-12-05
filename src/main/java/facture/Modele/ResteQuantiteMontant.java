package facture.Modele;

public class ResteQuantiteMontant {
    String id_Article;
    String type;
    String magasin;
    Double nombre;
    Double montant;
    String unite;

    public ResteQuantiteMontant(Object[] objects){
            setId_Article(""+objects[0]);
            setType(""+objects[1]);
            setMagasin(""+objects[2]);
            setNombre((double) objects[3]);
            setMontant((double) objects[4]);
            setUnite(""+objects[5]);
    }

    public String getId_Article() {
        return id_Article;
    }

    public void setId_Article(String id_Article) {
        this.id_Article = id_Article;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMagasin() {
        return magasin;
    }

    public void setMagasin(String magasin) {
        this.magasin = magasin;
    }

    public Double getNombre() {
        return nombre;
    }

    public void setNombre(Double nombre) {
        this.nombre = nombre;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

}
