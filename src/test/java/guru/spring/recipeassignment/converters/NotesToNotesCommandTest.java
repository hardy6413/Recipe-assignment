package guru.spring.recipeassignment.converters;

import guru.spring.recipeassignment.commands.NotesCommand;
import guru.spring.recipeassignment.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesToNotesCommandTest {

    public static final String RECIPE_NOTES = "Notes";
    public static final Long ID_VALUE = 1L;

    NotesToNotesCommand converter;

    @BeforeEach
    void setUp() {
        converter = new NotesToNotesCommand();
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new Notes()));
    }

    @Test
    void convert() {
        //given
        Notes notes = new Notes();
        notes.setId(ID_VALUE);
        notes.setRecipeNotes(RECIPE_NOTES);

        //when
        NotesCommand notesCommand = converter.convert(notes);

        //then
        assertNotNull(notesCommand);
        assertEquals(ID_VALUE,notesCommand.getId());
        assertEquals(RECIPE_NOTES,notesCommand.getRecipeNotes());

    }
}