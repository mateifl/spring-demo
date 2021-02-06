package ro.mfl.r2dbc.demo.handler;

import org.springframework.stereotype.Component;

import ro.mfl.r2dbc.demo.entities.Product;
import ro.mfl.r2dbc.demo.repositories.ProductRepository;

@Component
public class ProductHandler extends AbstractHandler<Integer, Product, ProductRepository> {

  private static final Product prototype = new Product();

  public ProductHandler(ProductRepository repository) {
    super(repository);
  }

  @Override
  protected Product prototype() {
    return prototype;
  }
}
