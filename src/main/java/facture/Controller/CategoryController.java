package facture.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import facture.Modele.Article;
import facture.Modele.Category;
import facture.Service.ArticleService;
import facture.Service.CategoryService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/Category")
@CrossOrigin(origins = "http://localhost:4200/")
public class CategoryController {
    private final CategoryService cat_serice;

    @GetMapping
    public List<Category> getAllCategory() {
        return cat_serice.retrieve();
    }
}
