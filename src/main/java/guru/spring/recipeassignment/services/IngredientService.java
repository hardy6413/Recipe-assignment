package guru.spring.recipeassignment.services;

import guru.spring.recipeassignment.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
