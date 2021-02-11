package ro.mfl.testclient.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import ro.mfl.testclient.entities.Product;
import ro.mfl.testclient.journey.Result;
import ro.mfl.testclient.journey.impl.LoadProductsJourney;


@SpringBootTest
public class TestLoadProductsJourney {

    @Autowired
    private LoadProductsJourney loadProductsJourney;

    @Test
    void testLoadProducts() {
        Result<Flux<Product>> result = loadProductsJourney.execute();
        
    }


}
