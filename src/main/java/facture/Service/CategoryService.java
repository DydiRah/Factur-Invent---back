package facture.Service;

import facture.Modele.Category;
import facture.Repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository cR){categoryRepository=cR;}

    public Category create(Category Category){
        return categoryRepository.save(Category);
    }

    public List<Category> retrieve(){
        return (List<Category>) categoryRepository.findAll();
    }
}
