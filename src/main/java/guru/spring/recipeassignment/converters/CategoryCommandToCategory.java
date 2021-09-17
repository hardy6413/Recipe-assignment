package guru.spring.recipeassignment.converters;

import guru.spring.recipeassignment.commands.CategoryCommand;
import guru.spring.recipeassignment.domain.Category;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;


@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
    @Override
    public Category convert(CategoryCommand source) {
        if (source == null) {
            return null;
        }

        final Category category = new Category();

        category.setId(source.getId());
        category.setDescription(source.getDescription());

        return category;
    }
}


