package de.gitterrost4.adventofcode.base;

public enum Direction3D {
    NORTH, SOUTH, EAST, WEST, UP, DOWN;

    public Direction3D opposite(){
        return switch(this){
            case NORTH -> SOUTH;
            case SOUTH -> NORTH;
            case EAST -> WEST;
            case WEST -> EAST;
            case UP -> DOWN;
            case DOWN -> UP;
        };
    }
}
