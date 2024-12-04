package de.gitterrost4.adventofcode.base;

import java.util.Set;
import java.util.stream.Stream;

public record Coordinate(int x, int y) {

    public Coordinate getDirection(Direction direction){
        return getDirection(direction, 1);
    }
    public Coordinate getDirection(Direction direction, int amount){
        return switch (direction){
            case NORTH ->  getNorth(amount);
            case SOUTH ->  getSouth(amount);
            case EAST ->  getEast(amount);
            case WEST ->  getWest(amount);
            case NORTHWEST -> getNorthWest(amount);
            case NORTHEAST -> getNorthEast(amount);
            case SOUTHWEST -> getSouthWest(amount);
            case SOUTHEAST -> getSouthEast(amount);
        };
    }
    public Coordinate getEast() {
        return getEast(1);
    }
    public Coordinate getEast(int amount) {
        return new Coordinate(x, y + amount);
    }

    public Coordinate getWest() {
        return getWest(1);
    }
    public Coordinate getWest(int amount) {
        return new Coordinate(x, y - amount);
    }

    public Coordinate getNorth() {
        return getNorth(1);
    }
    public Coordinate getNorth(int amount) {
        return new Coordinate(x - amount, y);
    }

    public Coordinate getSouth() {
        return getSouth(1);
    }
    public Coordinate getSouth(int amount) {
        return new Coordinate(x + amount, y);
    }

    public Coordinate getNorthWest() { return getNorthWest(1); }
    public Coordinate getNorthWest(int amount) { return getWest(amount).getNorth(amount); }

    public Coordinate getNorthEast() { return getNorthEast(1); }
    public Coordinate getNorthEast(int amount) { return getEast(amount).getNorth(amount); }

    public Coordinate getSouthWest() { return getSouthWest(1); }
    public Coordinate getSouthWest(int amount) { return getWest(amount).getSouth(amount); }

    public Coordinate getSouthEast() { return getSouthEast(1); }
    public Coordinate getSouthEast(int amount) { return getEast(amount).getSouth(amount); }

    public Stream<Coordinate> neighbors(){
        return Stream.of(getNorth(),getWest(),getSouth(),getEast());
    }

    public String getStringRepresentation(Set<Coordinate> adjacents){
        if(Set.of(getEast(), getWest()).equals(adjacents)){
            return "-";
        }
        if(Set.of(getEast(), getNorth()).equals(adjacents)){
            return "L";
        }
        if(Set.of(getEast(), getSouth()).equals(adjacents)){
            return "F";
        }
        if(Set.of(getNorth(), getWest()).equals(adjacents)){
            return "J";
        }
        if(Set.of(getSouth(), getWest()).equals(adjacents)){
            return "7";
        }
        if(Set.of(getNorth(), getSouth()).equals(adjacents)){
            return "|";
        }
        return "+";
    }

    public Coordinate normalize(int gridHeight, int gridWidth){
        return new Coordinate((x%gridHeight+gridHeight)%gridHeight, (y%gridWidth+gridWidth)%gridWidth);
    }

    public long distance1From(Coordinate other){
        return Math.abs(x-other.x)+Math.abs(y-other.y);
    }

    public boolean isBetween(Coordinate oneCornerInclusive, Coordinate otherCornerInclusive){
        return ((x<=oneCornerInclusive.x && x>=otherCornerInclusive.x)||(x>=oneCornerInclusive.x && x<=otherCornerInclusive.x)) &&
               ((y<=oneCornerInclusive.y && y>=otherCornerInclusive.y)||(y>=oneCornerInclusive.y && y<=otherCornerInclusive.y));
    }
    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

}
