package com.company;

import java.util.List;
import java.util.function.Predicate;

public class OurPredicate<T> {

    public Predicate<T> bulkOr (List<Predicate<T>> predicates) {
        Predicate <T> result = predicates.get(0);
        for (int i = 1; i < predicates.size() ; i++) {
            result = result.or(predicates.get(i));
        }
        return result;
    }
}
