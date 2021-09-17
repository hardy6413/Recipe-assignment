package guru.spring.recipeassignment.services;

import guru.spring.recipeassignment.commands.RecipeCommand;
import guru.spring.recipeassignment.converters.RecipeCommandToRecipe;
import guru.spring.recipeassignment.converters.RecipeToRecipeCommand;
import guru.spring.recipeassignment.domain.Recipe;
import guru.spring.recipeassignment.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeServiceIT {

    public static final String NEW_DESCRIPTION = "new description";

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Transactional
    @Test
    public void testSaveOfDescription(){
        //given
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe testRecipe = recipes.iterator().next();
        RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

        //when
        testRecipeCommand.setDescription(NEW_DESCRIPTION);
        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);

        //then
        assertEquals(NEW_DESCRIPTION,savedRecipeCommand.getDescription());
        assertEquals(testRecipe.getId(),savedRecipeCommand.getId());
        assertEquals(testRecipe.getCategories().size(),savedRecipeCommand.getCategories().size());
        assertEquals(testRecipe.getIngredients().size(),savedRecipeCommand.getIngredients().size());
    }
}