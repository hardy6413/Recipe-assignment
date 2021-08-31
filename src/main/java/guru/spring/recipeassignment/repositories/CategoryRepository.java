package guru.spring.recipeassignment.repositories;

import guru.spring.recipeassignment.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
