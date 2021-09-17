package guru.spring.recipeassignment.converters;

import guru.spring.recipeassignment.commands.CategoryCommand;
import guru.spring.recipeassignment.commands.IngredientCommand;
import guru.spring.recipeassignment.commands.NotesCommand;
import guru.spring.recipeassignment.commands.RecipeCommand;
import guru.spring.recipeassignment.domain.Difficulty;
import guru.spring.recipeassignment.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecipeCommandToRecipeTest {

    private static final  Long RECIPE_ID = 1L;
    private static final  String DESCRIPTION = "My Recipe";
    private static final  Integer PREP_TIME = 7;
    private static final  Integer COOK_TIME = 5;
    private static final  Integer SERVINGS = 3;
    private static final  String SOURCE = "source";
    private static final  String URL = "url";
    private static final  String DIRECTIONS = "directions";
    private static final  Long CAT_ID_1 = 1L;
    private static final  Long CAT_ID_2 = 2L;
    private static final  Long INGRED_ID_1 = 3L;
    private static final  Long INGRED_ID_2 = 4L;
    private static final  Long NOTES_ID = 8L;
    public static final Difficulty DIFFICULTY = Difficulty.EASY;


    RecipeCommandToRecipe converter;

    @BeforeEach
    void setUp() {
        converter = new RecipeCommandToRecipe(new CategoryCommandToCategory(),
                new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new NotesCommandToNotes());
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject()  {
        assertNotNull(converter.convert(new RecipeCommand()));
    }

    @Test
    void convert() {
        //given
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setDifficulty(DIFFICULTY);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setId(RECIPE_ID);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);
        recipeCommand.setPrepTime(PREP_TIME);

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(NOTES_ID);
        recipeCommand.setNotes(notesCommand);

        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(CAT_ID_1);

        CategoryCommand categoryCommand2 = new CategoryCommand();
        categoryCommand2.setId(CAT_ID_2);

        recipeCommand.getCategories().add(categoryCommand);
        recipeCommand.getCategories().add(categoryCommand2);

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(INGRED_ID_1);

        IngredientCommand ingredientCommand2 = new IngredientCommand();
        ingredientCommand2.setId(INGRED_ID_2);

        recipeCommand.getIngredients().add(ingredientCommand);
        recipeCommand.getIngredients().add(ingredientCommand2);

        //when
        Recipe recipe = converter.convert(recipeCommand);

        //then
        assertNotNull(recipe);
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(RECIPE_ID, recipe.getId());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(PREP_TIME, recipe.getPrepTime());




    }
}