package main;

import hospital.Hospital;
import resident.Resident;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Resident> residents = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident("R" + (3 - i)))
                .collect(Collectors.toList());
        System.out.println("Pre-sorting: " + residents);
        residents.sort(Comparator.comparing(Resident::getName));
        System.out.println("Post-sorting: " + residents);

        Set<Hospital> hospitals = new TreeSet<>();
    }
}
