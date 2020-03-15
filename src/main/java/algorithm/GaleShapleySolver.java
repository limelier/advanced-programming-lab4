package algorithm;

import element.Element;
import matchingProblem.Matching;
import matchingProblem.Problem;

import java.util.*;

public class GaleShapleySolver extends Solver {

    Map<Element, List<Element>> suitorPreferences;
    Set<Element> unmatchedSuitors;

    public GaleShapleySolver(Problem problem) {
        super(problem);
        suitorPreferences = new HashMap<>();
        unmatchedSuitors = new HashSet<>();
        for (Element suitor : problem.getSuitors()) {
            suitorPreferences.put(suitor, new ArrayList<>(suitor.getPreferences()));
            unmatchedSuitors.add(suitor);
        }
    }


    /**
     * Solve the problem using the Gale-Shapley algorithm.
     *
     * The algorithm keeps going as long as there are unmatched suitors with acceptors left to propose to. Once such a suitor is chosen, he will ask his preferred remaining acceptor to match with it. If that acceptor likes this suitor more than the one it is matched to, it will replace its suitor with this one, leaving the other unmatched.
     *
     * @return a stable matching
     */
    @Override
    public Matching solve() {
        Matching matching = new Matching();
        while (!unmatchedSuitors.isEmpty()) {
            Element suitor = unmatchedSuitors.iterator().next();
            Element acceptor = suitorPreferences.get(suitor).get(0);
            Element opponent = matching.getAcceptorMatch(acceptor);

            if (opponent == null || acceptor.prefersMore(suitor, opponent)) {
                matching.unmatch(opponent, acceptor);
                matching.match(suitor, acceptor);
                unmatchedSuitors.remove(suitor);
            }

            suitorPreferences.get(suitor).remove(acceptor);
            if (suitorPreferences.get(suitor).isEmpty()) {
                suitorPreferences.remove(suitor);
            }
        }
        return matching;
    }
}
