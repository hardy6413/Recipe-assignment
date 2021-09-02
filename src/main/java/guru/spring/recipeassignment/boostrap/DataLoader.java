package guru.spring.recipeassignment.boostrap;

import guru.spring.recipeassignment.domain.*;
import guru.spring.recipeassignment.repositories.CategoryRepository;
import guru.spring.recipeassignment.repositories.RecipeRepository;
import guru.spring.recipeassignment.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;
    private  final RecipeRepository recipeRepository;


    public DataLoader(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if (teaspoonUomOptional.isEmpty()){
            throw  new RuntimeException("Expected Uom not found");
        }

        Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if (tablespoonUomOptional.isEmpty()){
            throw  new RuntimeException("Expected Uom not found");
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if (cupUomOptional.isEmpty()){
            throw  new RuntimeException("Expected Uom not found");
        }

        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");

        if (pinchUomOptional.isEmpty()){
            throw  new RuntimeException("Expected Uom not found");
        }

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");

        if (ounceUomOptional.isEmpty()){
            throw  new RuntimeException("Expected Uom not found");
        }

        Optional<UnitOfMeasure> cloveUomOptional = unitOfMeasureRepository.findByDescription("Clove");

        if (cloveUomOptional.isEmpty()){
            throw  new RuntimeException("Expected Uom not found");
        }

        Optional<UnitOfMeasure> poundUomOptional = unitOfMeasureRepository.findByDescription("Pound");

        if (poundUomOptional.isEmpty()){
            throw  new RuntimeException("Expected Uom not found");
        }

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if (eachUomOptional.isEmpty()){
            throw  new RuntimeException("Expected Uom not found");
        }

        UnitOfMeasure teaspoonUom = teaspoonUomOptional.get();
        UnitOfMeasure tablespoonUom = tablespoonUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();
        UnitOfMeasure pinchUom = pinchUomOptional.get();
        UnitOfMeasure ounceUom = ounceUomOptional.get();
        UnitOfMeasure cloveUom = cloveUomOptional.get();
        UnitOfMeasure poundUom = poundUomOptional.get();
        UnitOfMeasure eachUom = eachUomOptional.get();

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if (americanCategoryOptional.isEmpty()){
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("Italian");

        if (italianCategoryOptional.isEmpty()){
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if (mexicanCategoryOptional.isEmpty()){
            throw new RuntimeException("Expected Category not found");
        }


        Optional<Category> fastFoodCategoryOptional = categoryRepository.findByDescription("Fast Food");

        if (fastFoodCategoryOptional.isEmpty()){
            throw new RuntimeException("Expected Category not found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category italianCategory = italianCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();
        Category fastFoodCategory = fastFoodCategoryOptional.get();

        Recipe spicyGrilledChickenTacos = new Recipe();

        spicyGrilledChickenTacos.setDescription("Spicy Grilled Chicken Tacos");
        spicyGrilledChickenTacos.setCookTime(15);
        spicyGrilledChickenTacos.setPrepTime(20);
        spicyGrilledChickenTacos.setDifficulty(Difficulty.MODERATE);
        spicyGrilledChickenTacos.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");


        Notes tacosNotes = new Notes();
        tacosNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");

        tacosNotes.setRecipe(spicyGrilledChickenTacos);
        spicyGrilledChickenTacos.setNotes(tacosNotes);

       spicyGrilledChickenTacos.getCategories().add(americanCategory);
       spicyGrilledChickenTacos.getCategories().add(mexicanCategory);


        spicyGrilledChickenTacos.addIngredient(new Ingredient("ancho chili powder",new BigDecimal(2),tablespoonUom,spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.addIngredient(new Ingredient("dried oregano", new BigDecimal(1),teaspoonUom,spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.addIngredient(new Ingredient("dried cumin", new BigDecimal(1),teaspoonUom,spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.addIngredient(new Ingredient("sugar", new BigDecimal(1),teaspoonUom,spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.addIngredient(new Ingredient("salt", new BigDecimal(1/2),teaspoonUom,spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.addIngredient(new Ingredient("garlic", new BigDecimal(1),cloveUom,spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.addIngredient(new Ingredient("finely grated orange zest", new BigDecimal(1),tablespoonUom,spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.addIngredient(new Ingredient("fresh squeezed orange juice", new BigDecimal(3),tablespoonUom,spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.addIngredient(new Ingredient("olive oil", new BigDecimal(2),tablespoonUom,spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.addIngredient(new Ingredient("boneless chicken thighs", new BigDecimal(4),eachUom,spicyGrilledChickenTacos));


        recipes.add(spicyGrilledChickenTacos);


        Recipe guacamole = new Recipe();
        guacamole.setDescription("Perfect Guacamole");
        guacamole.setPrepTime(10);
        guacamole.setCookTime(0);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon\" +\n" +
                "                \"\\n\" +\n" +
                "                \"2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\" +\n" +
                "                \"\\n\" +\n" +
                "                \"3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\\n\" +\n" +
                "                \"Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\\n\" +\n" +
                "                \"Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\\n\" +\n" +
                "                \"4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\\n\" +\n" +
                "                \"Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");


        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipe(guacamole);
        guacamoleNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\\n\" +\n" +
                "                \"Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\\n\" +\n" +
                "                \"The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\\n\" +\n" +
                "                \"To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");

        guacamole.setNotes(guacamoleNotes);


        guacamole.addIngredient(new Ingredient("ripe avocados",new BigDecimal(2), eachUom, guacamole));
        guacamole.addIngredient(new Ingredient("salt",new BigDecimal(1/4), teaspoonUom, guacamole));
        guacamole.addIngredient(new Ingredient("fresh lime",new BigDecimal(1), tablespoonUom, guacamole));
        guacamole.addIngredient(new Ingredient("red onion",new BigDecimal(3), tablespoonUom, guacamole));
        guacamole.addIngredient(new Ingredient("serrano",new BigDecimal(1), eachUom, guacamole));
        guacamole.addIngredient(new Ingredient("cilantro",new BigDecimal(2), tablespoonUom, guacamole));
        guacamole.addIngredient(new Ingredient("black pepper",new BigDecimal(1), pinchUom, guacamole));
        guacamole.addIngredient(new Ingredient("ripe tomato chopped",new BigDecimal(1/2), eachUom, guacamole));
        guacamole.addIngredient(new Ingredient("red radish",new BigDecimal(1), eachUom, guacamole));
        guacamole.addIngredient(new Ingredient("tortilla chips",new BigDecimal(1), eachUom, guacamole));

        guacamole.getCategories().add(americanCategory);
        guacamole.getCategories().add(mexicanCategory);


        recipes.add(guacamole);

        return  recipes;
    }
}
