package de.synyx.tutorials.spring.reactjs.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Functions {

    public static <T> List<T> sorted (Collection<T> collection, Comparator<T> comparator) {
        return new ArrayList<> (collection).stream ().sorted (comparator).collect (Collectors.toList ());
    }
}
