package guru.spring.recipeassignment.converters;

import guru.spring.recipeassignment.commands.NotesCommand;
import guru.spring.recipeassignment.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesCommandToNotesTest {

    public static final String RECIPE_NOTES = "Notes";
    public static final Long ID_VALUE = 1L;

    NotesCommandToNotes converter;

    @BeforeEach
    void setUp() {
        converter = new NotesCommandToNotes();
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    void convert() {
        //given
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setRecipeNotes(RECIPE_NOTES);
        notesCommand.setId(ID_VALUE);

        //when
        Notes notes = converter.convert(notesCommand);

        //then
        assertNotNull(notes);
        assertEquals(ID_VALUE,notes.getId());
        assertEquals(RECIPE_NOTES,notes.getRecipeNotes());

    }
}