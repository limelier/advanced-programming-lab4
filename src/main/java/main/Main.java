package main;

import algorithm.GaleShapleySolver;
import algorithm.Solver;
import element.Element;
import element.Hospital;
import element.Resident;
import matchingProblem.Generator;
import matchingProblem.Matching;
import matchingProblem.Partition;
import matchingProblem.Problem;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Generator g = new Generator();
        Problem p = g.generate(5);
        System.out.println(p);
        Solver s = new GaleShapleySolver(p);
        Matching m = s.solve();
        System.out.println(m);
        System.out.println(m.isStable());
    }
}
