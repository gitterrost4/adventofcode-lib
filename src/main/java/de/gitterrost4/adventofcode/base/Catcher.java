package de.gitterrost4.adventofcode.base;

import java.util.function.Supplier;

public class Catcher {
    public static <T> T recover(Supplier<T> sup, T recoverable){
        try{
            return sup.get();
        } catch (Exception e){
            return recoverable;
        }
    }
}
