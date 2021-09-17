package guru.spring.recipeassignment.converters;

import guru.spring.recipeassignment.commands.CategoryCommand;
import guru.spring.recipeassignment.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryCommandToCategoryTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;

    CategoryCommandToCategory converter;

    @BeforeEach
    void setUp() {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject()  {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject()  {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(LONG_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = converter.convert(categoryCommand);

        //then
        assertEquals(LONG_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}