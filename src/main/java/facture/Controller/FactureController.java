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
        Facture f = fact_sv.creerFacture(facture);
        f.setFact_detail_facture(articleService.getArticleInfo(f.getFact_detail_facture()));
        return f;
        // for (DetailFacture detailFacture : list) {
        //     //detail_fact_sv.creerDetailFacture(detailFacture);
        //     System.out.println(detailFacture.getArticle().getDesignation());
        // }
        // System.out.println("------------------------------------"+list.size());

        
    }

    @PutMapping("/{facture_id}")
    public Facture modifierFacture(@PathVariable Integer facture_id,@RequestBody Facture facture){
        return fact_sv.updateFacture(facture_id, facture);
    }

}
