package main;

import hospital.Hospital;
import resident.Resident;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Resident[] r = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident("R" + i)).toArray(Resident[]::new);
        List<Resident> residents = Arrays.asList(r);

        residents.sort(Comparator.comparing(Resident::getName));

        Hospital[] h = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Hospital("H" + i))
                .toArray(Hospital[]::new);
        Set<Hospital> hospitals = new TreeSet<>(Arrays.asList(h));

        Map<Resident, List<Hospital>> residentPreferences = new HashMap<>();
        residentPreferences.put(r[0], Arrays.asList(h[0], h[1], h[2]));
        residentPreferences.put(r[1], Arrays.asList(h[0], h[1], h[2]));
        residentPreferences.put(r[2], Arrays.asList(h[0], h[1]));
        residentPreferences.put(r[3], Arrays.asList(h[0], h[2]));
        System.out.println(residentPreferences);


        Map<Hospital, List<Resident>> hospitalPreferences = new TreeMap<>();
        hospitalPreferences.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        hospitalPreferences.put(h[1], Arrays.asList(r[0], r[2], r[1]));
        hospitalPreferences.put(h[2], Arrays.asList(r[0], r[1], r[3]));
        System.out.println(hospitalPreferences);

        System.out.println(
                Arrays.toString(residents.stream()
                        .filter(
                                i -> residentPreferences.get(i)
                                        .containsAll(Arrays.asList(h[0], h[2]))
                        ).toArray())
        );

        System.out.println(
                Arrays.toString(hospitals.stream()
                        .filter(
                                i -> hospitalPreferences.get(i)
                                        .get(0) == r[0]
                        )
                        .toArray())
        );
    }
}
