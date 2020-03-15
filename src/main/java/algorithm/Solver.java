package algorithm;

import matchingProblem.Matching;
import matchingProblem.Problem;

public abstract class Solver {
    Problem problem;

    public Solver(Problem problem) {
        this.problem = problem;
    }

    public abstract Matching solve();
}
