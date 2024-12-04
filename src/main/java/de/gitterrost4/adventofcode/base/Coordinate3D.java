package de.gitterrost4.adventofcode.base;

public record Coordinate3D(int x, int y, int z) {

    public Coordinate3D getDirection(Direction3D direction){
        return getDirection(direction, 1);
    }
    public Coordinate3D getDirection(Direction3D direction, int amount){
        return switch (direction){
            case NORTH ->  getNorth(amount);
            case SOUTH ->  getSouth(amount);
            case EAST ->  getEast(amount);
            case WEST ->  getWest(amount);
            case UP -> getUp(amount);
            case DOWN -> getDown(amount);
        };
    }
    public Coordinate3D getEast() {
        return getEast(1);
    }
    public Coordinate3D getEast(int amount) {
        return new Coordinate3D(x, y + amount, z);
    }

    public Coordinate3D getWest() {
        return getWest(1);
    }
    public Coordinate3D getWest(int amount) {
        return new Coordinate3D(x, y - amount, z);
    }

    public Coordinate3D getNorth() {
        return getNorth(1);
    }
    public Coordinate3D getNorth(int amount) {
        return new Coordinate3D(x - amount, y, z);
    }

    public Coordinate3D getSouth() {
        return getSouth(1);
    }
    public Coordinate3D getSouth(int amount) {
        return new Coordinate3D(x + amount, y, z);
    }

    public Coordinate3D getUp() {
        return getUp(1);
    }
    public Coordinate3D getUp(int amount) {
        return new Coordinate3D(x, y, z+amount);
    }

    public Coordinate3D getDown() {
        return getDown(1);
    }
    public Coordinate3D getDown(int amount) {
        return new Coordinate3D(x, y, z-amount);
    }

    public long distance1From(Coordinate3D other){
        return Math.abs(x-other.x)+Math.abs(y-other.y)+Math.abs(z-other.z);
    }

    public boolean isBetween(Coordinate3D oneCornerInclusive, Coordinate3D otherCornerInclusive){
        return ((x<=oneCornerInclusive.x && x>=otherCornerInclusive.x)||(x>=oneCornerInclusive.x && x<=otherCornerInclusive.x)) &&
               ((y<=oneCornerInclusive.y && y>=otherCornerInclusive.y)||(y>=oneCornerInclusive.y && y<=otherCornerInclusive.y)) &&
               ((z<=oneCornerInclusive.z && z>=otherCornerInclusive.z)||(z>=oneCornerInclusive.z && z<=otherCornerInclusive.z));
    }

    @Override
    public String toString() {
        return "("+x+","+y+","+z+")";
    }
}
