package de.gitterrost4.adventofcode.base;

public enum Direction {
    NORTH, SOUTH, EAST, WEST, NORTHEAST, SOUTHEAST, NORTHWEST, SOUTHWEST;

    public Direction opposite(){
        return switch(this){
            case NORTH -> SOUTH;
            case SOUTH -> NORTH;
            case EAST -> WEST;
            case WEST -> EAST;
            case NORTHEAST -> SOUTHWEST;
            case NORTHWEST -> SOUTHEAST;
            case SOUTHEAST -> NORTHWEST;
            case SOUTHWEST -> NORTHEAST;
        };
    }

    public Direction clockwiseNext4(){
        return switch(this){
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case EAST -> SOUTH;
            case WEST -> NORTH;
            case NORTHEAST -> SOUTHEAST;
            case NORTHWEST -> NORTHEAST;
            case SOUTHEAST -> SOUTHWEST;
            case SOUTHWEST -> NORTHWEST;
        };
    }

    public Direction counterClockwiseNext4(){
        return switch(this){
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case EAST -> NORTH;
            case NORTHEAST -> NORTHWEST;
            case NORTHWEST -> SOUTHWEST;
            case SOUTHWEST -> SOUTHEAST;
            case SOUTHEAST -> NORTHEAST;
        };
    }

    public Direction clockwiseNext(){
        return switch(this){
            case NORTH -> NORTHEAST;
            case NORTHEAST -> EAST;
            case EAST -> SOUTHEAST;
            case SOUTHEAST -> SOUTH;
            case SOUTH -> SOUTHWEST;
            case SOUTHWEST -> WEST;
            case WEST -> NORTHWEST;
            case NORTHWEST -> NORTH;
        };
    }

    public Direction counterClockwiseNext(){
        return switch(this){
            case NORTH -> NORTHWEST;
            case NORTHWEST -> WEST;
            case WEST -> SOUTHWEST;
            case SOUTHWEST -> SOUTH;
            case SOUTH -> SOUTHEAST;
            case SOUTHEAST -> EAST;
            case EAST -> NORTHEAST;
            case NORTHEAST -> NORTH;
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

    public static Direction[] values4(){
        return new Direction[]{NORTH, SOUTH, EAST, WEST};
    }
}
