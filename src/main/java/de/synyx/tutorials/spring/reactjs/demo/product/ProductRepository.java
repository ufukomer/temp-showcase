package de.synyx.tutorials.spring.reactjs.demo.product;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static de.synyx.tutorials.spring.reactjs.demo.Functions.sorted;

@Repository
public class ProductRepository {

    private final static IdCounter ID = new IdCounter ();

    private static final List<Product> PRODUCTS = Arrays.asList (
            new Product (ID.next (), "jeans", 42),
            new Product (ID.next (), "cardigan", 63)
    );

    public List<Product> findAllSorted (Comparator<Product> comparator) {
        return Collections.unmodifiableList ( sorted (PRODUCTS, comparator));
    }

    static class IdCounter {

        private int current = 0;

        public int next () {
            return ++current;
        }
    }
}
