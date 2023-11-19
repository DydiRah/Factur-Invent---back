package facture.Service;

import facture.Modele.Category;
import facture.Repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository cR){categoryRepository=cR;}

    public void create(Category Category){
        categoryRepository.save(Category);
    }

    public List<Category> retrieve(){
        return (List<Category>) categoryRepository.findAll();
    }
}
