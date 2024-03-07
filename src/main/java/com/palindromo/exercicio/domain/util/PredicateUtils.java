package com.palindromo.exercicio.domain.util;

import lombok.experimental.UtilityClass;

import java.util.function.Predicate;
import java.util.function.Supplier;

@UtilityClass
public class PredicateUtils {

    public static <v, T extends Throwable> void validar(v value, Predicate<v> predicate, Supplier<? extends T> exceptionSupplier) throws T {
        if (predicate.test(value))
            throw exceptionSupplier.get();
    }
}
