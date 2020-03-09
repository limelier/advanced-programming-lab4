package main;

import hospital.Hospital;
import resident.Resident;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Resident r0 = new Resident("R0");
        Resident r1 = new Resident("R1");
        Resident r2 = new Resident("R2");
        Resident r3 = new Resident("R3");
        List<Resident> residents = new ArrayList<>(Arrays.asList(r0, r1, r2, r3));
        System.out.println("Pre-sorting: " + residents);
        residents.sort(Comparator.comparing(Resident::getName));
        System.out.println("Post-sorting: " + residents);

        Set<Hospital> hospitals = new TreeSet<>();
    }
}
