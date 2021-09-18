package guru.spring.recipeassignment.services;

import guru.spring.recipeassignment.commands.RecipeCommand;
import guru.spring.recipeassignment.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long id);

}
