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
