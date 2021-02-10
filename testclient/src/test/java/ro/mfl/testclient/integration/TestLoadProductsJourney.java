package ro.mfl.testclient.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.mfl.testclient.entities.Product;
import ro.mfl.testclient.journey.Result;
import ro.mfl.testclient.journey.impl.LoadProductsJourney;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class TestLoadProductsJourney {

    @Autowired
    private LoadProductsJourney loadProductsJourney;

    @Test
    void testLoadProducts() {
        Result<List<Product>> result = loadProductsJourney.execute();
        assertTrue(result.getResult().size() > 0);
    }


}
