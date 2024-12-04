package de.gitterrost4.adventofcode.base;

import java.util.List;

public class MutableGrid extends Grid{
    public MutableGrid(List<String> lines) {
        super(lines);
    }

    public MutableGrid(String lines) {
        super(lines);
    }

    public MutableGrid set(Coordinate coordinate, String s){
        grid.get(coordinate.x()).set(coordinate.y(),s);
        return this;
    }
}
