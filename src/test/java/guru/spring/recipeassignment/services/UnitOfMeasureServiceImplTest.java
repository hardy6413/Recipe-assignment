package guru.spring.recipeassignment.services;

import guru.spring.recipeassignment.commands.UnitOfMeasureCommand;
import guru.spring.recipeassignment.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.spring.recipeassignment.domain.UnitOfMeasure;
import guru.spring.recipeassignment.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UnitOfMeasureServiceImplTest {

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureService service;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this).close();

        service = new UnitOfMeasureServiceImpl(unitOfMeasureRepository,unitOfMeasureCommand);
    }

    @Test
    void listAllUoms() {
        //given
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure uom_1 = new UnitOfMeasure();
        uom_1.setId(1L);
        UnitOfMeasure uom_2 = new UnitOfMeasure();
        uom_2.setId(2L);
        unitOfMeasures.add(uom_1);
        unitOfMeasures.add(uom_2);

        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);

        //when
        Set<UnitOfMeasureCommand> commands = service.listAllUoms();

        //then
        assertEquals(2,commands.size());
        verify(unitOfMeasureRepository,times(1)).findAll();
    }
}