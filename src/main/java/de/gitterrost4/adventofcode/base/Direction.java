package de.gitterrost4.adventofcode.base;

public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    public Direction opposite(){
        return switch(this){
            case NORTH -> SOUTH;
            case SOUTH -> NORTH;
            case EAST -> WEST;
            case WEST -> EAST;
        };
    }

    public static Direction fromLaymanTerms(String input){
        return switch (input){
            case "U" -> NORTH;
            case "L" -> WEST;
            case "R" -> EAST;
            case "D" -> SOUTH;
            default -> throw new IllegalArgumentException("input not recognized");
        };
    }

    public static Direction fromInt(Integer input){
        return switch(input){
            case 0 -> EAST;
            case 1 -> SOUTH;
            case 2 -> WEST;
            case 3 -> NORTH;
            default -> throw new IllegalArgumentException("input not recognized");
        };
    }
}
