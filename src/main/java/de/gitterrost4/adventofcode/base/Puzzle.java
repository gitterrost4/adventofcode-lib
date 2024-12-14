package de.gitterrost4.adventofcode.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

public abstract class Puzzle {

    protected final String resourceDir;
    protected final int year, day;

    public Puzzle(int year, int day) {
        this.year = year;
        this.day = day;
        this.resourceDir = "y"+year+"/day"+day;
    }

    public abstract Object partOne();
    public abstract Object partTwo();

    protected List<String> input(){
        return getResourceLines(resourceDir+"/input.txt");
    }
    protected String asRaw(List<String> input){
        return String.join("\n", input);
    }


    protected List<List<String>> asSingle(List<String> input){
        return input.stream().map(x-> Arrays.stream(x.split("")).toList()).toList();
    }

    protected List<String> sampleInput1(){
        return getResourceLines(resourceDir+"/sampleInput1.txt");
    }
    protected List<String> sampleInput2(){
        return getResourceLines(resourceDir+"/sampleInput2.txt");
    }

    public void printSolutions(){
        Instant now = Instant.now();
        Object part1 = partOne();
        long part1Time = Duration.between(now, Instant.now()).toMillis();
        if(part1 != null) {
            System.out.printf("%4d/%02d   Part 1: %-20s %dms\n", year, day, part1, part1Time);
            now = Instant.now();
            Object part2 = partTwo();
            long part2Time = Duration.between(now, Instant.now()).toMillis();
            if (part2 != null) {
                System.out.printf("          Part 2: %-20s %dms\n", part2, part2Time);
            }
        }
    }

    public static List<String> getResourceLines(String path) {
        try(InputStream is = getResourceAsInputStream(path)) {
            return Optional.ofNullable(is).map(InputStreamReader::new).map(BufferedReader::new).map(BufferedReader::lines).orElseThrow(()->new MissingResourceException("Resource "+path+" not found.", Puzzle.class.getName(), path)).toList();
        } catch(IOException e){
            throw new IllegalStateException("Could not open file "+path);
        }
    }

    public static InputStream getResourceAsInputStream(String path){
        return Puzzle.class.getClassLoader().getResourceAsStream(path);
    }
}
