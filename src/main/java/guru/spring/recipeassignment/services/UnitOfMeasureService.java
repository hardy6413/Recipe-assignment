package guru.spring.recipeassignment.services;

import guru.spring.recipeassignment.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {
    public Set<UnitOfMeasureCommand> listAllUoms();
}
