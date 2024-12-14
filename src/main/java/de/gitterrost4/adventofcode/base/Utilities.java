package de.gitterrost4.adventofcode.base;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Utilities {

    private static <T> List<List<T>> getAllCombinations(int count, List<T> elements) {
        return IntStream.range(0, count)
                .mapToObj(unused -> elements.stream().map(List::of).toList())
                .reduce(List.of(List.of()), (l1, l2) -> l1.stream()
                        .flatMap(s -> l2.stream()
                                .map(t-> Stream.concat(s.stream(),t.stream()).toList()))
                        .toList());
    }

}
