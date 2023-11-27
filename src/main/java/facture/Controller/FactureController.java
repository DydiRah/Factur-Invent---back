package facture.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import facture.Modele.Article;
import facture.Modele.DetailFacture;
import facture.Modele.Facture;
import facture.Service.ArticleService;
import facture.Service.DetailFactureService;
import facture.Service.FactureService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/Facture")
@CrossOrigin(origins = "http://localhost:4200/")
public class FactureController {
    private final FactureService fact_sv;
    private final DetailFactureService detail_fact_sv;
    private final ArticleService articleService;

    @GetMapping
    public List<Facture> getAllFacture() {
        return fact_sv.getAllFacture();
    }

    @PostMapping
    public Facture ajoutFacture(@RequestBody Facture facture){
        double prix = 0;
        Facture f = fact_sv.creerFacture(facture);
        f.setFact_detail_facture(articleService.getArticleInfo(f.getFact_detail_facture()));
        List<DetailFacture> list = f.getFact_detail_facture();
        for (DetailFacture detailFacture : list) {
            ///tsy aiko oe manina fa tsy mintsy ito  :( ----------------------*----------------------------*--------
            //detailFacture.setDetFactureFacture(f);
            //detailFacture.getDetFactureFacture().setFact_id(f.getFact_id());
            //System.out.println(detailFacture.getDetFactureFacture().getFact_id()+"______");
            detail_fact_sv.creerDetailFacture(detailFacture);
            prix = prix + (detailFacture.getQuantite()* detailFacture.getArticle().getPrix_unitaire());
            System.out.println(detailFacture.getQuantite()+"=quantite");
            System.out.println(detailFacture.getArticle().getArticle_id()+"=art_id");
            System.out.println(f.getFact_id()+"=facture_id");

        }
        Facture updateF = fact_sv.updateFacture(f.getFact_id(), prix);
        return updateF;
    }

    @PutMapping("/{facture_id}")
    public Facture modifierFacture(@PathVariable Integer facture_id,@RequestBody Facture facture){
        return fact_sv.updateFacture(facture_id, facture);
    }

}
