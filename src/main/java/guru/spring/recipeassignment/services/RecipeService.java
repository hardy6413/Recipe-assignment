package guru.spring.recipeassignment.services;

import guru.spring.recipeassignment.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
