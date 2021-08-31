package guru.spring.recipeassignment.repositories;

import guru.spring.recipeassignment.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
