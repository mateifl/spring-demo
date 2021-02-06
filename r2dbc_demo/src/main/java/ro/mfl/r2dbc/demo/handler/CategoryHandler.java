package ro.mfl.r2dbc.demo.handler;

import org.springframework.stereotype.Component;

import ro.mfl.r2dbc.demo.entities.Category;
import ro.mfl.r2dbc.demo.repositories.CategoryRepository;

@Component
public class CategoryHandler extends AbstractHandler<Integer, Category, CategoryRepository> {

  private static final Category prototype = new Category();

  public CategoryHandler(CategoryRepository repository) {
    super(repository);
  }

  @Override
  protected Category prototype() {
    return prototype;
  }
}
