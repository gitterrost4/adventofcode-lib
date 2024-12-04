package de.gitterrost4.adventofcode.base;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Grid {
    protected final List<List<String>> grid;

    public Grid(List<String> lines){
        this.grid = lines.stream().map(s-> Arrays.stream(s.split("")).collect(Collectors.toList())).collect(Collectors.toList());
    }

    public Grid(String lines){
        this.grid = Arrays.stream(lines.split("\n")).map(s-> Arrays.stream(s.split("")).collect(Collectors.toList())).collect(Collectors.toList());
    }

    public String get(Coordinate coordinate){
        return grid.get(coordinate.x()).get(coordinate.y());
    }

    public int width(){
        return grid.get(0).size();
    }

    public int height(){
        return grid.size();
    }

    public boolean isValidCoordinate(Coordinate coordinate) {
        return coordinate.isBetween(new Coordinate(0,0), new Coordinate(height()-1,width()-1));
    }

    public Stream<Coordinate> allCoordinates(){
        return IntStream.range(0,height()).boxed().flatMap(i->IntStream.range(0,width()).mapToObj(j->new Coordinate(i,j)));
    }

    @Override
    public String toString() {
        return grid.stream().map(sl->sl.stream().collect(Collectors.joining())).collect(Collectors.joining("\n"));
    }
}
